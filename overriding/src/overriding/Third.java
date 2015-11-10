package overriding;

public class Third extends First {
	
	int z;
	
	public Third() {
		super(0, 0, 0);
		this.y = 3;
		this.z = 3;
	}
	
	public void say() {
		this.y = 2;
		System.out.println("Third");
	}

}
