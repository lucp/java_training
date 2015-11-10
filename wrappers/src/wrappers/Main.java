package wrappers;

import java.util.LinkedList;

public class Main{
	
	public static Integer addIntegers(Integer I, int i) {
		return I + i;
	}
	
    public static void show(Long a) {
        System.out.println("LONG");
    }
	
	public static void show(short a) {
        System.out.println("short");
    }
	    
    public static void show(Short a) {
        System.out.println("SHORT");
    }
	
	public static void main(String[] args) {
		
		/**Basic and wrapper classes**/
		Integer I = 1;
		int i = 1;
		System.out.println(addIntegers(i, I));
		
		/*Again*/
		short shortShow = 1;
        int intShow = 2;
        
        /*The method show(Long) in the type Main is not applicable for the arguments (int)*/
//      show(intShow);
        
        show(shortShow);
		
		/**Generic class**/
		Integer someInt = new Integer(1);
		GenericClass<Integer> genericClass = new GenericClass<Integer>(someInt);
		System.out.println(genericClass.value.doubleValue());
	

	}

}
