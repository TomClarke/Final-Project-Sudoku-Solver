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
 * The Class View is the class that is visible to the user and this is all created using windowbuider 
 * and adapted to work within a MVC. 
 */
public class SudokuMenuView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The content pane. */
	private JPanel contentPane;

	public String chosenDate;
	/** The btn erase. */
	private JButton btnErase = new JButton("Erase");

	/** The btn load. */
	private JButton btnLoad = new JButton("Load");

	/** The btn help. */
	private JButton btnHelp = new JButton("Hint");

	/** The btn save. */
	private JButton btnSave = new JButton("Save");

	private JButton btnBacktrack = new JButton("Backtracking");

	private JButton btnNew = new JButton("New");

	private JButton btnDescribe = new JButton("How To Play");

	private JButton btnGAC = new JButton("Generalised Arc Consistancy");

	private JButton btnDVO = new JButton("Dynamic Variable Ordering");

	private JRadioButton rdbtnEnterPosValue = new JRadioButton("Enter Possible Value");

	private JRadioButton rdbtnEnterValue = new JRadioButton("Enter Value");

	private final ButtonGroup buttonGroup = new ButtonGroup();

	public String outputString;

	/** The btn number. */
	public CellView btnNumber[][];
	public SudokuBoard current;
	/** The suduko grid. */

	int rows = 3;
	int col = 3;
	public JPanel sudokuGrid;


	private MouseListener mouseAdapter;


	public int tempRow = 0;
	public int tempCol = 0; 
	public int tempValue = 0;
	public boolean done;


	public JRadioButton getRDBtnEnterValue() {
		return rdbtnEnterValue;
	}
	public void setRDBtnEnterValue(JRadioButton button) {
		rdbtnEnterValue = button;
	}

	public JRadioButton getRDBtnEnterPosValue() {
		return rdbtnEnterPosValue;
	}
	public void setRDBtnEnterPosValue(JRadioButton button) {
		rdbtnEnterPosValue = button;
	}

	public void setMouseAdapter(MouseListener adapter) {
		mouseAdapter = adapter;
	}

	public MouseListener getMouseAdapter() {
		return mouseAdapter;
	}


	public JLabel getLabel (int row,int col){
		return btnNumber[row][col];
	}

	public void setLabel (int row,int col,int sudokuBoard){

		setButton(sudokuBoard,btnNumber[row][col]);
	}



	/**
	 * Sets the button using a switch that takes the button and the input 
	 * provided by the input text box
	 *
	 * @param string the input
	 * @param event the test
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




	public static void possibleValue(String inputstrings,JLabel test) {
		char[] array = inputstrings.toCharArray();
		array = removeDuplicates(array);
		String b = new String(array);
		Font f = new Font("Dialog", Font.ITALIC, 10);
		test.setFont(f);
		test.setText(b);

	}

	//http://stackoverflow.com/questions/3398153/removing-duplicate-character-from-array
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
	 * Instantiates a new view.
	 * 
	 * Create the frame.
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


	public SudokuMenuView() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Save.
	 * This as an example is done to show a message box
	 * @return 
	 */
	public boolean Save() {
		JOptionPane.showMessageDialog(this,"File Saved");
		return true;
	}



	/**
	 * Load.
	 */
	public String loadMenu() {
		FileStore saved = new FileStore();
		File[] savedBoards = saved.getSavedFiles();

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

	void addDVOListener(ActionListener DVO) {
		btnDVO.addActionListener(DVO);
	}

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


	void addNewListener(ActionListener New) {
		System.out.println("Adding New Listener");
		btnNew.addActionListener(New);
	}

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
	public void updateBoard(SudokuBoard update) {

		this.current = update; 
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
				sudokuGrid.validate();
			}
		}
		sudokuGrid.validate(); //re-evaluate the grid.

	}


	//public synchronized void addMouseListener(MouseListener Button) {

	//}

	public void solved(String algorithm, Long time) {
		JOptionPane.showMessageDialog(this,"Solved!! Using: "+algorithm+"\n \n Time: "+time+" Milliseconds");	
	}

	public void cannotSolve() {
		JOptionPane.showMessageDialog(this,"This cannot be solved!");	
	}


	public void describe() {

		JOptionPane.showMessageDialog(this,"How To Play: "+"\n"+ "The aim is to fill in each of the squares that are split into 9x9 grids, " +"\n"+
				"each row, column and grid needs to contain the numbers 1-9 without "+"\n"+ "repeating a number"+"\n"+"\n"+"Tip: To add a value to a square " +
				"click on the desired square and use the"+"\n"+ "keyboard to enter the value needed and click on the square again. " +
				"To add" +"\n"+ " a possible value select the possible values option.");
		done = true;
	}

	public void setBoard(SudokuBoard board){
		current = board;

	}


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

	public void addNewBoard(SudokuBoard board){
		this.current = board;
	}

}

