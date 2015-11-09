package notify;

public class Main {

	public static void main(String[] args) {
	
		Monitor monitor = new Monitor();
		Tape tape = new Tape(monitor);
		Thread thread = new Thread(tape, "Tape");
		thread.start();
		try {
			while (tape.waiting != true) {
				Thread.sleep(1000);
			}
			synchronized (monitor) {
				System.out.println("Yes you can :P");
				monitor.notify();
			}
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("The End");
	}

}
