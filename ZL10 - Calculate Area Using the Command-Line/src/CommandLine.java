///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           ZL10 - Calculate Area Using the Command-Line
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
 * Returns the area of either a square or rectangle with side lengths given by command line arguments.
 *
 * If only one argument is passed in, the area of a square will be calculated. If two arguments are passed in
 * the area of a rectangle will be calculated.
 *
 * @author Matthew Smith
 */
public class CommandLine {

	public static void main(String[] args) {
		switch (args.length) {
			case 1:
				System.out.print(calculateArea(Integer.parseInt(args[0])));
				break;
			case 2:
				System.out.print(calculateArea(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
				break;
			default:
				System.out.print("usage: java CommandLine.java [squareSide] or java CommandLine.java " +
						"[rectangleSide1] [rectangleSide2]");
				break;
		}

		return;
	}

	/**
	 * Calculates the area of a square. Side length must be an integer.
	 *
	 * @param   squareSide length of one side of square
	 * @return  calculated area of the square
	 */
	private static int calculateArea(int squareSide) {
		return squareSide * squareSide;
	}

	/**
	 * Calculates the area of a rectangle. Side lengths must be integers.
	 *
	 * @param   rectangleSideA length of one side of the rectangle
	 * @param   rectangleSideB length of a differing side of the rectangle
	 * @return  calculated area of the rectangle
	 */
	private static int calculateArea(int rectangleSideA, int rectangleSideB) {
		return rectangleSideA * rectangleSideB;
	}

}
