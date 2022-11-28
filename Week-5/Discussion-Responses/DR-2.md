# Week 5: Create a Program
Create a basic Program/Code snippet using concepts from this week. 

Please state concept, chapter and section and what one can do with the code snippet.

### Response
- **Concept**: Generics
- **Chapter**: 19
- **Section**: 19.4

Generics provide the programmer with additional reusability in their code. In the example below, one class is used to print two different parameter types. 

If generics were not implemented, two separate classes would be required (one for each parameter), to get the same results.

### Main.java
``` Java
public class Main {
	public static void main(String[] args) {
		
		Printer<Integer> printInteger = new Printer<>(10525);
		Printer<String> printString = new Printer<>("The only easy day was yesterday.");
		
		printInteger.print();
		printString.print();
	}
}
```

### Printer.java
``` java
public class Printer <T> {
	T print;
	
	public Printer(T print) {
		this.print = print;
	}
	
	public void print() {
		System.out.println("Printing from the Printer.java class: " + print);
	}
}
```
### Output
``` 
Printing from the Printer.java class: 5
Printing from the Printer.java class: The only easy day was yesterday.
```
