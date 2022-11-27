# Week 5: Discussion Question 2
Create a Java project that shows the benefits of using generic types besides the example from the activity. Summarize your answers and explanation for how your code examples work in 300 words.
### Generic Types
The purpose of a generic (or parameterized) type "is to allow type (Integer, String, ... etc., and user-defined types) to be a parameter to methods, classes, and interfaces" (Geeks4Geeks, 2022). The benefit of using generic types is that you can pass various parameters to a method or a class. For example, this method will allow the program to have one method, like a print method, that can accept more than one parameter. The benefit is that the program can reuse the same code for different situations, no matter the parameter passed to the method or class.

The method or class takes a parameter, performs an action, performs a task, then returns a value. Naming conventions have been incorporated for generic parameters to ensure uniformity in Java during development. (Geeks4Geeks, 2022).
T - Type
E - Element
K - Key
N - Number
V - Value

In addition to the reusability of code, using generics cause errors to appear while the code is compiled. If a generic parameter is not used and a raw parameter is passed, the possibility of a runtime error increases significantly. Therefore, the programmer can use the generic parameter to catch the bug before the program compiles.

``` Java
public class Generics {

	public static void main(String[] args) {
		String[] string = {"Jason", "Michael", "Hatfield"};
		Integer[] integer = {1, 2, 3, 4};
		print(string);
		print(integer);
	}
	
	public static <E> void print(E[] e) {
		for (E print : e) {
			System.out.println(print);
		}
	}
}
```
### Output
``` 
Jason
Michael
Hatfield
1
2
3
4
```
### References
GeeksforGeeks. (2022, February 9). Generics in Java. https://www.geeksforgeeks.org/generics-in-java/ Oracle. (n.d.). 

Why Use Generics? https://docs.oracle.com/javase/tutorial/java/generics/why.html
