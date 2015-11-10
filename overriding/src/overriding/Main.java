package overriding;

public class Main {

	public static void main(String[] args) {
		
		First f = new Second(1, 2, 3);
		Second s = (Second)f;
		First t = new Third();
		
		f.say();
		s.say();
		t.say();
		
		Object myObj = new String[]{"one", "two", "three"};
        for (String st : (String[])myObj) System.out.print(st + ".");

	}

}
