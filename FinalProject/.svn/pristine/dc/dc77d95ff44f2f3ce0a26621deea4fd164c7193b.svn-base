package src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

//BigJava Cay S. Horstmann 896-905
public class XMLHandler {

	private DocumentBuilder builder;
	private XPath path;
	private Document doc;
	
	
	//creating the builders 
	public XMLHandler() throws ParserConfigurationException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
		XPathFactory xpFactory = XPathFactory.newInstance();
		path = xpFactory.newXPath();
	
	}
	//retrives the specified XML File and inputs the data within into an arrayList
	public ArrayList<String> parse(String fileName) throws SAXException, IOException, XPathExpressionException {
		//creates a file from the file name
		File f = new File(fileName);
		Document doc = builder.parse(f);
		ArrayList<String> items = new ArrayList<String>();
		//uses the string values within sudoku 
		String sudoku = path.compile("Sudoku").evaluate(doc);
		//adds values to the list and returns the list
		items.add(sudoku);
	
		return items;
	}
	
	//creates the document 
	public Document build (ArrayList<String> items) throws TransformerException{
		Date date = new Date();
		doc = builder.newDocument();
	//input the list of items and insert into the document
		doc.appendChild(createItems(items));
		//http://www.mkyong.com/java/how-to-create-xml-file-in-java-dom/
		// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/"+date+".xml"));
		 
				transformer.transform(source, result);
				
				System.out.println("File saved!");
		return doc;
	}
	
	
	// take the items from the list and insert into the sudoku element and store them 
	//between these elements. and return it to the builder to be added to the document
private Element createItems(ArrayList<String> items){
	Element e = doc.createElement("Sudoku");
	for(String anItem : items)
		e.appendChild(doc.createTextNode(anItem));
	return e;
}






	
}
