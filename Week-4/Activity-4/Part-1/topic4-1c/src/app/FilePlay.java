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
		copyFile("InUsers.txt", "OutUsers.txt");
		
		int error = copyFile("InUsers.txt", "OutUsers.txt");
		
		switch (error) {
			case 0:
				System.out.println("File was copied successfully.");
				break;
			case -1:
				System.out.println("File could not be opened.");
				break;
			case -2:
				System.out.println("File I/0 error");
				break;
		}
	}
	/**
	 * 
	 * @param in
	 * @param out
	 * @return
	 */
	private static int copyFile(String in, String out) {
		try {
			BufferedReader read = new BufferedReader(new FileReader(in));
			BufferedWriter write = new BufferedWriter(new FileWriter(out));
			
			int c;
			
			while((c = read.read()) != -1) {
				write.write(c);
			}
			
			read.close();
			write.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return -1;
		} catch (IOException e) {
			e.printStackTrace();
			return -2;
		}
		return 0;
	}
}
