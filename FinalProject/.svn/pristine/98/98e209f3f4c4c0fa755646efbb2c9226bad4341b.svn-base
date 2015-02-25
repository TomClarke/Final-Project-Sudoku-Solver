package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import src.SudokuBoard;

public class SudokuBoardTest {
SudokuBoard board = new SudokuBoard();
	@Test
	public void createBoard() {
		
		int [][]value = new int [9][9];
		for (int i = 0; i < 9 ; i++){
			for (int j = 0; j < 9 ; j++){
		value[i][j] = board.sudokuBoard[i][j].getValue();
		
		assertEquals(0,value[i][j]);
			}
		}
	}
	@Test
	public void PrintBoard() {
		board.sudokuBoard[2][2].setValue(2);
		board.sudokuBoard[2][3].setValue(6);
		board.sudokuBoard[8][4].setValue(8);
		board.sudokuBoard[6][5].setValue(1);
		
		
		assertEquals(2,board.sudokuBoard[2][2].getValue());
		assertEquals(6,board.sudokuBoard[2][3].getValue());
		assertEquals(8,board.sudokuBoard[8][4].getValue());
		assertEquals(1,board.sudokuBoard[6][5].getValue());
		
		
	}
	@Test
	public void setBoard() {
		SudokuBoard setting = new SudokuBoard();
		SudokuBoard copy = new SudokuBoard();
		setting.sudokuBoard[2][2].setValue(2);
		setting.sudokuBoard[2][3].setValue(6);
		setting.sudokuBoard[8][4].setValue(8);
		setting.sudokuBoard[6][5].setValue(1);
		
		copy.setBoard(setting);
		for (int i = 0; i < 9 ; i++){
			for (int j = 0; j < 9 ; j++){
				System.out.println("1:"+copy.sudokuBoard[i][j].getValue());
				System.out.println("2:"+setting.sudokuBoard[i][j].getValue());
				
		//assertEquals(copy.sudokuBoard[i][j].getValue(),setting.sudokuBoard[i][j].getValue());
			}
		}
	}
}
