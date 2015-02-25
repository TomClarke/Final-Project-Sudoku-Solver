package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import src.Controller;
import src.Model;
import src.Runner;
import src.SudokuMenuView;

public class GUITest {
	SudokuMenuView view = new SudokuMenuView();
	Runner run = new Runner();
	Model model = new Model();
	Controller control = new Controller(model, view);
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
		Model model = new Model();
		// Create controller class to lease between the model and the view
		Controller control = new Controller(model, View);
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
		view.possibleValue(view.btnNumber[3][3],"125643");
		String value = view.btnNumber[3][3].getText();
		
		assertEquals(value,"125643");
	}
	
	@Test
	public void SplashScreen(){
		
	}
	


}
