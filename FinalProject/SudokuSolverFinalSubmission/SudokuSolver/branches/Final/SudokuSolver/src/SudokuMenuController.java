package src;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Timer;
import javax.swing.JLabel;


/**
 * The Class Controller is used to me in the middle of the model and the view
 * and pass the needed information between them both.
 *
 * @author TomClarke
 */
public class SudokuMenuController  {


	/** The m_model. */
	private SudokuMenuModel m_model;

	/** The m_view. */
	private SudokuMenuView m_view;

	/** The splash screen. */
	private SplashScreen splashScreen;

	/** The timer. */
	public Timer timer = new Timer();

	/**
	 * Instantiates a new controller.
	 * adds all the listeners and updates the board.
	 * @param model the model
	 * @param view the view
	 * @param splashScreen the splash screen
	 */
	public SudokuMenuController(SudokuMenuModel model, SudokuMenuView view, SplashScreen splashScreen) {
		m_model = model;
		m_view = view;
		this.setSplashScreen(splashScreen);

		view.setMouseAdapter(new GridClickAdapter());
		view.addHelpListener(new HelpListener());
		view.addSaveListener(new SaveListener());
		view.addLoadListener(new LoadListener());
		view.addNewListener(new NewListener());
		view.addEraseListener(new EraseListener());
		view.addDescribeListener(new DescribeListener());
		view.addBacktrackingListener(new BacktrackingListener());
		view.addDVOListener(new DVOListener());
		view.addGACListener(new GACListener());
		view.updateBoard();
		view.setVisible(true);
	}

	/**
	 * Gets the splash screen.
	 *
	 * @return the splash screen
	 */
	public SplashScreen getSplashScreen() {
		return splashScreen;
	}



	/**
	 * Sets the splash screen.
	 *
	 * @param splashScreen the new splash screen
	 */
	public void setSplashScreen(SplashScreen splashScreen) {
		this.splashScreen = splashScreen;
	}

	/**
	 * The Class GridClickAdapter is the mouse listener when the user clicks on one 
	 * of the cells within the view.
	 */
	class GridClickAdapter implements MouseListener {

		/** The output string. */
		private String outputString;

		/** The output. */
		private String output = " ";

		/**
		 * When a mouse is clicked the event method is ran
		 */
		public void mouseClicked(MouseEvent e) {
			System.out.println("CLICKED");
			event(e);
		}

		/**
		 * Event uses the current cell which has been clicked on as 
		 * that is the getSource() provides the selected cell
		 *The values of the current pencil or value are added to the cell as the value
		 *when selected a key listener is activated so that it is possible to take the 
		 *values of the key stroke.
		 *
		 * @param event the event
		 */
		public void event(MouseEvent event) {

			CellView test = (CellView)event.getSource();
			if (m_view.getRDBtnEnterValue().isSelected() == false || m_view.getRDBtnEnterPosValue().isSelected() == true){
				System.out.println("FIND POS1: "+test.getText());

				findPosInput(test);

				String inputstrings = outputString;

				System.out.println("Output Possible: " + inputstrings);

				test.setPencil(inputstrings);

			} else {
				System.out.println("FIND POS2: "+test.getText());

				findInput(test);

				test.requestFocusInWindow();
				String input = output;

				System.out.println("Output: " + input);
				int inInput = 0;
				if(input != " "){
					inInput = Integer.parseInt(input);
				}
				System.out.println("setButton: "+inInput);

				test.setValue(inInput);
				test.intValue = inInput;
			}
			outputString = "";
		}


		/**
		 * Find pos input.
		 *
		 * @param test the test
		 */
		public void findPosInput(JLabel test) {
			test.setFocusable(true);
			test.setEnabled(true);
			test.requestFocusInWindow();
			test.addKeyListener(new KeyboardListener());
			System.out.println("selected:" + test);
		}

		/**
		 * Find input.
		 *
		 * @param test the test
		 */
		public void findInput(JLabel test) {
			test.setFocusable(true);
			test.setEnabled(true);
			test.requestFocusInWindow();
			test.addKeyListener(new KeyboardListener());
			System.out.println("selected:" + test);
		}

		/**
		 * The listener interface for receiving keyboard events.
		 * The class that is interested in processing a keyboard
		 * event implements this interface, and the object created
		 * with that class is registered with a component using the
		 * component's <code>addKeyboardListener<code> method. When
		 * the keyboard event occurs, that object's appropriate
		 * method is invoked.
		 *
		 * @see KeyboardEvent
		 */
		class KeyboardListener implements KeyListener {

			/** 
			 * the value of the key
			 */
			@Override
			public void keyPressed(KeyEvent e) {
				displayInfo(e);
			}

			/** 
			 * kept as they are overrides for the keylistener
			 */
			@Override
			public void keyReleased(KeyEvent e) {

			}

			/** 
			 * kept as they are overrides for the keylistener
			 */
			@Override
			public void keyTyped(KeyEvent e) {

			}

			/**
			 * Display info takes the value from the key listener where
			 * the value of the key input is then converted to the desired output 
			 *
			 * @param e the e
			 * @param string the string
			 */
			private void displayInfo(KeyEvent e) {
				char c = e.getKeyChar();
				if (outputString == null || output == null){
					output = "";
					outputString ="";
				}
				output = Character.toString(c);
				//System.out.println("Output Num: "+ outputString);	

				outputString = convertoString(c);
				//System.out.println("OutputString: "+outputString);	
			}

			/**
			 * Convert to string.
			 *
			 * @param c the c
			 * @return the string
			 */
			private String convertoString(char c) {
				String tempString = outputString;
				tempString = "" + c;

				return tempString;
			}
		}

		/**
		 * kept as they are overrides for the mouse listener
		 */
		@Override
		public void mouseEntered(MouseEvent arg0) {

		}

		/**
		 * kept as they are overrides for the mouse listener
		 */
		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		/** 
		 * kept as they are overrides for the mouse listener
		 */
		@Override
		public void mousePressed(MouseEvent arg0) {

		}

		/** 
		 * kept as they are overrides for the mouse listener
		 */
		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
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
			File directory = m_view.setLocation();
			m_model.Save(directory);
			m_view.Save();
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
	class BacktrackingListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			long startTime = System.currentTimeMillis();
			m_model.Solve("Backtracking");
			long endTime = System.currentTimeMillis();
			m_view.setBoard(m_model.getBoard());
			m_view.updateBoard();
			if(m_model.getBoard().getSolved() == false){
				m_view.cannotSolve();
			}
			else{
				long duration = endTime - startTime;
				//http://stackoverflow.com/questions/180158/how-do-i-time-a-methods-execution-in-java
				m_view.solved("Backtracking", duration);
				System.out.println("Backtracking Timer: "+duration+" MilliSeconds");
			}
		}
	}

	/**
	 * The listener interface for receiving GAC events.
	 * The class that is interested in processing a GAC
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addGACListener<code> method. When
	 * the GAC event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see GACEvent
	 */
	class GACListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			long startTime = System.currentTimeMillis();
			m_model.Solve("GAC");
			long endTime = System.currentTimeMillis();
			m_view.setBoard(m_model.getBoard());
			m_view.updateBoard();
			if(m_model.getBoard().getSolved() == false){
				m_view.cannotSolve();
			}
			else{
				long duration = endTime - startTime;
				m_view.solved("Generalised Arc Consistancy", duration);
				System.out.println("GAC Timer: "+duration+" MilliSeconds");
			}
		}
	}


	/**
	 * The listener interface for receiving DVO events.
	 * The class that is interested in processing a DVO
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addDVOListener<code> method. When
	 * the DVO event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see DVOEvent
	 */
	class DVOListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			long startTime = System.currentTimeMillis();
			m_model.Solve("DVO");
			long endTime = System.currentTimeMillis();
			m_view.setBoard(m_model.getBoard());
			m_view.updateBoard();
			if(m_model.getBoard().getSolved() == false){
				m_view.cannotSolve();
			}
			else{
				long duration = endTime - startTime;
				m_view.solved("Dynamic Variable Ordering", duration);
				System.out.println("DVO Timer: "+duration+" MilliSeconds");
			}
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
			m_model.Solve("DVOHint");
			m_view.setBoard(m_model.getBoard());
			m_view.updateBoard();
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
			m_view.setBoard(m_model.getBoard());
			m_view.updateBoard();
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
			File directory = m_view.setLocation();
			String chosenDate = m_view.loadMenu(directory);
			m_model.Load(directory,chosenDate);
			m_view.setBoard(m_model.getBoard());
			m_view.updateBoard();
		}
	}

	/**
	 * The listener interface for receiving new events.
	 * The class that is interested in processing a new
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addNewListener<code> method. When
	 * the new event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see NewEvent
	 */
	class NewListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			m_model.New();
			m_view.setBoard(m_model.getBoard());
			m_view.updateBoard();
		}
	}



	/**
	 * The listener interface for receiving describe events.
	 * The class that is interested in processing a describe
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addDescribeListener<code> method. When
	 * the describe event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see DescribeEvent
	 */
	class DescribeListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			m_view.describe();
		}
	}
}
