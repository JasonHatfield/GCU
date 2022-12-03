# Week 6: Discussion Question 2
## Response
> Asynchronous programming "is a multithreaded model that[ is] most applicable to netwokring and communications" (Bevans, 2022, para. 2). 

When operations are in progress, asynchronous programming does not block the ongoing execution of those operations. Therefore, asynchronous programming is a non-blocking architecture. For example, when two people text back and forth using a messaging application on their phones, this is a form of asynchronous programming. After one person sends a message to the other, the receiving person can wait to respond while completing other activities on their device. (Bevans, 2022).

> "Multithreading in Java is a process of executing multiple threads simultaneously" (javaTpoint, n.d.). 

Since a thread is the smallest unit in processing and is also independent, the program can complete many operations simultaneously (multi-tasking) using multithreading. As a result, complex programs consistently access many files to make the program perform as expected, and by using multithreading, the program can run more efficiently. Therefore, by simultaneously executing as many threads as needed, the program maximizes the utilization of the CPU, resulting in a performance improvement.

## Code Example: Multi-Threading (inspired by (Hartman, 2022))
### Main.java
``` Java
public class Main {
	public static void main(String[] args) {
		Thread1 thread1 = new Thread1("Thread One");
		Thread1 thread2 = new Thread1("Thread Two");

		thread1.start();
		thread2.start();
	}
}
```
### Thread1.java
``` Java
package multiThreading;

public class Thread1 implements Runnable {
	Thread thread;
	private String threadName;
	
	Thread1(String threadName) {
		this.threadName = threadName;
	}
	
	@Override
	public void run() {
		System.out.println("Thread running: " + threadName);
		
		for (int i = 0; i < 4; i++) {
			System.out.println(i);
			System.out.println(threadName);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Thread has been interrupted");
			}
		}
	}
	
	public void start() {
		System.out.println("Thread started");
		
		if (thread == null) {
			thread = new Thread(this, threadName);
			thread.start();
		}
	}
}
```
### Output
```
Thread started
Thread started
Thread running: Thread One
Thread running: Thread Two
0
Thread Two
0
Thread One
1
Thread Two
1
Thread One
2
Thread Two
2
Thread One
3
Thread Two
3
Thread One
```
## References
Bevans, D. (2022, October 14). Asynchronous vs. Synchronous Programming: Key Similarities and Differences. Mendix. https://www.mendix.com/blog/asynchronous-vs-synchronous-programming/ 

Hartman, J. (2022, November 5). Multithreading in Java Tutorial with Program & Examples. Guru99. https://www.guru99.com/multithreading-java.html 

javaTpoint. (n.d.). Multithreading in Java - javatpoint. https://www.javatpoint.com/multithreading-in-java
