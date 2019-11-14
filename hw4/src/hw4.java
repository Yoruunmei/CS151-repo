import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class hw4 {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		
		Question1 account = new Question1(1000000);
		
		Runnable person1UnSynced = () -> {
			System.out.println("P1 Depositing...");
			account.unSyncedDeposit(10000);
			account.unSyncedDeposit(50000);
			
			System.out.println("Current amt: " + account.getCurrentAmt());
		};
		
		Runnable person2UnSynced = () -> {
			System.out.println("P2 Depositing...");
			account.unSyncedDeposit(20000);
			account.unSyncedDeposit(60000);
			
			System.out.println("Current amt: " + account.getCurrentAmt());
		};
		
		Runnable person1Synced = () -> {
			System.out.println("===Now running synced ver.===");
			System.out.println("P1 Depositing...");
			account.unSyncedDeposit(10000);
			account.unSyncedDeposit(50000);
			
			System.out.println("Current amt: " + account.getCurrentAmt());
		};
		
		Runnable person2Synced = () -> {
			System.out.println("P2 Depositing...");
			account.unSyncedDeposit(20000);
			account.unSyncedDeposit(60000);
			
			System.out.println("Current amt: " + account.getCurrentAmt());
		};
		
		service.execute(person1UnSynced);
		service.execute(person2UnSynced);
		service.execute(person1Synced);
		service.execute(person2Synced);
		
		service.shutdown();
	}

}
