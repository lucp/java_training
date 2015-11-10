package staticpkg;

public class Base {

	private static void privateStaticFunction() {
		/**Cannot make a static reference to the non-static method publicFunction() from the type Base**/
//		publicFunction();
	}
	
	public static void publicStaticFunction() {
		privateStaticFunction();
	}
	
	public void publicFunction() {
		privateStaticFunction();
	}
	
}
