package src;



import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

// TODO: Auto-generated Javadoc
/**
 * The Class Node.
 *
 * @author TomClarke
 * s
 */
public class Node {
	
	/** The point. */
	public int point;
	
	/** The score. */
	public int score;
	
	/** The board. */
	public Board board; 
	
	/** The parent. */
	public Node parent;
	
	/** The move. */
	public int[] move;
	
	/** The children arraylist */
	public ArrayList<Node> children = new ArrayList<Node>();


	/**
	 * Instantiates a new node.
	 * and starts it by filling it with 0s
	 */
	public Node() {
		this.board = new Board();
		board.startNewBoard();
	}
	
	/**
	 * Instantiates a new node.
	 *
	 * @param board the board
	 */
	public Node(Board board){
		this.board = board;
	}
	
	/**
	 * Adds the node to the children of the current parent node
	 *
	 * @param node the node
	 */
	public void add(Node node){
		children.add(node);
		node.parent(this);
	}
	
	/**
	 * Parent.
	 *
	 * @param node the node
	 */
	private void parent(Node node) {
		this.parent = node;
	}

	
	/**
	 * Sets the score.
	 *
	 * @param sscore the new score
	 */
	public void setScore(int sscore){
		board.setScore(sscore);
	}


	/**
	 * Prints the board
	 */
	public void print(){
	
		System.out.println(point + "");
		this.board.PrintBoard();

	}

}
