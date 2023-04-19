///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Caption
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

public class Caption {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userCaption;
		
		userCaption = scnr.nextLine();
		String correctedCaption = userCaption;
		
		// if punctuation found, check it
		if (!Character.isLetter(userCaption.charAt(userCaption.length() - 1)))
		{
			// check for ! or ? and if true do nothing
			if (userCaption.charAt(userCaption.length() - 1) == '!' || userCaption.charAt(userCaption.length() - 1) == '?') 
				correctedCaption = userCaption;			
			
			// check for (comma), and if true replace with period
			if (userCaption.charAt(userCaption.length() - 1) == ',')
				correctedCaption = userCaption.substring(0, userCaption.length() - 1) + ".";
			
			// check for two ending periods, and if so check for a third. 
			// if third, do nothing; otherwise remove one period
			if (userCaption.length() > 1 && userCaption.charAt(userCaption.length() - 1) == '.' && userCaption.charAt(userCaption.length() - 2) == '.')
				if (userCaption.length() > 2 && userCaption.charAt(userCaption.length() - 3) == '.')
					correctedCaption = userCaption;
				else
					correctedCaption = userCaption.substring(0, userCaption.length() - 1);
		}
		else //just add a period
		{
			correctedCaption = userCaption.concat(".");			
		}

		System.out.println(correctedCaption);
	}
}
