package src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.tools.JavaFileManager.Location;

public class AllDifferent implements Constraint {


	boolean canAssignValue = false; 
	
	public List<Variable> constraintVariables = new LinkedList<Variable>();

	public List<Integer> focusDomain = new LinkedList<Integer>();
	
	public List<Variable> variables = new ArrayList<Variable>();
	
	public Network net = new Network() ;
	
	HashSet<Integer> result = new HashSet<Integer>();

	/* 4. constraint: take variable & domain
	 * 5. constraint: new domains for each variable
	 * 6. constraint: apply constraint 
	 * 7. constraint: AllDiff: check all variables, if false(no conflicts) keep domain as all 
	 * 8. constraint: AllDiff: check all variables, if true(conflicts) use conflict var and take from domain
	 * 9. constraint: Return new domains 
	 */

	@Override
	public List<Variable> applyConstraints(List<Variable> variableList) {
//reset the lists 
		constraintVariables.clear();
		focusDomain.clear();
		variables.clear();

		this.variables = variableList;

		System.out.println("Backtrack:");

		boolean solved = backtrack(0,variables);

		if (!solved){
			System.out.println("cannot be solved");
		}

		return variables;
	}
	/*http://en.wikipedia.org/wiki/Sudoku_solving_algorithms#Backtracking

	" Initialize 2D array with 81 empty grids(nx=9,ny=9)
     Fill in some empty grid with the known values
     Make an original copy of the array
     Start from top left grid(nx=0,ny=0), check if grid is empty
     if (grid is empty){
     assign the empty grid with values (i) 
       if (no numbers exists in same rows & same columns same as (i))
       fill in the number
       if (numbers exists in same rows & same columns same as (i))
       discard (i) and repick other values (i++)
     }else{
       while (nx<9){
         Proceed to next row grid(nx++,ny)
           if (nx equal 9){
           reset nx = 1
           proceed to next column grid(nx,ny++)
               if (ny equal 9){
               print solutions
               }
           }           
     }"
	 */
	
	private boolean backtrack(int num, List<Variable> var) {
		System.out.println("num: "+num);

		if(num == var.size()){
			
			return true;
		}

		if(var.get(num).isAssigned()){
			return backtrack(num+1,var);
		}

		for(int val = 1; val <= 9; val++){

			if(allDifferent(num,val,var)) {

//assigns variable and sets it to assigned = true
				var.get(num).assignVar(val);
				


				if (backtrack(num+1,var))
					//only returns true if board can be solved 
				return true;
			}

		}
		var.get(num).unAssignVar();
	
		return false;

	}

	
	private boolean allDifferent(int i, int val, List<Variable> var) {
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
	
	public boolean solved(Variable v) {
		return false;
	}

	@Override
	public int[] GAC(List<Variable> variableList) {
		GACCheckUpdatedDomains();
		GACGetLowestDomain() ;
		return null;
	}

	public int GACCheckUpdatedDomains() {
		return 0;
	}

	public int GACGetLowestDomain() {
		return 0;
	}

	public List<Constraint> checkAssigned()  {
		return null;
	}
}
