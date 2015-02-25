package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import src.SudokuMenuController;
import src.SudokuMenuModel;
import src.Runner;
import src.SudokuMenuView;

public class GUITest {
	SudokuMenuView view = new SudokuMenuView();
	Runner run = new Runner();
	SudokuMenuModel model = new SudokuMenuModel();
	SudokuMenuController control = new SudokuMenuController(model, view);
	@Test
	public void testGUIButtonPress() {

		SudokuMenuView View = new SudokuMenuView();
		Runner run = new Runner();
		 boolean SavePressTest = view.Save();
		//Test listeners and that calling the view methods works 
		assertEquals(SavePressTest,true);
		// Now this can be replicated for other buttons a controller is needed 
		//to give functionality. 
		//create model to give function
		SudokuMenuModel model = new SudokuMenuModel();
		// Create controller class to lease between the model and the view
		SudokuMenuController control = new SudokuMenuController(model, View);
	}


	@Test	
	public void testModelButtonPress2() {

		boolean SavePressModelTest = model.Save();
		//Test listeners and that calling the view methods works 
		assertEquals(SavePressModelTest,true);
	}
	
	@Test
	public void CreateButtonGrid(){
		String Value = view.btnNumber[1][1].getText();
		assertEquals(Value,"");
	
	}
	@Test
	public void PopulateButtonGrid(){
		view.setButton(5, view.btnNumber[1][1]);
		String value = view.btnNumber[1][1].getText();
		assertEquals(value,"5");
	}
	@Test
	public void PossibleValues(){
		view.possibleValue("125643",view.btnNumber[3][3]);
		String value = view.btnNumber[3][3].getText();
		
		assertEquals(value,"125643");
	}
	
	@Test
	public void SplashScreen(){
		
	}
	


}
