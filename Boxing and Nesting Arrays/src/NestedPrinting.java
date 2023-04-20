///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           ZL12 - Boxing and Nesting Arrays
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
 * A class that can be used to build String representations of 1D, 2D, and 3D String arrays
 * to display their contents.
 */
public class NestedPrinting {

	/**
	 * Takes a one-line String of input and makes a new version of
	 * it which ends with a suffix and is of the given length.
	 * To make it the correct length, the original input
	 * should either be truncated (losing some characters)
	 * or it should be padded at the end with spaces (' ')
	 * before adding the suffix.
	 *
	 * @param input A single line String to be fixed
	 * @param suffix The String that the output should end with
	 * @param length The total length of the output, including the suffix
	 * @return A String of the given length which ends with the suffix
	 **/
	public static String endWith(String input, String suffix, int length) {
		if (input.length() < length) {
			for (int i = 0; i < length; i++) {
				input = input.concat(" ");
			}
		}

		return input.substring(0, length - suffix.length()).concat(suffix);
	}

	/**
	 * Returns a line of characters which consists of
	 * lineChar repeated length times.
	 * @param lineChar The character to create a line out of
	 * @param length The length of the returned String
	 * @return A String of the given length consisting only of lineChar
	 */
	public static String lineOf(char lineChar, int length) {
		String lineString = "";

		for (int i = 0; i < length; i++) {
			lineString += lineChar;
		}

		return lineString;
	}

	/**
	 * Returns a single String as a representation of an array of Strings.
	 * The return should start with '{' and end with '}'. The elements
	 * of the array should be included without quotes and with commas
	 * after all but the last element of the array.
	 * There should be no newline at the end of the returned String.
	 *
	 * Example output:
	 * arrToString(new String[] { "hello", "there", "everyone" })
	 * returns: "{hello, there, everyone}"
	 *
	 * @param arr An array of Strings to be printed
	 * @return A String which has the array on a single line
	 */
	public static String arrToString(String[] arr) {
		String arrayElements = "";

		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				arrayElements = arrayElements.concat(arr[i]);
				continue;
			}

			arrayElements = arrayElements.concat(arr[i] + ", ");
		}

		return "{" + arrayElements + "}";
	}

	/**
	 * Returns a single String as a representation of an 2D array of Strings.
	 * The returned String should have arr.length+2 lines and it
	 * should end with a newline.
	 * Every line should start with the given prefix and
	 * end with the given suffix, but each line will have different contents.
	 *
	 * If adding the prefix + suffix would make the line longer
	 * than length, then the contents of the line should be truncated
	 * to allow for them to be added. You can assume that the
	 * length of prefix + suffix is always less than or equal
	 * to the length.
	 *
	 * The first line's contents is just "{".
	 * The final line's contents is just "}".
	 * The inner line's contents are two spaces ("  ") plus the
	 * String representation of a 1D array from arrToString(String[])
	 * plus a comma after all but the last element of the 2D array.
	 *
	 * Example Output (prefix is "_", suffix is "!", length is 15):
	 * _{            !
	 * _  {Hi, Guy}, !
	 * _  {2D}       !
	 * _}            !
	 *
	 * hint: use the arrToString(String[] arr) method you created
	 *
	 * @param arr The 2D array we're trying to represent as a String
	 * @param prefix A String which should be at the start of
	 *      every line of the output
	 * @param suffix A String which should be at the end of
	 *      every line of the output
	 * @param length The length of every line of the output
	 */
	public static String arrToString(String[][] arr, String prefix, String suffix, int length) {
		// calculate space to fill for either the header, the footer, or the contents
		int areaForHeaderFooter = length - prefix.length() - suffix.length() - 1; // 1 -> leading curly bracket
		int areaForArrContents = length - prefix.length() - suffix.length() - 2; // 2 -> leading two whitespaces

		// build "header" of output
		String headerString = String.format("%s{%s%s\n", prefix, lineOf(' ', areaForHeaderFooter), suffix);

		// build "contents" of output
		String arrayString = "";
		for (int i = 0; i < arr.length; i++) {
			String lineToBeInserted = arrToString(arr[i]);

			if (i != arr.length - 1) {
				lineToBeInserted += ",";
			}

			String lineFormatting = "%s  %-" + areaForArrContents + "." + areaForArrContents + "s%s\n";
			arrayString += String.format(lineFormatting, prefix, lineToBeInserted, suffix);
		}

		// build "footer" of output
		String footerString = String.format("%s}%s%s\n", prefix, lineOf(' ', areaForHeaderFooter), suffix);

		// combine and return
		return headerString + arrayString + footerString;
	}

	/**
	 * Returns a single String as a representation of an 3D array of Strings.
	 * EVERY LINE should start with the given prefix and
	 * end with the given suffix, but each line will have different contents.
	 *
	 * The first line's contents is just "{".
	 * The final line's contents is just "}".
	 * Between them will be a blocks of lines for each 2D array which
	 * should be created using arrToString(String[][]). Every line in each block
	 * should have two additional spaces ("  ") after the prefix.
	 * Between every block, there should be a divider which is a single
	 * line which is just the divider character repeated to fit the length.
	 *
	 * Example Output (prefix is "_", suffix is "!?",
	 *      divider is '-", length is 15):
	 * _{           !?
	 * _  {         !?
	 * _    {Hi, Guy!?
	 * _    {3D}    !?
	 * _  }         !?
	 * _------------!?
	 * _  {         !?
	 * _    {Nope}  !?
	 * _  }         !?
	 * _}           !?
	 *
	 *
	 * hint: use the arrToString(String[][] arr, String prefix, String suffix, int length) method you created
	 * @param arr The 3D array we're trying to represent as a String
	 * @param prefix A String which should be at the start of
	 *      every line of the output
	 * @param suffix A String which should be at the end of
	 *      every line of the output
	 * @param divider A character to be repeated to divide blocks
	 *      of 2D arrays
	 * @param length The length of every line of the output
	 * @return A String representing the 3D array
	 */
	public static String arrToString(String[][][] arr, String prefix, String suffix, char divider, int length) {
		// calculate space to fill for either the header, the footer, or the contents
		int areaForDivider = length - prefix.length() - suffix.length();
		int areaForHeaderFooter = length - prefix.length() - suffix.length() - 1; // 1 -> leading curly bracket
		int areaForArrContents = length - prefix.length(); // 2 -> leading two whitespaces

		// build "header" of output
		String headerString = String.format("%s{%s%s\n", prefix, lineOf(' ', areaForHeaderFooter), suffix);

		// build "divider" of output for use in loop
		String dividerString = String.format("%s%s%s\n", prefix, lineOf(divider, areaForDivider), suffix);

		// build "array contents" of output
		Scanner scanner;
		String arrayString = "";
		for (int i = 0; i < arr.length; i++) {
			scanner = new Scanner(arrToString(arr[i], "  ", suffix, areaForArrContents));

			while(scanner.hasNextLine()) {
				arrayString += prefix + scanner.nextLine() + "\n";
			}

			if (i != arr.length - 1) {
				arrayString += dividerString;
			}

			scanner.close();
		}

		// build "footer" of output
		String footerString = String.format("%s}%s%s\n", prefix, lineOf(' ', areaForHeaderFooter), suffix);

		// combine and return
		return headerString + arrayString + footerString;
	}

	/**
	 * Represents 3D array inside a box.
	 * The left and right variables represent the sides of the box
	 * and the divider is both the top and bottom (including corners).
	 *
	 * Example Output (left is "_", right is "!?",
	 *      divider is '-", length is 15):
	 * ---------------
	 * _{           !?
	 * _  {         !?
	 * _    {Hi, Guy!?
	 * _    {3D}    !?
	 * _  }         !?
	 * _------------!?
	 * _  {         !?
	 * _    {Nope}  !?
	 * _  }         !?
	 * _}           !?
	 * ---------------
	 *
	 * @param arr The 3D array we're trying to represent as a String
	 * @param left A String which should be at the start of
	 *      every line of the 3D array representation
	 * @param right A String which should be at the end of
	 *      every line of the 3D array representation
	 * @param divider A character to be repeated to divide blocks
	 *      of 2D arrays and fill the top and bottom of the box
	 * @param length The length of every line of the output
	 * @return A String representing the boxed 3D array
	 */
	public static String arrInBox(String[][][] arr, String left, String right, char divider, int length) {
		// build "header" of output
		String headerString = lineOf(divider, length) + "\n";

		// build "array contents" of output
		String arrayString = arrToString(arr, left, right, divider, length);

		// build "footer" of output
		String footerString = lineOf(divider, length) + "\n";

		// combine and return
		return headerString + arrayString + footerString;
	}
}