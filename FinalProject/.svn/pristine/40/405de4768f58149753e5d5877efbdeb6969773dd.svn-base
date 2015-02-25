package src;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;


/**
 * The Class Controller is used to me in the middle of the model and the view
 * and pass the needed information between them both
 * 
 * @author TomClarke
 */
public class SudokuMenuController  {


	/** The m_model. */
	private SudokuMenuModel m_model;
	
	/** The m_view. */
	private SudokuMenuView m_view;

	private SplashScreen splashScreen;


	/**
	 * Instantiates a new controller.
	 *
	 * @param model the model
	 * @param view the view
	 **/
	 public SudokuMenuController(SudokuMenuModel model, SudokuMenuView view, SplashScreen splashScreen) {
		m_model = model;
		m_view = view;
		this.splashScreen = splashScreen;

		view.setMouseAdapter(new GridClickAdapter());
		
		view.addSaveListener(new SaveListener());
		view.addLoadListener(new LoadListener());
		view.addNewListener(new NewListener());
		view.addEraseListener(new EraseListener());
		view.addDescribeListener(new DescribeListener());
		view.addSolveListener(new SolveListener());

		view.updateBoard();
		view.setVisible(true);
	}
	 
	class GridClickAdapter implements MouseListener {
		private String outputString;
		private String output = " ";

		public void mouseClicked(MouseEvent e) {
			System.out.println("CLICKED");
			event(e);
		}

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


		public void findPosInput(JLabel test) {
			test.setFocusable(true);
			test.setEnabled(true);
			test.requestFocusInWindow();
			test.addKeyListener(new KeyboardListener());
			System.out.println("selected:" + test);
		}

		public void findInput(JLabel test) {
			test.setFocusable(true);
			test.setEnabled(true);
			test.requestFocusInWindow();
			test.addKeyListener(new KeyboardListener());
			System.out.println("selected:" + test);
		}

		class KeyboardListener implements KeyListener {

			@Override
			public void keyPressed(KeyEvent e) {
				displayInfo(e, "KEY TYPED: ");
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			private void displayInfo(KeyEvent e, String string) {
				System.out.println("Display Info");
				char c = e.getKeyChar();
				if (outputString == null || output == null){
					output = "";
					outputString ="";
				}
				output = Character.toString(c);
				System.out.println("Output Num: "+ outputString);	

				outputString = convertoString(c);
				System.out.println("OutputString: "+outputString);	
			}
			
			private String convertoString(char c) {
				String tempString = outputString;
				tempString = "" + c;

				return tempString;
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
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
			String chosenDate = m_view.loadMenu();
	        m_model.Load(chosenDate);
	        m_view.setBoard(m_model.getBoard());
	        m_view.updateBoard();
		}
	}

	class NewListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			m_model.New();
		    m_view.setBoard(m_model.getBoard());
		    m_view.updateBoard();
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

	class DescribeListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			m_view.describe();
		}
	}


	
	}




	








  
