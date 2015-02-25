/**
 * 
 */
package src;


/**
 * The Class SudokuGUI is ussed as the runner class for the GUI
 *
 * @author TomClarke
 */
public class SudokuGUI {

	/**
	 * The main method creates a new instance of of the model the view and the controller 
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		Model model = new Model();
		View view = new View();
		@SuppressWarnings("unused")
		Controller controller = new Controller(model, view);
		
		view.setVisible(true);
	}

}
