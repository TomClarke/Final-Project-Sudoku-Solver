package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class DVO implements Constraint{

	public List<Variable> constraintVariables = new LinkedList<Variable>();

	public List<Variable> variables = new ArrayList<Variable>();

	public Network net = new Network() ;

	String result = null;

	PriorityQueue<Variable> queue = new PriorityQueue<Variable>();

	public AllDifferent allDiff = new AllDifferent();

	boolean solved = false;

	boolean hint  = false;

	int count = 0;

	public DVO(boolean hint) {

		this.hint = hint;

	}



	@Override
	public List<Variable> applyConstraints(List<Variable> variableList) {

		constraintVariables.clear();
		variables.clear();

		this.variables = variableList;

		System.out.println("DVO:");

	
		createQueue();
	
		
		if(hint == false){

			solved = DVOSolve(queue.poll().number,variables);

			if (!solved){
				System.out.println("cannot be solved");
			}
		}
		else{
			System.out.println("DVO HINT");
			DVOHint(queue.peek().number,variables,3);
		}
		return variables;
	}

	private boolean DVOHint(int num, List<Variable> var,int limit) {
		
		if( limit == 0){
			queue.clear();
		}
		if(queue.isEmpty()){
			return true;
		}
		

		if(var.get(num).isAssigned()){
			return DVOHint(queue.poll().number,var,0);
		}

		//for(int val : var.get(num).domain.domain){
		for(int val = 1; val <= 9; val++){
			if(allDiff.allDifferent(num,val,var)) {

				
				//assigns variable and sets it to assigned = true
				var.get(num).assignVar(val);
				
				createQueue();
				
				if(DVOHint(queue.poll().number,var,1))
				return true;
			}
		}
		var.get(num).unAssignVar();

		return false;
	}


	private void createQueue() {
		queue.clear();
		for(int i = 0; i < 81; i ++){
			if(!variables.get(i).isAssigned()){
				
			variables = allDiff.getConstraints(i,variables);
			//if(!((variables.get(i).domain.domainSize() == 9)||(variables.get(i).domain.domainSize() == 8))){
			variables.get(i).number = i;
			}	//System.out.println("["+variables.get(i).position[0]+","+variables.get(i).position[1]+"]"+variables.get(i).domain.domain.toString());
			queue.add(variables.get(i));
			//System.out.println("queue:"+queue.element().domain.domain.size());
		
		}
		}


	

	private boolean DVOSolve(int num, List<Variable> var) {
	

		if(queue.isEmpty()){

			return true;

		}

		if(var.get(num).isAssigned()){

			return DVOSolve(queue.poll().number,var);
		}

		for(int val = 1; val <= 9; val++){

			if(allDiff.allDifferent(num,val,var)) {

				//assigns variable and sets it to assigned = true
				var.get(num).assignVar(val);

				createQueue();

				if(DVOSolve(queue.poll().number,var))

					//only returns true if board can be solved 
					//queue.poll();
					return true;

			}
		}
		var.get(num).unAssignVar();

		return false;
	}



	@Override
	public boolean solved() {
		
		return solved;
	}





}
