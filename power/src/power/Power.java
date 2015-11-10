package power;

public class Power {

	public int power(int value) throws NaN{
		if (value == 0 || value == 1) return 1;
		else if (value > 1) {
			int result = 1;
			for (int i = 2; i <= value; i++) {
				result *= i;
			}
			return result;
		}
		else throw new NaN();
	}
	
	public static void main(String[] args) {
		
		Power p = new Power();
		try {
			System.out.println(p.power(5));
		} catch (NaN e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public class NaN extends Exception {}
	
}
