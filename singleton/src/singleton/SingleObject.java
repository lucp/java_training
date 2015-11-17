package singleton;

public class SingleObject {

	private int value;
	
	private static SingleObject instance = new SingleObject();
	
	private SingleObject(){}
	
	public static SingleObject getInstance(){
		return instance;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void say(){
		System.out.println("SingleObject:" + this.value);
	}
	
}
