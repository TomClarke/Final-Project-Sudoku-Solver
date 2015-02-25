/**
 *
 *Created by Thomas Clarke
 * 
 **/
import java.util.Scanner;


/**
 * The Queens problem is a constraint satisfaction problem where there are rules that only allow the queens to be positioned one queen on 
 * each line and column.
 * I have researched this by using these sources:
 * http://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
 * http://compsci.ca/v3/viewtopic.php?t=21497
 * http://stackoverflow.com/questions/4130640/solving-eight-queens-problem-with-2-d-array-indexoutofbounds-error
 * 
 */
public class Queens {
	
	/** The board size that is specified from the user */
	static int boardSize;
	
	/** Instantiates the board the board which is a 2D array. */
	static int[][] board;

	/**
	 * Instantiates a new queens.
	 *
	 * @param size the size of the board 
	 * and this constructor creates a 2D array that is the size of the boardSize squared 
	 * but it will also contain all 0, which means it is empty 
	 */
	public Queens (int size){
		this.boardSize = size;
		board = new int [size][size];

		for (int row = 0 ; row < size; row++)
			for (int col = 0 ; col < size; col++)
				board[row][col] = 0;
	}


	/**
	 * The main method creates the user engagement and allows the inputs for the user to
	 * set the size of the board as well as select if the user should be able to play 
	 * or the back tracking algorithm is used.
	 *
	 * @param args the arguments
	 */
	public static void main (String args []){

		Scanner scanner = new Scanner(System.in);
		System.out.println("This is the Queens game what size board would you like?");
		boardSize = scanner.nextInt();
		Queens game = new Queens(boardSize);
		System.out.println("Try it on your own (1)");
		System.out.println("Use Backtracking   (2)");
		int typeOfGame = scanner.nextInt();
		if( typeOfGame == 2){

			game.backtracking(0);
			game.print(board);
		}
		else{
			System.out.println("Add position of next Queen: Row");
			int row = scanner.nextInt();
			System.out.println("Add position of next Queen: Col");
			int col = scanner.nextInt();
			board[row][col] = 1;
			while (!game.check(row,col)){
				game.print(board);
				System.out.println("Add position of next Queen: Row");
				row = scanner.nextInt();
				System.out.println("Add position of next Queen: Col");
				col = scanner.nextInt();
				board[row][col] = 1;
				game.check(row, col);

			}
			System.out.println("Game Ended");
		}
	}


	/**
	 * Backtracking.
	 *
	 * @param col the col
	 * @return true, if successful
	 */
	private boolean backtracking(int col) {
		int row = 0;
		if (col == boardSize){
			return true;
		}
		else{

			boolean attempt = false;

			while((row < boardSize) && !attempt){
				if (check(row,col)){

					row++;
				}

				else {

					board[row][col] = 1 ;
					attempt = backtracking(col+1);

					if (!attempt ){
						board[row][col] = 0;
						row++;	
					}
				}
			}	
			return attempt;
		}
	}

	/**
	 * Check.
	 *
	 * @param row the row
	 * @param col the col
	 * @return true, if successful
	 */
	public boolean check(int row, int col) {

		//behind 
		for (int test = 0; test < col; test ++){
			if(board[row][test] == 1){
				return true;
			}
		}

		//front

		for (int test = col+1; test < boardSize; test++){
			if (board[row][test] == 1){
				return true;
			}
		}
		for (int test = 1; test <= col; test ++){
			if (row < test){
				break;
			}
			if(board[row-test][col-test] == 1){
				return true;
			}
		}
		for (int test = 1; test <= col; test ++){
			if (row + test >= boardSize){
				break;
			}
			if(board[row+test][col - test] == 1){
				return true;
			}
		}

		return false;

	}

	/**
	 * Prints the.
	 *
	 * @param board the board
	 */
	public void print(int[][] board ){

		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++){

				if (board[i][j] == 1){
					System.out.print(" Q ");
				}
				else {
					System.out.print(" * ");
				}
			}
			System.out.println();

		}

	}	

}
