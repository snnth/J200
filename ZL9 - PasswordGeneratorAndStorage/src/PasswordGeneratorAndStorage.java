///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           ZL9 - PasswordGeneratorAndStorage
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

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Matthew Smith
 */
public class PasswordGeneratorAndStorage {

	/**
	 * Adds an application to the applications ArrayList. If index is -1, add application
	 * to the end of applications. Else is index is within the size of applications, add
	 * application at that index in applications. Otherwise, return. However, if applications
	 * or application is null, return.
	 *
	 * @param applications
	 * @param application
	 * @param index
	 */
	public static void addApplication(ArrayList<String> applications, String application, int index) {
		if (applications == null || application == null || index < -1 || index >= applications.size()) {
			return;
		}

		if (index == -1) {
			applications.add(application);
		}

		if (index >= 0 && index < applications.size()) {
			applications.add(index, application);
		}
	}

	/**
	 * Generates a random password of length passwordLength and adds it to the end of
	 * passwords if index is -1, or adds it to the index of passwords if index is within the
	 * size of passwords (similar to how the addApplication adds an application). To generate
	 * the random password, use rand to generate a random int within the size of characters. You
	 * can then use this int to grab the char at that index in characters and concatenate that
	 * to your String password variable. However, if passwords is null, return.
	 *
	 * @param passwords
	 * @param passwordLength
	 * @param rand
	 * @param index
	 * @param characters
	 */
	public static void addPassword(ArrayList<String> passwords, int passwordLength, Random rand, int index, String characters) {
		if (passwords == null || index < -1 || index >= passwords.size()) {
			return;
		}

		String password = "";
		int i, selector = 0;
		for (i = 0; i < passwordLength; i++) {
			selector = rand.nextInt(Config.CHARACTERS.length());
			password = password.concat(Character.toString(Config.CHARACTERS.charAt(selector)));
		}

		if (index == -1) {
			passwords.add(password);
		}

		if (index >= 0 && index < passwords.size()) {
			passwords.add(index, password);
		}
	}

	/**
	 * Removes a password from your password storage parallel ArrayLists. To do this, remove the
	 * first instance (starting from index 0 of applications) of application in applications. Then
	 * remove its corresponding password in passwords. If there are duplicate application/password
	 * pairs (ie two Facebook passwords) you should only remove the first instance. However, if
	 * applications or passwords are null, return.
	 *
	 * @param applications
	 * @param passwords
	 * @param application
	 */
	public static void removePassword(ArrayList<String> applications, ArrayList<String> passwords, String application) {
		if (applications == null || applications.size() == 0 || passwords == null || passwords.size() == 0
				|| application == null)
		{
			return;
		}

		for (int i = 0; i < applications.size(); i++) {
			if (application.equals(applications.get(i))) {
				applications.remove(i);
				passwords.remove(i);
				return;
			}
		}
	}

	/**
	 * Generates a String with a display message for your applications and passwords,
	 * where the passwords are in star notation (every character in the password is
	 * replaced with '*'). The start of your message should be "Your Passwords:\n".
	 * Return "You do not have any passwords in storage!\n" if applications is null or
	 * empty or passwords is null or empty.
	 * Note: your generated String should end with a single '\n'.
	 * Example:
	 * Your Passwords:
	 * Canvas: ********
	 * Piazza: *************
	 *
	 * @param applications
	 * @param passwords
	 * @return the display message
	 */
	public static String getDisplayString(ArrayList<String> applications, ArrayList<String> passwords) {
		if (applications == null || applications.size() == 0 || passwords == null || passwords.size() == 0) {
			return "You do not have any passwords in storage!\n";
		}

		String displayString = "Your Passwords:\n";

		for (int i = 0; i < applications.size(); i++) {
			displayString = displayString.concat(applications.get(i) + ": ");
			for (int j = 0; j < passwords.get(i).length(); j++) {
				displayString = displayString.concat("*");
			}
			displayString = displayString.concat("\n");
		}

		return displayString;
	}

	public static void main(String[] args) {
		// setup
		Random rand = new Random(Config.SEED);
		ArrayList<String> applications = new ArrayList<>();
		ArrayList<String> passwords = new ArrayList<>();

		// add applications and passwords
		addApplication(applications, "Facebook", -1);
		addPassword(passwords, 8, rand, -1, Config.CHARACTERS);

		addApplication(applications, "Google", -1);
		addPassword(passwords, 16, rand, -1, Config.CHARACTERS);

		addApplication(applications, "Canvas", 1);
		addPassword(passwords, 8, rand, 1, Config.CHARACTERS);

		addApplication(applications, "Instagram", 0);
		addPassword(passwords, 24, rand, 0, Config.CHARACTERS);

		// display applications and passwords
		System.out.print(getDisplayString(applications, passwords));

		// remove certain passwords
		removePassword(applications, passwords, "Google");
		removePassword(applications, passwords, "Piazza");
		removePassword(applications, passwords, "Facebook");

		// display applications and passwords
		System.out.print(getDisplayString(applications, passwords));

		// remove certain passwords
		removePassword(applications, passwords, "Canvas");
		removePassword(applications, passwords, "Instagram");

		// display applications and passwords
		System.out.print(getDisplayString(applications, passwords));
	}
}
