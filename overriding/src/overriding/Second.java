package overriding;

public class Second extends First {
	
	public Second(int x, int y, int z) {
		super(x, y, z);
	}

	public void protectedFunction() {}
	
	public void say() {
		System.out.println("Second");
	}

}
