package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.Variable;

public class VariableTest {

public Variable variable;
	@Before
	public void setUp() throws Exception {
		
		variable = new Variable();
	}

	@Test
	public void testVariable() {
		// be able to create a variable
		assertNotNull(variable);
		assertEquals(false, variable.isAssigned());
	}

	@Test
	public void testAssignVariable() {
		// assign a variable to a value and lock it 
		variable.assignVar(9);
		
		assertEquals(true, variable.isAssigned());
		assertEquals(9, variable.value);
	}
	
	@Test
	public void testUnAssignVariable() {
		//assign and then unassign a variable
		variable.assignVar(9);
		variable.unAssignVar();
		assertEquals(false, variable.isAssigned());
		assertEquals(0, variable.value);
	}
	
	@Test
	public void testCompareTo() {
		//Compare the domains of two variables, the smallest domian
		// is given higher priority.
		Variable variable2 = new Variable();
		variable.domain.removeDomain(1);
		variable.domain.removeDomain(2);
		variable.domain.removeDomain(3);
		//variable domain size is 6
		assertEquals(6, variable.domain.domainSize());
		
		variable2.domain.removeDomain(4);
		variable2.domain.removeDomain(5);
		variable2.domain.removeDomain(6);
		variable2.domain.removeDomain(7);
		variable2.domain.removeDomain(8);
		assertEquals(4, variable2.domain.domainSize());
		
		int smallestValue;
		smallestValue = variable.compareTo(variable2);
		assertEquals(1, smallestValue);
	}
}
