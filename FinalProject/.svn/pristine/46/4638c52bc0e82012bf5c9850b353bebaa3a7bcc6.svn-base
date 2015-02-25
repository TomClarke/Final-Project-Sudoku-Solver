package src;

import java.io.IOException;
import java.text.DateFormat;

import javax.swing.SwingWorker;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;



/**
 * The Class Model is used to provide an action for the buttons
 */
public class Model {


	/** The view. */
	private final SudokuMenuView view = new SudokuMenuView();
	//private final Model mod = new Model();
	//private final  Controller control = new Controller(mod, view);
	

	/**
	 * Solve.
	 */
	public void Solve() {

	}


	/**
	 * Save.
	 * provide the action from within view
	 * @param values 
	 */

	public boolean Save() {


		SavedPuzzles saved = new SavedPuzzles();

		System.out.println("Saving...");
		String output[] = new String [81];
		System.out.println("Output: ");
		int count = 0;
		int i = 0;
		int j = 0;
		for(j=0 ; j<9 ; j++){
			for(i=0 ; i<9 ; i++){
			
			System.out.print("Set: "+count+"|");	
			output[count] = view.btnNumber[i][j].getText();
			System.out.print("output:("+i+","+j+ ")location: "+output[count]+ ", SetTo: "+view.btnNumber[i][j].getText());
			System.out.println();	
			
			if(output[count] == " "){
				output[count] = "0";
			}
			
			count++;
		}
			
		}

		try {
			saved.save(output);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}


	/**
	 * Load.
	 * @param chosenDate 
	 * @return 
	 */
	public SudokuBoard Load(String chosenDate) {

		SavedPuzzles saved = new SavedPuzzles();
		SudokuBoard loaded = null;
		try {
			loaded = saved.load(chosenDate);
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loaded;

		
	}


	/**
	 * Erase.
	 */
	public void Erase() {

	}


	/**
	 * Help.
	 */
	public void Help() {

	}


	/**
	 * Sets the button.
	 *
	 * @param value the value
	 * @return the int
	 */
	public void setSudokuBoard() {



	}

	public void getSudokuBoard() {



	}


	public SudokuBoard New() {

		SavedPuzzles saved = new SavedPuzzles();
		SudokuBoard loaded = null;
		
			
			 try {
				saved.startNew(0);
			} catch (XPathExpressionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			loaded = saved.load();

			//SudokuBoard sudukoBoard = new SudokuBoard();
			
			//sudukoBoard.setBoard(loaded);
	
		return loaded;


	}
}



