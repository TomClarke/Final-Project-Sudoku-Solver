package src;
//http://www.codeproject.com/Articles/43622/Solve-Tic-Tac-Toe-with-the-MiniMax-algorithm
//http://ai-depot.com/articles/minimax-explained/2/
import java.util.ArrayList;
import java.util.List;

public class GameTree {

	Board currentBoard = null;


	public GameTree(Board board) {
		this.currentBoard = board;

	}

	private int[] find(int level, int player) {
		//http://www.ocf.berkeley.edu/~yosenl/extras/alphabeta/alphabeta.html
		List<int[]> nextMoves = generateMoves();
		int best = 0;
	
		int otherPlayer = 0;
		if (player == 1 ){
			otherPlayer = 2;
		}else{
			otherPlayer = 1;
		}
		int bestRow = -1;
        int bestCol = -1 ;
        int[] score = {0};


		if (nextMoves.isEmpty() || level == 0){
			best = makeScore(currentBoard,player);
		}
		
		
		
			for (int ma = 0; ma < nextMoves.size(); ma++) {  
			    for (int mb = 0; mb < nextMoves.size(); mb++) { 
			    //	currentBoard[ma][mb] = player;
		int currentB = currentBoard.getBoard(ma,mb);
		currentB  =  player ;
			    
			
			if (player == 1){
				score = find(level - 1, player);
			  
	        
	               if (score[0] > best) {
	                  best = score[0];
	                  bestRow = ma;
	                  bestCol = mb;
	               }
	            } else {  // oppSeed is minimizing player
	            	score = find(level - 1, otherPlayer);
	                if (score[0] > best) {
		                  best = score[0];
		                  bestRow = ma;
		                  bestCol = mb;
	               }
	            }
	            // Undo move
			int currentA = currentBoard.getBoard(ma,mb);
			//= -1;
	         //   cells[move[0]][move[1]].content = Seed.EMPTY;
	         }
	      }
	      return new int[] {score[0], bestRow, bestCol};
	   }
			
		
		

	




	private List<int[]> generateMoves() {

		Board board = new Board();
		List<int[]> nextMoves = new ArrayList<int[]>();


		if (board.Check()==1 || board.Check()==2) {
			return nextMoves;   
		}


		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 3; ++col) {
				if (currentBoard.getBoard(row, col) == -1) {
					nextMoves.add(new int[] {row, col});
					System.out.println(nextMoves);
				}
			}
		}
		return nextMoves;
	}


	private int makeScore(Board currentBoard2, int player) {
		//http://www3.ntu.edu.sg/home/ehchua/programming/java/JavaGame_TicTacToe_AI.html

		int score = 0;

		score = score + scoreLine(currentBoard2, 0, 0, 0, 1, 0, 2);  // row 0
		score = score + scoreLine(currentBoard2,1, 0, 1, 1, 1, 2);  // row 1
		score = score + scoreLine(currentBoard2,2, 0, 2, 1, 2, 2);  // row 2
		score = score + scoreLine(currentBoard2,0, 0, 1, 0, 2, 0);  // col 0
		score = score + scoreLine(currentBoard2,0, 1, 1, 1, 2, 1);  // col 1
		score = score + scoreLine(currentBoard2,0, 2, 1, 2, 2, 2);  // col 2
		score = score + scoreLine(currentBoard2,0, 0, 1, 1, 2, 2);  // diagonal
		score = score + scoreLine(currentBoard2,0, 2, 1, 1, 2, 0);  // alternate diagonal
		return score;

	}

	private int scoreLine(Board compBoard,int r0, int c0, int r1, int c1, int r2, int c2) {
		int scoreline = 0;

		if (compBoard.getBoard(r0,c0) == 1){
			scoreline = 1;
		}
		else if (compBoard.getBoard(r0,c0) == 2){
			scoreline = -1;
		}
		if (compBoard.getBoard(r1,c1) == 1) {
			if (scoreline == 1) {   
				scoreline = 10;
			} else if (scoreline == -1) { 
				return 0;
			} else { 
				scoreline = 1;
			}
		} else if (compBoard.getBoard(r1,c1) == 2) {
			if (scoreline == -1) { 
				scoreline = -10;
			} else if (scoreline == 1) {
				return 0;
			} else {  
				scoreline = -1;
			}
		}

		// Third cell
		if (compBoard.getBoard(r2,c2) == 1) {
			if (scoreline > 0) { 
				scoreline *= 10;
			} else if (scoreline < 0) { 
				return 0;
			} else { 
				scoreline = 1;
			}
		} else if (compBoard.getBoard(r2,c2) == 2) {
			if (scoreline < 0) { 
				scoreline *= 10;
			} else if (scoreline > 1) { 
				return 0;
			} else { 
				scoreline = -1;
			}
		}


		return scoreline;
	} 














}

