///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           ZL7 - Output Four Per Line
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
 * Outputs contents of an array such that there are four values per line
 *
 * @author Matthew Smith
 */
public class FourPerLine {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int index;
		int[] array = new int[12];

		for (index = 0; index < array.length; ++index) {
			array[index] = scan.nextInt();
		}

		for (index = 0; index < array.length; index +=4) {
			System.out.print(array[index] + " ");
			System.out.print(array[index + 1] + " ");
			System.out.print(array[index + 2] + " ");
			System.out.println(array[index + 3]);
		}

	}
}
