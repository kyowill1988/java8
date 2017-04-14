package willzh.java8test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleFunction;
import java.util.function.Function;

public class FunctionTest {
	
	public static <T,R> List<R> map(List<T> list,Function<T,R> f){
		
		List<R> result = new ArrayList<R>();
		
		for(T t : list){
			result.add(f.apply(t));			
		}
		
		return result;		
	}
	
	public static double integrate(DoubleFunction<Double> f,double a,double b){
		return (f.apply(a) + f.apply(b)) * (b - a)/2.0;
	}
	

}
