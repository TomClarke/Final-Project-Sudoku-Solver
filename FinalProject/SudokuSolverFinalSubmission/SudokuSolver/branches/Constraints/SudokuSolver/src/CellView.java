package src;


import javax.swing.JLabel;

public class CellView extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Boolean assigned;
	int intValue;
	String strValue;

	
	public CellView(){
		NewCell();
	}

	
	private void NewCell() {
	
		intValue = 1;
		strValue = "0";
		assigned = false;
	}

public int getTextValue(){
	strValue = this.getText();
	int value = 0;
	if (strValue.equals(" ")|| strValue.equals("")){
		System.out.println("Value: "+strValue);
	}
	else
	
		value = Integer.parseInt(strValue);
		
	return value;
}
	
	
	
	public int getValue(){
			
		return intValue;
		
	}
	
	public void setValue(int value){
		
		//int intValue = Integer.parseInt(value);
		intValue = value;
		SudokuMenuView.setButton(value, this);

				
	}
	
	public String getPencil() {
		String strValue = this.getText();
		
		return strValue;
	}

	

	public void setPencil(String value){
	
		strValue = value;
		
		SudokuMenuView.possibleValue(value, this);
				
	}



	

	
	
}
