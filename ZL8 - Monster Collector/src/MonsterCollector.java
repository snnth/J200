///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           ZL8 - Monster Collector
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
import java.util.Random;
import java.util.Scanner;

public class MonsterCollector {

	/*
	 * This method is for trying to catch a monster of your very own!
	 * Generate a random number from 1 to 5 inclusive. If the user did NOT guess this number, they caught the monster.
	 * Add that monster to the next null spot in the myMonster array. If they were successful
	 * in catching the monster print "Congratulations, you caught [monster]!"
	 * otherwise print "You almost had it, but the monster escaped."
	 * If monster, myMonsters, or rand is null, return before doing ANYTHING else in the method.
	 *
	 * @param userGuess - user guess between 1 and 5
	 * @param monster - monster retrieved from getMonster
	 * @param myMonsters - array of monsters user has caught
	 * @param rand - random number generator
	 */
	public static void catchMonster(int userGuess, String monster, String[] myMonsters, Random rand) {
		if (monster == null || myMonsters == null || rand == null) {
			return;
		}

		int cpuNum = rand.nextInt(5) + 1;
		if (userGuess != cpuNum) {
			System.out.println("Congratulations, you caught " + monster + "!");
			for (int i = 0; i < myMonsters.length; i++) {
				if (myMonsters[i] == null) {
					myMonsters[i] = monster;
					return;
				}
			}
		} else {
			System.out.println("You almost had it, but the monster escaped.");
		}
	}

	/*
	 * This method is for retrieving your next monster to encounter.
	 * Search through the array starting at index 0 until you find an index that is not null;
	 * this will be the monster you encounter. Set that monsters index to null and return
	 * the monster.
	 *
	 * @param monsters - the array of monster left to encounter
	 * @return String - next monster to encounter. If monsters is null, return null.
	 * If you search through the entire monsters array, and all indexes are null, return null.
	 */

	public static String getMonster(String[] monsters) {
		String monster = "";
		for (int i = 0; i < monsters.length; i++) {
			if (monsters[i] != null) {
				monster = monsters[i];
				monsters[i] = null;
				return monster;
			}
		}
		return null;
	}

	/*
	 * Count the number of monsters the user caught, and print it to the console.
	 * If the user caught all the monsters, they are the master! Otherwise,
	 * they must continue to train.
	 * The number of monsters the user caught will be the number of non-null elements in the user's monster array,
	 * while the total possible monsters is the size of the myMonsters array.
	 * (See assignment page for example output)
	 *
	 * @param myMonsters - monsters the user has caught
	 */
	public static void printResult(String[] myMonsters) {
		int collectionAmount = 0, i = 0;

		for (i = 0; i < myMonsters.length; i++) {
			if (myMonsters[i] != null) {
				collectionAmount++;
			}
		}

		System.out.println("You caught " + collectionAmount + " monsters of " + myMonsters.length);

		if (collectionAmount == myMonsters.length) {
			System.out.println("You're the monster collector master!");
		} else {
			System.out.println("Keep training to be the very best!");
		}
	}

	/*
	 * This is the main method.
	 * Config.MONSTERS is an array provided in Config.java, full of cool monsters to encounter!
	 * Create a new array the same size as Config.MONSTERS, then copy all the entries from Config.MONSTERS
	 * into your new array.(Hint: A loop could be useful here)
	 * Welcome your user to the game, and start your game loop. The game ends when the user has encountered
	 * all monsters in our monsters array.
	 * First get the monster we are going to encounter. If the monster is null, inform the user there are no more
	 * monsters to encounter, and end the game. If the monster is not null, prompt the user for a number between
	 * 1 and 5 and begin the encounter. If the user input is out of range of 1 - 5, prompt the user again until we
	 * receive correct input.
	 * When the game ends, print the results.
	 * (See assignment page for example output)
	 *
	 * @param args unused
	 */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random(Config.SEED);

		int userInt = 0, i = 0;
		String monster = "";
		String[] collectedMonsters = new String[Config.MONSTERS.length];
		String[] monsters = new String[Config.MONSTERS.length];
		for (i = 0; i < monsters.length; i++) {
			monsters[i] = Config.MONSTERS[i];
		}

		System.out.println("Welcome to Monster Collector, collect " + monsters.length + " monsters to win!");

		for (i = 0; i < monsters.length; i++) {
			monster = getMonster(monsters);
			System.out.println("A wild " + monster + " appears! Guess a number between 1 and 5");

			if (scan.hasNextInt()) {
				userInt = scan.nextInt();
			}
			catchMonster(userInt, monster, collectedMonsters, rand);
		}

		System.out.println("There are no more monsters to encounter!");
		printResult(collectedMonsters);
	}
}
