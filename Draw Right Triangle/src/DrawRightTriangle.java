///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Draw Right Triangle
// Course:          CS200 Fall 20
//
// Author:          Matthew Smith
// Email:           mjsmith44@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Source or Recipient; Description
// Examples:
// Jane Doe; helped me with for loop in reverse method
// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html; 
//         counting for loop
// John Doe; I helped with switch statement in main method.
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

import java.util.Scanner;

public class DrawRightTriangle {

	public static void main(String[] args) {
		
		//create the variables/objects needed
		Scanner scan = new Scanner(System.in);
		Character drawCharacter;
		int drawHeight;
		
		// get user input
		drawCharacter = getDrawCharacter(scan);
		drawHeight = getDrawHeight(scan);

		// create whitespace, draw right triangle, close resources
		System.out.println("");
		drawRightTriangle(drawCharacter, drawHeight);
		scan.close();
	}
	
	/**
	 * This method draws the right triangle to the specified height using the 
	 * given character.
	 * 
	 * @param drawCharacter Character used the draw the triangle.
	 * @param drawHeight Determines how tall the triangle is.
	 */
	public static void drawRightTriangle(char drawCharacter, int drawHeight) {
		int heightIndex, widthIndex;
		int drawWidth = 1;
		
		// loop for drawing vertically
		for (heightIndex = 0; heightIndex < drawHeight; heightIndex++) {
			
			// loop for drawing horizontally
			for (widthIndex = 0; widthIndex < drawWidth; widthIndex++) {
				System.out.print("" + drawCharacter + " ");
			}
			drawWidth++;
			
			System.out.println("");
		}
		
	}
	
	/**
	 * Gets character from user. Must be passed in a scanner.
	 * 
	 * @param scan Scanner to be used to get character.
	 * @return char
	 */
	public static char getDrawCharacter(Scanner scan) {
		char returnCharacter = 'U'; // 'U' is default character, can be changed
		
		System.out.print("Enter a character: ");
		if (scan.hasNext()) {
			returnCharacter = scan.next().charAt(0);
			scan.nextLine(); // clear the scanner
			return returnCharacter;
		} else {
			return returnCharacter;
		}
	}
	
	/**
	 * Gets height from user. Height must be integer. Must be passed in a scanner.
	 * 
	 * @param scan Scanner to be used to get height.
	 * @return int
	 */
	public static int getDrawHeight(Scanner scan) {
		int returnHeight;
		boolean notWithinRange = true;

		System.out.print("Enter triangle height (1-10): ");
		do {
			if (scan.hasNextInt()) {
				returnHeight = scan.nextInt();
				if (returnHeight < 1 || returnHeight > 10) {
					System.out.println("Please enter height between 1 and 10.");
					scan.nextLine();
				} else {
					notWithinRange = false;
					scan.close();
					return returnHeight;
				}
			} else {
				System.out.println("Please enter height between 1 and 10.");
				scan.nextLine();
			}
		} while (notWithinRange);
		
		return -1; // if something went wrong
	}
	
	/**
	 * Used for testing purposes.
	 * 
	 * @param scan
	 */
	public static void testRun(Scanner scan) {
		System.out.println("Test run - Individual Methods");
		System.out.println("Character: " + getDrawCharacter(scan));
		System.out.println("Height: " + getDrawHeight(scan));
		System.out.println("Draw Rectangle: \n\n"); drawRightTriangle('U', 7);

		System.out.println("\nTest run - System");
		drawRightTriangle(getDrawCharacter(scan), getDrawHeight(scan));
	}
}
