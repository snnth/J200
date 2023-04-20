///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           ZL13 - Sudoku
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

import javax.annotation.processing.ProcessingEnvironment;
import javax.imageio.IIOException;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Matthew Smith
 */
public class Sudoku {

	/**
	 * Build a String containing character c of length len
	 *
	 * @param len The number of characters in the String
	 * @param c The character that makes up the String
	 * @return A string consisting of character c with length len, followed by a newline
	 */
	public static String constructLine(int len, char c) {
		String constructedLine = "";
		for (int i = 0; i < len; i++) {
			constructedLine = constructedLine.concat("" + c);
		}
		return constructedLine.concat("\n");
	}

	/**
	 * Convert the Sudoku board into a String following the pattern below.
	 * You can assume board is always a 9*9 2d array.
	 -------------------------
	 | 9 1 _ | _ _ _ | 4 2 7 |
	 | _ _ _ | _ _ 3 | 9 1 5 |
	 | 2 5 4 | 7 _ _ | 6 8 _ |
	 -------------------------
	 | 4 7 _ | _ 8 6 | _ 3 2 |
	 | _ 6 _ | 4 _ _ | _ _ 8 |
	 | 5 _ _ | _ 1 2 | _ 6 _ |
	 -------------------------
	 | 3 4 _ | 6 2 _ | _ _ 1 |
	 | _ _ _ | 3 _ _ | _ _ _ |
	 | _ 2 6 | _ _ 8 | _ _ 9 |
	 -------------------------

	 * Some key observations from the pattern:
	 *     1. In each row, there's a '|' after every 3 numbers
	 *     2. There is a line of '-' after every 3 lines (use constructLine to do this)
	 *     3. The length of each row is 25 (not including '\n')

	 * In the 2d array:
	 * for a number from 1 to 9, meaning it's a valid number, you should put the number itself;
	 * if a number equals to Config.EMPTY, meaning this position is currently empty, you should put a '_' instead.
	 *
	 * Note: Don't duplicate code. Be sure to use constructLine method.
	 * Note: Don't simply copy the example given above. You need to generate your output
	 *       according to the content in the input board.
	 *
	 * @param board A 2d array representing the Sudoku board
	 * @return A String containing the display of the Sudoku board,
	 *         or empty string if board is null
	 */
	public static String constructBoardString(int[][] board) {
		if (board == null)
			return "";

		String boardString = constructLine(25, '-');

		for (int i = 0; i < board.length; i++) {
			boardString = boardString.concat("| "); // start board line
			for (int j = 0; j < board[i].length; j++) {
				if (j == 3 || j == 6) {
					boardString = boardString.concat("| ");
				}

				if (board[i][j] == 0) {
					boardString = boardString.concat("_ ");
					continue;
				}

				boardString = boardString.concat("" + board[i][j] + " ");
			}
			boardString = boardString.concat("|\n"); // end board line

			if (i == 2 || i == 5) { // create seperator if need be
				boardString = boardString.concat(constructLine(25, '-'));
			}
		}

		return boardString.concat(constructLine(25, '-'));
	}

	/**
	 * Given an original Sudoku board, find the positions for pre-existing numbers
	 * For each element in the returned array:
	 * mark a true if the corresponding position in the board has a valid number (1~9);
	 * mark a false if the corresponding position in the board is empty (Config.EMPTY).
	 *
	 * A simplified example:
	 * 	Given {{Config.EMPTY, 1},
	 * 	       {3, Config.EMPTY}}
	 * 	Return {{false, true},
	 * 	        {true, false}}
	 *
	 * @param board The original board at the beginning of the game
	 * @return A 2d boolean array parallel to board, representing whether there's
	 *         a pre-existing number for each position; or null if board is null
	 */
	public static boolean[][] findOriginalPosition(int[][] board) {
		if (board == null)
			return null;

		boolean[][] staticValues = new boolean[9][9];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == Config.EMPTY) {
					staticValues[i][j] = false;
				} else {
					staticValues[i][j] = true;
				}
			}
		}

		return staticValues;
	}

	/**
	 * Check whether the Sudoku board is fully filled with valid numbers.
	 *
	 * Note: In this method, you only need to check whether the board is filled
	 * without empty positions (Config.EMPTY). You don't need to worry about if there's any
	 * conflict in the board.
	 *
	 * @param board The current board that needs to be checked
	 * @return true if fully filled; false otherwise, and when board is null.
	 */
	public static boolean checkFullForBoard(int[][] board) {
		if (board == null)
			return false;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == Config.EMPTY)
					return false;
			}
		}

		return true;
	}

	/**
	 * Check if some number (1~9) appears more than once in the array.
	 *
	 * A possible algorithm:
	 *     1. Create a boolean array of nine elements, each element corresponding to one number.
	 *     2. Loop through the input array arr, if the corresponding position of a number
	 *        in the boolean array is false, mark it as true.
	 *     3. If the position of a number is already true, return false (duplicate number found).
	 *
	 * @param arr A 1d array that needs to be checked
	 * @return true if no conflict; false otherwise, and when arr is null.
	 */
	public static boolean checkConflictForArray(int[] arr) {
		if (arr == null)
			return false;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 1 || arr[i] > 9) {
				continue;
			}
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] < 1 || arr[j] > 9) {
					continue;
				}
				if (arr[i] == arr[j] && i != j) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Check whether there's no conflict in the board (in each row, column and square)
	 *
	 * Note: Don't duplicate code. Be sure to use checkConflictForArray method.
	 *     For each row, column and square, first create array of 9 number set.
	 *     Then call checkConflictForArray method.
	 *
	 * Checking square is a little tricky, below is a possible algorithm:
	 *     for (each square s from all the 9 squares in the board) {
	 *         create a tempArr of size 9
	 *         for (each position [r, c] from all the 9 positions in square s) {
	 *             copy s[r][c] into a corresponding position in tempArr
	 *             // you need to figure out a 1-to-1 map between the index in tempArr
	 *             // and the index in square s
	 *         }
	 *         call checkConflictForArray with tempArr
	 *     }
	 *
	 * @param board The current board that needs to be checked
	 * @return true if no conflict; false otherwise, and when board is null
	 */
	public static boolean checkConflictForBoard(int[][] board) {
		if (board == null)
			return false;

		// check rows
		for (int i = 0; i < board.length; i++) {
			if (!checkConflictForArray(board[i])) {
				return false;
			}
		}

		// check columns
		int[] columnArray = new int[board.length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				columnArray[i] = board[j][i];
			}
			if (!checkConflictForArray(columnArray))
				return false;
		}

		// check square... coordinates are top left of square
		int[] squareArray = new int[9];
		for (int i = 0; i < 7; i += 3) { // segment square vertically
			for (int j = 0; j < 7; j += 3) { // segment square horizontally
				int position = 0;
				for (int k = 0; k < 3; k++) { // run through all nine spots in square and add them to array
					for (int l = 0; l < 3; l++) {
						squareArray[position++] = board[i + k][j + l];
					}
				}
				if (!checkConflictForArray(squareArray)) // check for conflicts
					return false;
			}
		}

		return true;
	}

	/**
	 * First check whether it's a valid move to put the given number at the given position,
	 * and then put the given number into the board if and only if it's a valid move.
	 *
	 * @param row The row you want to fill number
	 * @param col The column you want to fill number
	 * @param val The number you want to fill in
	 * @param board The current Sudoku board
	 * @param original The boolean array parallel to board, representing whether
	 *        there's a pre-existing number for each position
	 * @return 0 if either board or original is null
	 *         -1 if the row is out of valid range (0~8)
	 *         -2 if the column is out of valid range (0~8)
	 *         -3 if val is out of valid range (1~9 and Config.EMPTY)
	 *         -4 if the number at the current position (row, col) is pre-existing
	 *         -5 if there's a conflict in the board after filling in val at (row, col)
	 *            Note: remember to call checkConflictForBoard for this
	 *         1 if there's a success filling in the number. If and only if in
	 *         this case, should you actually place the number into the board.
	 *
	 *         Note: You need to check the conditions exactly in the above order.
	 */
	public static int fillNumber(int row, int col, int val, int[][] board, boolean[][] original) {
		if (board == null || original == null)
			return 0;

		if (row < 0 || row > 8)
			return -1;

		if (col < 0 || col > 8)
			return -2;

		if (val < 0 || val > 9)
			return -3;

		if (original[row][col])
			return -4;

		// fill the spot
		int previousVal = board[row][col];
		board[row][col] = val;

		if (!checkConflictForBoard(board)) {
			board[row][col] = previousVal;
			return -5;
		}

		return 1;
	}

	/**
	 * Read the original Sudoku board from a file.
	 * Refer to Chapter 11 in zyBook about how to read files.
	 *
	 * You can assume the file content is always in the following format:
	 * 	1. There are 9 lines in the file.
	 * 	2. Each line has 9 numbers separated by a space.
	 *
	 * @param fileName The file containing a Sudoku board
	 * @return A 2d array representing the Sudoku board read from the file
	 * @throws FileNotFoundException
	 */
	public static int[][] readBoardFromFile(String fileName) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(fileName));

		int[][] board = new int[9][9];
		int lineNumber = 0;
		while(scan.hasNextLine()) {
			String[] parsedLineArray = scan.nextLine().trim().split(" ");
			for (int i = 0; i < parsedLineArray.length; i++) {
				board[lineNumber][i] = Integer.parseInt(parsedLineArray[i]);
			}
			lineNumber++;
		}

		scan.close();
		return board;
	}

	/**
	 * Write the current Sudoku board to a file with the following format:
	 * 	1. Write each row of the board into a separate line
	 * 	2. Numbers in each line are separated by a space
	 *
	 * Refer to Chapter 11 in zyBook about how to write files.
	 *
	 * @param board The current Sudoku board
	 * @param fileName The file that needs to be written
	 * @throws IOException
	 */
	public static void saveBoardToFile(int[][] board, String fileName) throws IOException {
		FileOutputStream fileStream = new FileOutputStream(fileName);
		PrintWriter writer = new PrintWriter(fileStream);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (j == board.length - 1)
					writer.println(board[i][j]);
				else
					writer.print(board[i][j] + " ");
			}
		}

		writer.flush();
		fileStream.close();
	}

	/**
	 * This is the main program loops, prompts for user input and prints to the
	 * console.
	 *
	 * Algorithm
	 * 1. Initialize and welcome, print "Welcome to Sudoku!"
	 * 2. Prompt for input of a filename from where to load the original board:
	 *    "Please enter a file name to load Sudoku board (default is sudoku_board.txt): "
	 *    	- If user enters nothing, use the default file: sudoku_board.txt
	 * 2. Load the original Sudoku board from file
	 *    	- If file doesn't exist, quit with message "Cannot read from file <filename>"
	 *    	  with <filename> replaced by the filename
	 * 3. Create a 2d boolean array, parallel to the board, to mark the original
	 *    positions with pre-existing numbers
	 * 4. Game loop
	 * 		a) Prompt for input in the format of (row column value):
	 *           "Choose a position and fill a number (row column value): "
	 * 		b) If row is invalid, print "Row out of range (0~8)!"
	 * 		c) If column is invalid, print "Column out of range (0~8)!"
	 * 		d) If value is invalid, print "Value out of range (1~9)!"
	 * 		e) If it's a position with pre-existing number, print "The number at
	 * 		   this position is given to you. You cannot change!"
	 * 		f) If there's some conflict, print "The input caused a conflict in
	 * 		   row, column, or square! Try again!"
	 * 		g) If the input number is filled into the board successfully, check
	 * 		   whether the board is fully filled and finish the game if it is.
	 * 		Note: Don't duplicate code. Be sure to use fillNumber method.
	 * 5. If the game is finished with a success,
	 * 		a) print "Congratulations! You have won!"
	 * 		b) prompt for input ("Do you want to save your solution? (y/n): ")
	 * 		c) if y, save the finished board to file (solution.txt); if n, do nothing;
	 * 		   if neither, print "Unknown command. Defaulting to y..." and save to file
	 *      d) if file doesn't exist, quit with message "Cannot write to file <filename>"
	 *         with <filename> replaced by the filename
	 * 6. Print ending information ("Thanks for playing Sudoku!")
	 *
	 * @param args unused
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Sudoku!");
		System.out.print("Please enter a file name to load Sudoku board (default is sudoku_board.txt): ");

		Scanner userInput = new Scanner(System.in);
		String filename = userInput.nextLine();
		if (filename.equals("") || filename.equals("\n") || filename.equals("\t")) {
			filename = "sudoku_board.txt";
		}

		try {
			int[][] board = readBoardFromFile(filename);
			boolean[][] original = findOriginalPosition(board);

			int row = -1, column = -1, value = -1;
			do {
				System.out.print(constructBoardString(board));
				System.out.print("Choose a position and fill a number (row column value): ");

				Scanner parseUserInput = new Scanner(userInput.nextLine());
				row = Integer.parseInt(parseUserInput.next());
				column = Integer.parseInt(parseUserInput.next());
				value = Integer.parseInt(parseUserInput.next());

				switch (fillNumber(row, column, value, board, original)) {
					case -1:
						System.out.println("Row out of range (0~8)!");
						break;
					case -2:
						System.out.println("Column out of range (0~8)!");
						break;
					case -3:
						System.out.println("Value out of range (0~9)!");
						break;
					case -4:
						System.out.println("The number at this position is given to you. You cannot change!");
						break;
					case -5:
						System.out.println("The input caused a conflict in row, column, or square! Try again!");
						break;
					case 0:
						System.out.println("DEVELOPER PROBLEMS");
						break;
					default:
						break;
				}
				parseUserInput.close();

			} while (!checkFullForBoard(board));

			System.out.println("Congratulations! You have won!");
			System.out.print("Do you want to save your solution? (y/n): ");

			String saveOption = userInput.next();
			if (saveOption.equalsIgnoreCase("n")) {
				System.out.println("Thanks for playing Sudoku!");
				userInput.close();
				return;
			} else if (saveOption.equalsIgnoreCase("y")) {
				saveBoardToFile(board, "solution.txt");
			} else {
				System.out.println("Unknown command. Defaulting to y...");
				saveBoardToFile(board, "solution.txt");
			}

		} catch (FileNotFoundException e) {
			System.out.println("Cannot read from file " + filename);
			userInput.close();
			return;
		} catch (IOException e) {
			System.out.println("Cannot write to file solution.txt");
			userInput.close();
			return;
		}

		System.out.println("Thanks for playing Sudoku!");
		userInput.close();
	}
}
