package willzh.java8test;

public class ThreadTestForRunnable implements Runnable {

	private String name;
	
	private int count = 5;
	
	public ThreadTestForRunnable(){
		
	}
	
	public ThreadTestForRunnable(String name) {
		super();
		this.name = name;
	}


	@Override
	public void run() {
		
		for(int i = 0;i< 5;i++){

			System.out.println("运行"+Thread.currentThread().getName()+":"+ i + " count=" + count--);
			try{
				if(i== 3){
					Thread.yield();
				}
				
				Thread.sleep((int) Math.random() * 10);
			}catch(InterruptedException e){
				e.printStackTrace();
			}			
		}

	}



}
