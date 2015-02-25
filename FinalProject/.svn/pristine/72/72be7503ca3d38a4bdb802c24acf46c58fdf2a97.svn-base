package Tests;

import org.junit.*;

import src.CellView;
import src.FileStore;
import src.SudokuBoard;
import src.SudokuMenuModel;
import static org.junit.Assert.*;


public class SudokuMenuModelTest {
	
	
	@Test
	public void testErase()
		throws Exception {
		SudokuMenuModel testing = new SudokuMenuModel();
		FileStore saved = null;
		testing.New();
		 
		testing.Erase();
		int [][]value = new int [9][9];
		for (int i = 0; i < 9 ; i++){
			for (int j = 0; j < 9 ; j++){
			//value[i][j] = saved.board.sudokuBoard[i][j].getValue();
			//assertEquals(0,value[i][j]);
		}
		}
		
		// add additional test code here
	}

	
	@Test
	public void testHelp()
		throws Exception {
		SudokuMenuModel testing = new SudokuMenuModel();
		
		testing.Help();
		
	}

	
	@Test
	public void testLoad()
		throws Exception {
		SudokuMenuModel testing = new SudokuMenuModel();
		
		String chosenDate = "Tue Feb 04 03:39:18 GMT 2014";

		testing.Load(chosenDate);

		// add additional test code here
	}

	
	@Test
	public void testNew()
		throws Exception {
		SudokuMenuModel testing = new SudokuMenuModel();
		
		
		testing.New();

		// add additional test code here
	}

	
	
	@Test
	public void testSave()
		throws Exception {
		SudokuMenuModel testing = new SudokuMenuModel();
		testing.Load("");
		FileStore fileStore = new FileStore();
		fileStore.board = new SudokuBoard();
		testing.saved = fileStore;
		testing.loaded = new SudokuBoard();

		boolean result = testing.Save();

		
		assertTrue(result);
	}

	/**
	 * Run the void Solve() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18/02/14 00:08
	 */
	@Test
	public void testSolve()
		throws Exception {
		SudokuMenuModel testing = new SudokuMenuModel();
		testing.Load("");
		testing.saved = new FileStore();
		testing.loaded = new SudokuBoard();

		testing.Solve();

		// add additional test code here
	}

}