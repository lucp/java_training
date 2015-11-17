package exceptions;

public class MulticatchedExceptions {

	public static void main(String[] args) {
		
		try{
			if (args.length > 1) {
				throw new ExtendedException();
			}
			else {
				throw new AnotherExtendedException();
			}
		}
		/*The exception ExtendedException is already caught by the alternative Exception*/
//		catch (ExtendedException | Exception e) {}
		catch (ExtendedException | AnotherExtendedException e) {
			System.out.println("RuntimeException");
		}
		
	}
	
}
