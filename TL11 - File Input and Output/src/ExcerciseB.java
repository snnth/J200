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

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author Matthew Smith
 */
public class ExcerciseB {
	public static void main(String[] args) {
		String outFileName = "yee/myData.txt";
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(outFileName);
			for (int i = 1; i <= 9; i++) {
				writer.printf("%d, ", i * i);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Unable to write to " + outFileName);
		} finally {
			if (writer != null) writer.close();
		}
	}
}
