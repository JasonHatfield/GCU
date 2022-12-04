# Week 6: Learning Goals
Skim over this week's reading. Look at the table of contents and/or index. What is a topic that you see that interest you the most? (150+ words minimum, use a refence or quote, APA reference)
### Response
Multithreading is the topic that I want to learn more about this week. Until now, we have learned how to run code line by line, and simultaneously running multiple threads can be very useful in a program. By implementing the Thread class in Java, the program can create multiple instances of the same object and then run those instances simultaneously. For example, if we were to create a class named MultiThread with instances in the main class method names thread1 and thread 2, we could call the thread simultaneously for each method.

In the following example, the program iterates over four threads and prints the results to the console five times. 

### MultiThread.java
``` Java
public class MultiThread {

	public static void main(String[] args) {
		System.out.println("The threads are all running simulataneously"
				+ ", so there is no continuity for the order they will run.");
		for (int i = 0; i <=3; i++) {
			Thread1 thread = new Thread1(i);
			thread.start();
		}
	}
}
```
### Thread1.java
``` Java
public class Thread1 extends Thread {
	private int threadNumber;
	
	public Thread1 (int threadNumber) {
		this.threadNumber = threadNumber;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + " from thread " + threadNumber);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
```
### Console Output
```
The threads are all running simulataneously, so there is no continuity for the order they will run.
1 from thread 1
1 from thread 2
1 from thread 0
1 from thread 3
2 from thread 1
2 from thread 2
2 from thread 3
2 from thread 0
3 from thread 2
3 from thread 1
3 from thread 3
3 from thread 0
4 from thread 2
4 from thread 1
4 from thread 3
4 from thread 0
5 from thread 2
5 from thread 1
5 from thread 3
5 from thread 0
```
