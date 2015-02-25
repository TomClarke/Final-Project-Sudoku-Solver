package src;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

/**
 * The Class Model is used to provide an action for the buttons.
 */
public class SudokuMenuModel {

	/** The board model that is then performed with the network */
	public SudokuBoardModel board = null; 

	/** The date. */
	public String date = null;

	/** The file store instance that handles saved and loaded boards. */
	public FileStore fileStore = new FileStore();

	/**
	 * Sets the board.
	 *
	 * @param board the new board
	 */
	public void setBoard(SudokuBoard board) {
		this.board.currentBoard = board;
	}

	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	public SudokuBoard getBoard() {
		return board.currentBoard;
	}

	/**
	 * Instantiates a new sudoku menu model.
	 *
	 * @param boardModel the board model
	 */
	public SudokuMenuModel(SudokuBoardModel boardModel) {
		board = boardModel;
	}

	/**
	 * Solve passes the name of the solving method and solves the current board
	 *
	 * @param solvingMethod the solving method
	 */
	public void Solve(String solvingMethod) {

		System.out.println("Model Solving... ");
		board.Solve(solvingMethod);
		System.out.println("Solved Board ");
		board.currentBoard.PrintBoard();
	}

	/**
	 * Save the board uses the filestore board and then each value as been
	 * taken from the current board and saved to the filestore board and those values 
	 * are passed. Then the file store save method is called that takes the board within filestore
	 * and converts it to an XML file.
	 * @param directory 
	 *
	 * @return true, if successful
	 */

	public boolean Save(File directory) {

		System.out.println("Saving...");
		String[] output = new String[81];
		System.out.println("Output: ");

		int count = 0;
		int i = 0;
		int j = 0;

		SudokuBoard savedBoard;

		savedBoard = fileStore.board;

		for (j = 0; j < 9; j++) {
			for (i = 0; i < 9; i++) {

				System.out.println(new Integer(savedBoard.sudokuBoard[i][j]
						.getValue()).toString());

				output[count] = new Integer(
						savedBoard.sudokuBoard[i][j].getValue()).toString();

				System.out.println("output:(" + i + " ," + j + ")location: "
						+ output[count] + ", SetTo: "
						+ savedBoard.sudokuBoard[i][j].strValue);

				count++;
			}

		}

		try {
			fileStore.save(directory,output);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		return true;
	}

	/**
	 * Load takes the date selected from the loading menu and then passes
	 * it to the filestore load that can then take that value and set the current 
	 * board to the file from the filestore
	 * @param directory 
	 *
	 * @param chosenDate the chosen date
	 */
	public void Load(File directory, String chosenDate) {

		date = chosenDate;

		try {
			fileStore.load(directory,date);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setBoard(fileStore.board);

	}

	/**
	 * Erase ,creates a new board 
	 */
	public void Erase() {
		fileStore.board.newBoard();
	}


	/**
	 * New, creates a new board and populates it from a random pre-loaded 
	 * XML file, this is then set as the current board.
	 */
	public void New() {
		System.out.println("Make New Board");

		try {
			fileStore.startNew(0);
		} catch (XPathExpressionException e) {
	
			e.printStackTrace();
		} catch (SAXException e) {
		
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ParserConfigurationException e) {
	
			e.printStackTrace();
		}

		fileStore.getload();
		setBoard(fileStore.board);
		board.currentBoard.PrintBoard();

	}

	/**
	 * Update board by setting it to the view.
	 *
	 * @param board the board
	 */
	public void updateBoard(SudokuBoard board) {

		setBoard(board);
	}
}

