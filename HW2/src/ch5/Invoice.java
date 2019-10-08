package ch5;
import java.util.*;
import javax.swing.event.*;
public class Invoice {
	private ArrayList<LineItem> items;
	private ArrayList<ChangeListener> listeners;
	
	public Invoice() {
		items = new ArrayList<>();
	    listeners = new ArrayList<>();
	}
	
	public void addItem(LineItem item) {
		items.add(item);
	    // Notify all observers of the change to the invoice
	    ChangeEvent event = new ChangeEvent(this);
	    for (ChangeListener listener : listeners)
	       listener.stateChanged(event);
	}
	
	 public void addChangeListener(ChangeListener listener)
	 {
	    listeners.add(listener);
	 }
	 
	 public Iterator<LineItem> getItems() {
		 return new
				 Iterator<LineItem>() {
			 public boolean hasNext() {
				 return current < items.size();
			 }
			 
			 public LineItem next() {
				 return items.get(current++);
			 }
			 public void remove()
			 {
				 throw new UnsupportedOperationException();
			 }
			 private int current = 0;
		 };
	 }
	 public String format(InvoiceFormatter formatter) {
		 String r = formatter.formatHeader();
		 Iterator<LineItem> iter = getItems();
		 while (iter.hasNext())
			 r += formatter.formatLineItem(iter.next());
		 return r + formatter.formatFooter();
	 }
}
