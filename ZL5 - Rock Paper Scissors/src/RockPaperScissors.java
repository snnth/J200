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
import java.util.Random;

public class RockPaperScissors {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		Random rand = new Random(Config.SEED);
		String userChoiceString;
		int userChoiceInt, cpuChoiceInt;
				
		System.out.print("Please select one of [R/P/S]: ");
		if(scan.hasNext()) {
			userChoiceString = scan.next();
		} else {
			userChoiceString = "z";
		}
		
		if (userChoiceString.length() < 1 || userChoiceString.length() > 1) {
			userChoiceString = "z";
		}
		
		// convert users choice for comparison and displays choice
		userChoiceInt = convertUserChoice(userChoiceString.trim().charAt(0));
		displayChoice("You", userChoiceInt);
		if (userChoiceInt == 0) {
			userChoiceInt = 1;	
		}
		
		cpuChoiceInt = generateCpuChoice(rand);
		displayChoice("I", cpuChoiceInt);
		
		play(userChoiceInt, cpuChoiceInt);
		
		scan.close();
	}
	
	public static void play(int a, int b) {
		// scenarios for user losing
		if (a == 1 && b == 2) {
			System.out.println("Paper beats rock - you lose!");
		} else if (a == 2 && b == 3) {
			System.out.println("Scissors beats paper - you lose!");
		} else if (a == 3 && b == 1) {
			System.out.println("Rock beats scissors - you lose!");
		} else if (a == 2 && b == 1) {
			System.out.println("Paper beats rock - you win!");
		} else if (a == 3 && b == 2) {
			System.out.println("Scissors beats paper - you win!");
		} else if (a == 1 && b == 3) {
			System.out.println("Rock beats scissors - you win!");
		} else {
			System.out.println("A Tie!");
		}
	}
	
	public static void displayChoice(String who, int choiceInt) {
		if (choiceInt == 0) {
			System.out.println("Invalid choice! Defaulting to Rock.");
			return;
		}
		
		String choiceString = "placeholder";
		switch (choiceInt) {
		case 1:
			choiceString = "Rock";
			break;
		case 2:
			choiceString = "Paper";
			break;
		case 3:
			choiceString = "Scissors";
			break;
		}
		
		System.out.println(who + " chose: " + choiceString);
	}
	
	public static int convertUserChoice(char ch) {
		ch = Character.toLowerCase(ch);
		
		switch (ch) {
		case 'r':
			return 1;
		case 'p':
			return 2;
		case 's':
			return 3;
		default: 
			return 0;		
		}
	}
	
	public static int generateCpuChoice(Random r) {
		return r.nextInt(3) + 1;
	}
	
}