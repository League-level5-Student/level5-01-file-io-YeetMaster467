package _03_To_Do_List;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class ToDoList {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addTask = new JButton("Add Task");
	JButton viewTask = new JButton("View Tasks");
	JButton removeTask = new JButton("Remove Task");
	JButton saveList = new JButton("Save List");
	JButton loadList = new JButton("Load List");
	
	ArrayList<String> toDoList = new ArrayList<String>();
	

	public void showWindow() {
		panel.add(addTask);
		panel.add(viewTask);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("To Do List");
		frame.pack();
		frame.setVisible(true);
		
		addTask.addActionListener(a -> toDoList.add(JOptionPane.showInputDialog("Add a task.")));
		viewTask.addActionListener(a -> {
			String s = "";
			if (toDoList.isEmpty()) {
				s = "To do list is empty!";
			} else {
				for (int i = 0; i < toDoList.size(); i++) {
					s += toDoList.get(i) + "\n";
				}
			}
			JOptionPane.showMessageDialog(null, s);
		});
		removeTask.addActionListener(a -> {
			String s = "";
			if (toDoList.isEmpty()) {
				s = "To do list is empty!";
				JOptionPane.showMessageDialog(null, s);
			} else {
				for (int i = 0; i < toDoList.size(); i++) {
					s += (i + 1) + ". " + toDoList.get(i) + "\n";
				}
				String input = JOptionPane.showInputDialog(s + "\nEnter the task to be removed.");
				
				try {
					int num = Integer.parseInt(input) - 1;
					if (num > toDoList.size()) {
						JOptionPane.showMessageDialog(null, "Invalid number.");
					} else {
						toDoList.remove(num);
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Invalid number.");
				}
			}
		});
		
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/list.txt"));
			
			
			saveList.addActionListener(a -> {
				if (toDoList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "To do list is empty!");
				} else {
					String s = "";
					for (int i = 0; i < toDoList.size(); i++) {
						s += toDoList.get(i) + "\n";
					}
					try {
						FileWriter fw = new FileWriter("src/_03_To_Do_List/list.txt");
						fw.write(s);
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			
			
			loadList.addActionListener(a -> {
				String s = JOptionPane.showInputDialog("Where should the list be loaded from?");
				try {
					BufferedReader br2 = new BufferedReader(new FileReader(s));
					String line = br2.readLine();
					toDoList.clear();
					while (line != null) {
						toDoList.add(line);
						line = br2.readLine();
					}
					br2.close();
					JOptionPane.showMessageDialog(null, "List loaded.");
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, "File not found.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			
			String line = br.readLine();
			while (line != null) {
				toDoList.add(line);
				line = br.readLine();
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
//Copyright © 2024 Eli Singer//Copyright © 2024 Eli Singer