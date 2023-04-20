///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           TL11 - File Input and Output
// Course:          CS 200, Fall 2020
//
// Author:          Matthew Smith
// Email:           mjsmith44@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Source or Recipient; Description
// Jane Doe; helped me with for loops in main method
// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html; 
//         counting for loop
// John Doe; I helped with using constants
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Scanner;

/**
 * @author Matthew Smith
 */
public class ExcerciseC {

	public static void main(String[] args) {
		functionOne();
		functionTwo();
		functionThree();

	}

	public static void functionOne() {
		String str = "CS 200: Trace and Explain";
		String [] parts = str.split(" ");
		for (String part : parts) {
			System.out.println(part);
		}
	}

	public static void functionTwo() {
		String line = "Erin, Ashbury, erin.ashbury@email.com, 123456, 3.14";
		String []parts = line.split(",");
		boolean validEmail = parts[2].endsWith("@email.com");
		System.out.println(parts.length);
		int id = Integer.parseInt(parts[3].trim());
		double num = Double.parseDouble(parts[4].trim());
	}

	public static void functionThree() {
		String line = "Erin, Ashbury, erin.ashbury@email.com,123456,3.14";
		Scanner input = new Scanner(line);
		input.useDelimiter(",");  //since , is delimiter then whitespace isn't
		String firstName = input.next().trim();
		String lastName = input.next().trim();
		String email = input.next().trim();
		int id = input.nextInt();
		double num = input.nextDouble();
	}

}
