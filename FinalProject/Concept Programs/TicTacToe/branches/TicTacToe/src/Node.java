package src;



import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author TomClarke
 *s
 */
public class Node {
	public int point;
	public int score;
	public Board board; 
	public Node parent;
	public int[] move;
	public ArrayList<Node> children = new ArrayList<Node>();


	public Node() {
		this.board = new Board();
		board.startNewBoard();
	}
	
	public Node(Board board){
		this.board = board;
	}
	
	public void add(Node node){
		children.add(node);
		node.parent(this);
	}
	private void parent(Node node) {
		this.parent = node;
	}
		
	private void copy(Node node) {
		this.point = node.point;
		//this.board.copy();
	}
	
	public void setScore(int sscore){
		board.setScore(score);
	}


	public void print(){
	
		System.out.println(point + "");
		this.board.PrintBoard();

	}

}
