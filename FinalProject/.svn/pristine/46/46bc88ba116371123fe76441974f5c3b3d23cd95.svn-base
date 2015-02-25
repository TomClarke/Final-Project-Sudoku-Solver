package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * The Class Backtracking that implements a backtracking algorithm that inserts a value 
 * between 1-9 and then iterates through the algorithm until all the correct values have 
 * been found due to all of the constraints being satisfied. 
 */
public class Backtracking implements Constraint{

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



	/* 4. constraint: take variable & domain
	 * 5. constraint: new domains for each variable
	 * 6. constraint: apply constraint 
	 * 7. constraint: AllDiff: check all variables, if false(no conflicts) keep domain as all 
	 * 8. constraint: AllDiff: check all variables, if true(conflicts) use conflict var and take from domain
	 * 9. constraint: Return new domains 
	 */

	/** 
	 * Clears the constraints within the scope for each application of the algorithm. 
	 * the global variable list is also cleared for a new instance of the algorithm. 
	 * 
	 * the variable list is added to the current variables within this class  
	 * 
	 * the backtracking algorithm method is called and given the variables list and started at the
	 * first variable within that list. 
	 * When the backtracking algorithm returns with a boolean it is set to true if the sudoku 
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

	/**
	 * Backtracking algorithm that takes a list of variables and a counter 
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


	/**
	 * this is called to return if the algorithm was solved and returns the variable solved. 
	 **/
	@Override
	public boolean solved() {

		return solved;
	}



	/**
	 * View values updates the view with the current values of each cell, this 
	 * is so that the user can view the values. 
	 * This updates the entire board when called
	 * @param var the list of variables
	 * @param num the current number of values
	 */
	public void viewValues(List<Variable> var, int num){ 
		int count= 0;	

		SudokuBoard updateBoard = new SudokuBoard();
		for(int k = 0; k < 9 ; k++){
			for(int l = 0; l < 9 ; l++){
				if(count == num){
					updateBoard.sudokuBoard[k][l].current();
				}
				else{
					updateBoard.sudokuBoard[k][l].notCurrent();
				}

				updateBoard.sudokuBoard[k][l].setValue(var.get(count).value);
				count++;
			}
		}

		updateBoard.Currentboard = updateBoard;
		updateBoard.PrintBoard();
		//m_view.
		//m_view. .SudokuMenuView(updateBoard);
		//m_view.addNewBoard(updateBoard);
		//SudokuMenuView m_view = new SudokuMenuView(updateBoard);
		//m_view.updateBoard(updateBoard);
	}

}
