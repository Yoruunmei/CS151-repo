package ch5;

import java.util.*;

public class Bundle implements LineItem {
	
	private ArrayList<LineItem> items;
	private int amt;
	
	public Bundle() {
		items = new ArrayList<>();
		amt = 0;
	}

	public void add(LineItem item) {
		items.add(item);
	}

	public double getPrice() {
		double price = 0;
		for (LineItem item : items)
			price += item.getPrice();
		return price;
	}

	public String toString() {
		String description = "Bundle: ";
		for (int i = 0; i < items.size(); i++) {
			if (i > 0)
				description += ", ";
			description += items.get(i).toString();
		}
		return description;
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
