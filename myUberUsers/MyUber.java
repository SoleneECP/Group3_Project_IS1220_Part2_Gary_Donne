package myUberUsers;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class MyUber {
public static void main(String[] args) {
	PrintStream fileStream;
	PrintStream oldStream=System.out;
	try {
		fileStream = new PrintStream("testScenariooutput.txt");
		System.setOut(fileStream);
		System.out.println("my mama sucks");
		System.setOut(oldStream);
		System.out.println("but i still love her");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
