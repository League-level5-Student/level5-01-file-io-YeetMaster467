package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	
	public static void main(String[] args) {
		int key = FileEncryptor.encrypt();
		String decrypted = "";
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/encrypted.txt"));
			String line = br.readLine();
			String encrypted = "";
			while (line != null) {
				encrypted += line;
				line = br.readLine();
			}
			System.out.println(encrypted);
			
			char c;
			for (int i = 0; i < encrypted.length(); i++) {
				c = encrypted.charAt(i);
				if (Character.isAlphabetic(encrypted.charAt(i))) {
					for (int j = 0; j < key; j++) {
						c--;
						if (c == '`') {
							c = 'z';
						}
					}
					decrypted += c;
				} else {
					decrypted += c;
				}
			}
			
			System.out.println(decrypted);
			
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, decrypted);
	}
}
//Copyright © 2024 Eli Singer//Copyright © 2024 Eli Singer