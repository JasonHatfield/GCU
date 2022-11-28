# Week 5: Learning Goals
Skim over this week's reading. 

Look at the table of contents and/or index. 

What is a topic that you see that interest you the most?

## Response
In most of my discussions this week, I have been focusing on generics, but I am also very interested in ArrayLists and LinkedLists. An ArrayList is valuable and efficient if the program does not require objects at the beginning of the list to be inserted or removed. If this is the case, an Arraylist is the most efficient option. "If, however, [the] application requires the insertion or deletion of elements at the beginning of the list, you should choose [the] LinkedList" option (Liang, 2020, p. 784).

## Program Example
### LinkedvsArrayLists.java
``` Java
import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedvsArrayLists {

	public static void main(String[] args) {
		
		ArrayList<Integer> arrayList = new ArrayList<>();
		LinkedList<Integer> linkedList = new LinkedList<>();
		
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		arrayList.add(1); // cannot add this to the beginning of the list
		
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.addFirst(1); // last input in linkedList, but will display first
		
		System.out.print("ArrayList: " + arrayList + "\n");
		System.out.print("ArrayList: " + linkedList);
	}
}
```
### Output
```
 ArrayList: [2, 3, 4, 5, 1]
LinkedList: [1, 2, 3, 4, 5]
```
### Reference
