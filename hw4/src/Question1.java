import java.util.ArrayList;

// not using lambda expression to create a method in main that returns a Runnable instance b/c there are two questions and this way, the program is more organized.
public class Question1{

	// FIELDS
	public int currentAmt;
	public ArrayList<Integer> records = new ArrayList<Integer>();
	private int index = 0;
	// bank account obj = question1
	public Question1(int initialAmt) {
		currentAmt = initialAmt;
	}
	
	// METHODS
	public void unSyncedDeposit(ArrayList<Integer> a) {
		
		for (int i = 0; i < a.size(); i++) {
			records.add(a.get(i));
			currentAmt += a.get(i);
			System.out.println("history: " + records.toString());
			System.out.println("Current amt: " + this.getCurrentAmt());
		}
//		records.add(a);
//		currentAmt += a;
	}
	public void unSyncedWithdraw(ArrayList<Integer> a) {
		for (int i = 0; i < a.size(); i++) {
			records.add(-a.get(i));
			currentAmt -= a.get(i);
			System.out.println("history: " + records.toString());
			System.out.println("Current amt: " + this.getCurrentAmt());
		}
	}
	
	public synchronized void syncedDeposit(ArrayList<Integer> a) {
		for (int i = 0; i < a.size(); i++) {
			records.add(a.get(i));
			currentAmt += a.get(i);
			System.out.println("history: " + records.toString());
			System.out.println("Current amt: " + this.getCurrentAmt());
		}
//		System.out.println("synced");
//		records.add(a);
//		currentAmt += a;
//		System.out.println("synced history: " + records.toString());
	}
	public synchronized void syncedWithdraw(ArrayList<Integer> a) {
		for (int i = 0; i < a.size(); i++) {
			records.add(-a.get(i));
			currentAmt -= a.get(i);
			System.out.println("history: " + records.toString());
			System.out.println("Current amt: " + this.getCurrentAmt());
		}
	}
	
	public synchronized int getCurrentAmt() {
		return currentAmt;
	}

}
