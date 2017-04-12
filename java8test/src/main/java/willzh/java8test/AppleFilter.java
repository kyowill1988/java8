package willzh.java8test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleFilter {
	
	public static boolean isGreenApple(Apple apple){
		return "Green".equals( apple.getColor());
	}
	
	public static boolean isHeavyApple(Apple apple){		
		return apple.getWeight() > 150;
	}
	
	public static List<Apple> filterApples(List<Apple> inventory,Predicate<Apple> p){
		
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if(p.test(apple)){
				result.add(apple);
			}			
		}
		
		return result;
	}
	
	
}
