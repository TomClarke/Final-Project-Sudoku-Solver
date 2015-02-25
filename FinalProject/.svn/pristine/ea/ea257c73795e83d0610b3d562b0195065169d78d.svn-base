package src;


import java.util.List;

import src.Board;
import src.Node;


/**
 * The Class Minimax.
 */
public class Minimax {

	//http://www.codeproject.com/Articles/43622/Solve-Tic-Tac-Toe-with-the-MiniMax-algorithm
	// Big Java Book CAY S. HORSTMANN pages 664-676

	//https://github.com/Qazzian/UniWork/tree/master/TicTacToe
	//http://www.planetsourcecode.com/vb/scripts/ShowCode.asp?txtCodeId=6671&lngWId=2
	// The minimax code is modified from https://github.com/Qazzian/UniWork/blob/master/TicTacToe/Minimax.java

	/** The depth. */
	int depth;

	/** The max depth. */
	int maxDepth = 7;

	/** The comp player. */
	int compPlayer;

	/** The human player. */
	int humanPlayer;

	/** The moves that are stored within a list */
	public List<int[]> moves = null;  


	// The minimax code is modified from https://github.com/Qazzian/UniWork/blob/master/TicTacToe/Minimax.java
	/**
	 * Instantiates a new minimax.
	 */
	public Minimax(){

	}

	/**
	 * Instantiates a new minimax.
	 *
	 * @param compPlayer the comp player
	 * @param maxDepths the max depths
	 */
	public Minimax(int compPlayer, int maxDepths){
		this.setplayer(compPlayer);
		this.setDepth(maxDepths);
	}

	/**
	 * Instantiates a new minimax.
	 *
	 * @param aCompPlayer is a computer player
	 */
	public Minimax(int aCompPlayer ){
		this.setplayer(aCompPlayer);
	}

	/**
	 * Sets the depth.
	 *
	 * @param odepth the new depth
	 */
	public void setDepth(int odepth){
		depth = odepth;
	}

	/**
	 * Sets the player.
	 *
	 * @param compPlayer the new player
	 */
	public void setplayer(int compsPlayer){
		if(compsPlayer == 1 ){
			compPlayer = 1;
			humanPlayer = 2;
		}
		if(compsPlayer == 2 ){
			compPlayer = 2;
			humanPlayer = 1;
		}
	}

	/**
	 * Computer player.
	 *
	 * @return the int
	 */
	public int comPlayer(){
		return compPlayer;
	}

	/**
	 * Human player.
	 *
	 * @return the int
	 */
	public int humanPlayer(){
		return humanPlayer;
	}

	//The minimax code is modified from: Algortihms in a nutshell George T. Heineman, Gary Pollice & Stanley Selkow.Page 222 

	/**
	 * Best move method uses the minimax algorithm to gather the current boards and adds them to a 
	 * tree to be sorted and the next moves are created and then sorted. 
	 *
	 * @param aboard is the board that is passed 
	 * @param player the player
	 * @return the int[]
	 * @throws Exception 
	 */
	public int[] BestMove(Board aboard,int nplayer) throws Exception {
		
		//each time best move is run the depth is incremented. 
		depth++;
		Node newNode = new Node(new Board(aboard.board));
		//create a new node that contains the adoard board
		newNode.board.player(aboard.getPlayer());
		//set that boards player to the current player
		//initialise the nodes and moves 
		int player = nplayer;
		Node child;
		Node highScoreNode = new Node();
		//high positioned nodes are given a low score
		highScoreNode.setScore(-1);
		int[] highMove = new int [3];
		Node lowNode = new Node();
		//low positioned nodes are given a high score
		lowNode.setScore(1);
		int[] lowMove = new int[3];

		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){

				System.out.println("checking: (" + row +"," + col + ") at Depth: " + depth);
				// if the new node can be set, ie the position is not filled currently 
				if(newNode.board.canSetPosition(row,col)){
					//creates a temp board that then is given a position and printed, then the 
					//boards are created by iterating through the positons, at each point a node is created 
					//that is a child of the previous and is added to the newNode
					Board temp = new Board(newNode.board.board);
					temp.PrintBoard();

					temp.SetPosition(row, col, player);
					child = new Node(temp);
					newNode.add(child);

					//if temp check() returns that the player will win 
					if((temp.Check() == 1 )|| (temp.Check() == 2)) {
						//if player = player2 then set score 10 else -10
						if (player == compPlayer) {
							child.setScore(10);

						}
						else if (player == humanPlayer) {
							child.setScore(-10);
						}
						else {
							System.out.println("Error: Player Number"+player);
						
							break;
						}
						System.out.println("Player "+ player + " Won node: ");
						//temp.PrintBoard();
					}
					else {
						//if the depth is at the max which is set to 4, as the board size should not 
						//be big enough to allow the depth to need to be done more than 4 times to cover 
						//every move 
						if (depth == maxDepth){
							int value = child.board.Check();
							child.score = value;
							//check the child and swap the players
							//child.board.swapPlayer(player);
						}
						else{
							//this is the move that is given by the bestMove method recursive function
							//the input is the current boards child
							int [] move =  new int[2];
							move = BestMove(child.board,child.board.swapPlayer(player));

							//set position that is placed within the board 
							child.board.SetPosition(move[0], move[1],player);
					
							child.setScore(move[2]);
							System.out.println(move[0]);
							System.out.println(move[1]);
							System.out.println(move[2]);

						}
						System.out.println("Node evaluated to: " + child.score);
						child.board.PrintBoard();
					}
					// if the child score is less the the high node score then replace highscore node 
					// with the child 
					if(child.score > highScoreNode.score){
						highScoreNode = child;
						highMove[0] = row;
						highMove[1] = col;
						highMove[2] = child.score;
						child.board.PrintBoard();
					}
					//the child node is less than the low node the child is now 
					// set as the low node
					if(child.score < lowNode.score){
						lowNode = child;
						lowMove[0] = row;
						lowMove[1] = col;
						lowMove[2] = child.score;
						child.board.PrintBoard();
					}
				}
			}
		}
		System.out.println("Player: "+ player);
		// the player is the computer set the new node score to the high node score
		if(player == compPlayer) {
			newNode.setScore(highScoreNode.score);
			//highScoreNode.board.PrintBoard();
			depth--;
			//return the high move which is the move for the board
			return highMove;
		}
		//the player is the human and the new node score is set to the low node
		else if(player == humanPlayer){
			newNode.setScore(lowNode.score);
			depth--;
			//return the low move which is the move for the human 
			return lowMove;
			}
			else {
				throw new Exception("Player No invalid end");
			//System.out.println("Player No invalid end");

		}
		
	
	}
}



