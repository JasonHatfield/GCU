# Week 5: Discussion Question 1
Create a Java project that uses an ArrayList and a LinkedList. 

Show the most appropriate choice for inserting and deleting elements at the beginning of the list.
### ArrayList vs LinkedList
The ArrayList is part of the java.util package and derives from the Java collection framework. The ArrayList is advantageous when the programmer has a list that can grow or shrink. For example, when creating an array, a size declaration is required, but using an ArrayList removes the limitation in the array entirely. In addition, when the ArrayList has a new object added, the list expands to accommodate the newly required size. Any object can be removed from the ArrayList as long as the object's location or exact name is known. When adding an element, the typical run time is O(n). When retrieving an element, the time required is O(1), which is the main benefit of using an ArrayList. (GeeksforGeeks, 2022)

A LinkedList behaves in much the same way as an ArrayList. However, a critical difference between the two is that the LinkedList implements a doubly-linked list. Therefore, the LinkedList can add objects to the bottom and top of the stack. This method allows the getFirst() and getLast() methods to call data from the bottom or the top of the stack. Other benefits of using the LinkedList method are using the Iterator.remove(), removeFirst(), and removeLast().

Deciding to use either of these list types depends on the type of data added or accessed and the list size. For example, the LinkedList requires more system resources to compile, whereas the ArrayList requires less. However, the benefits of using a LinkedList outweigh the ArrayList in most cases, and choosing a LinkedList provides more data implementation and manipulation options. (Tran, 2008)
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
		
		System.out.print("ArrayList: " + arrayList + "\n");
		System.out.print("ArrayList: " + linkedList);
	}
}
```
### Output
``` 
ArrayList: [All, great, achievements, require, time.]
ArrayList: [Simplicity, is, the, ultimate, sophistication.]
```
### References
GeeksforGeeks. (2022, November 18). ArrayList in Java. https://www.geeksforgeeks.org/arraylist-in-java/

Tran, J. (2008, November 27). When to use LinkedList over ArrayList in Java? Stack Overflow. https://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist-in-java
