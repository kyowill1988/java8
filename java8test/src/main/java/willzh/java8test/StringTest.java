package willzh.java8test;

public class StringTest {
		
	public static void tryIndexOf(){
		
		String parentString = "abcdefgdddddecdgfdegsade";
		String childString = "de";	
		System.out.println(parentString.indexOf(childString));//首次  索引结果为3
		System.out.println(parentString.lastIndexOf(childString));//末次 索引结果为22
		
	}
	
	
}
