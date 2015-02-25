package src;
/**
 * 
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * The Class Controller is used to me in the middle of the model and the view
 * and pass the needed information between them both
 * 
 * @author TomClarke
 */
public class Controller  {

	/** The m_model. */
	private Model m_model;
	
	/** The m_view. */
	private View m_view;


	/**
	 * Instantiates a new controller.
	 *
	 * @param model the model
	 * @param view the view
	 */
	public Controller(Model model, View view) {
		m_model = model;
		m_view = view;

		view.addSaveListener(new SaveListener());
	}

	/**
	 * The listener interface for receiving save events.
	 * The class that is interested in processing a save
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addSaveListener<code> method. When
	 * the save event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see SaveEvent
	 */
	class SaveListener implements ActionListener {
		
		
		public void actionPerformed(ActionEvent e) {

			m_model.Save();
	
		}
	}
	
	/**
	 * The listener interface for receiving solve events.
	 * The class that is interested in processing a solve
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addSolveListener<code> method. When
	 * the solve event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see SolveEvent
	 */
	class SolveListener implements ActionListener {
		
	
		public void actionPerformed(ActionEvent e) {

			m_model.Solve();
		}
	}
	
	/**
	 * The listener interface for receiving erase events.
	 * The class that is interested in processing a erase
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addEraseListener<code> method. When
	 * the erase event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see EraseEvent
	 */
	class EraseListener implements ActionListener {
		

		public void actionPerformed(ActionEvent e) {

			m_model.Erase();
		}
	}
	
	/**
	 * The listener interface for receiving load events.
	 * The class that is interested in processing a load
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addLoadListener<code> method. When
	 * the load event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see LoadEvent
	 */
	class LoadListener implements ActionListener {
		

		public void actionPerformed(ActionEvent e) {

			m_model.Load();
		}
	}
	
	/**
	 * The listener interface for receiving help events.
	 * The class that is interested in processing a help
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addHelpListener<code> method. When
	 * the help event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see HelpEvent
	 */
	class HelpListener implements ActionListener {
		

		public void actionPerformed(ActionEvent e) {

			m_model.Help();
		}
	}

	/**
	 * The listener interface for receiving add1 events.
	 * The class that is interested in processing a add1
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addadd1Listener<code> method. When
	 * the add1 event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see add1Event
	 */
	class add1Listener implements ActionListener {
		

		public void actionPerformed(ActionEvent e) {

			m_model.add1();
			m_view.getBackground();
		}
	}

}







  
  
	
			
	

