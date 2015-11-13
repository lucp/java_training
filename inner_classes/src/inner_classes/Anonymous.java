package inner_classes;

public abstract class Anonymous {

	public abstract void sayHello();
	
	public static void main(String[] args) {
	
		Anonymous a = new Anonymous() {

			@Override
			public void sayHello() {
				System.out.println("Im anonymous!");
			}
			
		};
		
		a.sayHello();
		
		Anonymous.InnerInAnonymous iia = new Anonymous.InnerInAnonymous();
		iia.sayHello();
		
		Anonymous.InnerInAnonymous eiia = new Anonymous.InnerInAnonymous() {
			public void sayHello() {
				System.out.println("Im anonymous of inner class in anonymous!");
			}
		};
		eiia.sayHello();
		
	}
	
	public static class InnerInAnonymous {
		
		public void sayHello() {
			System.out.println("Im inner class in anonymous!");
		}
		
	}

}
