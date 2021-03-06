/**
 * 
 */
package src2;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author TomClarke
 *s
 */
public class Node {

	public Node left; 
	public Node right;
	public int number;
	public ArrayList<Node> children;


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

	public void print(){
		if( left!= null)
			left.print();
		System.out.println(number + "");
		if (right!= null) 
			right.print();

	}

}
