import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class hw4 {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		
		Question1 account = new Question1(1000000);
		Question1 account2 = new Question1(1000000);
		
		Runnable person1UnSynced = () -> {
			try {
				Thread.sleep(0);
				System.out.println("test");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			account.unSyncedDeposit(10000);
			//System.out.println("P1 Depositing...");
			account.unSyncedDeposit(10001);
			//System.out.println("P1 Depositing...");
			
			System.out.println("Current amt: " + account.getCurrentAmt());
		};
		
		Runnable person2UnSynced = () -> {
			//Thread.sleep(millis);
			//System.out.println("P2 Depositing...");
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			account.unSyncedDeposit(20000);
			account.unSyncedDeposit(20001);
			
			System.out.println("Current amt: " + account.getCurrentAmt());
		};
		
		Runnable person1Synced = () -> {
			try {
				Thread.sleep(1000);
				System.out.println("\n===Running synced===");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("===Now running synced ver.===");
			//System.out.println("P1 Depositing...");
			account2.syncedDeposit(10000);
			account2.syncedDeposit(10001);
			
			System.out.println("Current amt: " + account2.getCurrentAmt());
		};
		
		Runnable person2Synced = () -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("P2 Depositing...");
			account2.syncedDeposit(20000);
			account2.syncedDeposit(20001);
			
			System.out.println("Current amt: " + account2.getCurrentAmt());
		};
		
		service.execute(person1UnSynced);
		service.execute(person2UnSynced);
		
		service.execute(person1Synced);
		service.execute(person2Synced);
		
		service.shutdown();
	}

}
