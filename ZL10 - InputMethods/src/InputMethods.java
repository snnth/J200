///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           ZL10 - InputMethods
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

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Some methods to get user input and filter an ArrayList.
 *
 * @author Jim Williams
 * @author Matthew Smith
 */
public class InputMethods {

	/**
	 * This method returns an integer between min and max, inclusive of both, when that
	 * integer is the first token on an input line. Otherwise it will keep printing the prompt
	 * and getting another line of input.  If min is greater than max then return -2.
	 *
	 * @param input  A Scanner instance, if null this returns -1.
	 * @param prompt The string to print to the user asking for input.
	 * @param min  The minimum acceptable integer.
	 * @param max  The maximum acceptable integer.
	 * @return A value between min and max, inclusive, or return -1 if input is null or
	 *         return -2 if min is greater than max.
	 */
	public static int getValidInt(Scanner input, String prompt, int min, int max) {
		if (input == null)
			return -1;

		if (min > max)
			return -2;

		boolean haveValidNumber = false;
		int value = 0;
		do {
			System.out.print(prompt);
			if (input.hasNextInt()) {
				value = input.nextInt();
				if ( value >= min && value <= max) {
					haveValidNumber = true;
				}
			}
			if ( !haveValidNumber) {
				System.out.println("Error, not a valid number.");
				input.nextLine();
			}
		} while (!haveValidNumber);
		return value;
	}

	/**
	 * This method filters an ArrayList to make sure the data is clean and correct.
	 * This returns a new list that contains the elements from list in sorted order
	 * with all the null values and duplicate values removed.
	 *
	 * If list is null then return an empty list. If the list contains
	 * null values then they are all removed. This method uses
	 * Collections.sort(ArrayList<Integer>) to order the ArrayList. This method
	 * will not change the list passed in the parameter.
	 *
	 * @param list A list of Integers, may contain null and duplicate values.
	 * @return A list in sorted order, without duplicates or null values.
	 */
	public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
		if (list == null)
			return new ArrayList<Integer>();

		while (list.remove(null)) {}
		if (list.size() < 2)
			return list;

		ArrayList<Integer> newList = new ArrayList<>();
		Collections.sort(list);
		for ( int i = list.size() - 1; i > 0; i--) {
			if ( list.get(i).equals( list.get(i-1))) {
				list.remove(i);
			}
		}
		return list;
	}
}