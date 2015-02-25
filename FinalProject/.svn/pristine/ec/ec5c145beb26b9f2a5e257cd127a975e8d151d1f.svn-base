package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.Dimension;
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
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


/**
 * The Class View is the class that is visible to the user and this is all created using windowbuider 
 * and adapted to work within a MVC. 
 */
public class SudokuMenuView extends JFrame implements KeyListener{

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

	private JButton btnSolve = new JButton("Solve");


	private JButton btnNew = new JButton("New");


	private JButton btnDescribe = new JButton("How To Play");

	/** The btn number. */
	//public JLabel btnNumber[][];
	public CellView btnNumber[][];
	public SudokuBoard current;
	/** The suduko grid. */

	//private JPanel sudukoGrid = new JPanel(new GridLayout(9,9));
	int rows = 3;
	int col = 3;
	public JPanel sudukoGrid = new JPanel(new GridLayout(rows*col,rows*col));

	public String output = (" "); 
	public String outputString;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JRadioButton rdbtnEnterValue = new JRadioButton("Enter Value");

	private JRadioButton rdbtnEnterPosValue = new JRadioButton("Enter Possible Value");

	private final JLabel lblCreatesANew = new JLabel("Creates a new puzzle");
	private final JLabel lblClickToSolve = new JLabel("Click to solve the puzzle");
	private final JLabel lblLoadPreviousPuzzle = new JLabel("Load previous puzzle");
	private final JLabel lblDeleteAllInputs = new JLabel("Delete all inputs"); 
	private final JLabel lblSaveCurrentPuzzle = new JLabel("Save current puzzle");
	private final JLabel lblProvideSomeHelp = new JLabel("Provide some help");

	public int tempRow = 0;
	public int tempCol = 0; 
	public int tempValue = 0;
	public boolean done;




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

		//test.addPropertyChangeListener(listener)
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
		//System.out.println("Label: current"+test.getName()+" = "+test.intValue+ "| Text: "+test.getText());
		}
		test.paintImmediately(test.getVisibleRect());
		test.validate();
	


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
	public SudokuMenuView() {
		System.out.println("Set Label Placement");
		addMouseListener(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();		
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.add(new JLabel( new ImageIcon( "/src/backgrounds.jpg")));
		setContentPane(contentPane);
		buttonGroup.add(rdbtnEnterValue);
		buttonGroup.add(rdbtnEnterPosValue);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SudokuMenuView.class.getResource("/src/SudokuTitle.jpg")));
		rdbtnEnterValue.setSelected(true);
		sudukoGrid.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

		lblClickToSolve.setVisible(false);
		lblLoadPreviousPuzzle.setVisible(false);
		lblDeleteAllInputs.setVisible(false);
		lblSaveCurrentPuzzle.setVisible(false);
		lblProvideSomeHelp.setVisible(false);







		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(sudukoGrid, GroupLayout.PREFERRED_SIZE, 737, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDescribe, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnEnterPosValue)
								.addComponent(rdbtnEnterValue)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(btnLoad, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnErase, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
												.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnHelp, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnNew, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(lblProvideSomeHelp)
														.addComponent(lblSaveCurrentPuzzle)
														.addComponent(lblDeleteAllInputs)
														.addComponent(lblLoadPreviousPuzzle)
														.addComponent(lblCreatesANew)))))
														.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
																.addGap(274)
																.addComponent(btnSolve, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
																.addGap(18)
																.addComponent(lblClickToSolve)
																.addContainerGap(473, Short.MAX_VALUE))
																.addGroup(gl_contentPane.createSequentialGroup()
																		.addContainerGap(220, Short.MAX_VALUE)
																		.addComponent(lblNewLabel)
																		.addGap(213))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(12)
										.addComponent(btnDescribe)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(rdbtnEnterValue)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(rdbtnEnterPosValue)
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnNew)
												.addComponent(lblCreatesANew, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(btnErase)
														.addComponent(lblDeleteAllInputs))
														.addGap(18)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																.addComponent(btnLoad)
																.addComponent(lblLoadPreviousPuzzle))
																.addGap(18)
																.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																		.addComponent(btnSave)
																		.addComponent(lblSaveCurrentPuzzle))
																		.addGap(18)
																		.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																				.addComponent(btnHelp)
																				.addComponent(lblProvideSomeHelp)))
																				.addGroup(gl_contentPane.createSequentialGroup()
																						.addPreferredGap(ComponentPlacement.RELATED)
																						.addComponent(sudukoGrid, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)))
																						.addGap(18)
																						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																								.addComponent(btnSolve)
																								.addComponent(lblClickToSolve))
																								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		lblCreatesANew.setVisible(false);
		contentPane.setLayout(gl_contentPane);
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
for ( int j = 0; j < i-1; j++){
		possibilities[j] = savedBoards[j].getName();
}
			//{savedBoards[0].getName(),savedBoards[1].getName(),savedBoards[2].getName(),savedBoards[3].getName(),savedBoards[4].getName(),};



		String chosenDate = (String)JOptionPane.showInputDialog(frame,"Load: \n",
				" 32",
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
	void addSolveListener(ActionListener Solve) {
		btnSolve.addActionListener(Solve);
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
	 * Adds the erase listener.
	 *
	 * @param Erase the erase
	 */
	void addEraseListener(ActionListener Erase) {

		btnErase.addActionListener(Erase);
	}


	void addNewListener(ActionListener New) {
		btnNew.addActionListener(New);

	}


	public synchronized void addMouseListener(MouseListener Button) {

		
		//this.btnNumber = new JLabel[9][9];
		
		
		//System.out.println("Setup Start Board");
		this.current = new SudokuBoard();
		
		
		//this.btnNumber = new SudokuBoard();
		for(int i=0 ; i<9 ; i++){
			for(int j=0 ; j<9 ; j++){

				current.sudokuBoard[i][j].setValue(0);
				//current.sudokuBoard[i][j].setPencil(" 1");
				
				//current.sudokuBoard[i][j].setValue(i, j, 0);
				current.sudokuBoard[i][j].setPreferredSize(new Dimension(20,20));
				
				current.sudokuBoard[i][j].setOpaque(true);
				current.sudokuBoard[i][j].setBorder(new LineBorder(Color.GRAY));
				current.sudokuBoard[i][j].setHorizontalAlignment(JLabel.CENTER);
				//btnNumber[i][j].addMouseListener(Button);
				// btnNumber[i][j].addMouseListener(Button);
				current.sudokuBoard[i][j].setName("gridLocation"+i+","+j);
				current.sudokuBoard[i][j].setEnabled(true);
				current.sudokuBoard[i][j].addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e) {
						event(e);
					}
				});

				current.sudokuBoard[i][j].setBackground(Color.LIGHT_GRAY);
				

				if((i == 0 || i == 1 || i == 2) && (j == 0 || j == 1 || j == 2)){
					//btnNumber[i][j].setBackground(Color.DARK_GRAY);
					current.sudokuBoard[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.WHITE));
				}
				if((i == 0 || i == 1 || i == 2) && (j == 3 || j == 4 || j == 5)){
					//btnNumber[i][j].setBackground(Color.DARK_GRAY);
					current.sudokuBoard[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.GRAY));
				}
				if((i == 0 || i == 1 || i == 2) && (j == 6 || j == 7 || j == 8)){
					//btnNumber[i][j].setBackground(Color.DARK_GRAY);
					current.sudokuBoard[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.WHITE));
				}
				if((i == 3 || i == 4 || i == 5) && (j == 0 || j == 1 || j == 2)){
					//btnNumber[i][j].setBackground(Color.DARK_GRAY);
					current.sudokuBoard[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.GRAY));
				}
				if((i == 3 || i == 4 || i == 5) && (j == 3 || j == 4 || j == 5)){
					//btnNumber[i][j].setBackground(Color.DARK_GRAY);
					current.sudokuBoard[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.WHITE));
				}
				if((i == 3 || i == 4 || i == 5) && (j == 6 || j == 7 || j == 8)){
					//btnNumber[i][j].setBackground(Color.DARK_GRAY);
					current.sudokuBoard[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.GRAY));
				}
				if((i == 6 || i == 7 || i == 8) && (j == 0 || j == 1 || j == 2)){
					//btnNumber[i][j].setBackground(Color.DARK_GRAY);
					current.sudokuBoard[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.WHITE));
				}
				if((i == 6 || i == 7 || i == 8) && (j == 3 || j == 4 || j == 5)){
					//btnNumber[i][j].setBackground(Color.DARK_GRAY);
					current.sudokuBoard[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.GRAY));
				}
				if((i == 6 || i == 7 || i == 8) && (j == 6 || j == 7 || j == 8)){
					//btnNumber[i][j].setBackground(Color.DARK_GRAY);
					current.sudokuBoard[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.WHITE));
				}
				sudukoGrid.add(current.sudokuBoard[i][j]);

				
				/*btnNumber[i][j].setText(" ");

				btnNumber[i][j].setPreferredSize(new Dimension(20,20));
				//btnNumber[i][j].setBackground(Color.BLACK);
				btnNumber[i][j].setOpaque(true);
				btnNumber[i][j].setBorder(new LineBorder(Color.GRAY));
				btnNumber[i][j].setHorizontalAlignment(JLabel.CENTER);
				//btnNumber[i][j].addMouseListener(Button);
				// btnNumber[i][j].addMouseListener(Button);
				btnNumber[i][j].setName("gridLocation"+i+","+j);
				btnNumber[i][j].setEnabled(true);
				btnNumber[i][j].addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e) {
						event(e);
					}
				});

				btnNumber[i][j].setBackground(Color.LIGHT_GRAY);
				
				//sudukoGrid.add(btnNumber[i][j]);
				//  btnNumber[i][j].setBorder(new LineBorder(Color.BLACK));
				//btnNumber[i][j].addListener(Button);

				//btnNumber[1][1].setBackground(Color.RED);
				//GroupButtons();



				if((i == 0 || i == 1 || i == 2) && (j == 0 || j == 1 || j == 2)){
					//btnNumber[i][j].setBackground(Color.DARK_GRAY);
					btnNumber[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.WHITE));
				}
				if((i == 0 || i == 1 || i == 2) && (j == 3 || j == 4 || j == 5)){
					//btnNumber[i][j].setBackground(Color.DARK_GRAY);
					btnNumber[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.GRAY));
				}
				if((i == 0 || i == 1 || i == 2) && (j == 6 || j == 7 || j == 8)){
					//btnNumber[i][j].setBackground(Color.DARK_GRAY);
					btnNumber[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.WHITE));
				}
				if((i == 3 || i == 4 || i == 5) && (j == 0 || j == 1 || j == 2)){
					//btnNumber[i][j].setBackground(Color.DARK_GRAY);
					btnNumber[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.GRAY));
				}
				if((i == 3 || i == 4 || i == 5) && (j == 3 || j == 4 || j == 5)){
					//btnNumber[i][j].setBackground(Color.DARK_GRAY);
					btnNumber[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.WHITE));
				}
				if((i == 3 || i == 4 || i == 5) && (j == 6 || j == 7 || j == 8)){
					//btnNumber[i][j].setBackground(Color.DARK_GRAY);
					btnNumber[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.GRAY));
				}
				if((i == 6 || i == 7 || i == 8) && (j == 0 || j == 1 || j == 2)){
					//btnNumber[i][j].setBackground(Color.DARK_GRAY);
					btnNumber[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.WHITE));
				}
				if((i == 6 || i == 7 || i == 8) && (j == 3 || j == 4 || j == 5)){
					//btnNumber[i][j].setBackground(Color.DARK_GRAY);
					btnNumber[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.GRAY));
				}
				if((i == 6 || i == 7 || i == 8) && (j == 6 || j == 7 || j == 8)){
					//btnNumber[i][j].setBackground(Color.DARK_GRAY);
					btnNumber[i][j].setBorder(new BevelBorder(1, Color.BLACK, Color.WHITE));
				}
				sudukoGrid.add(btnNumber[i][j]);

 */

			}
		}

	}

	public void event(MouseEvent event) {

		//JLabel test = (JLabel)event.getSource();
		CellView test = (CellView)event.getSource();
		if (rdbtnEnterValue.isSelected()== false || rdbtnEnterPosValue.isSelected()==true){
			System.out.println("FIND POS1: "+test.getText());

			findPosInput(test);


			String inputstrings = outputString;

			System.out.println("Output Possible: " + inputstrings);
			//int inInputs = Integer.parseInt(inputs);

			test.setPencil(inputstrings);
			//possibleValue(inputstrings,test);

		}

		else{
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
			
			
			//setButton(inInput,test);
		}
		outputString = "";
	}


	public void findPosInput(JLabel test) {

		test.setFocusable(true);
		test.setEnabled(true);
		test.requestFocusInWindow();
		test.addKeyListener(this);
		System.out.println("selected:" + test);


	}

	public void findInput(JLabel test) {
		test.setFocusable(true);
		test.setEnabled(true);
		test.requestFocusInWindow();
		test.addKeyListener(this);
		System.out.println("selected:" + test);


	}
	@Override
	public void keyPressed(KeyEvent e) {
		displayInfo(e, "KEY TYPED: ");

	}

	@Override
	public void keyReleased(KeyEvent e) {
		//displayInfo(e, "KEY PRESSED: ");

	}

	@Override
	public void keyTyped(KeyEvent e) {
		//displayInfo(e, "KEY RELEASED: ");

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

	public void describe() {

		if (done == true){

			lblCreatesANew.setVisible(false);
			lblClickToSolve.setVisible(false);
			lblLoadPreviousPuzzle.setVisible(false);
			lblDeleteAllInputs.setVisible(false);
			lblSaveCurrentPuzzle.setVisible(false);
			lblProvideSomeHelp.setVisible(false);
			done = false;
		}
		else{
			lblCreatesANew.setVisible(true);
			lblClickToSolve.setVisible(true);
			lblProvideSomeHelp.setVisible(true);
			lblSaveCurrentPuzzle.setVisible(true);
			lblDeleteAllInputs.setVisible(true);
			lblLoadPreviousPuzzle.setVisible(true);
			JOptionPane.showMessageDialog(this,"How To Play: "+"\n"+ "The aim is to fill in each of the squares that are split into 9x9 grids, " +"\n"+
					"each row, column and grid needs to contain the numbers 1-9 without "+"\n"+ "repeating a number"+"\n"+"\n"+"Tip: To add a value to a square " +
					"click on the desired square and use the"+"\n"+ "keyboard to enter the value needed and click on the square again. " +
					"To add" +"\n"+ " a possible value select the possible values option.");
			done = true;
		}
	}

	public void setBoard(SudokuBoard loaded){
		
		System.out.println("Loaded: Set Buttons ");
	}
		/*for ( int i = 0; i < 9; i++){
			for ( int j = 0; j < 9; j++){
				//btnNumber[i][j].setText(""+loaded.sudokuBoard[i][j]);

				//setLabel(i,j,loaded.sudokuBoard[i][j]);

				setButton(loaded.sudokuBoard[i][j].intValue,btnNumber[i][j]);
				Font font = new Font("Dialog", Font.BOLD, 22);
			
				btnNumber[i][j].setFont(font);
			
				//btnNumber[i][j].
				//btnNumber[i][j].setEnabled(false);
			}
		}

	}
	*/
}



