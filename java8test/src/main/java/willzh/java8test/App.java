package willzh.java8test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.omg.Messaging.SyncScopeHelper;

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
    	
    	List<Apple> filterResultSix = helper.filter(inventory, (Apple p)->"Red".equals(p.getColor()));    	
    	System.out.println("filterResultSix:");
    	filterResultSix.forEach((Apple a)->System.out.println(a));
    	
    	List<Integer> numbers = Arrays.asList(new Integer(1),new Integer(2),new Integer(3));    	
    	List<Integer> filterResultSeven = helper.filter(numbers, (Integer i)-> i % 2 != 0);    	
    	System.out.println("filterResultSeven:");
    	filterResultSeven.forEach((Integer i)->System.out.println(i.intValue()));
    	
    	List<Integer> chaosNumbers = Arrays.asList(new Integer(100),new Integer(90),new Integer(200)); 
    	
    	Thread t1 = new Thread(new Runnable(){
    		public void run(){
    			System.out.println("How are you");
    		}    		
    	});
    	
    	t1.start();
    	
    	Thread t = new Thread(()->System.out.println("Hello world"));
    	t.start();
    	
    	ConsumerTest.ForEach(Arrays.asList(1,2,3,4,5), (Integer i)->System.out.println(i));
    	
    	List<Integer> ii =  FunctionTest.map(Arrays.asList("What","doesnot","kill","you","make","you","stronger"),
    			(String s)->s.length());
    	ii.forEach((Integer i)->System.out.println(i));
    	
    	
    }
}
