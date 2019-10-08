package ch5;

public class Product implements LineItem {

	private String description;
	private double price;
	private int amt;
	
	public Product(String description, double price) {
		this.description = description;
		this.price = price;
		amt = 0;
	}

	public double getPrice() {
		return price;
	}

	public String toString() {
		return description;
	}
	
	public int getAmt() {
		return amt;
	}
	
	public void addAmt() {
		amt++;
	}
}
