package src;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.SAXException;

/**
 * The Class FileStore in the parser fro the XML files to and from the program. 
 * Modified from the Java Book pages CAY S. HORSTMANN 884-910 
 */
public class FileStore {

	/** The board. */
	public SudokuBoard board;

	/** The saved board that contains the new values. */
	public SudokuBoard savedBoard;

	/** The imported node list contains the values that are taken from the XML. */
	public NodeList imported;

	/** The results are the values to be inserted into the cells . */
	public int[] results = new int[81];

	/** The store temp location for items. */
	public String[] store = new String[81];
	/** the preset location of the stored boards */
	public String locationPreset = ("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/"); 

	/**
	 * Start new.
	 *starting a new board, using an input file and converting it to a string,
	 *then creating a sudokuBoard from the strings values. 
	 * string array list of items from the XMLSelect that creates chars from preset XML files. 
	 * convert the items from the array list into a string array.
	 * convert the single strings in the array into a single continuous string
	 * limits the string values to between 1 and 82 so that only the values are considered.
	 * check length by checking the size of saved, if false return error message then
	 * checks the correct types of characters have been input, so only numbers
	 * input results into an array of integers and insert them into a board and set it as 
	 * the savedBoard.
	 *
	 * @param xml the number that relates to the XML file
	 * @throws XPathExpressionException the x path expression exception
	 * @throws SAXException the sAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParserConfigurationException the parser configuration exception
	 */
	public void startNew(int xml) throws XPathExpressionException,
	SAXException, IOException, ParserConfigurationException {

		ArrayList<String> items = XMLSelect(xml);

		store = items.toArray(store);

		System.out.println("Items:" + Arrays.toString(store));

		String saved = Arrays.toString(store);

		saved = saved.substring(1, 82);

		int strLength = saved.length();
		if (strLength != 81) {
			System.out.println("Not a valid length");
		} else {
			for (int i = 0; i < 81; i++) {
				if (!Character.isDigit(saved.charAt(i))) {
					System.out.println("Contains an invalid digit");
					break;
				}
				//input results into an array of integers
				results[i] = Integer.parseInt(String.valueOf(saved.charAt(i)));
			}
		}
		System.out.println("Results: " + Arrays.toString(results));

		// create a new board and populate with the results  
		board = new SudokuBoard();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (!(results[(j * 9) + i] != 0)) {
					board.sudokuBoard[i][j].setValue(results[(j * 9) + i]);
				}
				if (results[(j * 9) + i] != 0) {
					board.sudokuBoard[i][j].assigned = true;
					board.sudokuBoard[i][j].startingValue = true;
					board.sudokuBoard[i][j].setValue(results[(j * 9) + i]);
				}
			}
		}

		//update saved board as the currently created board
		savedBoard = board;

	}


	/**
	 * XML select.
	 * method for choosing which xml gets selected when a new board is requested.
	 * there is a file containing pre-made boards. 
	 * it uses a random number between 1 and 4 to select the correct file for the preset 
	 * XML files
	 *
	 * @param xml the number of the preset XML File
	 * @return the array list containing the values 
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws XPathExpressionException the x path expression exception
	 * @throws SAXException the sAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public ArrayList<String> XMLSelect(int xml)
			throws ParserConfigurationException, XPathExpressionException,
			SAXException, IOException {
		XMLHandler importer = new XMLHandler();
		//uses a random number generator that creates a number between 0 & 15 
		int randomNum = 0;
		if (xml > 0 && xml <= 14) {

			randomNum = xml;
		} else {
			Random rand = new Random();

			randomNum = rand.nextInt(14) + 1;
		}

		//which ever number is chosen then that is the selected XML board that will be imported 
		switch (randomNum) {
		case 1:
			ArrayList<String> selected1 = importer
			.parse(locationPreset+"1.xml");
			return selected1;
		case 2:
			ArrayList<String> selected2 = importer
			.parse(locationPreset+"2.xml");
			return selected2;
		case 3:
			ArrayList<String> selected3 = importer
			.parse(locationPreset+"3.xml");
			return selected3;
		case 4:
			ArrayList<String> selected4 = importer
			.parse(locationPreset+"4.xml");
			return selected4;
		case 5:
			ArrayList<String> selected5 = importer
			.parse(locationPreset+"5.xml");
			return selected5;
		case 6:
			ArrayList<String> selected6 = importer
			.parse(locationPreset+"6.xml");
			return selected6;
		case 7:
			ArrayList<String> selected7 = importer
			.parse(locationPreset+"7.xml");
			return selected7;
		case 8:
			ArrayList<String> selected8 = importer
			.parse(locationPreset+"8.xml");
			return selected8;
		case 9:
			ArrayList<String> selected9 = importer
			.parse(locationPreset+"9.xml");
			return selected9;
		case 10:
			ArrayList<String> selected10 = importer
			.parse(locationPreset+"10.xml");
			return selected10;
		case 11:
			ArrayList<String> selected11 = importer
			.parse(locationPreset+"11.xml");
			return selected11;
		case 12:
			ArrayList<String> selected12 = importer
			.parse(locationPreset+"12.xml");
			return selected12;
		case 13:
			ArrayList<String> selected13 = importer
			.parse(locationPreset+"13.xml");
			return selected13;
		case 14:
			ArrayList<String> selected14 = importer
			.parse(locationPreset+"14.xml");
			return selected14;
		}
		return null;

	}



	/**
	 * SaveBoard stores the current board and creates a new XML file and imports the data into it
	 * this file can then be found by the time stamp within the load window. 
	 * @param dir 
	 * @param output the values as a string 
	 * @return the saved sudokuBoard
	 * @throws ParserConfigurationException the parser configuration exception
	 */
	public SudokuBoard save(File dir, String[] output)
			throws ParserConfigurationException {
		XMLHandler exporter = new XMLHandler();
		ArrayList<String> items = new ArrayList<String>();

		SudokuBoard savingBoard = new SudokuBoard();

		//using the items arraylist to add the input string array given. 

		int count = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				items.add(output[count]);
				if (items.get(count).equals(" ")) {

				} else
					//set the values once converted to an integer to the board values
					savingBoard.sudokuBoard[j][i].setValue(Integer
							.parseInt(items.get(count)));
				count++;
			}

		}
		//print the saving board 
		savingBoard.PrintBoard();
		//create a null document 
		Document doc = null;
		try {
			//add items to the document
			doc = exporter.build(dir,items);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		DOMImplementation impl = doc.getImplementation();
		DOMImplementationLS implLS = (DOMImplementationLS) impl.getFeature(
				"LS", "3.0");
		LSSerializer ser = implLS.createLSSerializer();
		String out = ser.writeToString(doc);

		System.out.println("Out: " + out);
		return board;

	}



	/**
	 * get the saved files from file location, used by the load method, to return a list of 
	 * files saved. 
	 *
	 * @return the saved files
	 */
	public File[] getSavedFiles(File directory) {
		//path for where the files are saved 
		@SuppressWarnings("deprecation")
		//String decodedPath = URLDecoder.decode("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/");
		String decodedPath = URLDecoder.decode(""+directory);
		System.out.println(directory+"");
		File folder = new File(decodedPath);
		//saved list of files
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].getName().length() > 10) {

				if (listOfFiles[i].isFile()) {
					//	System.out.println("File " + listOfFiles[i].getName());
				}
			}
		}
		return listOfFiles;
	}


	/**
	 * Load the string that is selected via the load menu 
	 * uses the date specified and searches for the file that is named the same 
	 * as the string that is within the save file. 
	 * This is then loaded and inserted into the saved board, this is then the current board.
	 * @param directory 
	 *
	 * @param date the date
	 * @throws XPathExpressionException the x path expression exception
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws SAXException the sAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void load(File directory, String date) throws XPathExpressionException,
	ParserConfigurationException, SAXException, IOException {

		System.out.println("Loading..." + date);
		//loads the items from the XMLLoad method using the date specified
		ArrayList<String> items = XMLLoad(directory,date);
		//store the items 
		store = items.toArray(store);
		System.out.println("Items:" + Arrays.toString(store));
		String saved = Arrays.toString(store);
		//create and array that needs to be restricted in size 
		saved = saved.substring(1, 82);

		//if too long return with error message 
		int strLength = saved.length();
		if (strLength != 81) {
			System.out.println("Not a valid length");
		} else {
			// if contains the wrong charactors then false. 
			for (int i = 0; i < 81; i++) {
				if (!Character.isDigit(saved.charAt(i))) {
					System.out.println("Contains an invalid digit");
					break;
				}
				//results array is the integers of the values. 
				results[i] = Integer.parseInt(String.valueOf(saved.charAt(i)));
			}
		}
		System.out.println("Results: " + Arrays.toString(results));
		//input these into the new board 
		board = new SudokuBoard();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board.sudokuBoard[i][j].setValue(results[(j * 9) + i]);
			}
		}
		System.out.println("FileStore: loaded..");
		board.PrintBoard();

	}


	/**
	 * XML load takes the string value and takes the value that has been saved with the date 
	specified and returns it as an arraylist. 
	 *
	 * @param date the date
	 * @return the array list containing the values of the loaded file.
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws XPathExpressionException the x path expression exception
	 * @throws SAXException the sAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public ArrayList<String> XMLLoad(File dir,String date)
			throws ParserConfigurationException, XPathExpressionException,
			SAXException, IOException {
		XMLHandler importer = new XMLHandler();
		@SuppressWarnings("deprecation")
		String decodedPath = URLDecoder.decode(dir+"/"+date);
		//.decode("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/"
		//		+ date);
				
		ArrayList<String> loaded = importer.parse(decodedPath);

		return loaded;

	}

	/**
	 * load returns the global board variable
	 *
	 * @return the sudoku board
	 */
	public SudokuBoard getload() {
		System.out.println("Loading..");

		SudokuBoard loaded = board;

		return loaded;

	}

}
