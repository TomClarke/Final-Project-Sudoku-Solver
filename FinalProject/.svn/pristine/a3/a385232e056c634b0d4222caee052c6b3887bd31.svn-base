package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class AllDifferent  {

	public List<Variable> constraintVariables = new LinkedList<Variable>();

	public List<Variable> variables = new ArrayList<Variable>();

	public Network net = new Network() ;

	HashSet<Integer> result = new HashSet<Integer>();

	boolean solved = false;



	public boolean allDifferent(int i, int val, List<Variable> var) {
		//clear list for each varaible constraint
		constraintVariables.clear();

		//current variable 
		Variable test = var.get(i);

		//add test variable without assigning it as its not tested
		test.value = val;

		//get the domains from the 3 constraint locations 
		getRow(i,var);
		getCol(i,var);
		getSubgrid(i,var);

		// reset the hash table will be used to include all domains 
		result.clear();

		//how to return if there was a duplicate or not 
		//duplicate true = was passed into the hash
		//duplicate false = rejected from hash as was in there 
		boolean duplicate = false;

		//iterate the global variable ArrayList containing the domain of variable 
		for(int j = 0; j < constraintVariables.size();j++){

			result.add(constraintVariables.get(j).value);
		}
		//result of hash table input, if current variable is not within the hash 
		//meaning that it true and is different so satisfies the constraint. 
		duplicate = result.add(test.value);
		//if it satisfies remove it from the hash as it does not need to be in there, was 
		//just a test
		if(duplicate){
			result.remove(test.value);
		}
		//if the hash input was false, meaning it matched a domain it returns false
		if(!duplicate){
			return false;
		}

		return true;
	}
	
	
	public List<Variable> reduceArc(int i, List<Variable> var)	{
	
	constraintVariables.clear();

	//current variable 
	Variable test = var.get(i);
	test.domain.resetDomain();
	//add test variable without assigning it as its not tested

	//get the domains from the 3 constraint locations 
	getRow(i,var);
	getCol(i,var);
	getSubgrid(i,var);
	
	result.clear();

	//how to return if there was a duplicate or not 
	//duplicate true = was passed into the hash
	//duplicate false = rejected from hash as was in there 

	//iterate the global variable ArrayList containing the domain of variable 
	for(int j = 0; j < constraintVariables.size();j++){
		if(!(constraintVariables.get(j)==test))
		test.domain.restrictions.add(constraintVariables.get(j));
		result.add(constraintVariables.get(j).value);
	}
	//String domain = result.toString();
	LinkedList<Integer> list = new LinkedList<Integer>(result);
	for(int j = 0; j < list.size();j++){
	test.domain.removeDomain(list.get(j));
	}
	//test.printVariable();
	//System.out.println(result);
	//test.domain.printDomain(test);
	return var;
	
}

	public List<Variable> getConstraints(int i, List<Variable> var)	{
		
		constraintVariables.clear();

		//current variable 
		Variable test = var.get(i);
		test.domain.resetDomain();
		//add test variable without assigning it as its not tested

		//get the domains from the 3 constraint locations 
		getRow(i,var);
		getCol(i,var);
		getSubgrid(i,var);
		
		result.clear();

		//how to return if there was a duplicate or not 
		//duplicate true = was passed into the hash
		//duplicate false = rejected from hash as was in there 

		//iterate the global variable ArrayList containing the domain of variable 
		for(int j = 0; j < constraintVariables.size();j++){
			if(!(constraintVariables.get(j)==test))
				if(constraintVariables.get(j).isAssigned())
			test.domain.restrictions.add(constraintVariables.get(j));
			result.add(constraintVariables.get(j).value);
		}
		//String domain = result.toString();
		LinkedList<Integer> list = new LinkedList<Integer>(result);
		for(int j = 0; j < list.size();j++){
		test.domain.removeDomain(list.get(j));
		}
		//test.printVariable();
		//System.out.println(result);
		//test.domain.printDomain(test);
		return var;
		
	}
	
	//7 constraint: AllDiff: check all variables, if false(no conflicts) keep domain as all 
	//check constraints list again current
	private void getSubgrid(int focus, List<Variable> var) {

		//adds the subgrid values into a list 

		int row = var.get(focus).position[0];
		int col = var.get(focus).position[1];
		row = (row / 3) * 3 ;
		col = (col / 3) * 3 ;

		for( int r = 0; r < 3; r++ ){
			for( int c = 0; c < 3; c++ ){

				for(int i = 0; i < 81 ; i++){

					if((var.get(i).position[0] == row+r) && (var.get(i).position[1] == col+c )){
						//it shouldnt include the current test value 
						if(!((var.get(focus).position[0] == row+r)&&(var.get(focus).position[1] == col+c))){
							constraintVariables.add(var.get(i));
						}
					}
				}
			}
		}
	}




	private void getCol(int focus, List<Variable> var) {

		//adds the subgrid values into a list 
		int col = var.get(focus).position[0];
		for(int row = 0; row < 9 ; row++){

			for(int i = 0; i < 81 ; i++){

				if(((var.get(i).position[0] == col) && (var.get(i).position[1] == row ))) {
					//it shouldnt include the current test value 
					if(!((var.get(focus).position[1] == var.get(i).position[1]) && (var.get(focus).position[0] == var.get(i).position[0])) ){

						constraintVariables.add(var.get(i));
					}

				}
			}
		}

	}
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


	public boolean allDifferent(int val,Variable x, Variable y, List<Variable> var) {
			//clear list for each varaible constraint
			constraintVariables.clear();

			//current variable 
			Variable test = x;
			int i = x.number;

			//add test variable without assigning it as its not tested
			test.value = val;

			//get the domains from the 3 constraint locations 
			getRow(i,var);
			getCol(i,var);
			getSubgrid(i,var);

			// reset the hash table will be used to include all domains 
			result.clear();

			//how to return if there was a duplicate or not 
			//duplicate true = was passed into the hash
			//duplicate false = rejected from hash as was in there 
			boolean duplicate = false;

			//iterate the global variable ArrayList containing the domain of variable 
			for(int j = 0; j < constraintVariables.size();j++){

				result.add(constraintVariables.get(j).value);
			}
			//result of hash table input, if current variable is not within the hash 
			//meaning that it true and is different so satisfies the constraint. 
			duplicate = result.add(test.value);
			//if it satisfies remove it from the hash as it does not need to be in there, was 
			//just a test
			if(duplicate){
				result.remove(test.value);
			}
			//if the hash input was false, meaning it matched a domain it returns false
			if(!duplicate){
				return false;
			}

			return true;
		}

}
