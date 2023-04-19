///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           ZL9 - DNA Sequencing
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
import java.util.Scanner;

/**
 * @author Matthew Smith
 */
public class DNASequencing {

	/**
	 * Creates a String representing the given DNA sequence.
	 * Return null if DNA is null.
	 *
	 * @param DNA
	 * @return the String representation of the DNA sequence
	 */
	public static String getSequence(ArrayList<Character> DNA) {
		if (DNA == null) {
			return null;
		}

		String sequence = "";
		for (Character nucleotide: DNA) {
			sequence = sequence.concat(nucleotide.toString());
		}

		return sequence;
	}

	/**
	 * Swaps the given Character with another Character if it is within the DNA sequence.
	 * Return if DNA is null.
	 *
	 * @param DNA
	 * @param swap1
	 * @param swap2
	 */
	public static void swapNucleotides(ArrayList<Character> DNA, char swap1, char swap2) {
		if (DNA == null || DNA.size() < 1) {
			return;
		}

		char uppercaseSwap1 = Character.toUpperCase(swap1);
		char uppercaseSwap2 = Character.toUpperCase(swap2);
		for (int i = 0; i < DNA.size(); i++) {
			if (DNA.get(i) == uppercaseSwap1) {
				DNA.set(i, uppercaseSwap2);
			} else if (DNA.get(i) == uppercaseSwap2) {
				DNA.set(i, uppercaseSwap1);
			}
		}
	}

	/**
	 * Checks for a specific String sequence within the given DNA sequence.
	 * Return false if DNA or sequence are null.
	 *
	 * @param DNA
	 * @return true if the sequence is found, else false
	 */
	public static boolean containsSequence(ArrayList<Character> DNA, String sequence) {
		if (DNA == null || sequence == null)
			return false;

		if (getSequence(DNA).contains(sequence.toUpperCase()))
			return true;

		return false;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Character> DNA = new ArrayList<>();

		System.out.print("Enter number of nucleotides: ");
		int DNALength = scan.nextInt();

		System.out.println("Enter each nucleotide on a new line");
		if (DNALength > 0) {
			String userNucleotide = "";
			char parsedNucleotide;
			do {
				userNucleotide = scan.next();
				parsedNucleotide = userNucleotide.toUpperCase().charAt(0);

				if (parsedNucleotide == 'A' || parsedNucleotide == 'T'
						|| parsedNucleotide == 'G' || parsedNucleotide == 'C')
				{
					DNA.add(parsedNucleotide);
				} else {
					scan.nextLine();
				}
			} while (DNA.size() < DNALength);
		}

		System.out.println(getSequence(DNA));

		swapNucleotides(DNA, 'A', 'T');
		System.out.println(getSequence(DNA));

		swapNucleotides(DNA, 'C', 'G');
		System.out.println(getSequence(DNA));

		System.out.println(containsSequence(DNA, "TACG"));
		System.out.println(containsSequence(DNA, "GCATTA"));
		System.out.println(containsSequence(DNA, "CGCG"));
	}
}