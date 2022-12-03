# Week 6: Discussion Question 1
Explore the NIO classes in the Java programming language. 

Explain what features are provided by these classes and how they can be used to write network-based applications.

## Response
Java NIO (New Input/Output) is a new model introduced in the Java Developer Kit v. 1.4. Java NIO bases this new model on channels, buffers, and selectors. Channels connect to a source, buffers contain primitive data (e.g., char, int, etc.), and all data transfers through buffers and multiplexed selectors select the channel without blocking the I/O facility. The benefit of this new model is its performance on both the server and the application. (ID1212, Network Programming, 2018)

Accessing the Java NIO classes in the Java application requires the following packages to be imported:

Java Import Class | Class Details
--- | ---
java.nio | Buffers are used throughout the NIO APIs
java.nio.channels | Channels and selectors
java.nio.charset | Character encodings
java.nio.channels.spi | Service-provider classes for channels
java.nio.charset.spi | Service-provider classes for charsets
java.util.regex | Pattern matching using regular expressions

The Java NIO class provides an enhanced and efficient way to read and write files in databases through established channels. This method provides more flexibility and faster read/write speeds for network-based applications.

## Code Example (Inspired by tutorialspoint, n.d.)
### temp.txt (before program compile)
```
Hello World
```
### NIO_Example.java
``` Java
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;

public class NIO_Example {
	
	static final String FILE_NAME = "src/temp.txt";
	static final String OUTPUT_TEXT = "\nThis is the output text.";
	
	public static void main(String[] args) throws IOException {
		fileInput();
		fileOutput(ByteBuffer.wrap(OUTPUT_TEXT.getBytes()));
	}
	
	public static void fileInput() throws IOException {
		// accesses the file
		RandomAccessFile file = new RandomAccessFile(FILE_NAME, "r"); 
		// opens a file channel
		FileChannel fileChannel = file.getChannel(); 
		// creates the byteBuffer object and allocates memory
		ByteBuffer byteBuffer = ByteBuffer.allocate(512);
		
		readFromFile(fileChannel, byteBuffer);
		
		file.close();
	}
	
	// reads from the file and outputs the information to the console
	public static void readFromFile(FileChannel fileChannel, 
			ByteBuffer byteBuffer) throws IOException {
		while (fileChannel.read(byteBuffer) > 0) {
			// flip the buffer
			byteBuffer.flip();
			// prints all characters
			while(byteBuffer.hasRemaining()) {
				System.out.print((char) byteBuffer.get());
			}
		}
	}
	// appends and writes the OUTPUT_TEXT String to the file
	public static void fileOutput(ByteBuffer byteBuffer) throws IOException {
		Set<StandardOpenOption> options = new HashSet<>();
		options.add(StandardOpenOption.CREATE);
		options.add(StandardOpenOption.APPEND);
		Path path = Paths.get(FILE_NAME);
		FileChannel fileChannel = FileChannel.open(path, options);
		// writes 
		fileChannel.write(byteBuffer);
		fileChannel.close();
	}
}
```
### Console Output
```
Hello World
```
### temp.txt (after program compile)
```
Hello World
This is the output text.
```
## References
ID1212, Network Programming. (2018, November 2). Indroduction to Java NIO and non-blocking sockets [Video]. YouTube. https://www.youtube.com/watch?v=VhSu1pRIEqQ

totorialspoint. (n.d.). Java NIO - Quick Guide. Tutorialspoint. https://www.tutorialspoint.com/java_nio/java_nio_quick_guide.htm
