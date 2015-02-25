package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Backtracking implements Constraint{

public List<Variable> constraintVariables = new LinkedList<Variable>();
	
	public List<Variable> variables = new ArrayList<Variable>();
	
	public Network net = new Network() ;
	
	HashSet<Integer> result = new HashSet<Integer>();
	
	public boolean solved = false;
	
	public AllDifferent allDiff = new AllDifferent();
	


	/* 4. constraint: take variable & domain
	 * 5. constraint: new domains for each variable
	 * 6. constraint: apply constraint 
	 * 7. constraint: AllDiff: check all variables, if false(no conflicts) keep domain as all 
	 * 8. constraint: AllDiff: check all variables, if true(conflicts) use conflict var and take from domain
	 * 9. constraint: Return new domains 
	 */

	@Override
	public List<Variable> applyConstraints(List<Variable> variableList) {
		constraintVariables.clear();
		variables.clear();

		this.variables = variableList;

		System.out.println("Backtrack:");

		solved = backtrack(0,variables);

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

		if(num == var.size()){
			
			return true;
		}

		if(var.get(num).isAssigned()){
			return backtrack(num+1,var);
		}

		for(int val = 1; val <= 9; val++){

			//viewValues(var,num);
			//if(allDiff.allDifferent(num,val,var)) {
			if(allDiff.allDifferent(num,val,var)) {
			
				
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
	
	
	@Override
	public boolean solved() {
		
		return solved;
	}


}
