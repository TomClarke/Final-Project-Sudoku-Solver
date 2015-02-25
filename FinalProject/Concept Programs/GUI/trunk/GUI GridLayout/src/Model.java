package src;
/**
 * 
 */


/**
 * The Class Model is used to provide an action for the buttons
 */
public class Model {


	/** The view. */
	private final View view = new View();


	/**
	 * Solve.
	 */
	public void Solve() {

	}


	/**
	 * Save.
	 * provide the action from within view
	 */
	public void Save() {
		view.Save();
	}


	/**
	 * Load.
	 */
	public void Load() {


		view.Load();

	}


	/**
	 * Erase.
	 */
	public void Erase() {

	}


	/**
	 * Help.
	 */
	public void Help() {

	}

	/**
	 * Add1.
	 *
	 * @return true, if successful
	 */
	public boolean add1() {

		return true;
	}

	/**
	 * Sets the button.
	 *
	 * @param value the value
	 * @return the int
	 */
	public int setButton(int value) {
		int value1 = 0;		
		if (add1()){
			value1 = 1;
		
		}
		return value1;
		}


	
	}
