//
// Title:           ZL7 - Binary to Decimal
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
 * Converts binary value to decimal value.
 *
 * @author Matthew Smith
 */
public class BinaryToDecimal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int index;

		String binaryString = clean(scan.nextLine());
		// System.out.println(binaryString);

		int[] binaryArray = generateArray(binaryString);
		// display(binaryArray);

		int decimalNum = convert(binaryArray);
		System.out.println(decimalNum);

	}

	/**
	 * Internal method used to display contents of arrays.
	 *
	 * @param binaryArray Array to be displayed.
	 */
	private static void display(int[] binaryArray) {
		for(int index = 0; index < binaryArray.length; ++index) {
			System.out.print(binaryArray[index] + " ");
		}
		System.out.println("");
	}

	/**
	 * Converts array of binary vales to decimal integer.
	 *
	 * @param binaryArray
	 * @return Decimal integer.
	 */
	public static int convert(int[] binaryArray) {
		int decimalNum = 0;
		for (int index = 0; index < binaryArray.length; ++index) {
			decimalNum += binaryArray[index] * Math.pow(2.0, (double)index);
		}
		return decimalNum;
	}

	/**
	 * Creates an array of binary values based on given string. Binary values are reversed horizontally.
	 *
	 * @param binaryString String of binary input
	 * @return array
	 */
	public static int[] generateArray(String binaryString) {
		int[] array = new int[binaryString.length()];

		int arrayIndex = 0;
		for (int index = binaryString.length() - 1; index > -1; --index) {
			if ((int)binaryString.charAt(index) == 48) {
				array[arrayIndex] = 0;
			} else {
				array[arrayIndex] = 1;
			}
			++arrayIndex;
		}

		return array;
	}

	/**
	 * Removes all whitespace from string.
	 *
	 * @param binaryString string to be parsed.
	 * @return
	 */
	public static String clean(String binaryString) {
		String cleanBinaryNum = "";
		char charAtIndex = 'u';
		for (int index = 0; index < binaryString.length(); index++) {
			charAtIndex = binaryString.charAt(index);
			if (charAtIndex == '0' || charAtIndex == '1') {
				cleanBinaryNum += Character.toString(charAtIndex);
			}
		}
		return cleanBinaryNum;
	}
}
