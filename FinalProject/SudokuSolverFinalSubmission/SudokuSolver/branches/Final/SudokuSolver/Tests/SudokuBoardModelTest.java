package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.SudokuBoardModel;

public class SudokuBoardModelTest {

	SudokuBoardModel boardModel;
	@Before
	public void setUp() throws Exception {
	
		boardModel = new SudokuBoardModel();
		
	}

	@Test
	public void testSolveBacktracking() {
		boardModel.Solve("Backtracking");
		assertTrue(boardModel.currentBoard.solved);
	}

	@Test
	public void testSolveDVO() {
		boardModel.Solve("DVO");
		assertTrue(boardModel.currentBoard.solved);
	}
	
	@Test
	public void testSolveGAC() {
		boardModel.Solve("GAC");
		assertTrue(boardModel.currentBoard.solved);
	}
	
}
