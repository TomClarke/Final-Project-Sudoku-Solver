package src;

import java.io.IOException;
import java.text.DateFormat;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;



/**
 * The Class Model is used to provide an action for the buttons
 */
public class SudokuMenuModel {


	/** The view. */
	private final SudokuMenuView view = new SudokuMenuView();
	//private final Model mod = new Model();
	//private final  Controller control = new Controller(mod, view);
	public SudokuBoard loaded = null;
	public String date = null; 

	 public FileStore saved = new FileStore();

	/**
	 * Solve.
	 */
	public void Solve() {

		SudokuBoardModel boardModel= new SudokuBoardModel();
	boardModel.currentBoard = saved.board;
	System.out.println("Model Solving... ");
	SudokuBoard solvedBoard = boardModel.Solve();
	System.out.println("Solved Board ");
		solvedBoard.PrintBoard();
	}


	/**
	 * Save.
	 * provide the action from within view
	 * @param values 
	 */

	public boolean Save() {


		System.out.println("Saving...");
		String[] output = new String [81];
		System.out.println("Output: ");
	
		int count = 0;
		int i = 0;
		int j = 0;
		
		SudokuBoard savedBoard;
		
		savedBoard = saved.board;
		
		
		
		
		for(j=0 ; j<9 ; j++){
			for(i=0 ; i<9 ; i++){
			
			//System.out.print("Set: "+count+"|");	
			//output[count] = view.btnNumber[i][j].getText();
		
				System.out.println(new Integer(savedBoard.sudokuBoard[i][j].getValue()).toString());
				
			output[count] = new Integer(savedBoard.sudokuBoard[i][j].getValue()).toString();
			
			System.out.println("output:("+i+" ,"+j+ ")location: "+output[count]+ ", SetTo: "+savedBoard.sudokuBoard[i][j].strValue);
		
		
			
			count++;
		}
			
		}

		
		try {
			saved.save(output);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}


	/**
	 * Load.
	 * @param chosenDate 
	 */
	public void Load(String chosenDate) {

		date = chosenDate;
			
			 SwingWorker<SudokuBoard, Void> worker = new SwingWorker<SudokuBoard, Void>() {
		            
	    		 @Override
	             protected SudokuBoard doInBackground() throws Exception {
	    			 
	            	saved.load(date);
	                 return saved.board ;
	             }
	    		  @Override
	              protected void done() {

	    			  SudokuBoard board = null;
					try {
						board = get();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    			//SudokuBoard sudukoBoard = new SudokuBoard();
					//board.setBoard();
					board.setBoard(board);
					//m_view.setBoard(board);
					
	    		  }
	    	 };

	         worker.execute();
	     }


	/**
	 * Erase.
	 */
	public void Erase() {

		saved.board.newBoard();
	}


	/**
	 * Help.
	 */
	public void Help() {

		SudokuBoardModel boardModel= new SudokuBoardModel();
		boardModel.currentBoard = saved.board;
		/*int[] hintMove = boardModel.GAC();
		saved.board.setBoard(hintMove);
		System.out.println("Hint Board");
		saved.board.PrintBoard();
		*/
		SudokuBoard solvedBoard = boardModel.GAC();
		System.out.println("GAC Board ");
			solvedBoard.PrintBoard();
	}





	public void New() {
		
		SwingWorker<SudokuBoard, Void> worker = new SwingWorker<SudokuBoard, Void>() {
   		
		
   		 @Override
            protected SudokuBoard doInBackground() throws Exception {
   				System.out.println("To saved New ");
   				saved.startNew(0);
   				saved.load();
   			
   				
   				//board.PrintBoard();
                return saved.board ;
            }
   		  @Override
             protected void done() {

   				
				try {
					loaded = get();
					loaded.setBoard();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Print model: loaded ");
				loaded.PrintBoard();
		
   		  }
		};
	
	     worker.execute();
    }


	
		/*FileStore saved = new FileStore();
		SudokuBoardController loaded = null;
		
			
			 try {
				
				saved.startNew(0);
				
			} catch (XPathExpressionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			loaded = saved.load();

			//SudokuBoard sudukoBoard = new SudokuBoard();
			
			//sudukoBoard.setBoard(loaded);
	
		return loaded;

*/
	}
	



