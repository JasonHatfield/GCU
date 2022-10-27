
/**
 * @author Jason Hatfield
 * This is my original work.
 */
import java.util.Scanner;

public class Car {
	Scanner input = new Scanner(System.in);
	/**
	 * constructor bringing in the engine and tires.
	 * @param engine
	 * @param tire
	 */
	public Car(Engine engine, Tire[] tire) {
	}
	
	/**
	 * method to inform the user the car is ready for the engine
	 * to turn on.
	 */
	public void ready() {
		int userInput = 0;

		System.out.println("STATUS: Your car is ready to drive!");
		System.out.print("\nPress 1 to turn the engine on: ");

		userInput = input.nextInt();

		if (userInput == 1) {
			on();
		} else {
			ready();
		}
	}
	
	/**
	 * method to turn the engine on
	 */
	public void on() {
		int userInput = 0;
		System.out.println("\nSTATUS: Your car's engine is now running!");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.print("\nPress 1 to accelerate, or 2 to turn the engine off: ");

		userInput = input.nextInt();

		if (userInput == 1) {
			accelerate();
		} else if (userInput == 2) {
			off();
		} else {
			on();
		}

	}

	/**
	 * method to accelerate the car to 60 miles per hour
	 * also gives the user the option to turn the engine off.
	 */
	public void accelerate() {
		int sleepTime = 1000;

		System.out.println("\nSTATUS: Your car is accelerating...\n");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 60; i++) {
			System.out.println("Speed: " + (i + 1) + " MPH");

			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			sleepTime = (int) (sleepTime - (sleepTime * 0.05));
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		cruise();
	}

	/**
	 * method to tell the user the car is at 60 miles per hour
	 * gives the user the option to stop the car
	 */
	public void cruise() {
		System.out.println("\nSTATUS: Your car is now cruising at 60 MPH.");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.print("\nPress 1 when you are ready to stop your car: ");

		if (input.nextInt() == 1) {
			decelerate();
		} else {
			cruise();
		}
	}

	/**
	 * method to decelerate the car to a stop
	 */
	public void decelerate() {
		int sleepTime = 50;

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\nSTATUS: Your car is decelerating...\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 60; i > 0; i--) {
			System.out.println("Speed: " + (i) + " MPH");

			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			sleepTime = (int) (sleepTime + (sleepTime * 0.05));
		}

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\nSTATUS: Your car has stopped.");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		decision();
	}

	/**
	 * method to give the user the option to either accelerate again or to
	 * stop the engine.
	 */
	public void decision() {
		int userInput = 0;

		System.out.print("\nTo accelerate again, press 1, or press 2 to stop "
				+ "the engine: ");

		userInput = input.nextInt();

		if (userInput == 1) {
			accelerate();
		} else if (userInput == 2) {
			off();
		} else {
			decision();
		}
	}
	
	/**
	 * method to give the user the option to turn the engine on again
	 */
	public void off() {
		System.out.println("\nSTATUS: Your car is turned off.\n");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.print("Press 1 to turn the engine on: ");

		if (input.nextInt() == 1) {
			on();
		} else {
			off();
		}
	}
}