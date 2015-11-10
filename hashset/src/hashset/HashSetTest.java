package hashset;

import java.util.Arrays;
import java.util.HashSet;

public class HashSetTest {

    private String str;
    
    public HashSetTest(String str) {
        this.str = str;
    }
    
    public static void main(String args[]) {
    	HashSetTest h1 = new HashSetTest("1");
    	HashSetTest h2 = new HashSetTest("1");
        String s1 = new String("2");
        String s2 = new String("2");
        
        HashSet<Object> hs = new HashSet<Object>();
        hs.add(h1);
        hs.add(h2);
        hs.add(s1);
        hs.add(s2);
        
        Object arr[] = new Object[2];
        arr[0] = h1;
        arr[1] = s1;
        Arrays.sort(arr);
        
        System.out.print(hs.size());
    }
	
}
