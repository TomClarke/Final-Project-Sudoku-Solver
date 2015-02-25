package src;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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

public class FileStore {

	public ArrayList<SudokuBoard> SavedBoards = new ArrayList<SudokuBoard>();
	public SudokuBoard board;
	public SudokuBoard savedBoard;
	public NodeList imported;
	public int[] results = new int[81];
	public String[] store = new String[81];


    //starting a new board, using an input file and converting it to a string,
    //then creating a sudokuBoard from the strings values. 
	// Big Java Book
	public void startNew(int xml) throws XPathExpressionException,
			SAXException, IOException, ParserConfigurationException {
    //string arraylist of items from the XMLSelect that creates chars from preset
    //xml files. 
		ArrayList<String> items = XMLSelect(xml);
		//convert the items from the array list into a string array.
		store = items.toArray(store);
		
		System.out.println("Items:" + Arrays.toString(store));
		//convert the single strings in the array into a single continuious string
		String saved = Arrays.toString(store);
		//limits the string values to between 1 and 82 so that only the values are
		//considered.
		saved = saved.substring(1, 82);

        //check length by checking the size of saved, if false return error message
		int strLength = saved.length();
		if (strLength != 81) {
			System.out.println("Not a valid length");
		} else {
		    //check the correct types of charactors have been input, so only numbers
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
				board.sudokuBoard[i][j].setValue(results[(j * 9) + i]);
				if (results[(j * 9) + i] != 0) {
					board.sudokuBoard[i][j].assigned = true;
				}
			}
		}

		board.PrintBoard();
		//update saved board as the currently created board
		savedBoard = board;

	}

//method for choosing which xml gets selected when a new board is requested.
//there is a file containing premade boards. 
	public ArrayList<String> XMLSelect(int xml)
			throws ParserConfigurationException, XPathExpressionException,
			SAXException, IOException {
		XMLHandler importer = new XMLHandler();
		//uses a random number generator that creates a number between 0 & 15 
		int randomNum = 0;
		if (xml > 0 && xml <= 15) {

			randomNum = xml;
		} else {
			Random rand = new Random();

			randomNum = rand.nextInt(15) + 1;
		}

//which ever number is chosen then that is the selected XML board that will be imported 
		switch (randomNum) {
		case 1:
			ArrayList<String> selected1 = importer
					.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/1.xml");
			return selected1;
		case 2:
			ArrayList<String> selected2 = importer
					.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/2.xml");
			return selected2;
		case 3:
			ArrayList<String> selected3 = importer
					.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/3.xml");
			return selected3;
		case 4:
			ArrayList<String> selected4 = importer
					.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/4.xml");
			return selected4;
		case 5:
			ArrayList<String> selected5 = importer
					.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/5.xml");
			return selected5;
		case 6:
			ArrayList<String> selected6 = importer
					.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/6.xml");
			return selected6;
		case 7:
			ArrayList<String> selected7 = importer
					.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/7.xml");
			return selected7;
		case 8:
			ArrayList<String> selected8 = importer
					.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/8.xml");
			return selected8;
		case 9:
			ArrayList<String> selected9 = importer
					.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/9.xml");
			return selected9;
		case 10:
			ArrayList<String> selected10 = importer
					.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/10.xml");
			return selected10;
		case 11:
			ArrayList<String> selected11 = importer
					.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/11.xml");
			return selected11;
		case 12:
			ArrayList<String> selected12 = importer
					.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/12.xml");
			return selected12;
		case 13:
			ArrayList<String> selected13 = importer
					.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/13.xml");
			return selected13;
		case 14:
			ArrayList<String> selected14 = importer
					.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/14.xml");
			return selected14;
		case 15:
			ArrayList<String> selected15 = importer
					.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/15.xml");
			return selected15;
		}
		return null;

	}


//save board stores the current board and creates a new XML file and imports the data into it
//this file can then be found by the time stamp within the load window. 
	public SudokuBoard save(String[] output)
			throws ParserConfigurationException {
		XMLHandler exporter = new XMLHandler();
		ArrayList<String> items = new ArrayList<String>();
		Date date = new Date();

		SudokuBoard savingBoard = new SudokuBoard();

    //using the items arraylist to add the input string array given. 

		int count = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				items.add(output[count]);
				if (items.get(count).equals(" ")) {

				} else
				//set the values once converted to an integer to the board valeus
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
			doc = exporter.build(items);
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


// get the saved files from file location, used by the load method, to return a list of 
//files saved.
	public File[] getSavedFiles() {
	    //path for where the files are saved 
		String decodedPath = URLDecoder
				.decode("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/");
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

//load the string that is selected via the load menu 
	public void load(String date) throws XPathExpressionException,
			ParserConfigurationException, SAXException, IOException {

		System.out.println("Loading..." + date);
    //loads the items from the XMLLoad method using the date specified
		ArrayList<String> items = XMLLoad(date);
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

//XMLLoad takes the string value and takes the value that has been saved with the date 
//specified and returns it as an arraylist. 
	public ArrayList<String> XMLLoad(String date)
			throws ParserConfigurationException, XPathExpressionException,
			SAXException, IOException {
		XMLHandler importer = new XMLHandler();
		String decodedPath = URLDecoder
				.decode("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/"
						+ date);
		ArrayList<String> loaded = importer.parse(decodedPath);

		return loaded;

	}

//load returns the global board variable **** SHOULD USE GETTER/SETTER 
	public SudokuBoard load() {
		System.out.println("Loading..");

		SudokuBoard loaded = board;

		return loaded;

	}

}
