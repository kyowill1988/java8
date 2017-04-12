package willzh.java8test;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class App 
{
    public static void main( String[] args )
    {     
        
    	List<Apple> inventory = new ArrayList<>();
    	Apple appleOne = new Apple();
    	appleOne.setColor("Red");
    	appleOne.setWeight((double)200);
    	inventory.add(appleOne);
    	
    	Apple appleTwo = new Apple();
    	appleTwo.setColor("Green");
    	appleTwo.setWeight((double)100);
    	inventory.add(appleTwo);
    	
    	Apple appleThree = new Apple();
    	appleThree.setColor("Green");
    	appleThree.setWeight((double)50);
    	inventory.add(appleThree);
    	
    	List<Apple> filterResultOne = AppleFilter.filterApples(inventory,AppleFilter:: isGreenApple);
    	System.out.println("filterResultOne:");
    	for(Apple apple : filterResultOne){
    		System.out.println(apple);    		
    	}
    	
    	List<Apple> filterResultTwo = AppleFilter.filterApples(inventory,AppleFilter:: isHeavyApple);
    	System.out.println("filterResultTwo:");
    	for(Apple apple : filterResultTwo){
    		System.out.println(apple);    		
    	}
        
    	List<Apple> filterResultThree = AppleFilter.filterApples(inventory,(Apple a)-> "Red".equals(a.getColor()));
    	System.out.println("filterResultThree:");
    	filterResultThree.forEach((Apple a)->System.out.println(a));
    	
    	List<Apple> filterResultFour = inventory.stream().filter((Apple a)->a.getWeight() > 150).collect(toList());
    	System.out.println("filterResultFour:");
    	for(Apple apple : filterResultFour){
    		System.out.println(apple);    		
    	}
    	
    	List<Apple> filterResultFive = inventory.parallelStream().filter((Apple a)->a.getWeight() > 150).collect(toList());
    	System.out.println("filterResultFive:");
    	for(Apple apple : filterResultFive){
    		System.out.println(apple);    		
    	}
    	
    	
    }
}
