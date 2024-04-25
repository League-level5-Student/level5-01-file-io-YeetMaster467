package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	
	int key = 0;
	String message = "";
	
	public void encrypt() {
		try {
			
			Scanner s = new Scanner(System.in);
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/encrypted.txt");
			System.out.println("Enter a message to be encrypted.");
			String decrypted = s.nextLine().toLowerCase();
			String encrypted = "";
			for (int i = 0; i < decrypted.length(); i++) {
				if (Character.isAlphabetic(decrypted.charAt(i))) {
					for (int j = 0; j < key; j++) {
						
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
