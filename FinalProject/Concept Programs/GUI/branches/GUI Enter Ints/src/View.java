package src;

/**
 * @author TomClarke
 *
 */

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

/**
 * The Class View.
 */
public class View extends JFrame {


	/** The btn solve. 
	 * Allows the user to select a button that runs solve from the controller
	 * to solve the Sudoku 
	 */
	private JButton btnSolve = new JButton("Solve");

	/** The btn erase. 
	 * Allows the user to select a button that runs Erase from the controller
	 * to empty the Sudoku Grid 
	 */
	private JButton btnErase = new JButton("Erase");

	/** The btn load. 
	 * Allows the user to select a button that runs Load from the controller
	 * to load a grid from submited and saved ones 
	 */
	private JButton btnLoad = new JButton("Load");

	/** The btn help.
	 * allows the user to select a button that runs Help from the controller
	 * to help the user complete the Sudoku 
	 */
	private JButton btnHelp = new JButton("Help");

	/** The btn save.	 
	 * allows the user to select a button that runs Save from the controller
	 * to save the Sudoku 
	 */
	private JButton btnSave = new JButton("Save");

	/** The btn number. 
	 * Used to populate the grid and have the JButtons stored in a 2D array 
	 */
	private JButton[][] btnNumber;

	/** The suduko grid. 
	 * JPanel that will house the buttons for the sudoku grid and keep them 
	 * in a grid layout 
	 */
	private JPanel sudukoGrid = new JPanel(new GridLayout(9,9));

	/** The content pane. 
	 *  Houses the main GUI window
	 */
	private JPanel contentPane;



	/**
	 * Launch the application.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */
	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);





		/** Creates the right number of buttons that can then be placed in the 
		 * grid that can correctly place them.
		 * also creating a preferred size to make the small enough
		 */
		btnNumber = new JButton[9][9];
		for(int i=0 ; i<9 ; i++){
			for(int j=0 ; j<9 ; j++){
				//btnNumber[i][j] = new JButton(String.valueOf(i));
				btnNumber[i][j] = new JButton();
				btnNumber[i][j].setPreferredSize(new Dimension(30,30));

				sudukoGrid.add(btnNumber[i][j]);
			}
		}

		/** 
		 * label used within the GUI to house the banner 
		 */
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(View.class.getResource("/src/SudokuTitle.jpg")));



		/** 
		 * The group layout that groups the buttons and labels together so they are in the correct 
		 * positioning 
		 */

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(268)
						.addComponent(btnSolve, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(280))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
												.addGap(62)
												.addComponent(sudukoGrid, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE))
												.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
														.addGap(112)
														.addComponent(lblNewLabel)
														.addGap(36)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(btnErase, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
																.addComponent(btnLoad, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnHelp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
												.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
												.addComponent(btnSolve)
												.addContainerGap())
				);
		contentPane.setLayout(gl_contentPane);

	}




	/**
	 * Save.
	 * opens a popup box to show save file 
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
	 * Load.
	 */
	public void Buttons() {

		
		
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

	/**
	 * Adds the button listener to all of the buttons within the Sudoku grid. 
	 *
	 * @param buttonControl the button control
	 */
	void addButtonListener(ActionListener buttonControl) {
		for(int i=0 ; i<9 ; i++){
			for(int j=0 ; j<9 ; j++){
				btnNumber[i][j].addActionListener(buttonControl);
			}
		}
	} 
}


