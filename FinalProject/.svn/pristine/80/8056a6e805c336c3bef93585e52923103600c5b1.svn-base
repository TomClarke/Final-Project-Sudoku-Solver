package src;

import java.util.ArrayList;


public class Board {
	int[][] board;
	private static final int row = 3;
	private static final int col = 3;
	private static final int size = 3;
	//TicTacToe game = new TicTacToe();

	private int currentPlayer = 0;
	public Board left; 
	public Board right;
	public int score;
	public ArrayList<Board> children;

	public Board(){
		startNewBoard();
	}

	public void startNewBoard(){
		board = new int[row][col];

		for (int i = 0; i <row; i++) 
			for(int j =0; j < col; j++) 

				board[i][j] = 0;
	}	



	public Board(int [][] newBoard){		
		startNewBoard();
		board = newBoard;
		//score = findScore();
	}



	


	public void addToTree(Board newBoard){
		int compare = ((Integer)newBoard.score).compareTo(score);
		if (compare < 0){
			if (left == null) left = newBoard;
			else left.addToTree(newBoard);
		}
		if (compare > 0){

			if (right == null) right = newBoard;
			else right.addToTree(newBoard);
		}
	}

	public void printTree(){
		if( left!= null)
			left.printTree();
		System.out.println(score + "");
		if (right!= null) 
			right.printTree();

	}




	public int getBoard(int i, int j){
		int value = board[i][j];
		return value;
	}

public void player(int player){
	currentPlayer = player;
}


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



	public int[] findPosition(int player){
	
		Minimax mm = new Minimax();
		Board moveBoard = new Board();
		moveBoard = setBoard(moveBoard,board);
		
		int[] move = mm.BestMove(moveBoard, player);
		
		return move;


	}

	public Board setBoard(Board boardnew, int[][] current){

		int temp;
		Board tempB;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				temp = current[i][j];
				boardnew.SetPosition(i,j,temp) ;
			}
		}
		return boardnew;
	}


	public boolean isMoveValid(Board validBoard,int row, int col, int player){


		if(Check()==0)return true;



		return false;
	}


	public boolean canSetPosition(int row, int col){
		
		if (board[row][col] == 0){
			return true;
		}
		else {
			return false;
		}
	}

	public boolean SetPosition(int row, int col, int token){
		
		if (board [row][col] == 0){
			board [row][col] = token; 
			return true;}
	
		else{
			System.out.println("Error: choose another space: ");
			return false;
			//game.play();
		}

	}

	//public void SetPosition(Board bestBoards, int token){
	//	board[row][col] = bestBoards[row][col];
	//	board[row][col]= token;


	//game.play();
	//}
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


	public int full(){
		for(int line=0 ; line<3 ; line++)
			for(int column=0 ; column<3 ; column++)
				if( board[line][column]!=0 )
					return 0;
		return 4;
	}



	public int getPlayer() {
		
		return currentPlayer;
	}
	public int swapPlayer(int player) {
		if (player ==1 ){
				currentPlayer = 2;
		}
		else{
			currentPlayer = 1;
		}
		return currentPlayer;
	}
	
	

	public void setScore(int score2) {
		this.score = score2;
		
	}
}








