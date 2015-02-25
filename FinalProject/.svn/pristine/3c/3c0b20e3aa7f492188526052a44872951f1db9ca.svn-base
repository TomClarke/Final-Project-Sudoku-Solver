package src;

import java.io.IOException;
import java.text.DateFormat;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

/**
 * The Class Model is used to provide an action for the buttons
 */
public class SudokuMenuModel {

	/** The view. */
	public SudokuBoardModel board = null; 
	public String date = null;

	public FileStore fileStore = new FileStore();

	public void setBoard(SudokuBoard board) {
		this.board.currentBoard = board;
	}
	public SudokuBoard getBoard() {
		return board.currentBoard;
	}

	public SudokuMenuModel(SudokuBoardModel boardModel) {
		board = boardModel;
	}

	/**
	 * Solve.
	 */
	public void Solve() {

		System.out.println("Model Solving... ");
		board.Solve();
		System.out.println("Solved Board ");
		board.currentBoard.PrintBoard();
	}

	/**
	 * Save. provide the action from within view
	 * 
	 * @param values
	 */

	public boolean Save() {

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
			fileStore.save(output);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		return true;
	}

	/**
	 * Load.
	 * 
	 * @param chosenDate
	 */
	public void Load(String chosenDate) {

		date = chosenDate;

		try {
			fileStore.load(date);
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
	 * Erase.
	 */
	public void Erase() {
		fileStore.board.newBoard();
	}

	/**
	 * Help.
	 */
	public void Help() {

		SudokuBoardModel boardModel = new SudokuBoardModel();
		boardModel.currentBoard = fileStore.board;
		SudokuBoard solvedBoard = boardModel.GAC();
		System.out.println("GAC Board ");
		solvedBoard.PrintBoard();
	}

	public void New() {
		System.out.println("Make New Board");

		try {
			fileStore.startNew(0);
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
		System.out.println("Print model: board ");

		fileStore.load();
		setBoard(fileStore.board);
		board.currentBoard.PrintBoard();

	}
}
