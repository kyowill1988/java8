package willzh.java8test;

public class ExceptionTest {
	
	public static int test(String str){
		
		try{
			int i = str.length();
			return i;
		}catch(Exception e){
			return 0;
		}finally{
			return -1;
		}
	}
	
	
	
	
	
	
	
	
}
