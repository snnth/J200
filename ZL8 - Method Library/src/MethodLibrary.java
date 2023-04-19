///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           ZL8 - Method Library
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

import java.util.Arrays;
import java.util.Scanner;

/**
 * A library of methods demonstrating operations on arrays.
 *
 * @author Jim Williams
 * @author Matthew Smith
 */
public class MethodLibrary {
	public static void main(String args[]) {
		System.out.println("MethodLibrary");

		System.out.println("Example use of methods");
		int[] smallNumberListOne = {2, 1, 7, 4, 3};
		display("display:", smallNumberListOne);

		char [] characterList = {'a','b','c','d','e','f'};
		shiftArrayRight(characterList,2);
		System.out.print("after first: ");
		System.out.println(characterList);

		int[] bigNumberList = {1234, 20001, 3764, 20947, 9099};
		System.out.println("after second: " + getMax(bigNumberList));

		int[] smallNumberListTwo = { 8, 7, 3, 4, 5, 0, 1};
		sort(smallNumberListTwo, true);
		System.out.println("after third: " + Arrays.toString(smallNumberListTwo));

		Scanner scan = new Scanner("-5 0 error 25 happy 20 14 end");
		int userInt = fourth( scan, "Enter a number between 1 and 20, inclusive", 1, 20);
	}

	/**
	 * This method prints the description followed by the contents of list.
	 * The list begins with '[', ends with ']' and each element is separated
	 * with ', '.
	 * Example: display( "a description", new int[]{1,2,3})
	 * a description [1, 2, 3]
	 * @param description The text printed out before the list of integers.
	 * @param list The array of integers to be printed.
	 */
	public static void display(String description, int[] list) {
		System.out.print(description);
		System.out.print(" [");
		for (int i = 0; i < list.length; i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			System.out.print(list[i]);
		}
		System.out.println("]");
	}

	/**
	 * Shifts array elements to the right the given amount of times.
	 *
	 * @param list The array to do operations on.
	 * @param amount How many elements to shift.
	 */
	public static void shiftArrayRight(char[] list, int amount) {
		for (int i = 0; i < amount; i++) {
			char lastElement = list[list.length - 1];
			for (int j = list.length - 1; j > 0; j--) {
				list[j] = list[j - 1];
			}
			list[0] = lastElement;
		}
	}

	/**
	 * Returns max value of array.
	 *
	 * @param list The array to parse.
	 * @return Max value.
	 */
	public static int getMax(int[] list) {
		int firstElement;
		firstElement = list[0];
		for (int i = 0; i < list.length; i++) {
			if (list[i] > firstElement) {
				firstElement = list[i];
			}
		}
		return firstElement;
	}

	/**
	 * Sorts array such that elements are ordered from smallest integer to largest integer or from the largest
	 * integer to the smallest integer. A true boolean value does the former, a false boolean value does the latter.
	 *
	 * @param list The array to parse.
	 * @param direction
	 */
	public static void sort(int[] list, boolean direction) {
		int tempValue;
		for (int i = 0; i < list.length; i++) {
			for (int j = i + 1; j < list.length; j++) {
				if (direction) {
					if (list[i] > list[j]) {
						tempValue = list[i];
						list[i] = list[j];
						list[j] = tempValue;
					}
				} else {
					if (list[i] < list[j]) {
						tempValue = list[i];
						list[i] = list[j];
						list[j] = tempValue;
					}
				}
			}
		}
	}

	/**
	 * Asks user for a integer between the given bounds (inclusive) and returns it.
	 *
	 * @param scan
	 * @param prompt
	 * @param leftBound
	 * @param rightBound
	 * @return
	 */
	public static int fourth(Scanner scan, String prompt, int leftBound, int rightBound) {
		System.out.println(prompt);
		boolean withinBounds = false;
		int userInt = 0;

		do {
			if (scan.hasNextInt()) {
				userInt = scan.nextInt();
				if (userInt >= leftBound && userInt <= rightBound) {
					withinBounds = true;
				} else {
					System.out.println("Value must be between " + leftBound + " and " + rightBound + ".");
				}
			} else {
				scan.next();
			}
		} while (!withinBounds);

		return userInt;
	}
}
