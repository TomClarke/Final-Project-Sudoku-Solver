package src;

import java.util.Date;

public class SudokuBoard {

	int sudokuBoard[][];
	int row = 9;
	int col = 9;
	boolean Solved;
	String date;
	
	
	public SudokuBoard(){
		newBoard();
	}


	public void newBoard() {
		Date datea = new Date();
		date = datea.toString();
		
		sudokuBoard = new int [row][col];
		
		for (int i = 0; i <row; i++) 
			for(int j =0; j < col; j++) 

				sudokuBoard[i][j] = 0;
		
	}
	
	
	
	
	public int [][] getBoard(){
		return sudokuBoard;
	}
	
	public int getValue(int i, int j){
		int value = sudokuBoard[i][j];
		return value;
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
	                if(sudokuBoard[i][j] == 0)
	                {
	                    System.out.print("_");
	                }
	                else
	                {
	                    System.out.print(sudokuBoard[i][j]);
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
	
	
	public void setBoard(SudokuBoard loaded){
		System.out.println("Loaded: Set Buttons ");
	SudokuMenuView m_view = new SudokuMenuView();
		for ( int i = 0; i < 9; i++){
			for ( int j = 0; j < 9; j++){
				
				m_view.btnNumber[i][j].setText(""+loaded.sudokuBoard[i][j]);
				
			m_view.setLabel(i,j,loaded.sudokuBoard[i][j]);
				
			m_view.setButton(loaded.sudokuBoard[i][j],m_view.btnNumber[i][j]);
			}
		}
	}
	
	
	
	
}
