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
	//public Variable focus = new Variable();

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
		//System.out.println("num: "+num);

		if(num == var.size()){
			
			return true;
		}

		if(var.get(num).isAssigned()){
			return backtrack(num+1,var);
		}

		for(int val = 1; val <= 9; val++){

			if(allDifferent(num,val,var)) {


				var.get(num).assignVar(val);
				


				if (backtrack(num+1,var))
					
				return true;
			}

		}
		var.get(num).unAssignVar();
	
		return false;

	}

	

	private boolean allDifferent(int i, int val, List<Variable> var) {

		constraintVariables.clear();

		Variable test = var.get(i);

		test.value = val;



		getRow(i,var);
		getCol(i,var);
		getSubgrid(i,var);
	

		result.clear();
		boolean duplicate = false;
		//System.out.println();
		//System.out.print("consts: [");
		for(int j = 0; j < constraintVariables.size();j++){



			result.add(constraintVariables.get(j).value);

		//	System.out.print(constraintVariables.get(j).value);
		}
		//System.out.print("]");
		
		duplicate = result.add(test.value);

		if(duplicate){
		//	System.out.println(duplicate);
			result.remove(test.value);
		}

		//test.printVariable();
	
		//System.out.println(result);
	

		if(!duplicate){
			//already in set 
			return false;
		}
		
		return true;
		



	}






	//7 constraint: AllDiff: check all variables, if false(no conflicts) keep domain as all 
	//check constraints list again current


	private void getSubgrid(int focus, List<Variable> var) {


		int row = var.get(focus).position[0];
		int col = var.get(focus).position[1];

		//System.out.println();
		//System.out.print("Subgrid: ");
		row = (row / 3) * 3 ;
		col = (col / 3) * 3 ;

		for( int r = 0; r < 3; r++ ){
			for( int c = 0; c < 3; c++ ){

				for(int i = 0; i < 81 ; i++){
					
					if((var.get(i).position[0] == row+r) && (var.get(i).position[1] == col+c )){
						if(!((var.get(focus).position[0] == row+r)&&(var.get(focus).position[1] == col+c))){
							constraintVariables.add(var.get(i));
						//	System.out.print(var.get(i).value);
						}
					}
				}
			}
		}
	}




	private void getCol(int focus, List<Variable> var) {

		//System.out.println();
		int col = var.get(focus).position[0];
		//System.out.print("col: ");
		for(int row = 0; row < 9 ; row++){

			for(int i = 0; i < 81 ; i++){
				
				if(((var.get(i).position[0] == col) && (var.get(i).position[1] == row ))) {
		
					if(!((var.get(focus).position[1] == var.get(i).position[1]) && (var.get(focus).position[0] == var.get(i).position[0])) ){
					
						constraintVariables.add(var.get(i));
				//		System.out.print(var.get(i).value);
					}
					
				}
			}
		}
	
	}
	private void getRow(int focus, List<Variable> var) {

		Variable test = var.get(focus);
		//System.out.println();
		//System.out.print("row: ");
		
		int row = test.position[1];
		for(int col = 0; col < 9 ; col++){

			for(int i = 0; i < 81 ; i++){
				
				if(((var.get(i).position[1] == row) && (var.get(i).position[0] == col ))) {
					if(!((var.get(focus).position[1] == var.get(i).position[1]) && (var.get(focus).position[0] == var.get(i).position[0])) ){
						constraintVariables.add(var.get(i));
					//	System.out.print(var.get(i).value);
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
		//use priority queue
		return 0;
	}

	public List<Constraint> checkAssigned()  {

		return null;


	}

	public static List<Variable> removeDuplicates(List<Variable> constraintVariables2){
		Set<Variable> set = new HashSet<Variable>();       
		for(int i=0;i<constraintVariables2.size();++i){
			set.add(constraintVariables2.get(i));
		}//endFori

		List<Variable> vari = new LinkedList<Variable>();

		for(Variable u : set){
			vari.add(u);
		}
		return vari;
	}


}
