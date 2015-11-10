package overriding;

public class First {
	
	private int x;
	public int y;
	public int z;
	
	public First(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	protected void protectedFunction() {};
	
	public void say() {
		System.out.println("First");
	}
	
}
