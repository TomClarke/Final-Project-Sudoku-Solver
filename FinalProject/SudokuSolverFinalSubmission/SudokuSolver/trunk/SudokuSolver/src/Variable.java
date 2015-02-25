package src;

import java.util.LinkedList;

/**
 * The Class Variable that contains the values of the cells
 */
public class Variable implements Comparable<Object> {

	/** The domain that contains the possible values. */
	public Domain domain;
	
	/** The value. */
	public int value;
	
	/** The assigned means the value is locked. */
	public boolean assigned;
	
	/** The position includes the position on the board. */
	public int position[];
	
	/** The number of the variable within a list. */
	public int number;
	
	/** The temp. */
	public boolean temp;

	/**
	 * Instantiates a new variable.
	 */
	public Variable(){
		value = 0;
		domain = new Domain(); 
		position = new int [2];
		assigned = false;
		temp = false;	
	}

	/**
	 * Prints the variable.
	 */
	public void printVariable(){

		System.out.println("Variable: "+assigned+" ["+position[0]+","+position[1]+"] = "+value);
	}

	/**
	 * Current domain.
	 *
	 * @return the linked list
	 */
	public LinkedList<Integer> currentDomain(){

		return domain.getDomain();
	}

	/**
	 * Assign variable to the value to be assigns, this is then locked 
	 * providing the value is not 0.
	 *
	 * @param value the value
	 */
	public void assignVar(int value){
		this.value = value;
		if (value != 0){
			this.assigned = true;
		}	
	}
	
	/**
	 * Assign variable to the value to be assigns, this is then locked 
	 * providing the value is not 0.
	 * The temp value is then assigned to allow a temp value.
	 * @param value the value
	 * @param temp the temp
	 */
	public void assignVar(int value,boolean temp){
		this.value = value;
		this.temp = temp;
		if (value != 0){
			this.assigned = true;
		}	
	}

	/**
	 * Unassign the variable by unlocking it and setting the value to 0
	 */
	public void unAssignVar(){
		this.value = 0;
		this.assigned = false;
	}

	/**
	 * Checks if is assigned.
	 *
	 * @return true, if is assigned
	 */
	public boolean isAssigned(){
		boolean checkAssign = this.assigned;

		return checkAssign;
	}

	/** 
	 * the compareTo method that is used by the priority Queue so that the domains of the variables are
	 * compared when they are added to the queue, most constrained variable at the head of the queue.
	 */
	public int compareTo(Object otherObject){
		Variable other = (Variable) otherObject;
		if(!(this.domain.domainSize()==9)){
			if (this.domain.domainSize() < other.domain.domainSize()) return -1;
			if (this.domain.domainSize() > other.domain.domainSize()) return 1;
		}
		else{
			if (this.domain.restrictions.size() > other.domain.restrictions.size()) return -1;
			if (this.domain.restrictions.size() < other.domain.restrictions.size()) return 1;
		}
		return 0;
	}
}