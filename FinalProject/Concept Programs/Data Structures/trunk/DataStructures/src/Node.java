/**
 * 
 */
package src;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


/**
 * The Class Node is used to define the node objects and allow them to be 
 * sorted. 
 *
 * @author TomClarke
 */
public class Node {

	/** The nodes left node (Child) */
	public Node left; 
	
	/** The nodes right node (Child) */
	public Node right;
	
	/** The number is the value that the node contains  */
	public int number;
	
	/** The children of that node stored in an array list */
	public ArrayList<Node> children;


	/**
	 * Adds a node, however when a node is added it has to be compared so
	 * that is it placed in the correct location, this is done using 
	 * a compare to with the current number and the newNode's number integer
	 * if the number is less than the current the node is put left and 
	 * if more then then value is put right. 
	 *
	 * @param newNode the new node
	 */
	public void addNode(Node newNode){

		int compare = ((Integer)newNode.number).compareTo(number);
		if (compare < 0){
			if (left == null) left = newNode;
			else left.addNode(newNode);
		}
		if (compare > 0){

			if (right == null) right = newNode;
			else right.addNode(newNode);
		}

	}

	/**
	 * Prints the tree left and right. 
	 */
	public void print(){
		if( left!= null)
			left.print();
		System.out.print(number + ", ");
		if (right!= null) 
			right.print();

	}

}
