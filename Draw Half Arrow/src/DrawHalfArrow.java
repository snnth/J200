///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           ZL6 - Draw Half Arrow
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

/**
 * @author Matthew Smith
 *
 */
public class DrawHalfArrow {
	
	public static void main(String[] args) {
		
		// create the variables/objects needed
		Scanner scnr = new Scanner(System.in);
		int arrowBaseHeight = 0;
		int arrowBaseWidth = 0;
		int arrowHeadWidth = 0;

		int i = 0;
		int j = 0;

		System.out.print("Enter arrow base height: ");
		arrowBaseHeight = scnr.nextInt();

		System.out.print("Enter arrow base width: ");
		arrowBaseWidth = scnr.nextInt();

		System.out.print("Enter arrow head width: ");
		arrowHeadWidth = scnr.nextInt();

		// make sure arrow head width is larger than base width
		while (arrowHeadWidth <= arrowBaseWidth) {
			System.out.print("Enter arrow head width: ");
			arrowHeadWidth = scnr.nextInt();
		}
		
		// create space between input and output
		System.out.println("");
		
		// draw arrow base
		for (i = 0; i < arrowBaseHeight; i++) { // loop for drawing vertically
			
			for (j = 0; j < arrowBaseWidth; j++) { // loop for drawing horizontally
				System.out.print("*");
			}
			
			System.out.println("");
		}
		
		// draw arrow head
		int tipWidth = arrowHeadWidth;
		
		for (i = 0; i < arrowHeadWidth; i++) { // loop for drawing vertically
			
			for (j = tipWidth; j > 0; j--) { // loop for drawing horizontally
				System.out.print("*");
			}
			tipWidth--;
			
			System.out.println("");
		}

		return;
	}
}
