package src;

import java.util.ArrayList;
import java.util.List;

public class Network {

	Domain domains;
	Variable variable;
	public List<Variable> variableList = new ArrayList<Variable>(); 
	public SudokuBoard newboard;
	//public SudokuBoard oldBoard;

	public void setBoardSolved(boolean solved){
		this.newboard.setSolved(solved);
	}

	public void setup(SudokuBoard board) {

		this.newboard = board;

		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 9 ; j++){
				Variable variable = new Variable();

				//2.for each variable have a domain 
				variable.assignVar(newboard.sudokuBoard[i][j].intValue);
				variable.position[0] = i;
				variable.position[1] = j;
				variableList.add(variable);
			}

		}

	}


	public SudokuBoard solve(String solvingMethod,SudokuBoard board){

		//1. create variables from board
		/*
		 * 1. create variables from board
		 * 2. for each variable have a domain 
		 * 3. apply constraint
		 * 3.1 if variable == assigned: next 
		 * 4. constraint: take variable & domain
		 * 5. constraint: new domains for each variable
		 * 6. constraint: apply constraint 
		 * 7. constraint: AllDiff: check all variables, if false(no conflicts) keep domain as all 
		 * 8. constraint: AllDiff: check all variables, if true(conflicts) use conflict var and take from domain
		 * 9. constraint: Return new domains 
		 * 10. if variable domain is left with 1 number then value is that number.
		 * 11. step 3 until board is complete 
		 */

		setup(board);
		Constraint constrain = null;
		if(solvingMethod == "Backtracking"){

			constrain = new Backtracking();
		}
		if(solvingMethod == "DVO"){

			constrain = new DVO(false);
		}

		if(solvingMethod == "DVOHint"){
			boolean hint = true;
			constrain = new DVO(hint);
			
			variableList = constrain.applyConstraints(variableList);

			int count= 0;
			for(int k = 0; k < 9 ; k++){
				for(int l = 0; l < 9 ; l++){
					newboard.sudokuBoard[k][l].setValue(variableList.get(count).value); 
					count++;
				}

			}
			
		}

		if(solvingMethod == "GAC"){

			constrain = new GAC();
		}


		variableList = constrain.applyConstraints(variableList);

		int count= 0;
		for(int k = 0; k < 9 ; k++){
			for(int l = 0; l < 9 ; l++){
				newboard.sudokuBoard[k][l].setValue(variableList.get(count).value); 
				count++;
			}

		}

		boolean isSolved = constrain.solved();
		setBoardSolved(isSolved);
		//}
		return newboard;
	}





}
