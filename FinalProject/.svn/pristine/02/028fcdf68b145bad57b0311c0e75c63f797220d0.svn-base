package src;

public class SudokuBoardModel {

	SudokuBoard currentBoard = new SudokuBoard();
	
	int[] hint = new int [3];
	
	SudokuBoard solvedBoard = new SudokuBoard();
	
	
	
	public SudokuBoard Solve(){
		
		Network network = new Network();
		
		solvedBoard = network.backtrack(currentBoard);
		
		
		//solvedBoard = network.Solve(currentBoard);
		
		
		
		return solvedBoard;
		
		
	}
	
	
	
	
	public SudokuBoard GAC(){
		
		Network network = new Network();

		hint = network.GAC(currentBoard);
		
		int value = hint[0];
		int row = hint [1];
		int col = hint [2];
		
		currentBoard.sudokuBoard[row][col].intValue = value;
		currentBoard.sudokuBoard[row][col].assigned = true;
		return solvedBoard;
		
		
		
		
	}
	
	
	
}
