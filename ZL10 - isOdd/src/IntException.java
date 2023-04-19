///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           ZL10 - isOdd
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
import java.util.InputMismatchException;

/**
 * @author Matthew Smith
 */
public class IntException {

	public static void main(String[] args) {
		System.out.print(isOdd());
	}

	/**
	 * This method returns a boolean value of true if user input is a valid odd integer or false if it is anything else.
	 *
	 * @return true or false whether input value is odd or not
	 */
	public static boolean isOdd() {
		Scanner input = new Scanner(System.in);
		boolean isOdd = false;
		int userInt = 0;

		try {
			userInt = input.nextInt();
			if (Math.abs(userInt % 2) == 1)
				isOdd = true;
		} catch (InputMismatchException exception) {
			isOdd = false;
		}

		return isOdd;
	}

}