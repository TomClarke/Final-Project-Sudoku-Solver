package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.SudokuBoard;

public class SudokuBoardTest {

	SudokuBoard board;
	@Before
	public void setUp() throws Exception {
		board = new SudokuBoard();
		
	}

	@Test
	public void testGetSolved() {
		
		SudokuBoard newboard = new SudokuBoard();
		
		assertFalse(newboard.sudokuBoard[3][5].isVisible()==false);
	}

	
	@Test
	public void testUpdateBoard() {
		
		board = new SudokuBoard();
		
		board.sudokuBoard[3][2].setValue(7);
		board.sudokuBoard[7][1].setValue(9);
		
		board.update();
		
		assertSame(board.sudokuBoard[3][2].getValue(),board.sudokuBoard[3][2].getTextValue());
	}
}
