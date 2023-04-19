///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           ZL6 - Calendar
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

/**
 * This class contains the entire program to print out a yearly calendar.
 *
 * @author Jim Williams
 * @author Matthew Smith
 */
public class Calendar {

	/**
	 * This prompts for the year and the day of the week of January 1st and then
	 * prints out a calendar for the entire year.
	 *
	 * @param args unused
	 */
	public static void main(String[] args) {
		final char FIRST_MONTH = 1;
		final char LAST_MONTH = 12;
		final int DAYS_IN_A_WEEK = 7;

		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter year:");
		int year = input.nextInt();
		
		System.out.print("Enter day of week of Jan 1 (0-Sunday, 1-Monday, etc):");
		int startDay = input.nextInt();

		for (int month = FIRST_MONTH; month <= LAST_MONTH; ++month) {
			String monthName = getMonthName(month);
			displayMonthHeader(monthName, year);

			int daysInMonth = getDaysInMonth(month, year);
			displayMonthDays(startDay, daysInMonth);

			startDay = (startDay + daysInMonth) % DAYS_IN_A_WEEK;
		}
	}

	/**
	 * Builds and displays the header for each month in the calendar
	 * 
	 * @param monthName Name of month
	 * @param year What year that month is in
	 */
	public static void displayMonthHeader(String monthName, int year) {
		final int TOTAL_WIDTH = 28;
		final char MONTH_HEADER_LINE_CHAR = '-';

		System.out.println();
		String monthAndYearHeader = monthName + " " + year;
		int spacesBefore = (TOTAL_WIDTH - monthAndYearHeader.length()) / 2;
		fillWhitespace(' ', spacesBefore);
		System.out.println(monthAndYearHeader);
		fillWhitespace(MONTH_HEADER_LINE_CHAR, TOTAL_WIDTH);
		
		System.out.println();
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
	}

	/**
	 * Fills whitespace in the console with a given character for the given length  
	 * 
	 * @param character Character to be displayed
	 * @param length How many columns of spaces that will be filled
	 */
	public static void fillWhitespace(char character, int length) {
		for (int index = 0; index < length; index++) {
			System.out.print(character);
		}
	}

	/**
	 * Builds and displays each numerical day in the month in a calendar format.
	 * 
	 * @param startDay
	 * @param daysInMonth
	 */
	public static void displayMonthDays(int startDay, int daysInMonth) {
		final char CHAR_BETWEEN_DAYS = ' ';
		final int DAYS_IN_A_WEEK = 7;
		final int LOWEST_SINGLE_DIGIT_DAY = 1;
		final int HIGHEST_SINGLE_DIGIT_DAY = 9;

		fillWhitespace(CHAR_BETWEEN_DAYS, startDay * 4);
		for (int currentDay = 1; currentDay <= daysInMonth; currentDay++) {
			if (currentDay >= LOWEST_SINGLE_DIGIT_DAY && currentDay <= HIGHEST_SINGLE_DIGIT_DAY) {
				fillWhitespace(CHAR_BETWEEN_DAYS, 2);
			} else {
				fillWhitespace(CHAR_BETWEEN_DAYS, 1);
			}
			System.out.print(currentDay);
			fillWhitespace(CHAR_BETWEEN_DAYS, 1);
			
			startDay++;
			if (startDay % DAYS_IN_A_WEEK == 0) {
				System.out.println();
			}
		}
		
		System.out.println();
	}

	/**
	 * This returns the number of days in the specified month of year.
	 *
	 * @param month The month to return the number of days.
	 * @param year  The year is used for determining whether it is a leap year.
	 * @return The number of days in the specified month of the year.
	 */
	public static int getDaysInMonth(int month, int year) {
		int daysInMonth = 0;
		switch (month) {
		// 31 days
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			daysInMonth = 31;
			break;

		// 30 days
		case 4:
		case 6:
		case 9:
		case 11:
			daysInMonth = 30;
			break;

		case 2: // 28 or 29 days
			if (isLeapYear(year)) {
				daysInMonth = 29;
			} else {
				daysInMonth = 28;
			}
			break;
		}
		return daysInMonth;
	}

	/**
	 * Returns the name of the month, given the number of the month.
	 *
	 * @param month The month where 1 is January and 12 is December.
	 * @return The name of the month.
	 */
	public static String getMonthName(int month) {
		String monthStr;
		switch (month) {
		case 1:
			monthStr = "January";
			break;
		case 2:
			monthStr = "February";
			break;
		case 3:
			monthStr = "March";
			break;
		case 4:
			monthStr = "April";
			break;
		case 5:
			monthStr = "May";
			break;
		case 6:
			monthStr = "June";
			break;
		case 7:
			monthStr = "July";
			break;
		case 8:
			monthStr = "August";
			break;
		case 9:
			monthStr = "September";
			break;
		case 10:
			monthStr = "October";
			break;
		case 11:
			monthStr = "November";
			break;
		case 12:
			monthStr = "December";
			break;
		default:
			monthStr = "UNKNOWN";
			break;
		}
		return monthStr;
	}

	/**
	 * Every year that is exactly divisible by four is a leap
	 * year, except for years that are exactly divisible by 100, but these centurial
	 * years are leap years if they are exactly divisible by 400. For example, the
	 * years 1700, 1800, and 1900 are not leap years, but the years 1600 and 2000
	 * are. https://en.wikipedia.org/wiki/Leap_year
	 * 
	 * @param year Year to be analyzed
	 * @return True if given year is a leap year, false if not
	 */
	public static boolean isLeapYear(int year) {
		boolean leapYear = false;
		
		// every four years is a leap year
		if (year % 4 == 0) {
			
			// unless year is divisible by 100
			if (year % 100 == 0) {
				
				// except for every 400th year
				if (year % 400 == 0) {
					leapYear = true; // every 400 years
				} else {
					leapYear = false;
				}
			} else {
				leapYear = true; // every 4 years
			}
		} else {
			leapYear = false;
		}
	
		return leapYear;
	}
}
