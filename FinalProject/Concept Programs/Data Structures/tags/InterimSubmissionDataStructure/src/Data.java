/**
 * 
 */
package src;

// TODO: Auto-generated Javadoc
/**
 * The Class Data.
 *
 * @author TomClarke
 * 
 * Class Data used to construct the Data containing numbers(priority) and the outputs
 */
public class Data implements Comparable <Data>{

	/** The nums used for the priority, randomly assigned. */
	private int nums;

	/** The outputs which are taken from the large data set DataSet. */
	private int outputs;


	/**
	 * Instantiates a new data.
	 *
	 * @param num the num
	 * @param output the output
	 */
	public Data(int num, int output) {	

		this.nums = num;
		this.outputs = output;

	}

	/**
	 * Gets the output.
	 *
	 * @return the output
	 */
	public int getoutput() {
		return outputs;
	}

	/**
	 * Gets the num.
	 *
	 * @return the num
	 */
	public int getnum() {
		return nums;
	}

	/** 
	 * This override compares the data set numbers to sort them
	 * if current num == the new num
	 * then the output will be the lowest int from the current out to the new out
	 *  returns the ans which is the final output and the prioirity it has 
	 **/
	@Override
	public int compareTo(Data data) {
		int ans = 0;
		if(this.nums == data.nums){
			ans = ((Integer) this.outputs).compareTo(data.outputs);

			return ans;
		}
		return this.nums - data.nums;
	}

}







