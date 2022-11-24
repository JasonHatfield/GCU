## Week 4: Discussion Response 5
In 150+ words summarize this weeks reading. Use a quote amd APA referencing.
### Handling Exceptions
This week's reading summarizes handling exceptions and exploring the file class. 

> "A method should throw an exception if the errors needs to be handled by its caller" (Liang, 2020, p. 494). 

When the possibility of an exception exists when the program compiles and runs, the programmer must anticipate a possible exception and handle it using a try block. The code in the try block handles code under nominal conditions; however, when an error occurs, the code within the try block will handle the exception.

#### Code Example: 
``` Java
public class Exception {
	public static void main(String[] args) {
		int i = 10;
		int j = 0;
		
		try {
			System.out.println(i / j);
		} catch (ArithmeticException ae) {
			System.out.println("Cannot divide by zero.");
		}
	}
}
```
#### Output
```
Cannot divide by zero.
```
### The File Class
> "The File class contains the methods for obtaining the properties of a file/directory, and for renaming and deleting a file/directory" (Liang, 2020, p. 478). 

The ability to read from a file and write the output of a program to another file or alter the original file's contents in Java is powerful. In addition, data can be stored and accessed externally from Java so that the program can access and alter perpetual data from another source. 

#### Code Example:
``` Java
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class File {
	public static void main(String[] args) {
		readFile();
	}
	
	/**
	 * Reads from the file input.txt and sends the data to be reversed and
	 * written to the output.txt file 
	 */
	public static void readFile() {
		try {
			FileReader fileInput = new FileReader("input.txt");
			
			Scanner reader = new Scanner(fileInput);
			
			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				System.out.printf("Original: %s", data);
				reverseText(data);
				writeFile(data);
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes the reversed string to the output.txt file
	 * @param data
	 */
	public static void writeFile(String data) {
		try {
			FileWriter writer = new FileWriter("output.txt");
			writer.write(data);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reverses the inputted string.
	 * @param data
	 */
	public static void reverseText(String data) {
		StringBuilder dataInput = new StringBuilder();
		
		dataInput.append(data);
		
		dataInput.reverse();
		
		System.out.printf("\n\n Reverse: %s", dataInput);
	}
}
```
#### Output
```
Original: Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
 
 Reverse: .auqila angam erolod te erobal tu tnudidicni ropmet domsuie od des ,tile gnicsipida rutetcesnoc ,tema tis rolod muspi meroL
```
### Reference:
Liang, D. Y. (2020). Introduction to Java Programming and Data Structures, Comprehensive Version Plus MyLab Programming with Pearson eText -- Access Card Package (12th ed.). Pearson.
