package src1;
/**
 * 
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author TomClarke
 *
 */
public class Controller  {

	private Model m_model;
	private View m_view;


	public Controller(Model model, View view) {
		m_model = model;
		m_view = view;

		view.addSaveListener(new SaveListener());
	}

	class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			m_model.Save();
		}
	}
	class SolveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			m_model.Solve();
		}
	}
	class EraseListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			m_model.Erase();
		}
	}
	class LoadListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			m_model.Load();
		}
	}
	class HelpListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			m_model.Help();
		}
	}

	class add1Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			m_model.add1();
		}
	}

}







  
  
	
			
	

