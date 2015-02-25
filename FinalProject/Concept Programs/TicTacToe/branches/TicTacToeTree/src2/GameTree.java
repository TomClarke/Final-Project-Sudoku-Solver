package src2;
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
public class GameTree {
	
	// Big Java Book CAY S. HORSTMANN pages 664-676

		static ArrayList<Integer> list = new ArrayList<Integer>();
		private Node root;

		
		public GameTree(){
			
			root = new Node();
	        root.number = 0;
	        root.children = new ArrayList<Node>();
		}

		public void Initailise() {

			GameTree tree = new GameTree();

			
		
			System.out.println("Integers: " + list);

			tree.run(tree);


		}

		
		public void run(GameTree tree){

			for (int i = 0; i < list.size(); i++){

				tree.add(list.get(i));
				
				
			}
			
			print();

		}
		
		
		public void add(int num){
			
			
			Node newNode = new Node();
			newNode.number = num;
			newNode.left = null;
			newNode.right = null;
			if (root == null) root = newNode;
			else root.addNode(newNode);
		}
		
		
			public void print(){
		if (root!=null){
			root.print();
			System.out.println();
			}
		}
		
}
			
		
		
		
		
		
/*
 * 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class GameTree {

	// Big Java Book CAY S. HORSTMANN pages 664-676

	static ArrayList<Integer> list = new ArrayList<Integer>();
	private Board root;

	public GameTree(){

		root = new Board(null, false);
		root.score = 0;
		root.children = new ArrayList<Board>();
	}

	public void InitailiseTree() {

		root = new Board(null, false);


	}


	public Board setTest ( ){

		Board trees = new Board(null, false);
		//trees.startNewBoard();
		trees.SetPosition(1, 1, 2);
		trees.PrintBoard();
		return trees;
	}

}
 */
	}
	public static void main ( String [] args ){
		
		create board
		 *  1 for player 1
			2 for player 2
			0 for null
			
		1 give score to board 
			
			
			
			
		
		2 save board in tree
		
			
			
			
			
			
			
		2 find position
		3 add player 
		//2.
		// add possible
		
		
	}
	

}
	*/