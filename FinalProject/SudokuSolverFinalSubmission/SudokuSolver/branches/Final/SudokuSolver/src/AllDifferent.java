package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * The Class AllDifferent is used by the constraints as a way to check the values within the scope of a variable 
 */
public class AllDifferent  {

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



	/**
	 * All different.
	 *
	 *	clears list for each varaible constraint
	 *Assigns the current variable
	 *add test variable without assigning it as its not tested
	 *get the domains from the 3 constraint locations 
	 *reset the hash table will be used to include all domains 
	 *how to return if there was a duplicate or not 
		duplicate true = was passed into the hash
		duplicate false = rejected from hash as was in there 
	 *iterate the global variable ArrayList containing the domain of variable 
	 *result of hash table input, if current variable is not within the hash 
		meaning that it true and is different so satisfies the constraint. 
		duplicate = result.add(test.value);
		if it satisfies remove it from the hash as it does not need to be in there, was just a test
	 *if the hash input was false, meaning it matched a domain it returns false
	 *
	 * @param val the value to be assigned to the variable
	 * @param i the number of the current variable in the list
	 * @param var the list of all the current variables
	 * @return true, if successful
	 */
	public boolean allDifferent(int i, int val, List<Variable> var) {

		constraintVariables.clear();

		Variable test = var.get(i);

		test.value = val;

		getRow(i,var);
		getCol(i,var);
		getSubgrid(i,var);

		result.clear();

		boolean duplicate = false;

		for(int j = 0; j < constraintVariables.size();j++){

			result.add(constraintVariables.get(j).value);
		}

		duplicate = result.add(test.value);

		if(duplicate){
			result.remove(test.value);
		}

		if(!duplicate){
			return false;
		}

		return true;
	}


	/**
	 * Reduce arc.
	 *add test variable without assigning it as its not tested
		get the domains from the 3 constraint locations 
	 *how to return if there was a duplicate or not 
	 *duplicate true = was passed into the hash
	 *duplicate false = rejected from hash as was in there 
	 *iterate the global variable ArrayList containing the domain of variable 
	 *The scopes values are then entered into the hash set where they are then 
	 *passed into another linked list that contains the values without
	 *any duplicates, these values are then removed from the current variables
	 *domain. 
	 *
	 *
	 *
	 * @param i the number of the current variable in the list
	 * @param var the list of all the current variables
	 * @return the list containing all of the variables
	 */
	public List<Variable> reduceArc(int i, List<Variable> var)	{

		constraintVariables.clear();

		//current variable 
		Variable test = var.get(i);
		test.domain.resetDomain();

		getRow(i,var);
		getCol(i,var);
		getSubgrid(i,var);

		result.clear();


		for(int j = 0; j < constraintVariables.size();j++){
			if(!(constraintVariables.get(j)==test))
				test.domain.restrictions.add(constraintVariables.get(j));
			result.add(constraintVariables.get(j).value);
		}
		LinkedList<Integer> list = new LinkedList<Integer>(result);
		for(int j = 0; j < list.size();j++){
			test.domain.removeDomain(list.get(j));
		}

		return var;

	}

	/**
	 * getConstraints
	 *add test variable without assigning it as its not tested
		get the domains from the 3 constraint locations 
	 *how to return if there was a duplicate or not 
	 *duplicate true = was passed into the hash
	 *duplicate false = rejected from hash as was in there 
	 *iterate the global variable ArrayList containing the domain of variable 
	 *The scopes values are then entered into the hash set where they are then 
	 *passed into another linked list that contains the values without
	 *any duplicates, these values are then removed from the current variables
	 *domain. 
	 *
	 *This differs from the reduce arc as it adds a list of the variables within the 
	 *current variables scope.
	 *
	 *
	 * @param i the number of the current variable in the list
	 * @param var the list of all the current variables
	 * @return the list containing all of the variables
	 */
	public List<Variable> getConstraints(int i, List<Variable> var)	{

		constraintVariables.clear();


		Variable test = var.get(i);
		test.domain.resetDomain();

		getRow(i,var);
		getCol(i,var);
		getSubgrid(i,var);

		result.clear();

		for(int j = 0; j < constraintVariables.size();j++){
			if(!(constraintVariables.get(j)==test))
				if(constraintVariables.get(j).isAssigned())
					test.domain.restrictions.add(constraintVariables.get(j));
			result.add(constraintVariables.get(j).value);
		}

		LinkedList<Integer> list = new LinkedList<Integer>(result);
		for(int j = 0; j < list.size();j++){
			test.domain.removeDomain(list.get(j));
		}
		return var;

	}

	//7 constraint: AllDiff: check all variables, if false(no conflicts) keep domain as all 
	//check constraints list again current
	/**
	 * adds the sub-grid values into a list 
	 * it shouldn't include the current test value 
	 *
	 * @param focus the number of the current variable within the list var.
	 * @param var the list of all the variables 
	 * @return the sub-grid, the variables within the sub-grid. 
	 */
	private void getSubgrid(int focus, List<Variable> var) {

		int row = var.get(focus).position[0];
		int col = var.get(focus).position[1];
		row = (row / 3) * 3 ;
		col = (col / 3) * 3 ;

		for( int r = 0; r < 3; r++ ){
			for( int c = 0; c < 3; c++ ){

				for(int i = 0; i < 81 ; i++){

					if((var.get(i).position[0] == row+r) && (var.get(i).position[1] == col+c )){

						if(!((var.get(focus).position[0] == row+r)&&(var.get(focus).position[1] == col+c))){
							constraintVariables.add(var.get(i));
						}
					}
				}
			}
		}
	}




	/**
	 * adds the columns values into a list 
	 * it shouldn't include the current test value 
	 *
	 * @param focus the number of the current variable within the list var.
	 * @param var the list of all the variables 
	 * @return the columns, the variables within the columns. 
	 */
	private void getCol(int focus, List<Variable> var) {


		int col = var.get(focus).position[0];
		for(int row = 0; row < 9 ; row++){

			for(int i = 0; i < 81 ; i++){

				if(((var.get(i).position[0] == col) && (var.get(i).position[1] == row ))) {

					if(!((var.get(focus).position[1] == var.get(i).position[1]) && (var.get(focus).position[0] == var.get(i).position[0])) ){

						constraintVariables.add(var.get(i));
					}

				}
			}
		}

	}

	/**
	 * adds the row values into a list 
	 * it shouldn't include the current test value 
	 *
	 * @param focus the number of the current variable within the list var.
	 * @param var the list of all the variables 
	 * @return the row, the variables within the row. 
	 */
	private void getRow(int focus, List<Variable> var) {

		//adds the subgrid values into a list 
		Variable test = var.get(focus);

		int row = test.position[1];
		for(int col = 0; col < 9 ; col++){

			for(int i = 0; i < 81 ; i++){

				if(((var.get(i).position[1] == row) && (var.get(i).position[0] == col ))) {
					//it shouldnt include the current test value 
					if(!((var.get(focus).position[1] == var.get(i).position[1]) && (var.get(focus).position[0] == var.get(i).position[0])) ){
						constraintVariables.add(var.get(i));
					}
				}
			}
		}
	}
}
