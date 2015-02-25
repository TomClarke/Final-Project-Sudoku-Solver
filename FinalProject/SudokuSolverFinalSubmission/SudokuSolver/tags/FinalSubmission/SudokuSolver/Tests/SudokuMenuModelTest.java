package Tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import src.SudokuBoardModel;
import src.SudokuMenuModel;
import src.SudokuMenuView;

public class SudokuMenuModelTest {
SudokuBoardModel boardModel;
SudokuMenuModel menuModel;

	@Before
	public void setUp() throws Exception {
		boardModel = new SudokuBoardModel();
		menuModel = new SudokuMenuModel(boardModel);
	}

	
	@Test
	public void testBacktrackingSolve() {
		String solvingMethod = ("Backtracking");
		boardModel.Solve(solvingMethod);
		
		assertTrue(boardModel.currentBoard.solved);	
	}

	@Test
	public void testDVOSolve() {
		String solvingMethod = ("DVO");
		boardModel.Solve(solvingMethod);
		
		assertTrue(boardModel.currentBoard.solved);	
	}
	
	@Test
	public void testGACSolve() {
		String solvingMethod = ("GAC");
		boardModel.Solve(solvingMethod);
		
		assertTrue(boardModel.currentBoard.solved);	
	}
	
	@Test
	public void testBacktrackingCantSolve() {
		String solvingMethod = ("Backtracking");
		
		menuModel.New();
		
		boardModel.currentBoard.sudokuBoard[0][0].intValue = 4;
		boardModel.currentBoard.sudokuBoard[0][8].intValue = 4;
			
		boardModel.Solve(solvingMethod);
		
		assertFalse(boardModel.currentBoard.solved);
		
	}
	
	@Test
	public void tesDVOCantSolve() {
		String solvingMethod = ("DVO");
		
		menuModel.New();
		
		boardModel.currentBoard.sudokuBoard[0][0].intValue = 4;
		boardModel.currentBoard.sudokuBoard[0][8].intValue = 4;
			
		boardModel.Solve(solvingMethod);
		
		assertFalse(boardModel.currentBoard.solved);
		
	}
	
	@Test
	public void testGACCantSolve() {
		String solvingMethod = ("GAC");
		
		menuModel.New();
		
		boardModel.currentBoard.sudokuBoard[0][0].intValue = 4;
		boardModel.currentBoard.sudokuBoard[0][8].intValue = 4;
			
		boardModel.Solve(solvingMethod);
		
		assertFalse(boardModel.currentBoard.solved);
		
	}
	
	@Test
	public void testErase() {
		
		menuModel.New();
		
		menuModel.Erase();
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
		assertEquals(0,boardModel.currentBoard.sudokuBoard[i][j].intValue);
			}
		}		
	}
	
	@Test
	public void testLoad() {
		menuModel.New();
		SudokuBoardModel b1 = menuModel.board;
		SudokuMenuView view = new SudokuMenuView();
		File loc = view.setLocation();
		menuModel.Save(loc);	
		String date = boardModel.currentBoard.date;
		menuModel.Load(loc,date);
		
		assertEquals(b1.currentBoard,boardModel.currentBoard);
	}
	
	
	@Test
	public void testNew() {
		menuModel.New();
		boolean populated = false;
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(boardModel.currentBoard.sudokuBoard[i][j].intValue != 0){
				populated = true;
				}
			}
		assertTrue(populated); 	
		}
	}
	
	@Test
	public void testSave() {
		menuModel.New();
		SudokuBoardModel b1 = menuModel.board;
		SudokuMenuView view = new SudokuMenuView();
		File loc = view.setLocation();
		menuModel.Save(loc);	
		String date = boardModel.currentBoard.date;
		menuModel.Load(loc,date);
		
		assertEquals(b1.currentBoard,boardModel.currentBoard);
	}
	
}
