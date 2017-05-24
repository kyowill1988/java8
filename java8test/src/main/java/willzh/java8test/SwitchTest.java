package willzh.java8test;

public class SwitchTest {

	public static void foo(){

		String input = "c";
		
		switch(input){
			case "a":
				System.out.println("This is an apple !");
				break;
			case "b":
				System.out.println("This is a banana !");
				break;
			default:
				System.out.println("out of range");
				break;
		}

	}



}
