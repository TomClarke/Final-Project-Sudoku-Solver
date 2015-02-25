package src;


import java.util.LinkedList;
import java.util.List;


public class Variable {
	
	Domain domain;
	//List<CellView> variable; 
	Constraint constraints;
	public int value;
	public boolean assigned;
	public int position[];
	
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

}