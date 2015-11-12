package string_buffer_builder;

public class Main {
	
	public static void main(String[] args) {
		
		String str = "first";
		str = "second";
		
		StringBuffer strBuff = new StringBuffer("strBuff");
		strBuff.deleteCharAt(3);
		
		StringBuilder strBuild = new StringBuilder("strBuild");
		strBuild.append("1");
		strBuild.replace(2, 3, "hehe");
		
		System.out.println(strBuff);
		System.out.println(strBuild);
		
	}

}
