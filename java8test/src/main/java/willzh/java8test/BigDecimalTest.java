package willzh.java8test;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
		
		//银行家算法
		BigDecimal amount = new BigDecimal(100);
		BigDecimal rate1 = new BigDecimal(0.0035345);
		BigDecimal interest1 = amount.multiply(rate1).setScale(4, RoundingMode.HALF_EVEN);
		System.out.println("interest1 = " + interest1);
		
		BigDecimal rate2 = new BigDecimal(0.0035355);
		BigDecimal interest2 = amount.multiply(rate2).setScale(4, RoundingMode.HALF_EVEN);
		System.out.println("interest2 = " + interest2);
		
		BigDecimal rate3 = new BigDecimal(0.00353556);
		BigDecimal interest3 = amount.multiply(rate3).setScale(4, RoundingMode.HALF_EVEN);
		System.out.println("interest3 = " + interest3);
		
	}
}
