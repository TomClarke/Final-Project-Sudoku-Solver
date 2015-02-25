package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Network {

	Domain domains;
	Variable variable;
	List<Variable> variableList = new ArrayList<Variable>(); 
	public SudokuBoard newboard;
	public SudokuBoard oldBoard;


	private void setup(SudokuBoard board) {

		this.newboard = board;


		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 9 ; j++){
				Variable variable = new Variable();

				//2.for each variable have a domain 
				variable.assignVar(newboard.sudokuBoard[i][j].intValue);
				variable.position[0] = i;
				variable.position[1] = j;
				//variable.printVariable();
				variableList.add(variable);
				//System.out.println("Location: ("+i+ ","+ j+") Variable Value: " +variable.value+ "(Assigned "+variable.assigned+")");
				//variable.domain.printDomain(variable);

			}

		}

	}


	public SudokuBoard backtrack(SudokuBoard board){

		oldBoard = board;

		setup(board);

		while(newboard.Solved == false){


			Constraint constrain = new AllDifferent();



			variableList = constrain.applyConstraints(variableList);
			newboard.Solved = true;



			int count= 0;
			for(int k = 0; k < 9 ; k++){
				for(int l = 0; l < 9 ; l++){


					newboard.sudokuBoard[l][k].setValue(variableList.get(count).value); 
					//System.out.println("Setboard: ["+k+","+l+"] ="+newboard.sudokuBoard[k][l].getValue());
					count++;
					//System.out.println("Location: ("+k+" Variable Value: " +variableList.get(k).value+ "(Assigned "+variableList.get(k).assigned+")");
					//variableList.get(k).domain.printDomain(variableList.get(k));
				}

			}



		}
		return newboard;
	}







	public SudokuBoard Solve(SudokuBoard board){


		return newboard;
	}



	public int[] GAC(SudokuBoard board){

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

		oldBoard = board;

		setup(board);
		int [] bestMove = new int [2]; 

		Constraint constrain = new AllDifferent();

		bestMove = constrain.GAC(variableList);

		return bestMove;
	}

}
