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
	public void unSyncedDeposit(int a) {
		records.add(a);
		currentAmt += a;
		System.out.println("history: " + records.toString());
	}
	public void unSyncedWithdraw(int a) {
		records.add(a);
		currentAmt -= a;
	}
	
	public synchronized void syncedDeposit(int a) {
		records.add(a);
		currentAmt += a;
		System.out.println("history: " + records.toString());
	}
	public synchronized void syncedWithdraw(int a) {
		records.add(a);
		currentAmt -= a;
	}
	
	public int getCurrentAmt() {
		return currentAmt;
	}

}
