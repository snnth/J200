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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Matthew Smith
 */
public class ExcerciseA {
	public static void main(String[] args) {
		File file = new File("data.txt");
		Scanner input = null;
		try {
			input = new Scanner( file);
			while (input.hasNextLine()) {
				System.out.println( input.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (input != null) input.close();
		}
	}

}
