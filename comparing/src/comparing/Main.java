package comparing;

import java.util.ArrayList;
import java.util.Collections;

public class Main implements Comparable<Main> {
	
	boolean great;
	int value;
	
	public Main(boolean great, int value) {
		this.great = great;
		this.value = value;
	}

	public static void main(String[] args) {
		
		Main m1 = new Main(true, 1);
		Main m2 = new Main(false, 2);
		Main m3 = new Main(false, 3);
		Main m4 = new Main(true, 4);
		Main m5 = new Main(false, -5);
		
		ArrayList<Main> al = new ArrayList<Main>(5);
		al.add(m1);
		al.add(m2);
		al.add(m3);
		al.add(m4);
		al.add(m5);
		
		for (Main m : al) {
			System.out.print(m + "");
		}
		System.out.println();
		
		Collections.sort(al);
		for (Main m : al) {
			System.out.print(m + "");
		}
		System.out.println();
		

	}

	@Override
	public int compareTo(Main otherMain) {
		if (this.great == otherMain.great) {
			if (this.value < otherMain.value) return -1;
			else if (this.value > otherMain.value) return 1;
			else return 0;
		}
		else {
			if (this.great == true && otherMain.great == false) return 1;
			else return -1;
		}
	}
	
	@Override
	public String toString() {
		return "(" + this.great + "," + this.value + ")";
	}

}
