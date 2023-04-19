///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Hotdog Detector
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

public class HotdogDetector {
	
	public static void main(String args[]) {
		// create variables and instances needed
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a food: ");
		if (scan.hasNextLine()) {
			hotdogCheck(scan.nextLine());
		} else {
			hotdogCheck("nah");
		}
	}
	
	public static void hotdogCheck(String a) {
		if (a.trim().equals("hotdog")) {
			System.out.println("hotdog");
		} else {
			System.out.println("not hotdog");
		}
	}

}
