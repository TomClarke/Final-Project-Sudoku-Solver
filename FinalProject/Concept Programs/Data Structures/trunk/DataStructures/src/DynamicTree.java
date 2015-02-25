package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import src.Node;

// Big Java Book CAY S. HORSTMANN pages 664-676

/**
 * The Class DynamicTree.
 * creates a tree dynamically that can be populated with a data set.
 */
public class DynamicTree {


	/** The filename that is used to reference the data set.
	 * When the program is downloaded this will be different so needs to be changed 
	 * it was possible to reference the file within the package however i have also 
	 * added in an extra method that uses another random data set.
	 */
	static String fileName = "/Users/TomClarke/SkyDrive/ComputerScience/Year3/DataSet.txt";

	/** The list that will store the inputs from the data set  */
	static ArrayList<Integer> list = new ArrayList<Integer>();

	/** The root node that is at the top of the tree */
	private Node root;


	/**
	 * Instantiates a new dynamic tree.
	 * creating a new node, children, which are the nodes below that node which are stored
	 * within an array list 
	 * and a number that is the value assigned to that node. 
	 */
	public DynamicTree(){

		root = new Node();
		root.number = 0;
		root.children = new ArrayList<Node>();
	}

	/**
	 * Initailise reads the file with the data set and this will contain the integers that need to populate 
	 * the tree. at each line the find integer method is called to look at each string. 
	 * the IOException will trigger if the input file is unable to be read or within the wrong location. 
	 * A list of the integers taken are printed 
	 * 
	 */
	public void Initailise() {

		DynamicTree tree = new DynamicTree();
/*
		try {
			File file = new File(fileName);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String s; 
			while ((s = in.readLine()) != null) {
				findInteger(s);
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: ");
		}
		System.out.println("Integers: " + list);
*/
		 Random randomGenerator = new Random();
		    for (int i = 1; i <= 20; ++i){
		      int randomInt = randomGenerator.nextInt(100);
		      list.add(randomInt);
		   
		      System.out.println("Generated : " + randomInt); 
		      }
		tree.run(tree);


	}



	/**
	 * Find integer takes the strings taken from the dataset and they are split 
	 * so any string with a gap ", " is then split and the intergers are seperated and 
	 * added to the list. 
	 *
	 * @param s the split of the integers within the string.
	 */
	private static void findInteger(String s){
		String [] parts = s.split(", ");

		for (int i = 0; i < parts.length; i++) {
			try{
				int j = Integer.parseInt(parts[i]);
				list.add(j);
			} catch (Exception e){}
		}
	}

	/**
	 * Run.
	 *The method that initially creates the tree, this is done by iterating through the 
	 *list and then populating the tree with every integer within the list, at the end of 
	 *this method the tree is printed with the print method.
	 * @param tree the tree
	 */
	public void run(DynamicTree tree){

		for (int i = 0; i < list.size(); i++){

			tree.add(list.get(i));


		}

		print();

	}


	/**
	 * Adds the nodes to the tree, each node is created within this method when it is passed a 
	 * number num, then the number is assigned to the node and given a left and right children 
	 * set to null, however if there is not a root then this node becomes the root node.
	 * 
	 * if it is not a root value then it needs to be compared within the node class using the add 
	 * node method.
	 *
	 * @param num the num
	 */
	public void add(int num){


		Node newNode = new Node();
		newNode.number = num;
		newNode.left = null;
		newNode.right = null;
		if (root == null) root = newNode;
		else root.addNode(newNode);
	}


	/**
	 * Prints the root of the tree as long as it is not null.
	 */
	public void print(){
		if (root!=null){
			root.print();
			System.out.println();
		}
	}
}