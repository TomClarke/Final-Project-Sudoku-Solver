package src;


import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

/**
 * The Class View is the class that is visible to the user and this is all created using windowbuider 
 * and adapted to work within a MVC. 
 */
public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The content pane. */
	private JPanel contentPane;
	
	/** The btn solve. */
	private JButton btnSolve = new JButton("Solve");
	
	/** The btn erase. */
	private JButton btnErase = new JButton("Erase");
	
	/** The btn load. */
	private JButton btnLoad = new JButton("Load");
	
	/** The btn help. */
	private JButton btnHelp = new JButton("Help");
	
	/** The btn save. */
	private JButton btnSave = new JButton("Save");
	
	/** The btn number. */
	private JButton[][] btnNumber;
	
	/** The suduko grid. */
	private JPanel sudukoGrid = new JPanel(new GridLayout(9,9));
	
	/** The txt input. */
	private JTextField txtInput;

	
	/**
	 * buttonControl is a listener that uses the input string from a text box 
	 * and is converted into an integer and then that is then shown on the selected button
	 * this was done instead of buttons as it allowed faster testing but provides an easier and 
	 * more effective way to change the buttons while using a simular concept.
	 */	
	class buttonControl implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			 JButton test = (JButton)e.getSource();
			//Scanner scan = new Scanner(System.in);
			String input = txtInput.getText();
			int inInput = Integer.parseInt(input);
			setButton(inInput,test);
			
		}
		
		/**
		 * Sets the button using a switch that takes the button and the input 
		 * provided by the input text box
		 *
		 * @param input the input
		 * @param test the test
		 */
		private void setButton(int input, JButton test){
			  
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
			    	default: test.setText(" ");break;
			    	}
		}

		}

	
		
		




		
	/**
	 * Instantiates a new view.
	 * 
	 * Create the frame.
	 */
	public View() {
		btnNumber = new JButton[9][9];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


		/**
		 * Instantiates a series of buttons that are used to form the sudoku grid 
		 * and these are all given a string value and an then added to an action 
		 * listener.
		 * Each button is then added to the grid that is made using a layout manager
		 */
		ActionListener buttonC = new buttonControl();	
		
		for(int i=0 ; i<9 ; i++){
			for(int j=0 ; j<9 ; j++){
				//btnNumber[i][j] = new JButton(String.valueOf(i));
				btnNumber[i][j] = new JButton(" ");
				btnNumber[i][j].setPreferredSize(new Dimension(30,30));
				btnNumber[i][j].addActionListener(buttonC);
				sudukoGrid.add(btnNumber[i][j]);

			}
		}
	
	
	



		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(View.class.getResource("/src/SudokuTitlesmall.jpg")));
		
		txtInput = new JTextField();
		txtInput.setColumns(10);




/**
 * The layout manager code that assigns the locations for each element within the GUI.
 * 
 */

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(268)
					.addComponent(btnSolve, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
					.addGap(238))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(62)
							.addComponent(sudukoGrid, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(112)
							.addComponent(lblNewLabel)
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnErase, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
								.addComponent(btnLoad, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
								.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
								.addComponent(btnHelp, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
								.addComponent(txtInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(52))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(74)
							.addComponent(btnErase)
							.addGap(18)
							.addComponent(btnLoad)
							.addGap(18)
							.addComponent(btnSave))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(sudukoGrid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(btnHelp)
					.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnSolve)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(txtInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(16))))
		);
		contentPane.setLayout(gl_contentPane);
	}

	

	/**
	 * Save.
	 * This as an example is done to show a message box
	 */
	public void Save() {
		JOptionPane.showMessageDialog(this,"Saved File");
	}

	/**
	 * Load.
	 */
	public void Load() {

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
}

	




