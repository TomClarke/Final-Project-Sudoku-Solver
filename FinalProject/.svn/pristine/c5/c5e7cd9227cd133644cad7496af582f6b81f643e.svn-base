package src;

public class SudokuBoardModel {

	SudokuBoard currentBoard = new SudokuBoard();
	
	public SudokuBoard Solve(String solvingMethod){
		Network network = new Network();
		currentBoard = network.solve(solvingMethod,currentBoard);
		return currentBoard;
	}
}
