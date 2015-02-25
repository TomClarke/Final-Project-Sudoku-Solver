package src;
//http://www.planetsourcecode.com/vb/scripts/ShowCode.asp?txtCodeId=6671&lngWId=2
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Minimax {
	//http://www.codeproject.com/Articles/43622/Solve-Tic-Tac-Toe-with-the-MiniMax-algorithm
	// Big Java Book CAY S. HORSTMANN pages 664-676
	//Algortihms in a nutshell George T. Heineman, Gary Pollice & Stanley
	//Selkow.Page 222 
	//https://github.com/Qazzian/UniWork/tree/master/TicTacToe

	// The minimax code is modified from https://github.com/Qazzian/UniWork/blob/master/TicTacToe/Minimax.java

	int depth;
	int maxDepth = 4;
	int compPlayer;
	int humanPlayer;
	
	public List<int[]> moves = null;  

	

	public Minimax(){

	}

	public Minimax(int compPlayer, int maxDepths){
		this.setplayer(compPlayer);
		this.setDepth(maxDepths);
	}

	public Minimax(int aCompPlayer ){
		this.setplayer(aCompPlayer);
	}

	public void setDepth(int odepth){
		depth = odepth;
	}

	public void setplayer(int compPlayer){
		if(compPlayer == 1 ){
			compPlayer = 1;
			humanPlayer = 2;
		}
		if(compPlayer == 2 ){
			compPlayer = 2;
			humanPlayer = 1;
		}
	}

	public int comPlayer(){
		return compPlayer;
	}

	public int humanPlayer(){
		return humanPlayer;
	}



	public int[] BestMove(Board aboard,int player) {
		depth++;
		Node newNode = new Node(new Board(aboard.board));
	
		newNode.board.player(aboard.getPlayer());

		int players = player;

		Node child;
		Node highScoreNode = new Node();
		highScoreNode.setScore(-11);
		int[] highMove = new int [3];
		Node lowNode = new Node();
		lowNode.setScore(11);
		int[] lowMove = new int[3];

		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){

				System.out.println("checking: (" + row +"," + col + ") at Depth: " + depth);

				if(newNode.board.canSetPosition(row,col)){

					Board temp = new Board(newNode.board.board);
					temp.SetPosition(1, 1, 1);
					temp.PrintBoard();
					temp.SetPosition(row, col, player);
					child = new Node(temp);
					newNode.add(child);

					if(temp.Check() == player) {
						if (player == compPlayer) {
							child.board.setScore(10);
						}
						else if (player == humanPlayer) {
							child.board.setScore(-10);
						}
						else {
							System.out.println("Error: Player Number");

						}
						System.out.println("Player "+ player + "Won this node: ");
						temp.PrintBoard();
					}
					else {
						if (depth == maxDepth){
							 child.board.Check();
						
							child.board.swapPlayer(players);
						}
						else{
							int [] move = BestMove(child.board,child.board.swapPlayer(player));
							child.board.SetPosition(move[0], move[1],player);
							child.setScore(move[2]);
						}
						System.out.println("Node evaluated to" + child.score);
						child.board.PrintBoard();
					}

					if(child.board.score > highScoreNode.board.score){
						highScoreNode = child;
						highMove[0] = row;
						highMove[1] = col;
						highMove[2] = child.board.score;
						child.board.PrintBoard();
					}
					if(child.board.score < lowNode.board.score){
						lowNode = child;
						lowMove[0] = row;
						lowMove[1] = col;
						lowMove[2] = child.board.score;
						child.board.PrintBoard();
					}
				}
			}

			if(player == compPlayer) {
				newNode.setScore(highScoreNode.board.score);
				highScoreNode.board.PrintBoard();
				depth--;

				return highMove;
			}
			else if(player == humanPlayer){
				newNode.setScore(lowNode.score);
				depth--;
				return lowMove;
			}
			else {
				System.out.println("Player No invalid end");

			}
		}
		return lowMove;




	}


}