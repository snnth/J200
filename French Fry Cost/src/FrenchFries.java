///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           ZL10 - French Fry Cost
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

import java.util.Scanner;

/**
 * FrenchFries collects an int and double from the user and uses them to either
 * compute and print out the cost of a meal, or to print out an error message
 * when the price of a valid meal cannot be computed
 *
 * <p>Bugs: (a list of bugs and other problems)
 *
 * @author Matthew Smith
 */
public class FrenchFries{

	/**
	 *  computes the cost of a classic french fry meal consisting of numOrders of
	 *  French fries which each cost costPerOrder dollars.
	 *
	 *  @param numOrders the number of orders of the user wants to buy
	 *  @param costPerOrder dollar cost of a single order of French fries.
	 *  @return the cost of the meal if both numOrders and costPerOrder are valid
	 */
	public static double computeCost(int numOrders, double costPerOrder)
	{
		if (numOrders < 0 && costPerOrder < 0.0)
			throw new IllegalArgumentException("Orders and the cost per order cannot be negative.");

		if (numOrders < 0)
			throw new IllegalArgumentException("You cannot order negative fries.");

		if (costPerOrder < 0.0)
			throw new IllegalArgumentException("Fries must cost money.");

		return numOrders * costPerOrder;
	}

	/**
	 * Collects input from the user and either computes and
	 * prints out the cost of a meal, or to print out an error
	 * message when the price of a valid meal cannot be computed.
	 *
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		// gets the number of french fry orders from user.
		System.out.println("How many orders of French fries would you like?");
		while(!input.hasNextInt() && input.hasNextLine())
		{
			input.nextLine();
		}
		int numOrders = input.nextInt();

		// gets the cost of french fries from the user.
		System.out.println("How much does an order of fries cost?");
		while(!input.hasNextDouble() && input.hasNextLine())
		{
			input.nextLine();
		}
		double costPerOrder = input.nextDouble();

		// computes the cost or prints an error message
		try
		{
			double mealCost = computeCost(numOrders, costPerOrder);

			System.out.println("The cost of your French fries is $"+String.format("%.2f", mealCost)+".");
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("Error: "+e.getMessage());
		}
	}
}