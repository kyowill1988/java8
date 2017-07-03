package com.example.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.DemoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class BookTests {
	
	
	@Test
	public void testBookBean(){
		
		Book book = new Book();
		System.out.println(book.getName());
		
	}
	
	
	
}
