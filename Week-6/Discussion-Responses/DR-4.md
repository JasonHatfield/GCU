# Week 6: Create a Program/Code Snippet
- Create a basic Program/Code snippet using concepts from this week. 
- Please state concept, chapter and section and what one can do with the code snippet.

## Response
- Topic Server/Client
This program has a server class and a client class.

The client establishes a connection with the server and requests the contents of a file based on the file location.

The server receives the request, reads the file, and returns the contents of the file back to the client to be displayed to the console.

Upon completion of this task, the client requests to disconnect, and the server shuts down.

### Code Example
#### file.txt contents
```
"Optimism is the faith that leads to achievement. Nothing can be done without hope and confidence." - Helen Keller
```
#### Server.java
``` Java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Jason Hatfield
 * This is my original work.
 */
public class Server {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in, reader;
	private Path path;
	
	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.start(7777);
		server.cleanup();
	}
	
	public void start(int port) throws IOException {
		System.out.println("Waiting for a client connection...");
		serverSocket = new ServerSocket(port);
		clientSocket = serverSocket.accept();
		
		System.out.println("\nReceived a Client connection on port: "
				+ clientSocket.getLocalPort());
		
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		
		in = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		
		readFromFile();
		
		System.out.println("Server is shut down.");
		
		cleanup();
	}
	
	public void readFromFile() throws IOException {
		String inputLine;
		
		while ((inputLine = in.readLine()) != null) {
			if ("QUIT".equals(inputLine)) {
				System.out.println("Received a message to shut the Server "
						+ "down");
				out.println("Server Connection Terminated");
			} else {
				System.out.println("Received request to retrieve and display "
						+ "file contents");
				
				path = Paths.get(inputLine);
				
				reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
				
				String currentLine = null;
				
				while ((currentLine = reader.readLine()) != null) {
					out.println(currentLine);
				
				System.out.println("File contents sent to Client");
				}
			}
		}
	}
	
	public void cleanup() throws IOException {
		in.close();
		out.close();
		clientSocket.close();
		serverSocket.close();
	}
}
```
#### Client.java
``` Java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Jason Hatfield
 * This is my original work.
 */
public class Client {
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	private static final String FILE = "src/temp.txt";
	
	public static void main(String[] args) throws IOException, InterruptedException {
		String response;
		String message = FILE;
		
		Client client = new Client();
		client.start("127.0.0.1", 7777);
		
		System.out.print("Requesting contents of server file located at: " + FILE);
		
		response = client.sendMessage(message);
		
		System.out.println("\nServer response was: " + response);
		
		client.sendMessage("QUIT");
		
		client.cleanup();
	}
	
	public void start(String ip, int port) throws UnknownHostException,
				IOException {
		clientSocket = new Socket(ip, port);
		
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
	}
	
	public String sendMessage(String msg) throws IOException {
		out.println(msg);
		return in.readLine();
	}

	public void cleanup() throws IOException {
		in.close();
		out.close();
		clientSocket.close();
	}
}
```
### Server Console Output
```
Waiting for a client connection...

Received a Client connection on port: 7777
Received request to retrieve and display file contents
File contents sent to Client
Received a message to shut the Server down
Server is shut down.
```
### Client ConsoleOutput
```
Requesting contents of server file located at: src/temp.txt
Server response was: "Optimism is the faith that leads to achievement. Nothing can be done without hope and confidence." - Helen Keller
```
