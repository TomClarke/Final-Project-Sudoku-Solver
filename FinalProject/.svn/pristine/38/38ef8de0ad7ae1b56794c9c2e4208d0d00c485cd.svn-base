package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * The Class DVO uses the algorithm of backtracking using DVO to reduce the 
 * time it takes to solve the board.
 */
public class DVO implements Constraint{

	/** The constraint variables is a list of the variables within a scope */
	public List<Variable> constraintVariables = new LinkedList<Variable>();

	/** The variables that are a list of all the variables */
	public List<Variable> variables = new ArrayList<Variable>();

	/** The network that is creating a CSP */
	public Network net = new Network() ;

	/** The result the values that are within the scope. */
	HashSet<Integer> result = new HashSet<Integer>();

	/** if the board is solved. */
	boolean solved = false;

	/** The allDiff is the constraint that can be applied in this case all the values should
	 * be different. */
	public AllDifferent allDiff = new AllDifferent();

	/** The queue that will contain the variables in an order of the smallest domain at the head */
	PriorityQueue<Variable> queue = new PriorityQueue<Variable>();

	/** The hint is true if the user requested a hint */
	boolean hint  = false;

	/** The count. */
	int count = 0;

	/**
	 * Instantiates a new dvo, if the user defined hint meaning only one value is returned .
	 *
	 * @param hint the hint
	 */
	public DVO(boolean hint) {

		this.hint = hint;

	}


	/**
	 * Clears the constraints within the scope for each application of the algorithm. 
	 * the global variable list is also cleared for a new instance of the algorithm. 
	 * 
	 * the variable list is added to the current variables within this class  
	 * the create queue method is called 
	 * if the hint variable is true then the DVOhint method is called else the DVO solve method 
	 * is called.
	 * the backtracking algorithm method is called and given the variables list and started at the
	 * first variable within that list. 
	 * When the backtracking and DVO algorithm returns with a boolean it is set to true if the Sudoku 
	 * was solved and false if it was not possible. This is then throws an error.
	 * 
	 * the updated variables list is then returned.
	 * 
	 **/
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
			int top = queue.peek().number;
			DVOHint(queue.poll().number,variables);
			for( int i = 0; i < variables.size(); i++){
				if(i == top)
					variables.get(i).temp = false;
				if(variables.get(i).assigned && variables.get(i).temp){
					variables.get(i).unAssignVar();
				}

			}


		}
		return variables;
	}

	/**
	 * DVO hint.
	 * Backtracking algorithm that takes a list of variables and a counter 
	 * if the counter is the same as the size of the list then the backtrack ends and 
	 * returns true. Meaning it is solved.
	 * However this just needs one variable to be found, but the whole board needs to be solved
	 * to find the right value for one variable, this uses the most constrained variable and then
	 * fills its space within the board. 
	 * 
	 * if the current variable is assigned it already has its value so does not need to
	 * take part in the rest of the algorithm and the next variable is called 
	 * 
	 * a for loop uses all 9 possible variables that are then assigned to the variable
	 * temporarily and then checked using the all different constraint. if this returns
	 * true then the variable is then assigned that value. and then the next variable is 
	 * given to the backtracking, if this is true as well then the current variable is true.
	 * This means that that the current value cant be true if the next isnt. 
	 * if it returns false then the current value assigned temporarily is unassigned 
	 * as it did not satisfy all of the constraints. 
	 *
	 * @param num the counter of the current value 
	 * @param var the list of variables
	 * @return true, if successful
	 */
	private boolean DVOHint(int num, List<Variable> var) {


		if(queue.isEmpty()){
			return true;
		}

		if(var.get(num).isAssigned()){
			return DVOHint(queue.poll().number,var);
		}


		for(int val = 1; val <= 9; val++){
			if(allDiff.allDifferent(num,val,var)) {

				var.get(num).assignVar(val,true);
				//assigns variable and sets it to assigned = true


				createQueue();

				if(DVOHint(queue.poll().number,var))

					return true;
			}
		}
		var.get(num).unAssignVar();

		return false;
	}


	/**
	 * Creates the queue that consists of all the variables within the board and puts the variable
	 * with the most constraints at the head of the list. 
	 */
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




	/**
	 * DVO solve.
	 * Backtracking algorithm that takes a list of variables in the order of the most
	 * constrained variable first from a queue and a counter 
	 * if the counter is the same as the size of the list then the backtrack ends and 
	 * returns true. Meaning it is solved.
	 * 
	 * if the current variable is assigned it already has its value so does not need to
	 * take part in the rest of the algorithm and the next variable is called 
	 * 
	 * a for loop uses all 9 possible variables that are then assigned to the variable
	 * temporarily and then checked using the all different constraint. if this returns
	 * true then the variable is then assigned that value. and then the next variable is 
	 * given to the backtracking, if this is true as well then the current variable is true.
	 * This means that that the current value cant be true if the next isnt. 
	 * if it returns false then the current value assigned temporarily is unassigned 
	 * as it did not satisfy all of the constraints. 
	 *
	 * @param num the counter of the current value 
	 * @param var the list of variables
	 * @return true, if successful
	 */
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



	/**
	 * returns the solved boolean, this is from the constraints interface.
	 **/
	@Override
	public boolean solved() {

		return solved;
	}





}
