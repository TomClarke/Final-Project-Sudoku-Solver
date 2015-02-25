package Tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;
import org.xml.sax.SAXException;

import src.FileStore;
import src.XMLHandler;

public class SavedPuzzlesTest {

	
	
	@Test
	public void startNewBoard() throws ParserConfigurationException, XPathExpressionException, SAXException, IOException {
	//import an xml
		// create xml importer class
		FileStore saved = new FileStore();
		saved.startNew(1);
	
		System.out.println("Output");
		//int size = saved.board.getBoard().length; 
		
		//assertEquals(size,9);
	}


	@Test
	public void importXML() throws ParserConfigurationException, XPathExpressionException, SAXException, IOException {
	
		FileStore saved = new FileStore();
		saved.startNew(2);
	
		String testSaved = Arrays.toString(saved.results);
		String result = "[1, 0, 0, 3, 8, 0, 6, 9, 5, 0, 4, 5, 9, 0, 2, 0, 3, 0, 8, 0, 0, 0, 6, 1, 0, 0, 0, 2, 5, 0, 7, 0, " +
				"0, 8, 0, 0, 0, 1, 0, 0, 0, 8, 5, 7, 0, 7, 0, 0, 0, 2, 0, 4, 0, 0, 0, 0, 0, 0, 0, 6, 3, 0, 0, 0, 6, 4, 2, 0," +
				" 0, 0, 0, 0, 5, 0, 0, 8, 9, 0, 0, 0, 0]";

	assertEquals(testSaved,result);
	}
	
	
	@Test
	public void importMultipleXML() throws ParserConfigurationException, XPathExpressionException, SAXException, IOException {
//created xml select to use a switch for the random xml 
		FileStore saved = new FileStore();

		saved.startNew(7);
		
		String testSaved = Arrays.toString(saved.results);
		String result = "[4, 9, 0, 0, 0, 2, 0, 7, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 5, 9, 0, 0, 0, 0, 0, 7, 5, 0, 0, 4, 0, 0, " +
				"0, 0, 0, 0, 0, 0, 3, 7, 0, 0, 0, 3, 0, 0, 2, 1, 5, 8, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 8, 1, 0, 4, 0, 0, 0, 9," +
				" 0, 0, 0, 0, 6, 7, 0, 0, 2, 1]";
	
	assertEquals(testSaved,result);
	
	
	saved.startNew(5);
	
	String testSaved2 = Arrays.toString(saved.results);
	String result2 = "[0, 0, 4, 0, 0, 0, 7, 1, 0, 7, 9, 0, 8, 3, 0, 6, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0," +
			" 0, 0, 0, 0, 0, 0, 9, 3, 0, 2, 0, 0, 0, 0, 4, 5, 6, 7, 8, 9, 3, 0, 0, 2, 0, 0, 0, 0, 0, 0, 6, 1, 0, 6, 7," +
			" 0, 0, 0, 9, 0, 0, 0, 8, 4, 5, 0, 0, 0, 0]";
	assertEquals(testSaved2,result2);
	
	
	saved.startNew(7);
	
	String testSaved3 = Arrays.toString(saved.results);
	String result3 = "[4, 9, 0, 0, 0, 2, 0, 7, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 5, 9, 0," +
			" 0, 0, 0, 0, 7, 5, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 3, 7, 0, 0, 0, 3, 0, 0, 2, 1," +
			" 5, 8, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 8, 1, 0, 4, 0, 0, 0, 9, 0, 0, 0, 0, 6, 7, 0, 0, 2, 1]";

assertEquals(testSaved3,result3);


	}
}
