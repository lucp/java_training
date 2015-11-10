package serialize;

import java.io.Serializable;

public class ExtendedWithSerializable extends BaseNoSerializable implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public int y;

	public ExtendedWithSerializable(int x, int y) {
		super(x);
		this.y = y;
	}

}
