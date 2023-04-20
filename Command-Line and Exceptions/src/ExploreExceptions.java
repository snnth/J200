///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           TL10 - Command-Line and Exceptions
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
 * @author Matthew Smith
 */
import java.io.IOException;

public class ExploreExceptions {

	/**
	 * @throws IOException
	 * @throws Exception  Since Exception is a parent of IOException,
	 *        only Exception is necessary. However for CS 200 we aren't
	 *        considering inheritance relationships so listing both
	 *     since both are checked exceptions and may be thrown.
	 */
	static String lookupData(String key) throws Exception, IOException {
		if (key == null) {
			throw new IOException("null key");
		} else if (key.length() == 0) {
			throw new Exception("0 length key");
		}
		return key;
	}

	/**
	 * @throws Exception  Required due to the throw statement in catch
	 */
	static void process(String key) throws Exception {

		System.out.print("A");
		try {
			System.out.print("B");
			String data = lookupData(key);
			System.out.print("C");
			return;
		} catch (IOException e) {
			System.out.print("D");
		} catch (Exception e) {
			System.out.print("E");
			throw e;
		} finally {
			System.out.print("F");
		}
		System.out.print("G");
	}

	public static void main(String[] args) throws Exception {
		process(null);
		System.out.println();
		process("abc");
		System.out.println();
		try {
			process("");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
}