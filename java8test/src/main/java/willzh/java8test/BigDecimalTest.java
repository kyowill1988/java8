package willzh.java8test;

import java.math.BigDecimal;

public class BigDecimalTest {
	
	public static void foo(){
		
		int intNumber = 11;
		System.out.println(new BigDecimal(intNumber));
		double doubleNumber = 1001.00;
		System.out.println(new BigDecimal(doubleNumber));
		long longNumber = 1000000000;
		System.out.println(new BigDecimal(longNumber));
		String stringNumber = "1111";
		System.out.println(new BigDecimal(stringNumber));
		
		BigDecimal a = new BigDecimal(intNumber);
		BigDecimal b = new BigDecimal(doubleNumber);
		System.out.println("a+b=" + a.add(b));
		System.out.println("b-a=" + b.subtract(a));
		System.out.println("a*b=" + a.multiply(b));
		System.out.println("b/a=" + b.divide(a));
		
	}
}
