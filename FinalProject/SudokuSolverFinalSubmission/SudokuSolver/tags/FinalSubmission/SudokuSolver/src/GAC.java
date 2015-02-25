package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class GAC implements Constraint {


	public List<Variable> constraintVariables = new LinkedList<Variable>();

	public List<Variable> variables = new ArrayList<Variable>();

	public Network net = new Network() ;

	public AllDifferent allDiff = new AllDifferent();

	boolean solved = false;

	PriorityQueue<Variable> queue = new PriorityQueue<Variable>();

	LinkedList<Variable> restrictions = new LinkedList<Variable>();



	@Override
	public List<Variable> applyConstraints(List<Variable> variableList) {
		constraintVariables.clear();
		variables.clear();

		this.variables = variableList;

		System.out.println("GAC:");

		reduceArc();
	
		solved = GACSolve(queue.poll().number,variables);

		if (!solved){
			System.out.println("cannot be solved");
		}

		return variables;
	}


	/**
	 * http://en.wikipedia.org/wiki/AC-3_algorithm
	 *  Input:
	 *   A set of variables "variables"
	 *   A set of domains variables.get(i).domain.domain D(x) for each variable x in X. D(x) contains  vx0, vx1... vxn, the possible values of x
	 *   A set of unary constraints R1(x) on variable x that must be satisfied
	 *   A set of binary constraints R2(x, y) on variables x and y that must be satisfied
	 *  Output:
	 *   Arc consistent domains for each variable.

 function ac3 (X, D, R1, R2)
 // Initial domains are made consistent with unary constraints.
     for each x in X
         D(x) := { x in D(x) | R1(x) }   
     // 'worklist' contains all arcs we wish to prove consistent or not.
     worklist := { (x, y) | there exists a relation R2(x, y) or a relation R2(y, x) }

     do while worklist not empty
         select any arc (x, y) from worklist
         worklist := worklist - (x, y)
         if arc-reduce (x, y) 
             if D(x) is empty
                 return failure
             else
                 worklist := worklist + { (z, x) | z != y and there exists a relation R2(x, z) or a relation R2(z, x) }
   }

	 **/
private boolean GACSolve(int num, List<Variable> var) {
		

		if(queue.isEmpty()){

			return true;

		}

		if(var.get(num).isAssigned()){

			return GACSolve(queue.poll().number,var);
		}
		

		for(int val : var.get(num).domain.domain){

			if(allDiff.allDifferent(num,val,var)) {
//System.out.println("1["+var.get(num).position[0]+","+var.get(num).position[1]+"]"+var.get(num).domain.domain.toString());


				//assigns variable and sets it to assigned = true
				var.get(num).assignVar(val);
						reduceArc();
//System.out.println("2["+var.get(num).position[0]+","+var.get(num).position[1]+"]"+var.get(num).domain.domain.toString());

				if(GACSolve(queue.poll().number,var))

					//only returns true if board can be solved 
					//queue.poll();
					return true;

			}
		}
		var.get(num).unAssignVar();

		return false;
	}
	
	/** function arc-reduce (x, y)
     bool change = false
     for each vx in D(x)
         find a value vy in D(y) such that vx and vy satisfy the constraint R2(x, y)
         if there is no such vy {
             D(x) := D(x) - vx
             change := true
         }
     return change
	 * @param var 
	 * @param val 

	 **/

		private void reduceArc() {
			queue.clear();
		for(int i = 0; i < 81; i ++){
				if(!variables.get(i).isAssigned()){
					
					variables = allDiff.reduceArc(i,variables);
				variables.get(i).number = i;
				}
				queue.add(variables.get(i));
				//System.out.println("queue:"+queue.element().domain.domain.size());
			}
			}
	
	
	

	
	



	@Override
	public boolean solved() {

		return solved;
	}


	}



