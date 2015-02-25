/**
 * 
 */
package src;

/**
 * @author TomClarke
 *
 */
public class SudokuGUI {

	/**
	 * 
	 * This runs the GUI program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);
		
		view.setVisible(true);
	}

}
