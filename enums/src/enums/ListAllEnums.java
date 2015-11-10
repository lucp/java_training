package enums;

public class ListAllEnums {

	enum Type {one, two, three}
	
	public static void main(String[] args) {

		for (Type t : Type.values()) {
			System.out.println(t);
		}

	}

}
