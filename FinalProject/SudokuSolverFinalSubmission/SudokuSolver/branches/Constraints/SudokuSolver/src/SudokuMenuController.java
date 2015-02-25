package src;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
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


	/**
	 * Instantiates a new controller.
	 *
	 * @param model the model
	 * @param view the view
	 **/
	 public SudokuMenuController(SudokuMenuModel model, SudokuMenuView view) {
		m_model = model;
		m_view = view;

		view.addSaveListener(new SaveListener());
		view.addLoadListener(new LoadListener());
		view.addNewListener(new NewListener());
		view.addEraseListener(new EraseListener());
		view.addDescribeListener(new DescribeListener());

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

			String chosenDate = m_view.loadMenu();
	            	m_model.Load(chosenDate);
	        
	
		}
	}

	class NewListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
		 
		    	 SwingWorker<SudokuBoard, Void> worker = new SwingWorker<SudokuBoard, Void>() {
		    		 SudokuBoard board = null;
		    		 
		    		 @Override
		             protected SudokuBoard doInBackground() throws Exception {
		    				System.out.println("To Model New ");
		    			 m_model.New();
		    				
		    				//board.PrintBoard();
		                 return board ;
		             }
		    		  @Override
		              protected void done() {

		    				
						try {
							board = get();
							
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ExecutionException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//SudokuBoardController newBoard = new SudokuBoardController();
						//newBoard.setBoard(board);
						//m_view.setBoard(board);
		    			//SudokuBoard sudukoBoard = new SudokuBoard();
		    			//  taken.setBoard();//m_view.setBoard(board);
						
		    		  }
		    	 };

		         worker.execute();
		     }

	}
		//	m_model.New();
		
	//}
		
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




	








  
