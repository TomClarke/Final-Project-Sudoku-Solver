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
	public int[] results=new int[81];
	public String[] store = new String[81];
	
	
	
	//Big Java Book 
	public void startNew(int xml) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException{
				
				
		ArrayList<String> items = XMLSelect(xml);
		store = items.toArray(store);
		System.out.println("Items:" + Arrays.toString(store));
		String saved = Arrays.toString(store);
		saved = saved.substring(1,82);
		
		  int strLength = saved.length();
		  if(strLength != 81) {
		    System.out.println("Not a valid length");
		  } else {
		    for(int i=0;i<81;i++) {
		      if (!Character.isDigit(saved.charAt(i))) {
		        System.out.println("Contains an invalid digit");
		        break;
		      }
		      results[i] = Integer.parseInt(String.valueOf(saved.charAt(i)));
		    }
		  }	
		  System.out.println("Results: " + Arrays.toString(results));

		board = new SudokuBoard();
	for (int i = 0;i < 9; i++ ){
		for (int j = 0;j < 9; j++ ){
			  //System.out.println("results[i]"+results[i]);
			 
		//board.sudokuBoard[i][j].intValue = results[(j*9) + i] ;
			board.sudokuBoard[i][j].setValue(results[(j*9) + i]);
			if (results[(j*9) + i] != 0){
			board.sudokuBoard[i][j].assigned = true;
			}
			}
	}

	board.PrintBoard();
	savedBoard = board;
		
	}	
		
	
	public ArrayList<String> XMLSelect(int xml) throws ParserConfigurationException, XPathExpressionException, SAXException, IOException{
		XMLHandler importer = new XMLHandler();
		int randomNum = 0;
	 if (xml > 0 && xml <= 15){
			
			randomNum = xml;
		}
	else {
		Random rand = new Random();

		randomNum =  rand.nextInt(15) + 1;
		}
	
		switch (randomNum){
		case 1: 	 ArrayList<String>selected1 = importer.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/1.xml");
		return selected1;
		case 2: 	 ArrayList<String>selected2 = importer.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/2.xml");
		return selected2;
		case 3: 	 ArrayList<String>selected3 = importer.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/3.xml");
		return selected3;
		case 4: 	 ArrayList<String>selected4 = importer.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/4.xml");
		return selected4;
		case 5: 	 ArrayList<String>selected5 = importer.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/5.xml");
		return selected5;
		case 6: 	 ArrayList<String>selected6 = importer.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/6.xml");
		return selected6;
		case 7: 	 ArrayList<String>selected7 = importer.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/7.xml");
		return selected7;
		case 8: 	 ArrayList<String>selected8 = importer.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/8.xml");
		return selected8;
		case 9: 	 ArrayList<String>selected9 = importer.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/9.xml");
		return selected9;
		case 10: 	 ArrayList<String>selected10 = importer.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/10.xml");
		return selected10;
		case 11: 	 ArrayList<String>selected11 = importer.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/11.xml");
		return selected11;
		case 12: 	 ArrayList<String>selected12 = importer.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/12.xml");
		return selected12;
		case 13: 	 ArrayList<String>selected13 = importer.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/13.xml");
		return selected13;
		case 14: 	 ArrayList<String>selected14 = importer.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/14.xml");
		return selected14;
		case 15: 	 ArrayList<String>selected15 = importer.parse("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/PresetXML/15.xml");
		return selected15;
		}
		return null;
		
	}
	
	
	public SudokuBoard save(String[] output) throws ParserConfigurationException{
		XMLHandler exporter = new XMLHandler();
		ArrayList<String> items = new ArrayList<String>();
		Date date = new Date();	
		
		
		SudokuBoard savingBoard = new SudokuBoard();
		
		int count = 0;
		for (int i = 0;i < 9; i++ ){
			for (int j = 0;j < 9; j++ ){
				items.add(output[count]);
				
			
				//savingBoard = savedBoard;
			
				//savingBoard.sudokuBoard[j][i].intValue = Integer.parseInt(items.get(count));
				if(items.get(count).equals(" ")){
					
				}else
				savingBoard.sudokuBoard[j][i].setValue(Integer.parseInt(items.get(count))); 
			count++;
			}
			
		}
		
		savingBoard.PrintBoard();
		
		Document doc = null;
		try {
			doc = exporter.build(items);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DOMImplementation impl = doc.getImplementation();
		DOMImplementationLS implLS = (DOMImplementationLS) impl.getFeature("LS", "3.0");
		LSSerializer ser = implLS.createLSSerializer();
		String out = ser.writeToString(doc);
		
		System.out.println("Out: "+out);
		return board;
		
		
	}
	
	public File[] getSavedFiles(){
		String decodedPath = URLDecoder.decode("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/");
		File folder = new File(decodedPath);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		    	if (listOfFiles[i].getName().length()> 10 ) {
			  
		    	if (listOfFiles[i].isFile()) {
		        System.out.println("File " + listOfFiles[i].getName());
		      }
		    }
		    }
		return listOfFiles;
	}
	
	
	
	public void load(String date) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		
		System.out.println("Loading..."+date);
		
ArrayList<String> items = XMLLoad(date);

		store = items.toArray(store);
		System.out.println("Items:" + Arrays.toString(store));
		String saved = Arrays.toString(store);
		saved = saved.substring(1,82);
		
		  int strLength = saved.length();
		  if(strLength != 81) {
		    System.out.println("Not a valid length");
		  } else {
		    for(int i=0;i<81;i++) {
		      if (!Character.isDigit(saved.charAt(i))) {
		        System.out.println("Contains an invalid digit");
		        break;
		      }
		      results[i] = Integer.parseInt(String.valueOf(saved.charAt(i)));
		    }
		  }
		  System.out.println("Results: " + Arrays.toString(results));

		board = new SudokuBoard();
	for (int i = 0;i < 9; i++ ){
		for (int j = 0;j < 9; j++ ){
		board.sudokuBoard[i][j].setValue(results[(j*9) + i]) ;
		}
	}
	System.out.println("FileStore: loaded..");
	board.PrintBoard();
	
	}

public ArrayList<String> XMLLoad(String date) throws ParserConfigurationException, XPathExpressionException, SAXException, IOException{
	XMLHandler importer = new XMLHandler();
	String decodedPath = URLDecoder.decode("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/"+date);
	ArrayList<String>loaded = importer.parse(decodedPath);

	
	return loaded;
	
}


public SudokuBoard load() {
	System.out.println("Loading..");
	
	
	SudokuBoard loaded = board;
	
	return loaded;

}

	 
	
	
}
