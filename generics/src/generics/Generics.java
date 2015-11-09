package generics;

public class Generics<T> {

	T v;
	
	public Generics() {
		this.v = null;
	}
	
	public Generics(T v) {
		this.v = v;
	}
	
	public void show() {
		System.out.println(v);
	}
	
}
