package generics;

public class GenRun {

	public static <T> void show(T v) {
		System.out.println(v);
	}
	
	public static void main(String[] args) {
	
		Generics<String> g = new Generics<String>("5");

		g.show();
		GenRun.show(new Generics<Integer>(6));
		
	}

}
