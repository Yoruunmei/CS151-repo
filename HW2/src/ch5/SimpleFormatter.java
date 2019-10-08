package ch5;

public class SimpleFormatter implements InvoiceFormatter {
	/**
	 * 2 A simple invoice formatter. 3
	 */
	private double total;
	

		public String formatHeader() {
			total = 0;
			return "     I N V O I C E\n\n\n";
		}

		public String formatLineItem(LineItem item) {
			total += item.getPrice();
			return (String.format("%s: $%.2f	%d \n", item.toString(), item.getPrice(), item.getAmt()));
		}

		public String formatFooter() {
			return (String.format("\n\nTOTAL DUE: $%.2f\n", total));

		}

}
