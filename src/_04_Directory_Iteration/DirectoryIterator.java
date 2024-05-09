package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/* 
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		
		/* JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File directory = jfc.getSelectedFile();
			File[] files = directory.listFiles();
			if(files != null) {
				for(File f : files) {
				  System.out.println(f.getAbsolutePath());
				}
			}
		}
		*/
		
	
		File directory = new File("C:/Users/elico/git/level5-01-file-io-YeetMaster467/src");
		ArrayList<File> directories = new ArrayList<File>();
		directories.add(directory);
		
		for (int idk = 0; idk < directories.size(); idk++) {
			File[] files = directories.get(idk).listFiles();
			for (int i = 0; i < files.length; i++) {
				
				if (files[i].isDirectory()) {
					directories.add(files[i]);
				}
				if (files[i].getName().contains(".java")) {
					try {
						FileWriter fw = new FileWriter(files[i].getAbsolutePath(), true);
						fw.write("//Copyright © 2024 Eli Singer");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		
		/*
		 * Your task is to write a program that iterates through the src folder of this current Java Project. 
		 * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
		 * Be aware of possible directories inside of directories.
		 * (e.g //Copyright © 2019 FirstName LastName)
		 */
	}
}
//Copyright © 2024 Eli Singer//Copyright © 2024 Eli Singer