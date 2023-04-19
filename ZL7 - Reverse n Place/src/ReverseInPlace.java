//
// Title:           ZL7 - Reverse in Place
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
 * Reverses a given array in place.
 *
 * @author Matthew Smith
 */
public class ReverseInPlace {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int  index;

		// how long?
		int[] array = new int[scan.nextInt()];

		// what values?
		for (index = 0; index < array.length; ++index) {
			array[index] = scan.nextInt();
		}

		// reverse and display
		reverseArrayInPlace(array);
		displayArrayValues(array);

		scan.close();
	}

	/**
	 * Accepts a reference to an array and reverses the contents its instance.
	 *
	 * @param array Array to be reversed
	 */
	private static void reverseArrayInPlace(int[] array) {
		int reversingIndex = array.length - 1;
		int valuePlaceholder;

					  // if length is odd    // end at half (rnd down)   // end at half - 1
		int loopEnd = ((array.length % 2) == 1) ? array.length / 2 : (array.length / 2) - 1;
		for (int index = 0; index <= loopEnd; ++index) { // conditional could be more efficient
			valuePlaceholder = array[index];
			array[index] = array[reversingIndex];
			array[reversingIndex] = valuePlaceholder;
			--reversingIndex;
		}
	}

	/**
	 * Displays each element of the array increasing with spaces in between.
	 *
	 * @param array Array to be displayed
	 */
	private static void displayArrayValues(int[] array) {
		for (int index = 0; index < array.length; ++index) {
			System.out.print(array[index] + " ");
		}
		System.out.println("");
	}
}
