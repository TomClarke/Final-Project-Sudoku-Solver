package src;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

//BigJava Cay S. Horstmann 896-905
public class XMLHandler {

	private DocumentBuilder builder;
	private XPath path;
	private Document doc;
	
	
	
	public XMLHandler() throws ParserConfigurationException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
		XPathFactory xpFactory = XPathFactory.newInstance();
		path = xpFactory.newXPath();
	
	}
	
	public ArrayList<String> parse(String fileName) throws SAXException, IOException, XPathExpressionException {
		
		File f = new File(fileName);
		Document doc = builder.parse(f);
		
		ArrayList<String> items = new ArrayList<String>();
		
		String sudoku = path.compile("Sudoku").evaluate(doc);
		
		items.add(sudoku);
	
		return items;
	}
	
	
	public Document build (ArrayList<String> items) throws TransformerException{
		Date date = new Date();
		doc = builder.newDocument();
	
		doc.appendChild(createItems(items));
		//http://www.mkyong.com/java/how-to-create-xml-file-in-java-dom/
		// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File("/Users/TomClarke/SkyDrive/ComputerScience/Year3/3rd Year Programming/SudokuSolver/XMLFiles/"+date+".xml"));
		 
				// Output to console for testing
				// StreamResult result = new StreamResult(System.out);
		 
				transformer.transform(source, result);
				
				System.out.println("File saved!");
		return doc;
	}
	
	
private Element createItems(ArrayList<String> items){
	Element e = doc.createElement("Sudoku");
	for(String anItem : items)
		e.appendChild(doc.createTextNode(anItem));
	return e;
}






	
}
