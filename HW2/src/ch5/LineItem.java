package ch5;

public interface LineItem {

	/**
	 * Gets the price of this line item.
	 * 
	 * @return the price
	 * 
	 */
	double getPrice();

	/**
	 * 
	 * @return
	 */
	String toString();
	
	int getAmt();
	
	void addAmt(); 
		
}
