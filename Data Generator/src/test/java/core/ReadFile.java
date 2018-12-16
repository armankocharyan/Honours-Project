package core;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

	private Scanner x;
	private String fileName;
	
	public ReadFile(String fileName) {
		this.fileName = fileName;
		openFile();
	}
	
	public void openFile() {
		try {
			x = new Scanner(new File (fileName));
		}
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage() + "\n");
		}
	}
	
	public ArrayList<String> readFile() {
		ArrayList<String> someList = new ArrayList<String>();
		while (x.hasNext()) {
			someList.add(x.nextLine() + "\n");
		}
		x.close();
		return someList;
		
	}
}
