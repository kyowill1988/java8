package willzh.java8test;

public class BlockTest {
	
	static{
		System.out.println("--静态初始化块--");
	}
	
	{
		System.out.println("--非静态初始化块--");
	}
	
	public BlockTest(){
		System.out.println("--无参构造函数--");
	}
	
	public BlockTest(String name){
		System.out.println("--带参构造函数--");
	}
	
}
