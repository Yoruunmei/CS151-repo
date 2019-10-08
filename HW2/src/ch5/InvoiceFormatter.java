package ch5;

public interface InvoiceFormatter {

	String formatHeader();

	String formatLineItem(LineItem item);


	String formatFooter();
}
