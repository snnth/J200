///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           ZL10 - TestInputMethods
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

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This contains testing methods for the InputMethods class.
 * @author Jim Williams
 * @author Matthew Smith
 */
public class TestInputMethods {

	/**
	 * This main method runs the selected tests.  Comment out a test if you don't want it to run.
	 *
	 * @param args unused
	 */
	public static void main(String[]args) {
		testGetValidInt();
		testRemoveDuplicates();
	}

	/**
	 * Tests that the getValidInt method handles all the cases described in its method header comment.
	 */
	private static void testGetValidInt() {
		boolean error = false;

		{  //test 1, a straightforward "happy path" case "9\n" with min 5 and max 10, should result in 9
			int expected = 9;
			Scanner input = new Scanner("9\n");
			int actual = InputMethods.getValidInt(input, "Enter a number between 5 and 10:", 5, 10);
			if (actual != expected) {
				error = true;
				System.out.println("testGetValidInt 1) Error, expected: " + expected + ", actual: " + actual);
			}
		}

		{  //test 2, null scanner.
			int expected = -1;
			Scanner input = null;
			int actual = InputMethods.getValidInt(input, "Enter a number:", 0, 1);
			if (actual != expected) {
				error = true;
				System.out.println("testGetValidInt 2) Error, expected: " + expected + ", actual: " + actual);
			}
		}

		{  //test 3, min > max
			int expected = -2;
			Scanner input = new Scanner("5\n");
			int actual = InputMethods.getValidInt(input, "Enter a number between 4 and 0:", 4, 0);
			if (actual != expected) {
				error = true;
				System.out.println("testGetValidInt 3) Error, expected: " + expected + ", actual: " + actual);
			}
		}

		{  //test 4, min value check, "5\n" with min 5 and max 10.
			int expected = 5;
			Scanner input = new Scanner("5\n");
			int actual = InputMethods.getValidInt(input, "Enter a number between 5 and 10:", 5, 10);
			if (actual != expected) {
				error = true;
				System.out.println("testGetValidInt 4) Error, expected: " + expected + ", actual: " + actual);
			}
		}

		{  //test 5, max value check, "6\n" with min 0 and max 6 should result in 6.
			int expected = 6;
			Scanner input = new Scanner("6\n");
			int actual = InputMethods.getValidInt(input, "Enter a number between 4 and 0:", 0, 6);
			if (actual != expected) {
				error = true;
				System.out.println("testGetValidInt 5) Error, expected: " + expected + ", actual: " + actual);
			}
		}

		{  //test 6, skip multiple lines
			int expected = 5;
			Scanner input = new Scanner("\n a 5\n 5 9\n");
			int actual = InputMethods.getValidInt(input, "Enter a number between 0 and 5:", 0, 5);
			if (actual != expected) {
				error = true;
				System.out.println("testGetValidInt 6) Error, expected: " + expected + ", actual: " + actual);
			}
		}

		if (error) {
			System.out.println("testGetValidInt failed");
		} else {
			System.out.println("testGetValidInt passed");
		}
	}

	/**
	 * Tests that the removeDuplicates method handles all the cases described in its method header comment.
	 */
	private static void testRemoveDuplicates() {
		boolean error = false;

		{  //test 1, a simple case
			ArrayList<Integer> list = new ArrayList<>();
			list.add(20);
			//can also add an array of items to an array list with:
			//list.addAll(java.util.Arrays.asList( new Integer[]{20}));

			ArrayList<Integer> expected = new ArrayList<>();
			expected.add(20);
			ArrayList<Integer> actual = InputMethods.removeDuplicates(list);
			if (!actual.equals(expected)) {
				error = true;
				System.out.println("testRemoveDuplicates 1) Error, expected: " + expected + " , actual: " + actual);
			}
		}

		{  //test 2, null list
			ArrayList<Integer> list = null;

			ArrayList<Integer> expected = new ArrayList<>();
			ArrayList<Integer> actual = InputMethods.removeDuplicates(list);
			if (!actual.equals(expected)) {
				error = true;
				System.out.println("testRemoveDuplicates 2) Error, expected: " + expected + " , actual: " + actual);
			}
		}

		{  //test 3, null values in arraylist
			ArrayList<Integer> list = new ArrayList<>();
			list.add(20);
			list.add(null);
			list.add(null);
			list.add(40);
			list.add(30);
			list.add(null);

			ArrayList<Integer> expected = new ArrayList<>();
			expected.add(20);
			expected.add(30);
			expected.add(40);
			ArrayList<Integer> actual = InputMethods.removeDuplicates(list);
			if (!actual.equals(expected)) {
				error = true;
				System.out.println("testRemoveDuplicates 3) Error, expected: " + expected + " , actual: " + actual);
			}
		}

		{  //test 4, duplicate values and values out of order
			ArrayList<Integer> list = new ArrayList<>();
			list.add(20);
			list.add(40);
			list.add(30);
			list.add(20);

			ArrayList<Integer> expected = new ArrayList<>();
			expected.add(20);
			expected.add(30);
			expected.add(40);
			ArrayList<Integer> actual = InputMethods.removeDuplicates(list);
			if (!actual.equals(expected)) {
				error = true;
				System.out.println("testRemoveDuplicates 4) Error, expected: " + expected + " , actual: " + actual);
			}
		}

		{  //test 5, verify input list is unchanged
			ArrayList<Integer> list = new ArrayList<>();
			list.add(20);
			list.add(30);
			list.add(40);
			//can also add an array of items to an array list with:
			//list.addAll(java.util.Arrays.asList( new Integer[]{20}));

			ArrayList<Integer> expected = new ArrayList<>();
			expected.add(20);
			expected.add(30);
			expected.add(40);
			ArrayList<Integer> actual = InputMethods.removeDuplicates(list);
			if (!actual.equals(expected)) {
				error = true;
				System.out.println("testRemoveDuplicates 1) Error, expected: " + expected + " , actual: " + actual);
			}
		}

		if (error) {
			System.out.println("testRemoveDuplicates failed");
		} else {
			System.out.println("testRemoveDuplicates passed");
		}
	}
}
