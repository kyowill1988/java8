package willzh.java8test;

public class BlockTest {
	
	private int i = 100;
	
	static{
		System.out.println("--静态初始化块--");
		
	}
	
	{
		Inner inner = new Inner();
		inner.show();
		System.out.println("--非静态初始化块--");
	}
	
	public BlockTest(){
		System.out.println("--无参构造函数--");
	}
	
	public BlockTest(String name){
		System.out.println("--带参构造函数--");
	}
	
	public class Inner{
		
		private int i = 10;
		
		public Inner(){
			
		}
		
		public void show(){
			System.out.println(i);
			System.out.println(this.i);
			System.out.println(BlockTest.this.i);
		}
		
	}
	
}
