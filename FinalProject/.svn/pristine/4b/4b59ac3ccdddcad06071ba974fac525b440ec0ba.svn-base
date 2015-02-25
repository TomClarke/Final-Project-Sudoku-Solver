package src;

public class SudokuBoardModel {

	SudokuBoard currentBoard = new SudokuBoard();
	
	int[] hint = new int [3];
	
	public SudokuBoard Solve(String solvingMethod){
		Network network = new Network();
		currentBoard = network.solve(solvingMethod,currentBoard);
		return currentBoard;
	}
	/*
	public SudokuBoard GAC(){
		
		Network network = new Network();

		hint = network.GAC(currentBoard);
		
		int value = hint[0];
		int row = hint [1];
		int col = hint [2];
		
		currentBoard.sudokuBoard[row][col].intValue = value;
		currentBoard.sudokuBoard[row][col].assigned = true;
		return currentBoard;
	}
	*/
	
	
}
