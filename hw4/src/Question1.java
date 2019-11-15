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
		for (int i = 0; i < 10; i++)
			records.add(0);
	}
	
	// METHODS
	public void unSyncedDeposit(int a) {

			records.set(index, a);
			System.out.println("history: " + records.toString());
			currentAmt += records.get(index);
			System.out.println("Current amt: " + this.getCurrentAmt());
			index= index+1;
			

	}
	public void unSyncedWithdraw(int a) {

			records.set(index, -a);
			System.out.println("history: " + records.toString());
			currentAmt += records.get(index);
			System.out.println("Current amt: " + this.getCurrentAmt());
			index=index+1;

	}
	
	public synchronized void syncedDeposit(int a) {

			records.set(index, a);
			System.out.println("history: " + records.toString());
			currentAmt += records.get(index);
			System.out.println("Current amt: " + this.getCurrentAmt());
			index += 1;

	}
	public synchronized void syncedWithdraw(int a) {

		records.set(index, -a);
		System.out.println("history: " + records.toString());
		currentAmt += records.get(index);
		System.out.println("Current amt: " + this.getCurrentAmt());
		index=index+1;
		
	}
	
	public synchronized int getCurrentAmt() {
		return currentAmt;
	}
}
