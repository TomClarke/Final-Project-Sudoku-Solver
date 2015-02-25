package Tests;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import src.DVO;
import src.Network;
import src.SudokuBoard;
import src.SudokuBoardModel;
import src.SudokuMenuModel;
import src.Variable;

public class DVOTest {

	DVO dvo;
	
	@Before
	public void setUp() throws Exception {
		dvo = new DVO(false);
	}

	@Test
	public void testApplyConstraints() {
		
		SudokuBoard board = new SudokuBoard();
		SudokuMenuModel model = new SudokuMenuModel(new SudokuBoardModel());
		model.New();
		board = model.board.currentBoard;
		Network network = new Network();
		network.setup(board);
		
		
		List<Variable> list = dvo.applyConstraints(network.variableList);
		boolean assigned = false;
		for(int i = 0; i < list.size();i++){
			if(list.get(i).assigned == true)
				assigned = true;
		}
		assertTrue(assigned);
		
	}

	@Test
	public void testHintApplyConstraints() {
		dvo = new DVO(true);
		SudokuBoard board = new SudokuBoard();
		SudokuMenuModel model = new SudokuMenuModel(new SudokuBoardModel());
		model.New();
		board = model.board.currentBoard;
		Network network = new Network();
		network.setup(board);
		
		
		List<Variable> list = dvo.applyConstraints(network.variableList);
		boolean assigned = false;
		for(int i = 0; i < list.size();i++){
			if(list.get(i).assigned == true)
				assigned = true;
		}
		assertTrue(assigned);
		
	}
}


