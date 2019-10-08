package ch5;

public class DiscountedItem implements LineItem {

	private LineItem item;
	private double discount;
	private int amt;
	
	public DiscountedItem(LineItem item, double discount) {
		this.item = item;
		this.discount = discount;
		amt = 0;
	}

	public double getPrice() {
		return item.getPrice() * (1 - discount / 100);
	}

	public String toString() {
		return item.toString() + " (Discount " + discount + "%)";
	}

	@Override
	public int getAmt() {
		// TODO Auto-generated method stub
		return amt;
	}

	public void addAmt() {
		amt++;
	}
}
