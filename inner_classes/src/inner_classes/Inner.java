package inner_classes;

public class Inner {

	private int x = 0;
	
	public InnerInner ii = new InnerInner();
	
	public static void main(String[] args) {
		Inner i = new Inner();
		i.ii.change();
		System.out.println(i.x);
		int x = 2;

	}
	
	public class InnerInner {
		
		public void change() {
			x = 1;
		}
		
	}

}
