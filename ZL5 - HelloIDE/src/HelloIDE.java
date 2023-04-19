import java.util.Scanner;

///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Hello IDE
// Course:          CS200 Fall 20
//
// Author:          Matthew Smith
// Email:           mjsmith44@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Source or Recipient; Description
// Examples:
// Jane Doe; helped me with for loop in reverse method
// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html; 
//         counting for loop
// John Doe; I helped with switch statement in main method.
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

public class HelloIDE {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String firstName;
		
		System.out.println("What is your name?");
		if (scan.hasNextLine()) {
			firstName = scan.nextLine();
			firstName = firstName.trim();
		} else {
			firstName = Config.DEFAULT_NAME;
		}
				
			
		if (firstName.length() < 1)
			firstName = Config.DEFAULT_NAME;
		
		System.out.println("Hello, " + firstName + "!");
		
		scan.close();
	}
	
}
