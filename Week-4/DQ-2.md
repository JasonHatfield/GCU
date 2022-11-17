### Week 4: Discussion Question 2

What do pass by reference and pass by value mean in the Java programming language? Does Java pass by reference or pass by value? Provide code examples to show both cases. Summarize your answers and explanation for how your code examples work in 300 words.

### Passed by Value vs. Passed by Reference in Java
Answering the question of whether or not Java passes by reference or passes by value seems ambiguous. Generally, most of the resources I have found while researching this question point to Java passing by value and not by reference. Passing by value means that one method passes a variable's value into another. 

However, this concept becomes confusing because 

>"Java creates a copy of references and passes it to a method, but they still point to the same memory reference" (GeeksforGeeks, 2022). 

So what happens is Java passes references by value.

### Code Example with Explanation
#### PassByValue.java Class
``` Java
public class PassByValue {
	public static void main(String[] args) {
		// creates a new value
		Value value = new Value();
		
		/* 
		 * sets the value to a primitive int of 10 through the Value.java
		 * class setter method
		 */
		value.setValue(10);
		
		System.out.println("Original value object: " + value.getValue());
		
		// passes reference by value
		increaseValue(value);
		
		System.out.println("\nIncreased original value object in the main "
				+ "method: " + value.getValue());
	}
	/*
	 * private method that references the memory address of the value passed in
	 * although this seems like it is passed by reference, it is actually
	 * passed by value from the referenced memory address
	 */
	private static void increaseValue(Value value) {
		/* 
		 * increases the passed value by one because it references the same
		 * address location in memory as the value passed into the method
		 */
		value.setValue(value.getValue() + 1);
		
		// create a new object at a different memory address
		value = new Value();
		value.setValue(5);
		/*
		 * although a new value object is created, the original value is not 
		 * altered because the new value object has a separate address in 
		 * memory from the original object
		 */
		
		System.out.println("\nNew value object in the increseValue method: " 
				+ value.getValue());
	}
}
``` 
#### Value.java Class
``` Java
/*
 * Getter and Setter for the Value object.
 */
public class Value {
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
```
#### Output
```
Original value object: 10

New value object in the increseValue method: 5

Increased original value object in the main method: 11

```
### Reference
GeeksforGeeks. (2022, August 5). Java is Strictly Pass by Value! https://www.geeksforgeeks.org/g-fact-31-java-is-strictly-pass-by-value/
