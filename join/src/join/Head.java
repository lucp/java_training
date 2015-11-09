package join;

public class Head {

	public static void main(String[] args) {
		
		Tape tape = new Tape();
		Thread thread = new Thread(tape, "tape");
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end");
		
	}
	
}
