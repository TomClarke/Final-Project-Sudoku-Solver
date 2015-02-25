package src;

/**
 *
 *Created by ThomasClarke
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
	int count = 1;
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
	 * Backtracking algorthim that adds the queen to a loaction and then 
	 * it is checked. 
	 * if an attemp is made then the boolean value is set to false until 
	 * the algorithm finds a queen that is allowed to stay there. 
	 *
	 * @param col the coloum that the queen can be placed in 
	 * @return true, if a queen can be placed in that location  
	 */
	private boolean backtracking(int col) {
		int row = 0;
		if (col == boardSize){
			print(board);
			return false;

		}
		else {

			boolean attempt = false;

			while((row < boardSize) && !attempt){
				if (check(row,col)){
					// check the row and col using the check() method.
					// consider next square in col
					row++;
				}

				else {
					// places a queen in the nect col 
					
					board[row][col] = 1 ;
					attempt = backtracking(col+1);

					if (!attempt ){
						//if queen is not true meaning queen move is not valid
						//try next square in col
						board[row][col] = 0;
						row++;	
					}
				}
			}	
			return attempt;
		}
	}

	/**
	 * Check method uses the location and the board to check that the new 
	 * loaction will be safe for the queen to be put into, each for loop 
	 * checks the board for the invalid positions. 
	 * for loop 1 checks behind 
	 * for loop 2 checks the next coloum
	 * for loop 3 checks up diagonal 
	 * for loop 4 checks down diagonal
	 *
	 * @param row the row
	 * @param col the col
	 * @return true, if successful
	 */
	public boolean check(int row, int col) {

		//for loop 1  
		for (int test = 0; test < col; test ++){
			if(board[row][test] == 1){
				return true;
			}
		}
		//for loop 2 
		for (int test = col+1; test < boardSize; test++){
			if (board[row][test] == 1){
				return true;
			}
		}
		//for loop 3 
		for (int test = 1; test <= col; test ++){
			if (row < test){
				break;
			}
			if(board[row-test][col-test] == 1){
				return true;
			}
		}
		//for loop 4 
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
	 * Prints the board by using two for loops to print the board 
	 * with the 2D array 
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
		System.out.println(count);
		count++;

	}	

}
