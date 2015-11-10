package serialize;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeExtendedTest {

	public static void main(String[] args) {
		
		ExtendedWithSerializable s = new ExtendedWithSerializable(1, 2);
        try {
            FileOutputStream fos = new FileOutputStream("ExtendedWithSerializable.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s);
            oos.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }

	}

}
