package willzh.java8test;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        
//        File[] hiddenFiles = new File(".").listFiles(File:: isHidden);
//        for(File f : hiddenFiles){
//        	System.out.println(f.getName());        	
//        }        
        
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
        
    }
}
