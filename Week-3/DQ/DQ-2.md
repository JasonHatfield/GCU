## Topic 3 - Discussion Question 1

What does the keyword final do on a class member variable?<br>
What does the keyword final do on a class method?<br>
What does the keyword final do on a class?<br>
Why would you want to mark a class or method as static?<br>
Summarize your answers and rationale in 400 words.

---
### Class Member Variable 

The keyword `final` has a variety of uses, including classes, class member variables, and class methods.

> "Final variables are nothing but constants. We cannot change the value of a final variable once it is initialized" (Singh, 2022).

The final class member variable is used to set a variable as constant. 

By instantiating the variable and declaring the variable as final, the data can no longer change.

---
#### Example
``` Java
public class Conversion {
	// the final keyword will restrict the program from chaning the variable
  final static double CONVERSION = 2.2046226218;
	
	public static void main(String[] args) {
		poundToKilogram(5);
		kilogramToPound(25);
	}
	
	public static void poundToKilogram(double pound) {
		System.out.printf("%.2f Pounds is equal to %.2f Kilograms.%n", pound, (pound / CONVERSION));
	}
	
	public static void kilogramToPound(double kilogram) {
		System.out.printf("%.2f Kilograms is equal to %.2f Pounds.%n", kilogram, (kilogram * CONVERSION));
	}
}
```
### Output
```
5.00 Pounds is equal to 2.27 Kilograms.
25.00 Kilograms is equal to 55.12 Pounds.
```
---
### Final Class Method
A final class method is a method that cannot be overwritten by another method. 

For example, if a sub-class calls a final method through inheritance in the superclass, there will be no problem; however, no changes are possible to the final method inside the superclass.

#### Example
``` Java	     
class Test {  
   public static void main(String[] args) {
	   // creates a new Chicken of type Animal
	   Animal chicken = new Chicken();
	   // calls the inherited chicken print method from the Animal superclass
	   chicken.print();
   }
}

class Animal {
	// final keyword locks this method so it cannot be changed
	final void print() {
		System.out.println("Printing from the Animal class in the final print method.");
	}
}

class Chicken extends Animal {
	
}
```
#### Output
```
Printing from the Animal class in the final print method.
```
