package src;


import java.util.LinkedList;

public class Variable implements Comparable<Object> {
	
	Domain domain;
	Constraint constraints;
	public int value;
	public boolean assigned;
	public int position[];
	public int number;
	
	public Variable(){
		value = 0;
		domain = new Domain(); 
		position = new int [2];
		assigned = false;
		
		
	}

	public void printVariable(){
		
		System.out.println("Variable: "+assigned+" ["+position[0]+","+position[1]+"] = "+value);
	}
	
	public LinkedList<Integer> currentDomain(){
				
		return domain.getDomain(this);
		
	}
	
	public void assignVar(int value){
		this.value = value;
		
		if (value != 0){
		this.assigned = true;
		}	
	}
	
	public void unAssignVar(){
		this.value = 0;
		this.assigned = false;
	}
	
	public boolean isAssigned(){
		boolean checkAssign = this.assigned;
		
		return checkAssign;
		
	}
	
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