/**
 * 
 */
package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;


/**
 * The Class HashFunction.
 *
 * @author TomClarke
 * // Big Java Book CAY S. HORSTMANN pages 655-663
 * The hash function class uses a hush function to sort a large data set
 * by using a hash set.
 */
public class HashFunction {


	/** The filename that is used to reference the data set.
	 * When the program is downloaded this will be different so needs to be changed 
	 * it was possible to reference the file within the package however i have also 
	 * added in an extra method that uses another random data set.
	 */
	static String fileName = "/Users/TomClarke/SkyDrive/ComputerScience/Year3/DataSet.txt";

	/** The list to hold the file data . */
	static ArrayList<Integer> list = new ArrayList<Integer>();

	/** the hash set that will store the integers from the list. 
	 */
	HashSet<Integer> h = new HashSet<Integer>();




	/**
	 * Run method when called iterates through the list and stores it in 
	 * the hash set that is designed to take unordered integers. 
	 * after the for loop the hash set is then printed.
	 */
	private void run() {

		for (int i=0; i < list.size(); i++){
			int store = list.get(i);
			h.add(store);
		}
		//h.add(list);
		System.out.println(h);
	}	



	/**
	 * The initialise method.
	 * reads the file and looks for the integers within the file by
	 * using the read line and find integer presets, these allow the
	 * integers to be found quickly and put into the list
	 * 
	 * There is a catch exception to deal with file read errors
	 *
	 */
	public void Initialise(){

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
		run();

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




}
