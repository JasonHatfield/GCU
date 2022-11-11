### What is meant by the statement “class abstraction is the separation of class implementation from the use of a class”? 

Illustrate your answer with a Java class.
---

Liang explains that a program's inner working is hidden from a user through encapsulation, and the user does not need to know how the program works to complete tasks. (2019) For example, if a person takes a liquid capsule containing medicine, the pill's exterior encapsulates the medicine within. Therefore, the patient does not need to know how the medicine inside works, only that they need to take the pill in order to start the process.

The following example of a program shows that when a user activates a method to accelerate, the program automatically speeds the car up to a predetermined speed:


``` Java
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
  ```


Reference:

Liang, Y. (2019). Introduction to Java Programming and Data Structures, Comprehensive Version (12th ed.). Pearson.
