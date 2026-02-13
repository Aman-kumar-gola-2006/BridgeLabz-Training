package interfaces.functionalinterface.backgroundjobexecution;

public class ExecuteTasks {
	public static void main(String[] args) {
		Runnable job = ()->{
			System.out.println("BackGround Job Started");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Background Job Completed");
		};
		
		Thread thread = new Thread(job);
		thread.start();
		
		System.out.println("Main Thread Continues....");
	}
}
