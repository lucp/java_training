package staticpkg;

public class StaticBlock {

    static int x[];
	    
    static {
    	x = new int[1];
        x[0] = 1;
    }
	    
    public static void main(String args[]) {
    	
    	System.out.println(StaticBlock.x[0]);
    }   
	
}
