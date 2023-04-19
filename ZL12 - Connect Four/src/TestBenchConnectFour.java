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

public class TestBenchConnectFour {

	public static void main(String[] args) {
		testIsWinningCord();
	}

	// Add at least 4 more clearly distinct test vectors to help debug the bugs in isWinningCoord
	public static void testIsWinningCord() {
		{//Vertical
			int[][] board = {
					{0,-1,-1,-1,-1,-1,-1},
					{0,-1,-1,-1,-1,-1,-1},
					{0,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1}
			};
			System.out.println("Vertical winning move test (Row: 3, Col: 0): " +
					ConnectFour.isWinningCoord(3, 0, board, 0));
			ConnectFour.drawBoard(board);
		}
		{//Diagonal Negative 1
			int[][] board = {
					{ 1, 1, 1, 0,-1,-1,-1},
					{ 1, 1, 0,-1,-1,-1,-1},
					{ 1, 0,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1}
			};
			System.out.println("Diagonal (neg) winning move test (Row: 3, Col: 0): " +
					ConnectFour.isWinningCoord(3, 0, board, 0));
			ConnectFour.drawBoard(board);
		}
		{//Diagonal Negative 2
			int[][] board = {
					{ 1, 1, 1,-1,-1,-1,-1},
					{ 1, 1, 0,-1,-1,-1,-1},
					{ 1, 0,-1,-1,-1,-1,-1},
					{ 0,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1}
			};
			System.out.println("Diagonal (neg) winning move test (Row: 0, Col: 3): " +
					ConnectFour.isWinningCoord(0, 3, board, 0));
			ConnectFour.drawBoard(board);
		}
		{//Diagonal Positive 1
			int[][] board = {
					{ 0, 1, 1, 1,-1,-1,-1},
					{-1, 0, 1, 1,-1,-1,-1},
					{-1,-1, 0, 1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1}
			};
			System.out.println("Diagonal (pos) winning move test (Row: 3, Col: 3): " +
					ConnectFour.isWinningCoord(3, 3, board, 0));
			ConnectFour.drawBoard(board);
		}
		{//Diagonal Positive 2
			int[][] board = {
					{-1, 1, 1, 1,-1,-1,-1},
					{-1, 0, 1, 1,-1,-1,-1},
					{-1,-1, 0, 1,-1,-1,-1},
					{-1,-1,-1, 0,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1}
			};
			System.out.println("Diagonal (pos) winning move test (Row: 0, Col: 0): " +
					ConnectFour.isWinningCoord(0, 0, board, 0));
			ConnectFour.drawBoard(board);
		}
		{//Horizontal Left
			int[][] board = {
					{ 0, 0, 0,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1}
			};
			System.out.println("Horizontal-Left winning move test (Row: 0, Col: 3): " +
					ConnectFour.isWinningCoord(0, 3, board, 0));
			ConnectFour.drawBoard(board);
		}
		{//Horizontal Right
			int[][] board = {
					{-1,-1,-1,-1, 0, 0, 0},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1}
			};
			System.out.println("Horizontal-Right winning move test (Row: 0, Col: 3): " +
					ConnectFour.isWinningCoord(0, 3, board, 0));
			ConnectFour.drawBoard(board);
		}
		{//Horizontal Center
			int[][] board = {
					{-1,-1, 0, 0, 0,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1}
			};
			System.out.println("Horizontal-Center winning move test (Row: 0, Col: 1): " +
					ConnectFour.isWinningCoord(0, 1, board, 0));
			ConnectFour.drawBoard(board);
		}
	}

}

