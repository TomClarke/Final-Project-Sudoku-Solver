package src;

import java.net.MalformedURLException;

/**
 * The Class SudokuGUI is used as the runner class for the GUI
 * 
 * @author TomClarke
 */
public class Runner {

	/**
	 * The main method creates a new instance of of the model the view and the
	 * controller
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		SplashScreen splashScreen = new SplashScreen();

		SudokuBoardModel boardModel = new SudokuBoardModel();
		SudokuMenuView view = new SudokuMenuView(boardModel.currentBoard);
		SudokuMenuModel model = new SudokuMenuModel(boardModel);
		SudokuMenuController controller = new SudokuMenuController(model, view,
				splashScreen);

	}
}
