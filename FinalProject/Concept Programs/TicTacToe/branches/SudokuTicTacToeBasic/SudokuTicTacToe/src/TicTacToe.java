package src;
import java.util.Scanner;



// Big Java Book Program example practise
public class TicTacToe {
	

	private static final int row = 3;
	private static final int col = 3;
	public Board board;
	public int player1;
	public int player2;
	public Board bestBoard;
	public Scanner in = new Scanner(System.in);
	
	public static void main(String [] args){
		System.out.println("Welcome");
		TicTacToe game = new TicTacToe();
		
	
	}
	
	public TicTacToe(){
		board = new Board();
		start();
	}
	
	public void start(){
		//setup 
		board = new Board();
		board.startNewBoard();
		System.out.println("Starting TicTacToe game..");
		System.out.println("How many Players");
		int NoPlayers = in.nextInt();
		if (NoPlayers == 1){
			player1 = 1;
			player2 = 0;
			//player 1
		}
		if (NoPlayers == 2){
			player1 = 1;
			player2 = 2;
			//player 2 real or not
		}
		
		play();
		
		
	}
	
	public void play(){

		//TicTacToe game = new TicTacToe();
		int token = 0;
		System.out.println("please enter the row :");
		int row = in.nextInt();
		System.out.println("please enter the cols :");
		int col = in.nextInt();
		//enter 
		
			token = 1; //"X";
		
		
		//place X
		board.SetPosition(col, row, token);
		board.PrintBoard();
		int num = board.Check();
		System.out.println(num);
		if(num == 1){
			won(player1);	
		}
		if(num == 0){
				System.out.println("turn 2 :");
				turn(1);
		}
		if(num == 4){
			draw();
		}


		//check won 
		//next turn 
	}
	
	public void playAuto(){
		
		int player = 2; //"O";
		//best option
	
		Board bestBoards;
	    bestBoards = board.findPosition(player);
	    board.PrintBoard();
	  
		board.SetPosition(bestBoards, player);
		if(board.Check() == player){
			won(player2);
		}
		if(board.Check() == 0||board.Check()==1){
			System.out.println("turn 1 :");
			turn(2);
		}
		if(board.Check() == 4){
			draw();
		}
		
		
		//place O
	}
	public void turn(int player){
		
		if (player == 1){
			//player 2's go
			playAuto();
		}
		else {
			play();
		}
		//whos turn is it
		//if X then play
		//if Y then playAuto
		
	}
	
	public void won(int player){
		//search board 
		//who won
		System.out.println("Player "+ player + " won: ");
		System.out.println("Rematch? Y=1 Else press any key");
		int rematch =  in.nextInt();
		if(rematch == 1){
			main(null);
		}
		else{
			System.out.println("Thanks for playing");
		}
		//display win
	 
	}
	public void draw(){
	System.out.println("Draw");
	System.out.println("Rematch? Y=1 Else press any key");
	int rematch =  in.nextInt();
	if(rematch == 1){
		main(null);
	}
	else{
		System.out.println("Thanks for playing");
	}
	}
}
	

