package src;

import java.util.Date;

public class SudokuBoard {

	public CellView sudokuBoard[][];
	int row = 9;
	int col = 9;
	boolean Solved;
	String date;
	SudokuBoard Currentboard;


	
	public SudokuBoard(){
		newBoard();
	}



	public void newBoard() {
		Date datea = new Date();
		date = datea.toString();
		
		//sudokuBoard = new int [row][col];
		sudokuBoard = new CellView[row][col];
		for (int i = 0; i <row; i++)
			for(int j =0; j < col; j++)
				sudokuBoard[i][j] = new CellView();
			
		
		for (int i = 0; i <row; i++) 
			for(int j =0; j < col; j++) 
				sudokuBoard[i][j].setValue(0);
				
				//sudokuBoard[i][j].intValue = 1;
	}
	

	
	
	public void PrintBoard(){
		 for(int i = 0; i < 9; i++)
	        {
	            if((i % 3) == 0)
	            {
	                System.out.println("+-----+-----+-----+");
	            }
	            for(int j = 0; j < 9; j++)
	            {
	                if((i % 3) == 0 || (i % 3) == 1 ||(i % 3) == 2 )
	                {
	                    System.out.print("|");
	                }
	                if(sudokuBoard[i][j].intValue == 0)
	                {
	                    System.out.print("_");
	                }
	                else
	                {
	                    System.out.print(sudokuBoard[i][j].intValue);
	                }
	            }
	            System.out.println("|");
	        }
	        System.out.println("+-----+-----+-----+");
	        System.out.println();
	    }


	public void getSolved(){
		Solved = true;
	}
	
	public boolean isSolved(){
		
		return Solved;
		
	}
	
	
	public void setBoard(SudokuBoard taken){
		System.out.println("Loaded: View Text ");
	//SudokuMenuView m_view = new SudokuMenuView();
	
		for ( int i = 0; i < 9; i++){
			for ( int j = 0; j < 9; j++){
			
			
				
			int value = taken.sudokuBoard[i][j].getValue();
				taken.sudokuBoard[i][j].setValue(value);
			
			}
		}
				this.PrintBoard();
	
	}
	
	public void setBoard(){
		System.out.println("Loaded: View Text ");
	//SudokuMenuView m_view = new SudokuMenuView();
	
		for ( int i = 0; i < 9; i++){
			for ( int j = 0; j < 9; j++){
			
			
				
			int value = this.sudokuBoard[i][j].getValue();
				this.sudokuBoard[i][j].setValue(value);
			
			}
		}
				this.PrintBoard();
	
	}

	
	public SudokuBoard update(){
		for ( int i = 0; i < 9; i++){
			for ( int j = 0; j < 9; j++){
				
				if (this.sudokuBoard[i][j].assigned == false){
		this.sudokuBoard[i][j].intValue = this.sudokuBoard[i][j].getTextValue();
				}

			}
		}
		this.PrintBoard();
		return this;
	}



	public void setBoard(int[] hintMove) {
	
		
		
	}
	
	
	
}
