# Week 5: Discussion Question 1
Create a Java project that shows the benefits of using generic types besides the example from the activity. Summarize your answers and explanation for how your code examples work in 300 words.
### ArrayList vs LinkedList
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
