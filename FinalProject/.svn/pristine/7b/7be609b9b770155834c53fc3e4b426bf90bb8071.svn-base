package src;

import java.util.ArrayList;


/**
 * The Class Board.
 */
public class Board {
	
	/** The board. */
	public int[][] board;
	
	/** The Constant row set to 3. */
	private static final int row = 3;
	
	/** The Constant col set to 3.. */
	private static final int col = 3;

	/** The current player. */
	private int currentPlayer = 0;
	
	/** The current player. */
	private int computerPlayer = 2;
	
	/** The left is the direction it is assigned. */
	public Board left; 
	
	/** The right is the direction it is assigned. */
	public Board right;
	
	/** The score. */
	public int score;
	
	/** The children array list that stores a boards children */
	public ArrayList<Board> children;

	/**
	 * Instantiates a new board.
	 */
	public Board(){
		startNewBoard();
	}

	/**
	 * Start new board by adding a new integer 2D array that is then populated with 0.
	 *
	 */
	public void startNewBoard(){
		board = new int[row][col];

		for (int i = 0; i <row; i++) 
			for(int j =0; j < col; j++) 

				board[i][j] = 0;
	}	



	/**
	 * Instantiates a new board.
	 * and populates it using the startNewBoard
	 * @param newBoard the new board
	 */
	public Board(int [][] newBoard){		
		startNewBoard();
		board = newBoard;
		//score = findScore();
	}





	/**
	 * Gets the board value that is within the paramaters 
	 * row and col 
	 *
	 * @param row the row integer to be used with the 
	 * @param col and these combined show a value
	 * @return the board
	 */
	public int getBoard(int row, int col){
		int value = board[row][col];
		return value;
	}

/**
 * The current player
 *
 * @param player the currently used
 */
public void player(int player){
	currentPlayer = player;
}


	/**
	 * Prints the board.
	 * any value this is 1 is X
	 * 0 is ignored and any other which must be 2 will be O.
	 */
	public void PrintBoard(){

		System.out.println();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 0) {
					System.out.print("_");
				} else {
					if(board[i][j] == 1){
						System.out.print("X");}
					else{
						System.out.print("O");}	

				}
				if (j < 2) {
					System.out.print("|");
				} else {
					System.out.println();
				} 
			}
		}
		System.out.println();
	}



	/**
	 * Find position initiallises the MiniMax class
	 * and creates a new board.
	 *
	 * @param player is the players current turn.
	 * @return the int[] is the move that is returned by the best move in minimax.
	 * @throws Exception 
	 */
	public int[] findPosition(int player) throws Exception{
	
		Minimax mm = new Minimax();
		Board moveBoard = new Board();
		moveBoard = setBoard(moveBoard,board);
		mm.setplayer(computerPlayer);
		
		int[] move = mm.BestMove(moveBoard, player);
		
		return move;


	}

	/**
	 * Sets the board, takes a new Board and converts it to a board 
	 * that is it takes a copy and puts it into another board.
	 *
	 * @param boardnew the new board called boardnew
	 * @param current the current 2D array board
	 * @return the board
	 */
	public Board setBoard(Board boardnew, int[][] current){

		int temp;
		@SuppressWarnings("unused")
		Board tempB;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				temp = current[i][j];
				boardnew.SetPosition(i,j,temp) ;
			}
		}
		return boardnew;
	}


	/**
	 * Checks if is move valid.
	 *
	 * @param validBoard the valid board to be tested
	 * @param row the row
	 * @param col the col
	 * @param player the player
	 * @return true, if is move valid
	 */
	public boolean isMoveValid(Board validBoard,int row, int col, int player){


		if(Check()==0)return true;



		return false;
	}


	/**
	 * Can set position checks if the set place within the board constains an 
	 * empty value, meaning it will return true if the value was 0 but if the value
	 * was anything other then it would return false.
	 *
	 * @param row the row
	 * @param col the col
	 * @return true, if successful
	 */
	public boolean canSetPosition(int row, int col){
		
		if (board[row][col] == 0){
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Sets the position if the value is true  meaning there is no current value, 
	 * this then allows the current token of the player to be placed else the space 
	 * has already been filled
	 *
	 * @param row the row
	 * @param col the col
	 * @param token of the current player
	 * @return true, if successful
	 */
	public boolean SetPosition(int row, int col, int token){
		
		if (board [row][col] == 0){
			board [row][col] = token; 
			return true;}
	
		else{
			System.out.println("Error: choose another space: ");
			return false;
		}

	}

	/**
	 * Check runs each of the methods that checks the board for wins or full
	 * else it returns with 0 that shows the program the value that each win is 
	 * or a full board.
	 *
	 * @return the int
	 */
	public int Check(){

		int ccol = checkCol();//p1 p2 3non
		//System.out.println("col: "+ccol);
		int crow = checkRow();
		//System.out.println("row: "+crow);
		int cdiad = checkDiag();
		//System.out.println("dia: "+cdiad);
		int full = 	full(); //0false 4true
		//System.out.println("full: "+full);
		if (full == 4){
			return 4;
		}
		if (ccol == 1||crow == 1||cdiad == 1){
			return 1;
		}
		if (ccol == 2||crow == 2||cdiad == 2){
			return 2;
		}

		return 0;
		//board rotate

	}

	/**
	 * Check col checks the values within each col and if all have the value 1 then 
	 * return 1, meaning X has 3 in a col
	 * this also checks the values within each col and if all have the value 2 then 
	 * return 2, meaning O has 3 in a col
	 * @return the int
	 */
	public int checkCol(){
		for (int col = 0; col<3;col++){

			if( (board[0][col] == 1) && (board[1][col] ==1) && ( board[2][col] == 1)){
				return 1;
			}

			if( (board[0][col] == 2) && (board[1][col] ==2) && ( board[2][col] == 2)){
				return 2;
			}
		}
		return 0;

	}



	/**
	 * Check row checks the values within each row and if all have the value 1 then 
	 * return 1, meaning X has 3 in a row
	 * this also checks the values within each row and if all have the value 2 then 
	 * return 2, meaning O has 3 in a row
	 * @return the int
	 */
	public int checkRow(){
		for (int row = 0; row<3;row++){

			if( (board[row][0] == 1) && (board[row][1] == 1) && ( board[row][2] == 1)){
				return 1; 
			}
			if( (board[row][0] == 2) && (board[row][1] == 2) && ( board[row][2] == 2)){
				return 2;
			}
		}
		return 0;
	}

	/**
	 * Check diagonal checks the values within each diagonal line and if all have the value 1 then 
	 * return 1, meaning X has 3 in a diagonal line 
	 * this also checks the values within each diagonal line and if all have the value 2 then 
	 * return 2, meaning O has 3 in a diagonal line
	 *
	 * @return the int
	 */
	public int checkDiag(){

		if((board[0][0] == 1) && (board[1][1] == 1 ) &&( board[2][2] == 1)){
			return 1;
		}
		if((board[0][0] == 2) && (board[1][1] == 2) &&( board[2][2] == 2)){
			return 2;
		}

		if( (board[2][0] == 1) && (board[1][1] == 1) && (board[0][2] == 1)){
			return 1;
		}
		if( (board[2][0] == 2) && (board[1][1] ==2) && (board[0][2] == 2)){
			return 2;
		}

		return 0;
	}


	/**
	 * Full boards are when all of the values within the board are are taken by 
	 * 1 or 2. 
	 *
	 * @return the int
	 */
	public int full(){
		for(int line=0 ; line<3 ; line++)
			for(int column=0 ; column<3 ; column++)
				if( board[line][column]!=0 )
					return 0;
		return 4;
	}



	/**
	 * Gets the current player.
	 *
	 * @return the player
	 */
	public int getPlayer() {
		
		return currentPlayer;
	}
	
	/**
	 * Swap player takes the current player and returns the other. 
	 *
	 * @param player the player
	 * @return the int
	 */
	public int swapPlayer(int player) {
		if (player ==1 ){
				currentPlayer = 2;
		}
		else{
			currentPlayer = 1;
		}
		return currentPlayer;
	}
	
	

	/**
	 * Sets the score that is stored within the 
	 * board. 
	 *
	 * @param score2 the new score
	 */
	public void setScore(int score2) {
		this.score = score2;
		
	}
}








