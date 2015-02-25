/**
 * 
 */
package src;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;


/**
 * The Class PrioirtyQueue.
 * 
 * Big Java Book CAY S. HORSTMANN pages 676-692
 * 
 * @author TomClarke
 */
public class PrioirtyQueueClass {
	
	/** The file name. */
	static String fileName = "/Users/TomClarke/SkyDrive/ComputerScience/Year3/DataSet.txt";
	
	/** The list to hold the file data . */
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	/**
	 * The main method.
	 *sets up a priority queue
	 *reads the file and looks for the integers within the file by 
	 *using the read line and find integer presets, these allow the 
	 *integers to be found quickly and put into the list
	 *
	 *There is a catch exception to deal with file read errors 
	 * @param args the arguments
	 */
	public void Initialise(){

		PrioirtyQueueClass queue = new PrioirtyQueueClass();

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

		queue.Run();


	}

	/**
	 * Find integer.
	 *by splitting the string of every int, the string is a ", "
	 *this is then added to the list and a for loop then recursively does the rest
	 *
	 * @param s the s
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
	 * uses a random number to add a priority to the dataset, this number will be between 1-100
	 * the for loop means each list item is given a priority.
	 *
	 * The while loop sets the current number by retrieving and removing the current number
	 * and if it is null then break as that is the end of the set 
	 * 
	 * print statements print the values and their priorities
	 */
	public void Run(){
		Random rand = new Random();

		PriorityQueue<Data> num = new PriorityQueue<Data>();
		for (int i = 0; i < list.size(); i++){

			num.add(new Data(new Integer(rand.nextInt(100)),list.get(i)));
		}

		System.out.println();
		System.out.println("Priority: ");
		while(true) {
			Data current = num.poll();
			if(current == null) {
				break;
			}

			System.out.println("Output " + current.getoutput() + "  Priority: " + current.getnum() + "  ");

		}
		System.out.println();
	}
}
