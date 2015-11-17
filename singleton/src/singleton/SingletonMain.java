package singleton;

public class SingletonMain {

	public static void main(String[] args) {
		
		SingleObject singleObject = SingleObject.getInstance();
		singleObject.setValue(1);
		singleObject.say();
		SingleObject singleObject2 = SingleObject.getInstance();
		singleObject2.say();
		singleObject.setValue(2);
		singleObject2.say();

	}

}
