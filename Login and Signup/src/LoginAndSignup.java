///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           ZL11 - Login and Signup
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class LoginAndSignup {

	/**
	 * readFromFile method will read from the database file and save all usernames,
	 * passwords, and keys in the corresponding ArrayLists.If the file cannot open,
	 * output error message: <dbName> cannot open!
	 * @param dbName The file name to save all users, passwords, and keys
	 * @param users
	 * @param pwds
	 * @param keys
	 */
	public static void readFromFile(String dbName, ArrayList<String> users, ArrayList<String> pwds, ArrayList<Integer> keys) {
		try {
			File database = new File(dbName);

			Scanner fileScanner = new Scanner(database);
			Scanner lineScanner;
			while (fileScanner.hasNextLine()) {
				lineScanner = new Scanner(fileScanner.nextLine());
				users.add(lineScanner.next());
				pwds.add(lineScanner.next());
				keys.add(lineScanner.nextInt());
				lineScanner.close();
			}

			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println(dbName + " cannot open!");
		}
	}

	/**
	 * writeToFile method write the username password and key back to the file
	 * The username and its corresponding encrypted password and key are written in the same line.
	 * Use tab to separate each of them. If the file cannot open,
	 * output error message: <fileName> cannot open!
	 * @param fileName
	 * @param users
	 * @param encryptedpwds
	 * @param keys
	 */
	public static void writeToFile(String fileName, ArrayList<String> users, ArrayList<String> encryptedpwds, ArrayList<Integer> keys) {
		try {
			PrintWriter fileWriter = new PrintWriter(new File(fileName));

			for (int i = 0; i < users.size(); i++) {
				fileWriter.println(users.get(i) + "\t" + encryptedpwds.get(i) + "\t" + keys.get(i));
			}

			fileWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " cannot open!");
		}
	}

	/**
	 * Encrypt the password - shift all the character in the password to the right for key position
	 * @param password
	 * @param key
	 * @return an encrypted password
	 */
	public static String pwdEncryption(String password, int key) {
		String encryptedPass = "";
		for (int i = 0; i < password.length(); i++) {
			encryptedPass += Character.toString(password.charAt(i) + key);
		}

		return encryptedPass;
	}

	/**
	 * Decrypt the password - left shift the encrypted password to key position
	 * @param encryptedPassword
	 * @param key
	 * @return the original password
	 */
	public static String pwdDecryption(String encryptedPassword, int key){
		String decryptedPass = "";
		for (int i = 0; i < encryptedPassword.length(); i++) {
			decryptedPass += Character.toString(encryptedPassword.charAt(i) - key);
		}

		return decryptedPass;
	}

	/**
	 * Check whether the username and password are correct
	 * if the username does not exist, return "Invalid username"
	 * if the username exists but the password is incorrect, return "Invalid password"
	 * if the username exists and password is correct, return "Successful login"
	 *
	 * @param users ArrayList contains all usernames
	 * @param pwds ArrayList contains all passwords
	 * @param keys ArrayList contains all keys to encrypt and decrypt
	 * @param userName
	 * @param password
	 * @return String a message to indicate the login result
	 */
	public static String login(ArrayList<String> users, ArrayList<String> pwds, ArrayList<Integer> keys, String userName, String password) {
		int userIndex = users.indexOf(userName);
		if (userIndex == -1)
			return "Invalid username";

		if (!password.equals(pwdDecryption(pwds.get(userIndex), keys.get(userIndex))))
			return "Invalid password";

		return "Successful login";
	}

	/**
	 * This method is used for signup
	 * If the newUsername already exists, then the signup action fails and return "Invalid username"
	 * Else signup action succeed and add username, encrypted password and the key to the corresponding ArrayList.
	 * return "Successful signup"
	 * @param rand Random instance to generate a random key. The key should in range of [1, 20]
	 * @param users ArrayList contains all usernames
	 * @param pwds ArrayList contains all passwords
	 * @param keys ArrayList contains all keys to encrypt and decrypt
	 * @param newUser new username
	 * @param newPwd new password
	 * @return String a message to indicate the signup result
	 */
	public static String signup(Random rand, ArrayList<String> users, ArrayList<String> pwds, ArrayList<Integer> keys, String newUser, String newPwd) {
		if (!uniqueUser(newUser, users))
			return "Invalid username";

		users.add(newUser);
		int key = rand.nextInt(20) + 1;
		pwds.add(pwdEncryption(newPwd, key));
		keys.add(key);
		return "Successful signup";
	}

	/**
	 * Determine whether the new username exists
	 * @param newUser
	 * @param users
	 * @return boolean true if the newUser doesn't exist
	 * 				   false if the newUser already exists
	 */
	public static boolean uniqueUser(String newUser, ArrayList<String> users) {
		if (users.contains(newUser))
			return false;

		return true;
	}

	public static void main(String[] args) {
		ArrayList<String> registeredUsers = new ArrayList<>();
		ArrayList<String> userPasswords = new ArrayList<>();
		ArrayList<Integer> userKeys = new ArrayList<>();
		readFromFile("userDB.txt", registeredUsers, userPasswords, userKeys);

		System.out.println("Welcome to my CS200 program!");
		Random keyGeneration = new Random(Config.SEED);
		Scanner userInput = new Scanner(System.in);
		boolean successfulLogin = false;
		int menuAction = -1;
		do {
			System.out.println("Please select the following actions:");
			System.out.println("1.Login");
			System.out.println("2.Signup");

			if (userInput.hasNextInt()) { // ensures integer is being used
				menuAction = userInput.nextInt();
			} else {
				System.out.println("Unrecognized action");
				userInput.nextLine();
				continue;
			}

			switch (menuAction) {
				case 1: // login
					System.out.print("Please enter the username: ");
					String registeredUsername = userInput.next();
					System.out.print("Please enter the password: ");
					String registeredPassword = userInput.next();

					String loginResult = login(registeredUsers, userPasswords, userKeys,
							registeredUsername, registeredPassword);
					System.out.println(loginResult);
					if (loginResult.equals("Successful login"))
						successfulLogin = true;

					break;
				case 2: // signup
					System.out.print("Please enter the new username: ");
					String desiredUsername = userInput.next();
					System.out.print("Please enter the new password: ");
					String desiredPassword = userInput.next();
					System.out.println(signup(keyGeneration, registeredUsers, userPasswords, userKeys,
							desiredUsername, desiredPassword));
					break;
				default: // any other action
					System.out.println("Unrecognized action");
					break;
			}
		} while (!successfulLogin);

		userInput.close();
	}

	private static void tests() {
		System.out.println("Tests:");
		boolean allTestsPassed = true;

		{   // tests if readFromFile correctly reads from file
			ArrayList<String> expectedUsers = new ArrayList<>();
			ArrayList<String> expectedPasswords = new ArrayList<>();
			ArrayList<Integer> expectedKeys = new ArrayList<>();
			expectedUsers.add("ritattt");
			expectedPasswords.add("wrqjuxlkdq");
			expectedKeys.add(3);

			ArrayList<String> actualUsers = new ArrayList<>();
			ArrayList<String> actualPasswords = new ArrayList<>();
			ArrayList<Integer> actualKeys = new ArrayList<>();
			readFromFile("userDB.txt", actualUsers, actualPasswords, actualKeys);

			if (!actualUsers.toString().equals(expectedUsers.toString()) ||
					!actualPasswords.toString().equals(expectedPasswords.toString()) ||
					!actualKeys.toString().equals(expectedKeys.toString()))
			{
				System.out.println("readFromFileTest Failed: expected= " + expectedUsers.toString() +
						expectedPasswords.toString() + expectedKeys.toString() +
						" | actual= " + actualUsers.toString() + actualPasswords.toString() + actualKeys.toString());
				allTestsPassed = false;
			}
		}

		{   // tests if writeToFile writes to file
			ArrayList<String> users = new ArrayList<>();
			ArrayList<String> passwords = new ArrayList<>();
			ArrayList<Integer> keys = new ArrayList<>();

			users.add("user");
			passwords.add("password");
			keys.add(100);
			writeToFile("actualTestDatabase.txt", users, passwords, keys);

			File file = new File("actualTestDatabase.txt");
			if (file.length() != 19) {
				System.out.println("writeToFileTest Failed: expected= file length 19 | " +
						"actual= file length " + file.length());
				allTestsPassed = false;
			}
		}

		{   // tests password encryption
			String expected = "def";
			String actual =	pwdEncryption("abc", 3);
			if (!expected.equals(actual)) {
				System.out.println("pwdEncryptionTest Failed: expected= " + expected + " | actual= " + actual);
				allTestsPassed = false;
			}
		}

		{   // tests password decryption
			String expected = "gh";
			String actual = pwdDecryption("hi", 1);
			if (!expected.equals(actual)) {
				System.out.println("pwdDecryptionTest Failed: expected= " + expected + " | actual= " + actual);
				allTestsPassed = false;
			}
		}

		{   // tests if signup detects duplicate usernames
			Random rand = new Random(Config.SEED);
			ArrayList<String> users = new ArrayList<>();
			ArrayList<String> passwords = new ArrayList<>();
			ArrayList<Integer> keys = new ArrayList<>();
			users.add("dupe");

			String expected = "Invalid username";
			String actual = signup(rand, users, passwords, keys, "dupe", "pwd");
			if (!expected.equals(actual)) {
				System.out.println("signupTest Failed: expected= " + expected + " | actual= " + actual);
				allTestsPassed = false;
			}
		}

		{   // tests if signup signs up unique user
			Random rand = new Random(Config.SEED);
			ArrayList<String> users = new ArrayList<>();

			String expected = "Successful signup";
			String actual = signup(rand, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
					"newUser", "pass");
			if (!expected.equals(actual)) {
				System.out.println("signupTest Failed: expected= " + expected + " | actual= " + actual);
				allTestsPassed = false;
			}
		}

		{   // tests if uniqueUser detects duplicate user
			ArrayList<String> users = new ArrayList<>();
			users.add("newUser");

			boolean expected = false;
			boolean actual = uniqueUser("newUser", users);
			if (expected != actual) {
				System.out.println("uniqueUserTest Failed: expected= " + expected + " | actual= " + actual);
				allTestsPassed = false;
			}
		}

		{   // tests if uniqueUser detects duplicate user
			ArrayList<String> users = new ArrayList<>();
			users.add("diffUser");

			boolean expected = true;
			boolean actual = uniqueUser("newUser", users);
			if (expected != actual) {
				System.out.println("uniqueUserTest Failed: expected= " + expected + " | actual= " + actual);
				allTestsPassed = false;
			}
		}

		{   // tests if login detects if username is not valid
			ArrayList<String> users = new ArrayList<>();
			ArrayList<String> passwords = new ArrayList<>();
			ArrayList<Integer> keys = new ArrayList<>();
			users.add("newUser");

			String expected = "Invalid username";
			String actual = login(users, passwords, keys, "oldUser", "password");
			if (!expected.equals(actual)) {
				System.out.println("uniqueUserTest Failed: expected= " + expected + " | actual= " + actual);
				allTestsPassed = false;
			}
		}

		{   // tests if login detects if wrong password is given
			ArrayList<String> users = new ArrayList<>();
			ArrayList<String> passwords = new ArrayList<>();
			ArrayList<Integer> keys = new ArrayList<>();
			users.add("newUser");
			passwords.add("def");
			keys.add(3);

			String expected = "Invalid password";
			String actual = login(users, passwords, keys, "newUser", "def");
			if (!expected.equals(actual)) {
				System.out.println("uniqueUserTest Failed: expected= " + expected + " | actual= " + actual);
				allTestsPassed = false;
			}
		}

		{   // tests if login successfully logs in user with correct information
			ArrayList<String> users = new ArrayList<>();
			ArrayList<String> passwords = new ArrayList<>();
			ArrayList<Integer> keys = new ArrayList<>();
			users.add("newUser");
			passwords.add("def");
			keys.add(3);

			String expected = "Successful login";
			String actual = login(users, passwords, keys, "newUser", "abc");
			if (!expected.equals(actual)) {
				System.out.println("uniqueUserTest Failed: expected= " + expected + " | actual= " + actual);
				allTestsPassed = false;
			}
		}

		if (!allTestsPassed)
			System.out.println("Some tests failed.");
		else
			System.out.println("All tests passed!");
	}

}
