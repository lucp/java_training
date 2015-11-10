package serialize;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeTest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private SomeInnerClass someInnerClass = new SomeInnerClass();
    
    public static void main(String[] args) {
    	SerializeTest s = new SerializeTest();
        try {
            FileOutputStream fos = new FileOutputStream("SerializeTest.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s);
            oos.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public class SomeInnerClass implements Serializable {
    }
    
}
