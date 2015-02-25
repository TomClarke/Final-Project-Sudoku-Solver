package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.Network;
import src.SudokuBoard;
import src.SudokuBoardModel;
import src.SudokuMenuModel;

public class NetworkTest {
public Network network; 
	@Before
	public void setUp() throws Exception {
	network = new Network();
	}
	
	@Test
	public void testNewNetwork() {
		SudokuBoard board = new SudokuBoard();

		network.setup(board);
		
		assertTrue(network.variableList.size() == 81);
	}
	
	
	@Test
	public void testSolveBT() {
		SudokuBoard board = new SudokuBoard();
		SudokuMenuModel model = new SudokuMenuModel(new SudokuBoardModel());
		model.New();
		board = model.board.currentBoard;
		network.solve("Backtracking", board);
		
		assertTrue(board.solved);
	}
	
	@Test
	public void testSolveGAC() {
		SudokuBoard board = new SudokuBoard();
		SudokuMenuModel model = new SudokuMenuModel(new SudokuBoardModel());
		model.New();
		board = model.board.currentBoard;
		network.solve("GAC", board);
		
		assertTrue(board.solved);
	}
	
	@Test
	public void testSolveDVO() {
		SudokuBoard board = new SudokuBoard();
		SudokuMenuModel model = new SudokuMenuModel(new SudokuBoardModel());
		model.New();
		board = model.board.currentBoard;
		network.solve("DVO", board);
		
		assertTrue(board.solved);
	}
	
	@Test
	public void testIsSolved() {
		
	}
	
}
