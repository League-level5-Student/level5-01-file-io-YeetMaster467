package _01_File_Recorder;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class FileRecorder {
	
	// Create a program that takes a message from the user and saves it to a file.
	
	public static void main(String[] args) {
		System.out.println("Enter a message to be saved to a file.");
		Scanner s = new Scanner(System.in);
		try {
			
			FileWriter fw = new FileWriter("src/_01_File_Recorder/response.txt");
			fw.write(s.nextLine());
			fw.close();
			s.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
