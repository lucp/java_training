package synch_function;

public class SynchFunctionClass implements Runnable{

	public synchronized void synchFunctionWait() throws InterruptedException {
		wait();
	}
	
	public synchronized void synchFunctionNotify() {
		notify();
	}

	@Override
	public void run() {
		System.out.println("SynchFunctionClass run() and wait()");
		try {
			synchFunctionWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("SynchFunctionClass end");
	}
	
}
