/**
 * 
 * @author Jason Hatfield
 * This is my original work.
 */

public class HelloWorld {
	
	private void sayHello(String name) {
		System.out.println("Hello, my name is " + name + ".");
	}
	
	public static void main(String[] args) {
		HelloWorld hello = new HelloWorld();
		hello.sayHello("Jason Hatfield");
	}

}
