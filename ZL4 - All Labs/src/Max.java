///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Max
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

public class Max {
	
	/**
	 * Determines the max of given values
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @return maxNumber 
	 */
	public static int maxFive(int a, int b, int c, int d, int e) {
		int maxFound = a;
		
		// determine which number is the largest
		if (maxFound < b)
			maxFound = b;
		if (maxFound < c)
			maxFound = c;
		if (maxFound < d)
			maxFound = d;
		if (maxFound < e)
			maxFound = e;
		
		return maxFound;
	}
	
	public static void main(String[] args) {
		// Don't modify main's code below
		Scanner scnr = new Scanner(System.in); 
		int v, w, x, y, z;
		int maxVal;
		
		v = scnr.nextInt(); 
		w = scnr.nextInt(); 
		x = scnr.nextInt(); 
		y = scnr.nextInt(); 
		z = scnr.nextInt(); 
		
		maxVal = maxFive(v, w, x, y, z);
		System.out.println(maxVal); 
	}
}
