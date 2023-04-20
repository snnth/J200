///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           descriptive title of the program making use of this file
// Course:          course number, term, and year
//
// Author:          your name
// Email:           your @wisc.edu email address
// Lecturer's Name: name of your lecturer
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
public class Clue{
	public static void main(String[] args){
		// create new scanner and suspect variables
		Scanner scan = new Scanner(System.in);
		String suspectOne, suspectTwo;
		   
		// ask user who were the two people with alibi
		System.out.println("Who was the first person with the alibi?");
		if (scan.hasNext())
		   suspectOne = scan.next();
		else 
		   suspectOne = "tempOne";
		   
			System.out.println("Who was the second person with the alibi?");
		if (scan.hasNext())
		   suspectTwo = scan.next();
		else 
		   suspectTwo = "tempTwo";
		   
		System.out.println(murdererMessage(identifyMurderer(suspectOne, suspectTwo)));        
	}
    
	public static String identifyMurderer(String first, String second) {
		// clean up the inputs for comparing
		first = first.trim();
		second = second.trim();
		  
		// determine how to build string and build string
		if (first.equalsIgnoreCase("amos") && second.equalsIgnoreCase("kevin")) {
			return "juan";
		} else if (first.equalsIgnoreCase("amos") && second.equalsIgnoreCase("juan")) {
			return "kevin";
		} else if (first.equalsIgnoreCase("kevin") && second.equalsIgnoreCase("amos")) {
			return "juan";
		} else if (first.equalsIgnoreCase("kevin") && second.equalsIgnoreCase("juan")) {
			return "amos";
		} else if (first.equalsIgnoreCase("juan") && second.equalsIgnoreCase("amos")) {
			return "kevin";
		} else if (first.equalsIgnoreCase("juan") && second.equalsIgnoreCase("kevin")) {
			return "amos";
		} else {
			return "unknown";
		}
	}
   
   	/**
	 * Determines the detective's message. The input should be case insensitive. 
	 * If the murderer is not recognized or is null, the message
	 * "We're not sure who that is. We need to investigate further." is returned.
	 *
	 * @param murderer abbreviation.
	 * @return The detective's message for a given murderer. 
	 */
	public static String murdererMessage(String murderer) { 
		murderer = murderer.trim();
		if (murderer.equalsIgnoreCase("amos")) {
			return "It was Amos with the candlestick!";			
		} else if (murderer.equalsIgnoreCase("kevin")) {
			return "It was Kevin with the revolver!";			
		} else if (murderer.equalsIgnoreCase("juan")) {
			return "It was Juan with the lead pipe!";
		} else {
			return "We're not sure who that is. We need to investigate further.";
		}
	}
}