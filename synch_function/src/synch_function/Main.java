package synch_function;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Starting all...");
		SynchFunctionClass sfc = new SynchFunctionClass();
		Thread thread = new Thread(sfc, "SynchFunctionClass");
		thread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sfc.synchFunctionNotify();
		System.out.println("Ending all...");

	}

}
