## Topic 3 - Discussion Question 2

What does the keyword final do on a class member variable?<br>
What does the keyword final do on a class method?<br>
What does the keyword final do on a class?<br>
Why would you want to mark a class or method as static?<br>

---
### Final Class Member Variable 

The keyword `final` has a variety of uses, including classes, class member variables, and class methods.

> "Final variables are nothing but constants. We cannot change the value of a final variable once it is initialized" (Singh, 2022).

The final class member variable is used to set a variable as constant. 

By instantiating the variable and declaring the variable as final, the data can no longer change.

#### Example
``` Java
public class Conversion {
	// the final keyword will restrict the program from changing the variable
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
#### Output
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
---
### Final Class
> "A class that is declared final cannot be subclassed. This is particularly useful, for example, when creating an immutable class like the String class" (Oracle, n.d.).

By annotating a class as final, the programmer is deciding to remove any chance for inheritance with this class. 

Adding the final keyword to the class means no subclasses can be created using the extends keyword. 

This option is useful when ensuring no data can be accidentally created in a subclass that should not be accessible from the final class.

#### Example
``` Java
//by adding the final keyword in the Animal class, we receive an error when compiling
//because the Chicken subclass can no longer access the Superclass Animal.
final class Animal {
	
	final void print() {
		System.out.println("Printing from the Animal class in the final print method.");
	}
}
//a compile error is thrown because Chicken can no longer inherit from Animal
class Chicken extends Animal {
	
}
```
#### Output
```
Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	Type mismatch: cannot convert from Chicken to Animal

	at Test.main(Test.java:4)
```
---
### Static Keyword
> "When a member is declared static, it can be accessed before any objects of its class are created, and without reference to any object" (GeeksforGeeks, 2021).

When creating a method, the programmer can call the method without the requirement of creating an object.

#### Example
``` Java
//this example is an excerpt from the Final Class Member Variable example above
public static void poundToKilogram(double pound) {
	System.out.printf("%.2f Pounds is equal to %.2f Kilograms.%n", pound, (pound / CONVERSION));
}
```
---
### References
GeeksforGeeks. (2021, December 2). static Keyword in Java. https://www.geeksforgeeks.org/static-keyword-java/ 

Oracle. (n.d.). Writing Final Classes and Methods (The JavaTM Tutorials > Learning the Java Language > Interfaces and Inheritance). Oracle Java Documentation. Retrieved November 11, 2022, from https://docs.oracle.com/javase/tutorial/java/IandI/final.html 

Singh, C. (2022, November 5). Final Keyword In Java – Final variable, Method and Class. BeginnersBook. https://beginnersbook.com/2014/07/final-keyword-java-final-variable-method-class/
