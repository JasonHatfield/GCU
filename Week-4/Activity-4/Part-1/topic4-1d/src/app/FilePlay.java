package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Jason Hatfield
 * This is my original work.
 */
public class FilePlay {
	public static void main(String[] args) {
		
		try {
			copyFile("InUsers.txt", "OutUsers.txt");
			System.out.println("File was copied successfully.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File could not be opened.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File I/O error.");
		}
	}
	/**
	 * 
	 * @param in
	 * @param out
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void copyFile(String in, String out) throws FileNotFoundException, IOException {
			BufferedReader read = new BufferedReader(new FileReader(in));
			BufferedWriter write = new BufferedWriter(new FileWriter(out));
			
			int c;
			
			while((c = read.read()) != -1) {
				write.write(c);
			}

			read.close();
			write.close();
	}
}
