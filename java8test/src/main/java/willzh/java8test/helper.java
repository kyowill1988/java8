package willzh.java8test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class helper {
	
	public static<T> List<T> filter(List<T> t,Predicate<T> p){
		
		List<T> result = new ArrayList<>();
		for(T e : t){
			if(p.test(e)){
				result.add(e);				
			}			
		}
		
		return result;
	}
	
}
