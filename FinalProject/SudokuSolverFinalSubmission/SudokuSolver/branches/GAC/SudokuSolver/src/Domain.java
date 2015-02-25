package src;

import java.util.LinkedList;

public class Domain {

	Variable variables;
	LinkedList<Integer> domain = new LinkedList<Integer>();
	
	public Domain(){
		for (int i = 1; i < 10; i++){
			
		domain.add(i);
		}
	}

	
	public LinkedList<Integer> getDomain(){
		
	return domain;
		
	}
	
	
	public void addDomain(Variable variable) {
		if(variable.value != 0){
		if(domain.contains(variable.value)){
			
		}		
	domain.add(variable.value);
		}
	}
	
	public void removeDomain(int value){
		if(domain.isEmpty()){
			System.out.print("Error: domain empty");
		}
		else {
		for(int i = 0; i < domain.size(); i++ ){
			
			domain.remove(i);
		}
	
		}
		}
	
	
	
	
	public void removeDomain(Variable variable){
		if(domain.isEmpty()){
			System.out.print("Error: domain empty");
		}
		else {
		for(int i = 0; i < domain.size(); i++ ){
			
		if (domain.get(i) == variable.value){
			domain.remove(i);
		}
	
		}
		}
	}

	
	public LinkedList<Integer> getDomain(Variable variable) {
		
		return domain;
	}
	
	
	

	public void printDomain(Variable variable){
		System.out.print("Variable: ["+variable.position[0]+","+variable.position[1]+"] " +variable.value+" Domain: " );
		for(int i = 0; i < this.domain.size(); i ++){

			System.out.print(","+this.domain.get(i));
		}
		System.out.println();
	}


}

