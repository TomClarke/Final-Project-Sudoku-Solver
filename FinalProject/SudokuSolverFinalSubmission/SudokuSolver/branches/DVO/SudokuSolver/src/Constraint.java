package src;

import java.util.List;

public interface Constraint {

    /** Constrains the values that the variables can take on. 
     * @param variableList */
    public abstract List<Variable> applyConstraints(List<Variable> variableList);
	
    public abstract boolean solved(Variable v);
	
    public abstract int[] GAC(List<Variable> variableList);

}
