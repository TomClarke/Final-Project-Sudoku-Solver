package src;

public class Board {
	int[][] board;
	private static final int row = 3;
	private static final int col = 3;
	int[] state = {1,2,-1};
	//TicTacToe game = new TicTacToe();

	public void board(){
		startNewBoard();
	}

	public void startNewBoard(){
		board = new int[row][col];

		for (int i = 0; i <row; i++) 
			for(int j =0; j < col; j++) 

				board[i][j] = -1;
	}	
	


	public void PrintBoard(){

		System.out.println();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == -1) {
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
	

	
	public int getBoard(int i, int j){
		int value = board[i][j];
		return value;
	}
	
	public  int[][] is(int i, int j,int add){
		
		board [i][j] = add;
		
		return board;
	}
	
	public Board copy(int[][] board){
		
		Board newB = null;
	
		for (int i=0; i<=3; i++){
			for (int j=0; j<=3; j++){
			
		newB.board[i][j] = board[i][j] ;
			}
		}
		return newB;
	}

	
	
	public Board findPosition(int player){
		
		Board newBoard = null;
        GameTree tree = new GameTree(board);
       // newBoard = move(newBoard, player);
		//in current board 
		//copy board into tree
		//find 
		//all options of board
		//best option 
		 //block
		 //prevent 
		
		//out board [][] = 2
		//board[1][0] = 2;
		newBoard = treefind(2,player);
		newBoard.PrintBoard();
		newBoard.copy(board);
		
	
		
		
		return newBoard;
		
	}

	public boolean SetPosition(int col, int row, int player){
	
		if (board [row][col] == -1){
			board [row][col] = player; }
		else{
			System.out.println("Error: choose another space: ");
			return false;
			//game.play();
		}

		return true;
	}

	public void SetPosition(Board useBoard, int player){
	
		
		
		for (int i=0; i<=3; i++){
			for (int j=0; j<=3; j++){
			
		board = useBoard.is(i, j,board[i][j]);
			}
		}
	}

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

			if( board[0][col] + board[1][col] + board[2][col] == 3){
				return 1;
			}

			if( board[0][col] + board[1][col] + board[2][col] == 6){
				return 2;
			}
		}
		return 0;

	}



	public int checkRow(){
		for (int row = 0; row<3;row++){

			if( board[row][0] + board[row][1] + board[row][2] == 3){
				return 1;
			}
			if( board[row][0] + board[row][1] + board[row][2] == 6){
				return 2;
			}
		}
		return 0;
	}

	public int checkDiag(){
		
				if( board[0][0] + board[1][1] + board[2][2] == 3){
					
					return 1;
				}
				if( board[0][0] + board[1][1] + board[2][2] == 6){
					return 2;
				}

				if( board[2][0] + board[1][1] + board[0][2] == 3){
					return 1;
				}
				if( board[2][0] + board[1][1] + board[0][2] == 6){
					return 2;
				}

		return 0;
	}


	public int full(){
		for(int line=0 ; line<3 ; line++)
			for(int column=0 ; column<3 ; column++)
				if( board[line][column]!=-1 )
					return 0;
		return 4;
	}
	
	
	
	

	private void undoMove(int r, int c)
	{
		
		board[r][c] = 0;
	}
}








