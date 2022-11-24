## Week 4: Discussion Response 4
Create a basic Program/code snippet using concepts from this week concepts. State the chapter, section, and concept demonstrated.
### File Input and Output
- Chapter 12
- Section 11
- File Input and Output

#### Input text from input.txt file
```
The quick brown fox jumps over the lazy dog.
```
#### FileIO.java Driver Class 
``` Java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {

	/*
	 * Program to read the contents of a file, reverse the order of the letters in the 
	 * string of the file and output to another file.
	 */
	public static void main(String[] args) {
		readFromFile();
	}
	/*
	 * reads the first line int he input.txt file and prints to the console
	 */
	public static void readFromFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
			
			String line = reader.readLine();
			reader.close();
			
			System.out.println(line + "\n");
			
			writeToFile(line);
			
		} catch (Exception e) {}
	}
	/*
	 * receives the line String, splits the string into a char[], reverses the order,
	 * and prints the results to the output.txt file and the console.
	 */
	public static void writeToFile(String line) {
		try {
			char[] ch = line.toCharArray();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
			
			for (int i = line.length() - 1; i > -1; i--) {
				System.out.print(ch[i]);
				writer.write(ch[i]);
			}
			
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```
#### Console Output
```
The quick brown fox jumps over the lazy dog.

.god yzal eht revo spmuj xof nworb kciuq ehT
```
#### output.txt Output
```
.god yzal eht revo spmuj xof nworb kciuq ehT
```
### Reference
Liang, D. Y. (2020). Introduction to Java Programming and Data Structures, Comprehensive Version Plus MyLab Programming with Pearson eText -- Access Card Package (12th ed.). Pearson.
