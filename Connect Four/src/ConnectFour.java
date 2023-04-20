///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           ZL12 - Connect Four
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

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class ConnectFour {

	final static int BOARD_WIDTH = 7;
	final static int BOARD_HEIGHT = 6;
	final static int CONNECT_WIN = 4;
	final static int COMPUTER_PLAYER = 0;
	final static int HUMAN_PLAYER = 1;

	public enum argState {NONE, PLAYERS, TEST};

	/**
	 * A Connect Four game. To enter test mode, use -t followed by any long number. To change the amount
	 * of players use -p followed by 0, 1, or 2.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numPlayers = 2;
		boolean testMode = false;
		boolean seedInput = false;
		long seed = 0;

		argState cmdFlag = argState.NONE;
		for (String arg: args) {
			switch (arg) {
				case "-t":
					cmdFlag = argState.TEST;
					break;
				case "-p":
					cmdFlag = argState.PLAYERS;
					break;
				default:
					if (cmdFlag == argState.TEST) {
						seed = Long.parseLong(arg);
						seedInput = true;
					}  else if (cmdFlag == argState.PLAYERS) {
						numPlayers = Integer.parseInt(arg);
					}
					cmdFlag = argState.NONE;
					break;
			}
		}

		Random rand;
		if (seedInput) {
			rand = new Random(seed);
		} else {
			rand = new Random();
		}

		int[] players = new int[]{COMPUTER_PLAYER, COMPUTER_PLAYER};
		for(int i = 0; i < numPlayers && i < players.length; i++) {
			players[i] = HUMAN_PLAYER;
		}

		boolean gameOn = true;
		System.out.println("Welcome to Connect Token Game. \nOn your turn, please select a column from 1 to " +
				BOARD_WIDTH + " to drop your token.");
		int[][] board = new int[BOARD_HEIGHT][BOARD_WIDTH];
		for (int i = 0; i < board.length; i++) {
			Arrays.fill(board[i], -1);
		}

		int player = 0;
		drawBoard(board);
		while (gameOn) {
			System.out.println("Player " + (player + 1) + " your move:");

			if(players[player] == HUMAN_PLAYER) {
				while (!input.hasNextInt()){
					input.next();
				}
				int move = input.nextInt();
				if (move < 1 || move > BOARD_WIDTH || board[BOARD_HEIGHT - 1][move - 1] != -1) {
					System.out.println("Invalid column: " + move + ". Please select a (non-full) column from 1 to " +
							BOARD_WIDTH + ".");
					continue;
				}
				gameOn = !isWinningCol(move - 1, board, player);
				dropToken(move - 1, board, player);
			} else {
				gameOn = !executeTurnCPU(board, player, rand);
			}
			
			drawBoard(board);
			if(!gameOn) {
				System.out.println("Player " + (player + 1) + " won!");
			}
			player = (player + 1) % 2;
			if(gameOn && checkFullBoard(board)) {
				System.out.println("Game over. We have a draw!");
				gameOn = false;
			}
		}

		System.out.println("Thank you for playing!");
	}

	/**
	 * Checks if the game board is full, i.e., if no more tokens can be added.
	 *
	 * A game board is not full if any of the top most cells contain the value -1.
	 *
	 * @param board The game board to verify. It must be of size BOARD_WIDTH * BOARD_HEIGHT.
	 * @return true if the game board is not full, false otherwise.
	 */
	public static boolean checkFullBoard(int[][] board) {
		for(int i = 0; i < BOARD_WIDTH; i++)
		{
			if(board[BOARD_HEIGHT - 1][i] == -1)
				return false;
		}
		return true;
	}

	/**
	 * Maps the player index to a character.
	 *
	 * @param player The integer index to map to a character.
	 * @return Returns the mapped character:
	 *         - 0 is mapped to 'X'
	 *         - 1 is mapped to 'O'
	 *         - Every other index is mapped to ' '
	 */
	public static char getToken(int player) {
		return (player == 0 ? 'X' : (player == 1 ? 'O' : ' '));
	}

	/**
	 * Drops a token into the game board at a specified column, col. The token is place at the lowest
	 * unfilled cell (value -1) of column col. Specifically, the lowest unfilled cell is set to the player
	 * index.
	 *
	 * @param col The column where the token is dropped.
	 * @param board The game board into which the token is dropped. It must be of size BOARD_WIDTH * BOARD_HEIGHT.
	 * @param player The player index.
	 * @return Returns false if the column if full, i.e., the maximum index is not -1. Otherwisem returns true.
	 */
	public static boolean dropToken(int col, int[][] board, int player) {
		if(board[BOARD_HEIGHT - 1][col] != -1) {
			return false;
		}
		for(int i = 0; i < board.length; i++) {
			if(board[i][col] == -1) {
				board[i][col] = player;
				break;
			}
		}
		return true;
	}

	/**
	 * Checks each column to see if dropping a token at that column would result in a win for
	 * the specified player index.
	 *
	 * @param board The game board into which the token is dropped. It must be of size BOARD_WIDTH * BOARD_HEIGHT.
	 * @param player The player index.
	 * @returns The lowest column index for which the specified player would win by dropping a token. If there is
	 *          no such column, -1 is returned.
	 */
	public static int findWinningMove(int[][] board, int player) {
		for(int col = 0; col < BOARD_WIDTH; col++) {
			if(isWinningCol(col, board, player)) {
				return col;
			}
		}
		return -1;
	}

	/**
	 * Checks if dropping a token at the specified column for the specified player would result in
	 * a win.
	 *
	 * @param col The column where the token is dropped.
	 * @param board The game board into which the token is dropped. It must be of size BOARD_WIDTH * BOARD_HEIGHT.
	 * @param player The player index.
	 * @return true if col is a winning column for player. Otherwise, returns false.
	 */
	public static boolean isWinningCol(int col, int[][] board, int player) {
		for(int i = BOARD_HEIGHT - 1; i >= 0; i--)
		{
			if(isWinningCoord(i, col, board, player)) { return true; }
		}
		return false;
	}

	/**
	 * Checks if specified coordinate is a winning spot for the specified players if token is dropped there.
	 *
	 * @param row The row the coordinate is on.
	 * @param column The column the coordinate is on.
	 * @param board The game board.
	 * @param player The player index.
	 * @return true if coordinate is a winning coordinate. Otherwise, returns false.
	 */
	public static boolean isWinningCoord(int row, int column, int[][] board, int player) {
		if (row >= BOARD_HEIGHT || row < 0 || column >= BOARD_WIDTH || column < 0 || board[row][column] != -1
				|| (row < BOARD_HEIGHT - 1 && board[row + 1][column] != -1)
				|| (row > 0 && board[row - 1][column] == -1))
		{
			return false;
		}

		{ // Vertical
			int count = 0;
			for (int i = row - 1; i >= 0; i--) {
				if (board[i][column] != player) {
					break;
				} else {
					count++;
				}
			}

			if (count >= CONNECT_WIN - 1) {
				return true;
			}
		}

		{ // Horizontal
			int count = 0;
			for (int i = column - 1; i >= 0; i--) {
				if (board[row][i] != player) {
					break;
				} else {
					count++;
				}
			}
			for (int i = column + 1; i < BOARD_WIDTH; i++) {
				if (board[row][i] != player) {
					break;
				} else {
					count++;
				}
			}
			if (count >= CONNECT_WIN - 1) {
				return true;
			}
		}

		{ // Diagonals
			int countNegSlope = 0, iteration = 0;
			for (int i = row + 1; i < BOARD_HEIGHT; i++){
				for (int j = column - iteration - 1; j >= 0; j--){
					if (board[i][j] != player) {
						iteration++;
						break;
					} else {
						countNegSlope++;
					}
				}
			}

			iteration = 0;
			for (int i = row - 1; i >= 0; i--){
				for (int j = column + iteration + 1; j < BOARD_WIDTH; j++){
					if (board[i][j] != player) {
						iteration++;
						break;
					} else  {
						countNegSlope++;
					}
				}
			}

			if (countNegSlope >= CONNECT_WIN - 1) {
				return true;
			}

			int countPosSlope = 0;
			iteration = 0;
			for (int i = row + 1; i < BOARD_HEIGHT; i++){
				for (int j = column + iteration + 1; j < BOARD_WIDTH; j++){
					if (board[i][j] != player) {
						iteration++;
						break;
					} else {
						countPosSlope++;
					}
				}
			}

			iteration = 0;
			for (int i = row - 1; i >= 0; i--){
				for (int j = column - iteration - 1; j >= 0; j--){
					if (board[i][j] != player) {
						iteration++;
						break;
					} else {
						countPosSlope++;
					}
				}
			}

			if (countPosSlope >= CONNECT_WIN - 1) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Set of instructions to execute a full turn for the specified player. Will either drop a winning token
	 * for specified player, drop a token in the opposing players winning coordinate to block them, or pick a spot
	 * at random.
	 *
	 * @param board The game board.
	 * @param player The player index,
	 * @param rand Random number generator for creating random moves.
	 * @return true if move won specified player the game. Otherwise, false.
	 */
	public static boolean executeTurnCPU(int[][] board, int player, Random rand) {
		int column = findWinningMove(board, player);
		if(column != -1) {
			dropToken(column, board, player);
			return true;
		}

		column = findWinningMove(board, (player + 1) % 2);
		if(column != -1) {
			dropToken(column, board, player);
			return false;
		}

		do {
			column = rand.nextInt(BOARD_WIDTH);
		} while(board[BOARD_HEIGHT - 1][column] != -1);
		dropToken(column, board, player);
		return false;
	}

	/**
	 * Draws the game board. Top and bottom of the game board made up of '-', vertical divers are made up of '|', and
	 * each column is labeled at the bottom.
	 *
	 * @param board The game board.
	 */
	public static void drawBoard(int[][] board) {
		for(int i = 0; i < BOARD_WIDTH; i++) {
			System.out.print("--");
		}
		System.out.println("-");

		for(int i = board.length - 1; i >= 0; i--) {
			System.out.print("|");
			for(int j = 0; j < BOARD_WIDTH; j++) {
				System.out.print(getToken(board[i][j]) + "|");
			}
			System.out.println();
		}

		for(int i = 0; i < BOARD_WIDTH; i++) {
			System.out.print("--");
		}
		System.out.println("-");

		System.out.print(" ");
		for(int i = 0; i < BOARD_WIDTH; i++) {
			System.out.print((i + 1) + " ");
		}
		System.out.println();
	}

}
