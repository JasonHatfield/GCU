# Week 5: Discussion Question 1
Create a Java project that uses an ArrayList and a LinkedList. Show the most appropriate choice for inserting and deleting elements at the beginning of the list. Summarize your answers and explanation for how your code examples work in 300 words.
### ArrayList vs LinkedList
``` Java
import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedvsArrayLists {

	public static void main(String[] args) {
		
		ArrayList<String> arrayList = new ArrayList<>();
		LinkedList<String> linkedList = new LinkedList<>();
		
		arrayList.add("All");
		arrayList.add("great");
		arrayList.add("achievements");
		arrayList.add("require");
		arrayList.add("time.");
				
		linkedList.add("is");
		linkedList.add("the");
		linkedList.add("ultimate");
		linkedList.add("sophistication.");
		linkedList.addFirst("Simplicity"); // last input in linkedList, but will display first
		
		System.out.print("ArrayList: " + arrayList.toString() + "\n");
		System.out.print("ArrayList: " + linkedList);
	}
}
```
### Output
``` 
ArrayList: [All, great, achievements, require, time.]
ArrayList: [Simplicity, is, the, ultimate, sophistication.]
```
