package src;

import java.awt.Color;

import javax.swing.JLabel;

/**
 * The Class CellView extends a JLabel and is what fills the Sudoku grid, this class 
 * represents one of these cells, they contain the values. 
 */
public class CellView extends JLabel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The assigned cell meaning it is given definate value. */
	Boolean assigned;

	/** The intvalue is the constrained within the cell. */
	public int intValue;

	/** The str value is the pencil values that are a string of values. */
	String strValue;

	/** The starting value is the value assigned before computation */
	Boolean startingValue;

	/**
	 * Instantiates a new cell view.
	 */
	public CellView() {
		NewCell();
	}

	/**
	 * New cell, setting the starting value to false and the 
	 * values to 0, they are not assigned to begin with.
	 */
	private void NewCell() {
		startingValue = false;
		intValue = 0;
		strValue = "0";
		assigned = false;
	}

	/**
	 * Gets the text value from the current cells text, and if it is a
	 * string value then is returns the string as an integer.
	 *
	 * @return the text value
	 */
	public int getTextValue() {
		strValue = this.getText();
		int value = 0;
		if (strValue.equals(" ") || strValue.equals("")) {
			System.out.println("Value: " + strValue);
		} else

			value = Integer.parseInt(strValue);

		return value;
	}

	/**
	 * Gets the integer value of the cell.
	 *
	 * @return the value
	 */
	public int getValue() {

		return intValue;
	}

	/**
	 * Sets the value of the cell from an integer and assigns it to the cell 
	 *
	 * @param value the new value
	 */
	public void setValue(int value) {
		if(this.startingValue == true){
			intValue = value;
			SudokuMenuView view = new SudokuMenuView(null);
			view.setStartButton(value, this);
		}
		else{
			intValue = value;
			SudokuMenuView.setButton(value, this);
		}
	}

	/**
	 * Gets the pencil value wish is the string value from the text
	 *
	 * @return the pencil
	 */
	public String getPencil() {
		String strValue = this.getText();

		return strValue;
	}

	/**
	 * Sets the pencil sets the string within the cell 
	 *
	 * @param value the new pencil
	 */
	public void setPencil(String value) {

		strValue = value;

		SudokuMenuView.possibleValue(value, this);

	}

	/**
	 * Currently used
	 */
	public void current(){

		this.setBackground(Color.red);
		this.setOpaque(true);
	}

	/**
	 * Not current used currently 
	 */
	public void notCurrent(){

		this.setBackground(Color.gray);
		this.setOpaque(true);
	}
}
