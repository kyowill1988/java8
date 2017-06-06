package willzh.java8test;

public class ReflectionTest {
	
	public static void foo(){
		
		Class c1 = int.class;
		Class c2 = String.class;
		Class c3 = double.class;
		Class c4 = Double.class;
		
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c2.getSimpleName());
		System.out.println(c3.getName());
		System.out.println(c4.getName());
		System.out.println(c4.getSimpleName());
		
	}
	
	
}
