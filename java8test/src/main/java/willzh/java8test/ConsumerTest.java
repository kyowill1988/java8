package willzh.java8test;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {
	
	public static <T> void ForEach(List<T> list,Consumer<T> c){
		
		for(T t : list){
			c.accept(t);			
		}		
	}
	
}
