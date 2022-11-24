## Topic 3 - Discussion Question 1

What are some reasons a programmer might decide to declare a class as abstract? 
<br>What are some reasons a programmer might decide to declare a class as an interface?

--- 
#### Abstract
> "An abstract class cannot be used to create objects. An abstract class can contain abstract methods that are implemented in concrete subclasses" (Liang, 2019, p. 501).

If the programmer uses an abstract class, this implementation restricts the class from creating objects directly. The benefits of using an abstract class are that the class contains the blueprints of an object but passes those onto subclasses through inheritance. 

By creating abstract methods in the abstract class, any subclasses must contain those methods for the program to compile. 

Another benefit of using abstraction is `encapsulation`, which hides the inner working of the superclass. 

A disadvantage of using an abstract class is that objects cannot be created directly in the class and must be created in the subclass.

---
#### Interface
> "An `interface` is for defining common behavior for classes (including unrelated classes)" (Liang, 2019, p. 500)
An interface is a separate file available to the programmer with many similarities to the abstract class. 

The void methods contained in this file will require any classes to implement those methods before the program can compile. 

The benefit of using this interface is that when a class is created, it must follow the outlined requirements in the interface. 

A drawback is that this option provides an additional restriction to classes and will require specific implementation.

---
### Example
``` Java
public class TestEdible {
	
	public static void main(String[] args) {
		// creates an array of objects
    Object[] objects = {new Tiger(), new Chicken(), new Apple(),
				new Orange()};
		
		for (int i = 0; i < objects.length; i++) {
			if (objects[i] instanceof Edible) {
				System.out.println(((Edible)objects[i]).howToEat());
			} else {
				System.out.println("Object is not edible");
			}
		}
	}
}

class Animal {
	private double weight;
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
// 'extends' calls the superclass Animal
// 'implements' calls the interface class Edible
class Chicken extends Animal implements Edible {

	@Override
	public String howToEat() {
		return "Chicken: Fry it";
	}
}

class Tiger extends Animal {
	
}

abstract class Fruit implements Edible {
	
}

class Apple extends Fruit {

	@Override
	public String howToEat() {
		return "Apple: Make apple cider";
	}
}

class Orange extends Fruit {

	@Override
	public String howToEat() {
		// TODO Auto-generated method stub
		return "Orange: Make orange juice";
	}
}
```
Output
``` 
Object is not edible
Chicken: Fry it
Apple: Make apple cider
Orange: Make orange juice
```
---
### Reference
Liang, Y. (2019). Introduction to Java Programming and Data Structures, Comprehensive Version (12th ed.). Pearson.
