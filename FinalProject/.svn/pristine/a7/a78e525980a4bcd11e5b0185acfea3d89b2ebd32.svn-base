package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import src.Domain;
import src.Variable;


public class DomainTest {
public Domain domain;
	
@Before
	public void setUp() throws Exception {
domain = new Domain();	
}

	@Test
	public void testCreateDomain() {
		assertEquals(9,domain.domainSize());
	}
	
	@Test
	public void testGetDomain() {
		domain.domain.remove(1);
		assertSame(domain.domain,domain.getDomain());
	
	}
	
	@Test
	public void testDomainSize() {
		
		domain.domain.remove(1);
		assertSame(domain.domain.size(),domain.domainSize());
		
	}
	
	@Test
	public void testResetDomain() {
		domain.removeDomain(5);
		domain.removeDomain(8);
		domain.removeDomain(9);
		
		Domain domainStore = new Domain();
		
		domain = domainStore;
		
		domain.resetDomain();
		
		assertNotSame(domain.domain.toString(), domainStore.domain.toString());
		
		
	}
	
	@Test
	public void testRemoveDomain() {
				Domain domainStore = new Domain();
		
		domain = domainStore;
		domain.removeDomain(5);
		domain.removeDomain(8);
		domain.removeDomain(9);
		
		assertNotSame(domain.domain.toString(), domainStore.domain.toString());
		
		
		
	}
	
	@Test
	public void testRemoveVariableDomain() {
		Variable var = new Variable();
		var.assignVar(8);
		
		Domain domainStore = new Domain();
		
	domain = domainStore;
	domain.removeDomain(var);

	String list = "[1,2,3,4,5,6,7,9]";
	
	assertNotSame(domain.domain.toString(),list);		
	}
	
	@Test
	public void testDomainEmpty() {
		for(int i = 1; i < 10; i++){
			domain.removeDomain(i);
		}
		
		assertTrue(domain.domainIsEmpty());
		
	}
	
	@Test
	public void testDomainContains() {
		domain.removeDomain(8);
		
		
		assertTrue(domain.contains(4));
		assertTrue(domain.contains(9));
		assertFalse(domain.contains(8));
		
		
	}
}
