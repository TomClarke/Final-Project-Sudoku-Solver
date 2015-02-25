package src;

import java.net.MalformedURLException;

import javax.swing.SwingUtilities;

/**
 * The Class runner is used as the runner class for the GUI and whole program.
 *
 * @author TomClarke
 */
public class Runner {

	/**
	 * The main method creates a new instance of the splash screen and later the model, view and the
	 * controller.
	 *A swing worker is used to all the splash to perform while the program is loading.
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		SplashScreen splashScreen = new SplashScreen();

		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {	
                	//SplashScreen splashScreen = new SplashScreen();
                    new SplashScreen().initUI();
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		SudokuBoardModel boardModel = new SudokuBoardModel();
		SudokuMenuView view = new SudokuMenuView(boardModel.currentBoard);
		SudokuMenuModel model = new SudokuMenuModel(boardModel);
		@SuppressWarnings("unused")
		SudokuMenuController controller = new SudokuMenuController(model, view,
				splashScreen);

	}
}
