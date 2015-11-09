package notify;

public class Tape implements Runnable{

	public boolean waiting;
	private Monitor monitor;
	
	public Tape(Monitor monitor) {
		this.monitor = monitor;
		this.waiting = false;
	}
	
	@Override
	public void run() {
		
		try {
			System.out.println("Working...");
			Thread.sleep(2000);
			synchronized (monitor) {
				this.waiting = true;
				System.out.println("Can I finish?");
				monitor.wait();
			}
			System.out.println("Thank you :*");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}


}
