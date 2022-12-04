# Week 6: Vocabulary
Find a word, concept, or idea from this week’s reading that you’re unclear or desire better understanding. Research it and put the definition in your own words.

### Response
The concept from this week that I want to know more about is the Java NIO AsynchrousFileChannel. This new option allows Java to read and write data to and from files asynchronously. As a result, "asynchronous channels are safe for use by multiple concurrent threads" (tutorialspoint, n.d.). Asynchronous means there is no timing requirement for transmission, and the read/write functions can happen independently.

The two approaches require the importation of the java.util.concurrent.Futureobject and java.nio.channels.CompletionHandler classes. The Futureobject class returns and the CompletionHandler class passes. The interface in the Futureobject class has a get() method "which returns the status of operation that is handled asynchronously on the basis of which further execution of other task could get decided" (tutorialspoint, n.d.).

The following example shows how the AsynchronousFileChannel class can read and write from a file:

### Code Example
#### temp.txt file original content
```
"Optimism is the faith that leads to achievement. Nothing can be done without hope and confidence." - Helen Keller
```
#### AsyncFileChannel.java
``` Java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * This program reads the contents of a file, prints the contents of the 
 * file to the console in reverse order, replaces the contents of the file 
 * with the reverse string, and prints the new contents back to the console.
 * @author Jason Hatfield
 * This is my original work.
 */
public class AsyncFileChannel {
	static final String FILE_PATH = "src/temp.txt";
	static Path filePath = Paths.get(FILE_PATH);
	static ByteBuffer buffer = ByteBuffer.allocate(1024);
	
	/**
	 * Main method to execute reading from a file, reversing the contents
	 * overwriting the original contents of the file witht he reversed string
	 * and printing the new results to the console.
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void main(String[] args) throws IOException,
				InterruptedException, ExecutionException {
		String fileContent = readFromFile(filePath);
		
		System.out.println("Original: " + fileContent);
		
		fileContent = reverseString(fileContent); 
		
		writeToFile(fileContent);
		
		System.out.println("\nNew: " + fileContent);
	}
	
	/**
	 * Reads the contents of the file.
	 * @param path
	 * @return fileContent to main
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static String readFromFile(Path path) throws IOException,
				InterruptedException, ExecutionException {
		
		AsynchronousFileChannel fileChannel = 
				AsynchronousFileChannel.open(filePath, 
						StandardOpenOption.READ);
		
		Future<Integer> operation = fileChannel.read(buffer, 0);
		
		operation.get();
		
		String fileContent = new String(buffer.array()).trim();
		
		buffer.clear();
		
		return fileContent;
	}
	/**
	 * reverses the contents of the string 
	 * @param input
	 * @return reversed string
	 */
	public static String reverseString(String input) {
		char ch;
		String reverseString = "";
		
		for (int i = 0; i < input.length(); i++) {
			ch = input.charAt(i);
			reverseString = ch + reverseString; 
		}
		return reverseString;
	}
	
	/**
	 * overwrites the contents of the file with the reversed string
	 * @param fileContent
	 * @throws IOException
	 */
	public static void writeToFile(String fileContent) throws IOException {
		BufferedWriter writer = new BufferedWriter (new FileWriter(FILE_PATH));
		writer.write(fileContent);
		writer.close();
	}
}
```
#### Console Output
```
Original: "Optimism is the faith that leads to achievement. Nothing can be done without hope and confidence." - Helen Keller

New: relleK neleH - ".ecnedifnoc dna epoh tuohtiw enod eb nac gnihtoN .tnemeveihca ot sdael taht htiaf eht si msimitpO"
```
#### temp.txt file new conent
```
relleK neleH - ".ecnedifnoc dna epoh tuohtiw enod eb nac gnihtoN .tnemeveihca ot sdael taht htiaf eht si msimitpO"
```
### Reference
tutorialspoint. (n.d.-b). Java NIO - AsynchronousFileChannel. Tutorialspoint. https://www.tutorialspoint.com/java_nio/java_nio_asynchronous_filechannel.htm
