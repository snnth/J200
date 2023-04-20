///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Guessing Game
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

public class GuessingGame {
	
	public static void main(String args[]) {
		// set up variables and objects needed for game
		Scanner scan = new Scanner(System.in);
		Random rand = new Random(Config.SEED);
		int generatedNum, guessedNum, totalGuesses, guessesRemaining;
		generatedNum = rand.nextInt(5) + 1; 
		totalGuesses = 2; // just in case, you know?
		guessesRemaining = totalGuesses;
		
		// user can guess totalGuesses amount of times
		System.out.println("Guess a number between 1 and 5");
		while (guessesRemaining != 0) {
			
			// if its their second try, or more, tell them to "Guess again!"
			if (guessesRemaining < totalGuesses)
				System.out.println("Guess again!");
			
			// ask for the guess
			guessedNum = scan.nextInt();
			
			// if they got it right, tell them and end the loop
			if (guessedNum == generatedNum) {
				System.out.println("You win!");
				break;
			} else {
				// else, reduce the amount of guesses they have by one
				guessesRemaining -= 1;
				
				// if no more guesses, they lose.
				if (guessesRemaining == 0) {
					System.out.println("You lose! It was " + generatedNum);
					break;
				}
				
				// otherwise, tell the user how close they were
				if (guessedNum < generatedNum) {
					System.out.println("That's too low");
				} else {
					System.out.println("That's too high");
				}
			}
		}
		
		scan.close();
	}
}
