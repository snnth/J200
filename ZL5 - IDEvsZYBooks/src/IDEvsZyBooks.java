///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           IDE vs zyBooks
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
 * The behavior of this code is different in Eclipse or IntelliJ as compared to zyBooks.
 * Refactor the code so that it works in both zyBooks and Eclipse or IntelliJ.
 *
 * @author mrenault, Yanan, mppowers
 *
 */

public class IDEvsZyBooks {
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	    	
        System.out.println("Enter 3 integers:");
        int a = readInt(scan);
        int b = readInt(scan);
        int c = readInt(scan);
        System.out.println("The integers you entered are: " + a + ", " + b + ", and " + c);
        compareSum(a, b, c);
        
        System.out.println("Enter 3 words:");
        String d = readWord(scan);
        String e = readWord(scan);
        String f = readWord(scan);
        System.out.println("The words you entered are: \"" + d + "\", \"" + e + "\", and \"" + f + "\"");
        compareSum(d, e, f);
        
        scan.close();
    }

    public static void compareSum(int a, int b, int c) {
        if (a + b == c) {
            System.out.println(a + " + " + b + " equals " + c);
        } else if (a + b < c) {
            System.out.println(a + " + " + b + " is less than " + c);
        } else {
            System.out.println(a + " + " + b + " is greater than " + c);
        }
    }
    
    public static void compareSum(String a, String b, String c)	{
    	if (a.concat(b).equals(c)) {
    		System.out.println("\"" + a + "\" concatenated with \"" + b + "\" is \"" + c + "\"");	
    	} else {
    		System.out.println("\"" + a + "\" concatenated with \"" + b + "\" is not \"" + c + "\"");    		
    	}
    }

    public static int readInt(Scanner sc) {
    	return sc.nextInt();
    }

    public static String readWord(Scanner sc) {
        return sc.next();
    }
}