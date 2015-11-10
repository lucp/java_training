package notify;

public class WaitAndNotifyAfter {

	 public void waitForSomething() throws InterruptedException {
	    Monitor m = new Monitor();
	    synchronized (m) {
	        m.wait();
	        m.notify();         
	    }
	}
	
}
