package src;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

/**
 * The Class View is the class that is visible to the user and this is all created using window builder 
 * and adapted to work within a MVC. 
 */
public class SudokuMenuView extends JFrame{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The content pane. */
	private JPanel contentPane;

	/** The chosen date. */
	public String chosenDate;

	/** The btn erase. */
	private JButton btnErase = new JButton("Erase");

	/** The btn load. */
	private JButton btnLoad = new JButton("Load");

	/** The btn help. */
	private JButton btnHelp = new JButton("Hint");

	/** The btn save. */
	private JButton btnSave = new JButton("Save");

	/** The btn backtrack. */
	private JButton btnBacktrack = new JButton("Backtracking");

	/** The btn new. */
	private JButton btnNew = new JButton("New");

	/** The btn describe. */
	private JButton btnDescribe = new JButton("How To Play");

	/** The btn gac. */
	private JButton btnGAC = new JButton("Generalised Arc Consistancy");

	/** The btn dvo. */
	private JButton btnDVO = new JButton("Dynamic Variable Ordering");

	/** The radiobtn enter possible value. */
	private JRadioButton rdbtnEnterPosValue = new JRadioButton("Enter Possible Value");

	/** The radiobtn enter value. */
	private JRadioButton rdbtnEnterValue = new JRadioButton("Enter Value");

	/** The button group. */
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/** The output string. */
	public String outputString;

	/** The btn number. */
	public CellView btnNumber[][];

	/** The current. */
	public SudokuBoard current;
	
	/** The rows. */
	int rows = 3;

	/** The col. */
	int col = 3;

	/** The sudoku grid. */
	public JPanel sudokuGrid;

	/** The mouse adapter. */
	private MouseListener mouseAdapter;
	
	
	/**
	 * Gets enter value.
	 *
	 * @return the rdbtnEnterValue
	 */
	public JRadioButton getRDBtnEnterValue() {
		return rdbtnEnterValue;
	}

	/**
	 * Sets the enter value.
	 *
	 * @param button the button value 
	public void setRDBtnEnterValue(JRadioButton button) {
		rdbtnEnterValue = button;
	}

	/**
	 * Gets the Possible Value
	 *
	 * @return the rdbtnEnterPosValue
	 */
	public JRadioButton getRDBtnEnterPosValue() {
		return rdbtnEnterPosValue;
	}

	/**
	 * Sets the Possible Value
	 *
	 * @param button the button value 
	 */
	public void setRDBtnEnterPosValue(JRadioButton button) {
		rdbtnEnterPosValue = button;
	}

	/**
	 * Sets the mouse adapter.
	 *
	 * @param adapter the new mouse adapter
	 */
	public void setMouseAdapter(MouseListener adapter) {
		mouseAdapter = adapter;
	}

	/**
	 * Gets the mouse adapter.
	 *
	 * @return the mouse adapter
	 */
	public MouseListener getMouseAdapter() {
		return mouseAdapter;
	}


	/**
	 * Gets the label from a location
	 *
	 * @param row the row
	 * @param col the col
	 * @return the label
	 */
	public JLabel getLabel (int row,int col){
		return btnNumber[row][col];
	}

	/**
	 * Sets the label.
	 *
	 * @param row the row
	 * @param col the col
	 * @param sudokuBoard the sudoku board
	 */
	public void setLabel (int row,int col,int sudokuBoard){

		setButton(sudokuBoard,btnNumber[row][col]);
	}



	/**
	 * Sets the button using a switch that takes the button and the input
	 * provided by the input text box.
	 *
	 * @param input the input
	 * @param test the test
	 */

	public static void setButton(int input, CellView test){

		Font f = new Font("Dialog", Font.ITALIC, 22);
		test.setFont(f);

		switch(input){
		case 1: test.setText("1"); break;
		case 2: test.setText("2"); break;
		case 3: test.setText("3"); break;
		case 4: test.setText("4"); break;
		case 5: test.setText("5"); break;
		case 6: test.setText("6"); break;
		case 7: test.setText("7"); break;
		case 8: test.setText("8"); break;
		case 9: test.setText("9"); break;
		case 0: test.setText(" "); break;
		}
		if(test.intValue!= 0){
		}

	}




	/**
	 * Possible values are added to the label and will 
	 * display the values.
	 *
	 * @param inputstrings the inputstrings
	 * @param test the test
	 */
	public static void possibleValue(String inputstrings,JLabel test) {
		char[] array = inputstrings.toCharArray();
		array = removeDuplicates(array);
		String b = new String(array);
		Font f = new Font("Dialog", Font.ITALIC, 10);
		test.setFont(f);
		test.setText(b);

	}

	//Taken from : http://stackoverflow.com/questions/3398153/removing-duplicate-character-from-array
	/**
	 * Removes the duplicates within the array as the possible values should not display
	 * duplicates but users might include them in human error
	 *
	 * @param str the str
	 * @return the char[]
	 */
	public static char[] removeDuplicates(char[] str) {

		int len = str.length;

		int tail = 1;

		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j]) {
					break;
				}
			}

			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}

		}
		for(; tail < len;tail++){
			str[tail] = 0;
		}
		return str;

	}



	/**
	 * Instantiates a new view, and sets the current board to the passed in sudoku board. 
	 * The view is then created as well as the layout managers.
	 * 
	 * Create the frame.
	 *
	 * @param sudokuBoard the sudokuBoard that will become the displayed board.
	 */
	public SudokuMenuView(SudokuBoard sudokuBoard) {

		this.current = sudokuBoard; // The injector pattern or dependency injection

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 816);
		contentPane = new JPanel();		
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		buttonGroup.add(rdbtnEnterValue);
		buttonGroup.add(rdbtnEnterPosValue);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SudokuMenuView.class.getResource("/src/SudokuTitle.jpg")));
		rdbtnEnterValue.setSelected(true);
		sudokuGrid = new JPanel();
		sudokuGrid.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));


		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(32)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(btnGAC)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnBacktrack, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
												.addGap(66)
												.addComponent(btnDVO))
												.addComponent(sudokuGrid, GroupLayout.PREFERRED_SIZE, 737, GroupLayout.PREFERRED_SIZE)))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(btnDescribe, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
														.addComponent(rdbtnEnterPosValue)
														.addComponent(rdbtnEnterValue)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
																.addComponent(btnLoad, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnErase, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
																.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnHelp, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnNew, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
																.addGap(74))
				);
		rdbtnEnterValue.setToolTipText("How to enter a value that is assigned to a cell");
		btnGAC.setToolTipText("Solves the sudoku using Generalised Arc Consistancy");
		btnDVO.setToolTipText("Solves the sudoku using Dynamic Variable Ordering ");
		btnDescribe.setToolTipText("Instructions to use the program and solve the Sudoku ");
		rdbtnEnterPosValue.setToolTipText("Enter a \"penciled\" value that is a possible value for that cell");
		btnNew.setToolTipText("Create a new puzzle ");
		btnErase.setToolTipText("Erase the current puzzle by deleting all values from the cells ");
		btnLoad.setToolTipText("Load a previously saved sudoku puzzle ");
		btnSave.setToolTipText("Save a puzzle in its current state and select it later using the load button ");
		btnHelp.setToolTipText("Creates the next best value to be chosen within the puzzle ");
		btnBacktrack.setToolTipText("Solves the sudoku using Backtracking");

		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(12)
										.addComponent(btnDescribe)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(rdbtnEnterValue)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(rdbtnEnterPosValue)
										.addGap(18)
										.addComponent(btnNew)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnErase)
										.addGap(18)
										.addComponent(btnLoad)
										.addGap(18)
										.addComponent(btnSave)
										.addGap(18)
										.addComponent(btnHelp))
										.addComponent(sudokuGrid, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(btnGAC)
												.addComponent(btnDVO)
												.addComponent(btnBacktrack))
												.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		contentPane.setLayout(gl_contentPane);
	}


	/**
	 * Instantiates a new sudoku menu view.
	 */
	public SudokuMenuView() {

	}

	/**
	 * Save.
	 * This shows a message box
	 *
	 * @return true, if successful
	 */
	public boolean Save() {
		JOptionPane.showMessageDialog(this,"File Saved");
		return true;
	}



	/**
	 * Load the menu to view the saved boards saved within a file location and one is selected 
	 * it is returned and saved as the chosen date, this is then used to load board to the view.
	 * @param directory 
	 *
	 * @return the string
	 */
	public String loadMenu(File dir) {
		FileStore saved = new FileStore();
		File[] savedBoards = saved.getSavedFiles(dir);

		int i = savedBoards.length;


		JFrame frame = new JFrame("Choose A Date To Load");
		ImageIcon icon = new ImageIcon(SudokuMenuView.class.getResource("/src/SudokuTitle.jpg"));
		Object[] possibilities = new Object[i];
		for (int j = 0; j < i - 1; j++) {
			possibilities[j] = savedBoards[j].getName();
		}



		String chosenDate = (String)JOptionPane.showInputDialog(frame,"Load: \n",
				" Please Choose a Saved Sudoku",
				JOptionPane.PLAIN_MESSAGE,
				icon,
				possibilities,
				"savedBoards[1].getName()");

		return chosenDate;
	}


	/**
	 * Adds the save listener.
	 *
	 * @param Describe the describe
	 */
	void addDescribeListener(ActionListener Describe){
		btnDescribe.addActionListener(Describe);
	}

	/**
	 * Adds the save listener.
	 *
	 * @param save the save
	 */
	void addSaveListener(ActionListener save) {
		btnSave.addActionListener(save);
	}

	/**
	 * Adds the solve listener.
	 *
	 * @param Solve the solve
	 */
	void addBacktrackingListener(ActionListener Solve) {
		btnBacktrack.addActionListener(Solve);
	}

	/**
	 * Adds the dvo listener.
	 *
	 * @param DVO the dvo
	 */
	void addDVOListener(ActionListener DVO) {
		btnDVO.addActionListener(DVO);
	}

	/**
	 * Adds the gac listener.
	 *
	 * @param GAC the gac
	 */
	void addGACListener(ActionListener GAC) {
		btnGAC.addActionListener(GAC);
	}

	/**
	 * Adds the load listener.
	 *
	 * @param Load the load
	 */
	void addLoadListener(ActionListener Load) {
		btnLoad.addActionListener(Load);
	}

	/**
	 * Adds the help listener.
	 *
	 * @param Help the help
	 */
	void addHelpListener(ActionListener Help) {
		btnHelp.addActionListener(Help);
	}

	/**
	 * Adds the erase listener.
	 *
	 * @param Erase the erase
	 */
	void addEraseListener(ActionListener Erase) {

		btnErase.addActionListener(Erase);
	}


	/**
	 * Adds the new listener.
	 *
	 * @param New the new
	 */
	void addNewListener(ActionListener New) {
		System.out.println("Adding New Listener");
		btnNew.addActionListener(New);
	}

	/**
	 * Update board re creates the sudoku grid each time by resetting the layout and re-populating it. 
	 * This includes a mouse listener within each cell and provides a board for a better look, this is then 
	 * validated to allow it to be shown.
	 */
	public void updateBoard() {

		sudokuGrid.removeAll(); //remove everything from the grid.
		sudokuGrid.setLayout(new GridLayout(rows*col,rows*col)); //reset the layout of the grid

		for(int i=0 ; i<9 ; i++){
			for(int j=0 ; j<9 ; j++){


				current.sudokuBoard[i][j].setOpaque(true);
				current.sudokuBoard[i][j].setBorder(new LineBorder(Color.GRAY));
				current.sudokuBoard[i][j].setHorizontalAlignment(JLabel.CENTER);
				current.sudokuBoard[i][j].setName("gridLocation"+i+","+j);
				current.sudokuBoard[i][j].setEnabled(true);
				current.sudokuBoard[i][j].setToolTipText("To enter a value: select a cell and enter a number on the keyboard then click again");

				current.sudokuBoard[i][j].addMouseListener(mouseAdapter);

				current.sudokuBoard[i][j].setBackground(Color.LIGHT_GRAY);

				if((i == 0 || i == 1 || i == 2) && (j == 0 || j == 1 || j == 2)){
					current.sudokuBoard[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.WHITE));
				}
				if((i == 0 || i == 1 || i == 2) && (j == 3 || j == 4 || j == 5)){
					current.sudokuBoard[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.GRAY));
				}
				if((i == 0 || i == 1 || i == 2) && (j == 6 || j == 7 || j == 8)){
					current.sudokuBoard[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.WHITE));
				}
				if((i == 3 || i == 4 || i == 5) && (j == 0 || j == 1 || j == 2)){
					current.sudokuBoard[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.GRAY));
				}
				if((i == 3 || i == 4 || i == 5) && (j == 3 || j == 4 || j == 5)){
					current.sudokuBoard[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.WHITE));
				}
				if((i == 3 || i == 4 || i == 5) && (j == 6 || j == 7 || j == 8)){
					current.sudokuBoard[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.GRAY));
				}
				if((i == 6 || i == 7 || i == 8) && (j == 0 || j == 1 || j == 2)){
					current.sudokuBoard[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.WHITE));
				}
				if((i == 6 || i == 7 || i == 8) && (j == 3 || j == 4 || j == 5)){
					current.sudokuBoard[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.GRAY));
				}
				if((i == 6 || i == 7 || i == 8) && (j == 6 || j == 7 || j == 8)){
					current.sudokuBoard[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.WHITE));
				}
				sudokuGrid.add(current.sudokuBoard[i][j]);

			}
		}
		sudokuGrid.validate(); //re-evaluate the grid.
	}

	/**
	 * Solved is a message box that give the time the algorithm took to complete the algorithm
	 *
	 * @param algorithm the algorithm name
	 * @param time the time it took to complete
	 */
	public void solved(String algorithm, Long time) {
		JOptionPane.showMessageDialog(this,"Solved!! Using: "+algorithm+"\n \n Time: "+time+" Milliseconds");	
	}

	/**
	 * Cannot solve message box
	 */
	public void cannotSolve() {
		JOptionPane.showMessageDialog(this,"This cannot be solved!");	
	}


	/**
	 * Describe is a message box that contains a description of the puzzle rules.
	 */
	public void describe() {

		JOptionPane.showMessageDialog(this,"How To Play: "+"\n"+ "The aim is to fill in each of the squares that are split into 9x9 grids, " +"\n"+
				"each row, column and grid needs to contain the numbers 1-9 without "+"\n"+ "repeating a number"+"\n"+"\n"+"Tip: To add a value to a square " +
				"click on the desired square and use the"+"\n"+ "keyboard to enter the value needed and click on the square again. " +
				"To add" +"\n"+ " a possible value select the possible values option.");
	}

	/**
	 * Sets the board.
	 *
	 * @param board the newboard
	 */
	public void setBoard(SudokuBoard board){
		current = board;

	}


	/**
	 * Sets the start button of th values of the cell view 
	 * and allows the value to be set to the cells text view. 
	 * 
	 *
	 * @param value the value
	 * @param test the test
	 */
	public void setStartButton(int value, CellView test) {
		Font f = new Font("Dialog", Font.BOLD, 26);
		test.setFont(f);	
		test.removeNotify();

		switch(value){
		case 1: test.setText("1"); break;
		case 2: test.setText("2"); break;
		case 3: test.setText("3"); break;
		case 4: test.setText("4"); break;
		case 5: test.setText("5"); break;
		case 6: test.setText("6"); break;
		case 7: test.setText("7"); break;
		case 8: test.setText("8"); break;
		case 9: test.setText("9"); break;
		case 0: test.setText(" "); break;
		}
		if(test.intValue!= 0){
		}
	}

	//modified from http://stackoverflow.com/questions/10083447/selecting-folder-destination-in-java
	/**
	 * the file location chooser that displays the directories and allows them 
	 * to be used within the file store.
	 * @return the selected file directory
	 */
	public File setLocation() {
		JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File(""));
	    chooser.setDialogTitle("Choose A File Location");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);	   

	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	      System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
	    } else {
	      System.out.println("No Selection ");
	    }
		return chooser.getSelectedFile();
	  }

	}


