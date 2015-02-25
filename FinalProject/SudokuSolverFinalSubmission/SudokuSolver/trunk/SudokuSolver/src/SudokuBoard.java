package src;

import java.util.Date;

/**
 * The Class SudokuBoard contains the variables within the board, this is made 
 * of cell views.
 */
public class SudokuBoard {

	/** The sudoku board 2D arry */
	public CellView sudokuBoard[][];

	/** The row. */
	int row = 9;

	/** The col. */
	int col = 9;

	/** The solved. */
	public boolean solved;

	/** The date. */
	public String date;

	/** The Currentboard. */
	SudokuBoard Currentboard;

	/**
	 * Instantiates a new sudoku board.
	 */
	public SudokuBoard() {
		newBoard();
	}

	/**
	 * New board creates a date, and a black sudokuBoard.
	 */
	public void newBoard() {
		Date datea = new Date();
		date = datea.toString();
		solved = false;

		sudokuBoard = new CellView[row][col];
		for (int i = 0; i < row; i++){
			for (int j = 0; j < col; j++){
				sudokuBoard[i][j] = new CellView();
				sudokuBoard[i][j].setValue(0);
				sudokuBoard[i][j].setVisible(true);
			}
		}
	}

	/**
	 * Prints the board.
	 */
	public void PrintBoard() {
		for (int i = 0; i < 9; i++) {
			if ((i % 3) == 0) {
				System.out.println("+-----+-----+-----+");
			}
			for (int j = 0; j < 9; j++) {
				if ((i % 3) == 0 || (i % 3) == 1 || (i % 3) == 2) {
					System.out.print("|");
				}
				if (sudokuBoard[i][j].intValue == 0) {
					System.out.print("_");
				} else {
					System.out.print(sudokuBoard[i][j].intValue);
				}
			}
			System.out.println("|");
		}
		System.out.println("+-----+-----+-----+");
		System.out.println();
	}

	/**
	 * Gets the solved variable.
	 *
	 * @return the solved
	 */
	public boolean getSolved() {
		return solved;

	}

	/**
	 * Sets the solved variable.
	 *
	 * @param solv the new solved
	 */
	public void setSolved(boolean solv) {

		solved = solv;

	}


	/**
	 * Updates the GUI with the sudoku
	 *
	 * @return the sudoku board
	 */
	public SudokuBoard update() {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				if (this.sudokuBoard[i][j].assigned == false) {
					this.sudokuBoard[i][j].intValue = this.sudokuBoard[i][j]
							.getTextValue();
				}

			}
		}
		this.PrintBoard();
		return this;
	}
}
