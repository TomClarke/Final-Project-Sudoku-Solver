package src;

import java.net.MalformedURLException;




/**
 * The Class SudokuGUI is used as the runner class for the GUI
 *
 * @author TomClarke
 */
public class Runner {

	/**
	 * The main method creates a new instance of of the model the view and the controller 
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
	
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			     try {
					new SplashScreen().initUI();

				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		});
	
	}
}
		
		



