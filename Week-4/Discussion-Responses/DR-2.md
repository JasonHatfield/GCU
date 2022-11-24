## Week 4: Discussion Response 2
- What is the best practice?
- Chapter or assignment relating?
- Where did you learn the best practice: research, school, work, friends
- no minimal word count
- APA reference required.
### Best Practice: Try/Catch Block
Chapter 12 of the course text covers handling exceptions with a try/catch block in Java. When programming, if there is a chance for the program to throw an exception, the best practice is to surround the code with a try/catch block. Additionally, to improve on this best practice, it is best to refer to a method in a try statement and address any exception in the catch exception statement. 

>"The try block contains the code that is executed in normal circumstances. The catch block contains the code that is executed in exceptional circumstances" (Liang, 2020, p. 472). 

I learned this concept in my C# class, and I incorporate the try/catch block into my code when I use the scanner to allow a user to input data.

### Code Example
``` Java
public class TryCatch {
	public static void main(String[] args) {
		
		try {
			getInt();
			System.out.println("After parsing the string statement");
		} catch(NumberFormatException | NullPointerException e) {
			System.out.println("No integer can be made from this!");
		} 
		System.out.println("\nEnd here.");
		}
	
	public static void getInt() {
		int myInt = Integer.parseInt("not an integer");
	}
}
```
### Output
``` 
No integer can be made from this!

End here.
```
### Reference:
Liang, Y. (2019). Introduction to Java Programming and Data Structures, Comprehensive Version (12th ed.). Pearson.
