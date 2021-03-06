package willzh.java8test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.mail.MessagingException;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.sql.Date;

import static java.util.Comparator.comparing;

/**
 * 
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  App.java   
 * @Package willzh.java8test   
 * @Description: 测试代码   
 * @author: willzh     
 * @Copyright: 2017 www.tydic.com Inc. All rights reserved.
 */
public class App 
{
	public static void main( String[] args ) throws MessagingException, IOException, InstantiationException, IllegalAccessException
	{     		
		System.out.println(ExceptionTest.test("1"));
		System.out.println(ExceptionTest.test(null));
		
		BlockTest blt = new BlockTest();
		BlockTest blt2 = new BlockTest("ttt");
		
		
		System.out.println(System.currentTimeMillis());
		
		PrintTest test = new PrintTest();
		Class ctest = test.getClass();
		
		try {
			test.print(1, 1);
			Method method = ctest.getMethod("print", int.class,int.class);
			method.invoke(test, 1,1);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		ReflectionTest.foo();
		IntegerTest.foo();
		BigDecimalTest.foo();
		SwitchTest.foo();
		
		//String workerName = "willzh.java8test.WordWorker";
		String workerName = "willzh.java8test.ExcelWorker";
		
		try {
			Class worker = Class.forName(workerName);
			OfficeAble officeWorker = (OfficeAble) worker.newInstance(); 
			officeWorker.start();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		ABase ab = new ABase();
		System.out.println(ab.getId());
		//reflection
		System.out.println(ab.getClass());
	    //test batch command
		//twice one two three
		//there is a class named class
		Class c1 = ABase.class;
		try {
			Class c3 = Class.forName("willzh.java8test.ABase");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ABase abc = (ABase)c1.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ABase bb = ab;
		System.out.println(bb.getId());
		
		Class c2 = bb.getClass();
		System.out.println(c1==c2);
		
		System.out.println("main主线程开始");
		
		ThreadTestImplements t11 = new ThreadTestImplements("t11");
		ThreadTestImplements t21 = new ThreadTestImplements("t21");
		t11.start();
		t21.start();
		
		try{
			t11.join();		
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		
		try{
			t21.join();			
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		
		new Thread(new ThreadTestForRunnable("A")).start();
		new Thread(new ThreadTestForRunnable("B")).start();
		
		ThreadTestForRunnable my = new ThreadTestForRunnable();
		new Thread(my,"C").start();
		new Thread(my,"D").start();
		new Thread(my,"E").start();
		
		System.out.println("main主线程结束");
		
		StringTest.tryIndexOf();
		
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
		
		List<String> appleColorNames = inventory.stream()
		.filter(d->d.getWeight() > 10)
		.sorted(comparing(Apple::getWeight))
		.map(Apple::getColor)
		.distinct()
		.collect(toList());
		
		System.out.println("TestCount:"+inventory.stream().count());
		Double totalWeight = inventory.stream().map(Apple::getWeight).reduce(Double::sum).get();
		System.out.println("totalWeight="+totalWeight);
		
		Map<String, List<Apple>> otherApples = inventory.stream().collect(Collectors.groupingBy(Apple::getColor));
		
		
		
		appleColorNames.forEach((String name)->System.out.println(name));
		
		List<Dish> menu = Arrays.asList(
				new Dish("pork",false,800,Dish.Type.MEAT),
				new Dish("beef",false,700,Dish.Type.MEAT),
				new Dish("chicken",false,400,Dish.Type.MEAT),
				new Dish("french fries",true,530,Dish.Type.OTHER),
				new Dish("rice",true,350,Dish.Type.OTHER),
				new Dish("season fruit",true,120,Dish.Type.OTHER),
				new Dish("pizza",true,550,Dish.Type.OTHER)
				);
		
		//前三个高热量的菜名
		List<String> filterDishNames = menu.stream().filter(d->d.getCalories() > 300)
			.limit(3)
			.map(Dish::getName)
			.collect(toList());
		filterDishNames.forEach(System.out::println);
		
		menu.stream()
			.filter(d->d.getCalories()> 20)
			.map(Dish::getName)
			.skip(3)
			.forEach(System.out::println)
			;
		
		//筛选出前两个荤菜
		System.out.println("筛选出前两个荤菜");
		menu.stream()
		.filter(d->d.getType() == Dish.Type.MEAT)
		.map(Dish::getName)
		.limit(2)
		.forEach(System.out::println)
		;
	
		menu.stream()
			.map(Dish::getName)
			.map(String::length)
			.forEach(System.out::println)
			;
		
		//扁平化
		System.out.println("扁平");
		menu.stream()
			.map(Dish::getName)
			.map(w->w.split(""))
			.flatMap(Arrays::stream)
			.distinct()
			.forEach(System.out::println);
		
		System.out.println("All less than 1000 calories? "+menu.stream().allMatch(d->d.getCalories() < 1000));
		System.out.println("All less than 100 calories? "+menu.stream().allMatch(d->d.getCalories() < 100));
		
		menu.stream()
			.filter(Dish::isVegetarian)
			.findAny()
			.ifPresent(d->System.out.println(d.getName()))
			;
			
		
		
		
		
		List<Integer> numbers2 = Arrays.asList(1,2,3,4,5);
		numbers2.stream()
			   .map(n->n*n)
			   .forEach(System.out::println);
		
		System.out.println(numbers2.stream().reduce(1,(a,b)->a*b));
		System.out.println(numbers2.stream().reduce(0,Integer::sum));
		
		System.out.println(numbers2.stream().reduce(Integer::max));
		System.out.println(numbers2.stream().reduce(Integer::min));
		System.out.println(numbers2.stream().reduce(Integer::min).orElse(0));
		
		System.out.println(numbers2.size());
		System.out.println(numbers2.stream()
			.map(d->1)
			.reduce(0,(a,b)->a+b));
		System.out.println(numbers2.stream().count());
		
		IntStream ns = IntStream.rangeClosed(1, 5);
	    System.out.println("factorial="+ns.reduce(1,(a,b)->a*b));
	    
	    Stream<int[]> pythagoreanTriples =
	    IntStream.rangeClosed(1, 100).boxed()
	    	.flatMap(a-> IntStream.rangeClosed(1, 100)
	    	    	.filter(b->Math.sqrt(a*a+b*b) % 1 == 0)
	    	    	.mapToObj(b->new int[]{a,b,(int)Math.sqrt(a*a+b*b)}));
	    
	    //TODO DEBUG pythagoreanTriples.forEach(t->System.out.println(t[0]+","+t[1]+","+t[2]));
	    Stream.iterate(1, n->n +2)
	    	.limit(10)
	    	.forEach(System.out::println);
	    
	    //TODO Tomorrow
	    
	    
		
		List<String> streamTest = filterDishNames;
		Stream<String> stream = streamTest.stream();
		stream.forEach(System.out::println);
        //stream.forEach(System.out::println); 流已被操作，只能遍历一次
		
		
		

	}
}
