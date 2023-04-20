///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           TL10 - Command-Line and Exceptions
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

/**
 * @author Matthew Smith
 */
public class CountWords {
	public static void main(String[] args) {

		// help
		if (args.length < 1) {
			System.out.println("Usage: java CountWords [-letters] word(s)");
			return;
		}

		// setup
		int wordCount = args.length;
		int letterCount = 0;
		int doubleLetterCount = 0;
		boolean letters = false;

		// if they want letters let them have it
		if (args[0].equals("-letters")) {
			wordCount -= 1;
			letters = true;
		}

		char previousChar = '\0';
		for (String arg : args) {
			if (arg.equals("-letters")) {
				continue;
			}
			System.out.print(arg + " ");
			if (letters == true) {
				for (int i = 0; i < arg.length(); ++i) {
					char ch = arg.charAt(i);
					if (Character.isLetter(ch)) {
						letterCount++;
						if (previousChar == ch) {
							doubleLetterCount++;
						}
					}
					previousChar = ch;
				}
				previousChar = '0';
			}
		}
		System.out.println();
		System.out.println("wordCount=" + wordCount);
		if (letters) {
			System.out.println("letterCount=" + letterCount
					+ " doubleLetterCount=" + doubleLetterCount);
		}
	}
}