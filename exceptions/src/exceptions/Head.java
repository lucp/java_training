package exceptions;

public class Head {

	public void firstFunction() {
		secondFunction();
		System.out.println("First");
	}
	
	private void secondFunction() {
		throw new RuntimeException();
	}

	public static void publicStaticFunction() {}
	
	/**main with throwing clause**/
	public static void main(String[] args) throws InterruptedException {
		
		Head head = new Head();
		try{
			head.firstFunction();
		}
		catch (Exception e) {
			System.out.println("RuntimeException");
		}
		
		Thread.sleep(1);
        publicStaticFunction();

	}

}
