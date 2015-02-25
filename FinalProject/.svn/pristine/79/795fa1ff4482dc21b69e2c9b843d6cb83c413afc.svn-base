package src;

import java.util.LinkedList;

/**
 * The Class Domain contains the values that a variable can hold. 
 * this stores a variables scope and the possible values due to 
 * the constraints that scope enforce. 
 */
public class Domain {

	/** The variables. */
	Variable variables;

	/** The domain is the list of values within the domian */
	public LinkedList<Integer> domain = new LinkedList<Integer>();

	/** The restrictions are the list of variables within the scope  */
	LinkedList<Variable> restrictions = new LinkedList<Variable>();

	/**
	 * Instantiates a new domain containing the numbers 1-9.  
	 */
	public Domain(){
		for (int i = 1; i < 10; i++){

			domain.add(i);
		}
	}


	/**
	 * Gets the domain.
	 *
	 * @return the domain list
	 */
	public LinkedList<Integer> getDomain(){

		return this.domain;

	}

	/**
	 * Domain size.
	 *
	 * @return the integer of the domain size
	 */
	public int domainSize(){

		return domain.size();
	}


	/**
	 * Reset domain to the original values.
	 */
	public void resetDomain(){
		domain.clear();
		for (int i = 1; i < 10; i++){

			domain.add(i);
		}
	}



	/**
	 * Removes the domain.
	 *
	 * @param value the value
	 */
	public void removeDomain(int value){
		if(domain.isEmpty()){
			System.out.print("Error: domain empty");
		}
		else {
			for(int i = 0; i < domain.size(); i++ ){
				if(domain.get(i) == value){
					domain.remove(i);
				}
			}

		}
	}




	/**
	 * Removes the domain.
	 *
	 * @param variable the variable
	 */
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







	/**
	 * Prints the domain.
	 *
	 * @param variable the variable
	 */
	public void printDomain(Variable variable){
		System.out.print("Variable: ["+variable.position[0]+","+variable.position[1]+"] " +variable.value+" Domain: " );
		for(int i = 0; i < this.domain.size(); i ++){

			System.out.print(this.domain.get(i)+",");
		}
		System.out.println();
	}

	/**
	 * is the domain is empty.
	 *
	 * @return true, if successful
	 */
	public boolean domainIsEmpty(){

		return domain.isEmpty();
	}

	/**
	 * searches the domain for the integer value.
	 *returns true if it is in the domain and false if not
	 * @param value the value
	 * @return true, if successful
	 */
	public boolean contains(int value){
		for(int i = 0; i < domain.size(); i++ ){
			if (domain.get(i) == value){
				return true;
			}
		}	return false;
	}
}


