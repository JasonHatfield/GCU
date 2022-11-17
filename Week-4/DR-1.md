## Week 4: Discussion Response 1
Find a word, concept, or idea from this week’s reading that you’re unclear or desire better understanding. Research it and put the definition in your own words (150+ words minimum, use a reference and APA)

### The File Class
Understanding how to create, read from, and write to a file or a database is essential in managing data in a program. Because this topic is so important, I desire to become proficient in this concept. 
>"The File class contains the methods for obtaining the properties of a file/directory, and for renaming and deleting a file/directory" (Liang, 2020, p. 478).

There are many ways to write to a file, but the BufferedWriter option is the simplest. This method is easy to both create and write data to a file. Additionally, the BufferedReader option allows the program to read from a file. Combining these two tools offers many options to create, store, and manipulate data from a program.

Code Example:
``` Java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
	public static void main(String[] args) {
		try {
			/*
			 * creates a new FileWriter using the BufferedWriter Java.IO class,
			 * creates a new file called output.txt and provides the option to
			 * write data to the file
			 */
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
			
			writer.write("   J    a   v     v  a\n");
			writer.write("   J   a a   v   v  a a\n");
			writer.write("J  J  aaaaa   V V  aaaaa\n");
			writer.write(" JJ  a     a   V  a     a\n");
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			/*
			 * creates a new FileReader using the BufferedReader java.io class and
			 * reads from the output.txt file
			 */
			BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
			
			String line = reader.readLine();
			// while loop to continuously read and display each line to the console
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
		}
	}
}
```
output.txt Output:
```
   J    a   v     v  a
   J   a a   v   v  a a
J  J  aaaaa   V V  aaaaa
 JJ  a     a   V  a     a
 ```

Console Output:
```
   J    a   v     v  a
   J   a a   v   v  a a
J  J  aaaaa   V V  aaaaa
 JJ  a     a   V  a     a
```
### Reference
Liang, D. Y. (2020). Introduction to Java Programming and Data Structures, Comprehensive Version Plus MyLab Programming with Pearson eText -- Access Card Package (12th ed.). Pearson.
