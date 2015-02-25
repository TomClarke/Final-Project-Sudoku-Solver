/**
 * 
 */
package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author TomClarke
 *
 */
public class Controller {

	private Model m_model;
	private View m_view;

	/**
	 * Uses the very to create a new instance of the save listener
	 * 
	 */
	public Controller(Model model, View view) {
		m_model = model;
		m_view = view;

		view.addSaveListener(new SaveListener());
	}

	/**
	 * The listeners for event
	 * Save will listen for an event that is triggered from the view 
	 * in this case pressing a button Save 
	 */
	class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			m_model.Save();
		}
	}
	/**
	 * The listeners for event
	 * Save will listen for an event that is triggered from the view 
	 * in this case pressing a button Solve 
	 */
	class SolveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			m_model.Solve();
		}
	}
	/**
	 * The listeners for event
	 * Save will listen for an event that is triggered from the view 
	 * in this case pressing a button Erase  
	 */
	class EraseListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			m_model.Erase();
		}
	}
	
	
	/**
	 * The listeners for event
	 * Save will listen for an event that is triggered from the view 
	 * in this case pressing a button Load 
	 */
	class LoadListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			m_model.Load();
		}
	}
	/**
	 * The listeners for event
	 * Save will listen for an event that is triggered from the view 
	 * in this case pressing a button Help 
	 */
	class HelpListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			m_model.Help();
		}
	}
	/**
	 * The listeners for event
	 * Save will listen for an event that is triggered from the view 
	 * in this case pressing a button any of the buttons in the sudoku 
	 * to edit them. 
	 */
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			m_model.Buttons();
		}
	}
	


}





 
  
  
	
			
	

