package join;

import java.util.Iterator;
import java.util.LinkedList;

public class Tape implements Runnable {

	public static LinkedList<Integer> intList = new LinkedList<Integer>();
	
	public Tape() {
		Tape.intList.add(1);
		Tape.intList.add(2);
	}
	
	@Override
	public void run() {
		
		System.out.println("Tape starts");
		Iterator<Integer> it = intList.listIterator();
		while (it.hasNext()) {
			it.next();
			try {
				Thread.sleep(1000);
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println("Tape stops");
		
	}

}
