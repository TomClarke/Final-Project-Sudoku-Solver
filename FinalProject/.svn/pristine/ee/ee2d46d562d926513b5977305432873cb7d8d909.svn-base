package src;

/**
 * The Class SudokuBoardModel that creates an object that the constraint network uses to solve
 * the current sudoku
 */
public class SudokuBoardModel {

	/** The current board. */
	public SudokuBoard currentBoard = new SudokuBoard();
	
	/**
	 * Solve passes the currentBoard into the network along with the solving method and returns 
	 *
	 * @param solvingMethod the solving method
	 * @return the sudoku board
	 */
	public SudokuBoard Solve(String solvingMethod){
		Network network = new Network();
		currentBoard = network.solve(solvingMethod,currentBoard);
		return currentBoard;
	}
}
