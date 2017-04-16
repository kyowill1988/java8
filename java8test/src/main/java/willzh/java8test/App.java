package willzh.java8test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import javax.mail.MessagingException;

import static java.util.stream.Collectors.toList;

public class App 
{
	public static void main( String[] args ) throws MessagingException
	{     
		Mail.sendMail();
		
		
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

		inventory.sort(Comparator.comparing(Apple::getWeight));
		System.out.println("One");
		for(Apple apple : inventory){
			System.out.println(apple);    		
		}

		inventory.sort(Comparator.comparing(Apple::getWeight).reversed()
				.thenComparing(Apple::getColor).reversed());
		System.out.println("Two");
		for(Apple apple : inventory){
			System.out.println(apple);    		
		}

		Function<Integer,Integer> f = x->x+1;
		Function<Integer,Integer> g = x->x*2;
		Function<Integer,Integer> h = f.andThen(g);
		System.out.println("h="+h.apply(1));//print 4
		
		Function<Integer,Integer> f2 = x->x+1;
		Function<Integer,Integer> g2 = x->x*2;
		Function<Integer,Integer> h2 = f2.compose(g2);
		System.out.println("h2="+h2.apply(1));//print 3
		
		
		

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


		Runnable r = ()->{System.out.println("How do you do~");};
		r.run();


	}
}
