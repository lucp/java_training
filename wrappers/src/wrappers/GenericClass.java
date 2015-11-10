package wrappers;

public class GenericClass<T extends Object> {
	
	public T value;
	
	public GenericClass(T value) {
		this.value = value;
	}

}
