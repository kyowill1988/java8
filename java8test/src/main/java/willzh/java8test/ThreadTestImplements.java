package willzh.java8test;


public class ThreadTestImplements extends Thread {
		
	private String name;
	
	private int count = 5;

	public ThreadTestImplements(String name) {
		super();
		this.name = name;
	}
	
	public void run(){
		
		for(int i = 0;i< 5;i++){
			
			System.out.println("运行"+name+":"+ i + " count=" + count--);
			try{
				sleep((int) Math.random() * 10);
			}catch(InterruptedException e){
				e.printStackTrace();
			}			
		}
		
	}
	
	
	
	
	
}
