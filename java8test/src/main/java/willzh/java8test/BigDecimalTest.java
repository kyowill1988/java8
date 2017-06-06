package willzh.java8test;

import java.math.BigDecimal;

public class BigDecimalTest {
	
	public static void foo(){
		
		int intNumber = 0;
		System.out.println(new BigDecimal(intNumber));
		double doubleNumber = 1000.00;
		System.out.println(new BigDecimal(doubleNumber));
		long longNumber = 1000000000;
		System.out.println(new BigDecimal(longNumber));
		String stringNumber = "1111";
		System.out.println(new BigDecimal(stringNumber));
		
	}
}
