import java.util.ArrayList;
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
				System.out.println("===Running UNSYNCED deposits/withdraws===");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			account.unSyncedDeposit(10000);
			

			account.unSyncedWithdraw(10000);

		};
		
		Runnable person2UnSynced = () -> {
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			account.unSyncedDeposit(60000);
			

			account.unSyncedWithdraw(60000);

			
			
		};
		
		Runnable person1Synced = () -> {
			try {
				Thread.sleep(1000);
				System.out.println("\n===Running SYNCED deposits/withdraws===");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			account2.syncedDeposit(10000);
			

			account2.syncedWithdraw(10000);

		};
		
		Runnable person2Synced = () -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			account2.syncedDeposit(60000);
			

			account2.syncedWithdraw(60000);

		};
		
		service.execute(person1UnSynced);
		service.execute(person2UnSynced);
		
		service.execute(person1Synced);
		service.execute(person2Synced);
		
		service.shutdown();
	}

}
