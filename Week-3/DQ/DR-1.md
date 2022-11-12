### Interfaces

For my simple code snippet, I decided to concentrate on the interface concept we learned this week.

#### AnimalInterface.java
``` Java
/**
 * @author Jason Hatfield
 * This is my original work.
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal = new Animal() {
		};
		
		animal.name();
		animal.eat();
	}
}
```
#### Animal.java
``` Java
/**
 * @author Jason Hatfield
 * This is my original work.
 */
public abstract class Animal implements AnimalInterface {
	public void name() {
		System.out.println("Printing from the name method in the animal class.");
	}
	
	public void eat() {
		System.out.println("Printing from the eat method in the animal class.");
	}
}
```
#### Main.java
``` java
/**
 * @author Jason Hatfield
 * This is my original work.
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal = new Animal() {
		};
		
		animal.name();
		animal.eat();
	}
}
```
### Output
``` plainlanguage
Printing from the name method in the animal class.
Printing from the eat method in the animal class.
```
