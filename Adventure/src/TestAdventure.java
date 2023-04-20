///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           descriptive title of the program making use of this file
// Course:          course number, term, and year
//
// Author:          your name
// Email:           your @wisc.edu email address
// Lecturer's Name: name of your lecturer
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

import java.util.Arrays;
import java.util.Random;

/**
 * This contains testing methods for the Adventure program.
 */
public class TestAdventure {

    /**
     * Uncomment testing methods to have them run.
     * @param args unused
     */
    public static void main(String[] args) {
        testParseCoordinates();
        testParseFields();
        testDetermineLocation();
        testEnter();
        testMapString();
    }

    /**
     * Tests for the parseCoordinates method.
     */
    private static void testParseCoordinates() {
        boolean error = false;
        int testNum = 1;

        // 1 - test for splitting of normal coordinates
        {
            String coordinateString = "8,6";
            int [] expected = new int[]{8,6};
            int [] actual = Adventure.parseCoordinates(coordinateString);
            if ( !Arrays.equals(expected,actual)) {
                System.out.println("testParseCoordinates " + testNum++ + ") Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }

        // 2 - test for empty string
        {
            String coordinateString = "";
            int [] expected = null;
            int [] actual = Adventure.parseCoordinates(coordinateString);
            if (expected != actual) {
                System.out.println("testParseCoordinates " + testNum++ + ") Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }

        // 3 - test for blank string
        {
            String coordinateString = "     ";
            int [] expected = null;
            int [] actual = Adventure.parseCoordinates(coordinateString);
            if (expected != actual) {
                System.out.println("testParseCoordinates " + testNum++ + ") Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }

        // 4 - test for coordinate string of alpha chars with no comma
        {
            String coordinateString = "this is not a coordinate";
            int [] expected = null;
            int [] actual = Adventure.parseCoordinates(coordinateString);
            if (expected != actual) {
                System.out.println("testParseCoordinates " + testNum++ + ") Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }

        // 5 - test for coordinate string of alpha chars with one comma
        {
            String coordinateString = "these, are not coordinates";
            int [] expected = null;
            int [] actual = Adventure.parseCoordinates(coordinateString);
            if (expected != actual) {
                System.out.println("testParseCoordinates " + testNum++ + ") Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }

        // 6 - test for coordinate string of alpha chars with more than one comma
        {
            String coordinateString = "these, good sir, are not coordinates";
            int [] expected = null;
            int [] actual = Adventure.parseCoordinates(coordinateString);
            if (expected != actual) {
                System.out.println("testParseCoordinates " + testNum++ + ") Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }

        if ( error) {
            System.out.println("Error in testParseCoordinates.");
        } else {
            System.out.println("All tests in testParseCoordinates passed.");
        }
    }

    /**
     * Tests for the parseFields method.
     */
    private static void testParseFields() {
        boolean error = false;
        int testNum = 1;

        // Test that string without split delimiter is put in array
        {
            String fieldInformation = "this is just one field";
            String[] expected = new String[]{"this is just one field"};
            String[] actual = Adventure.parseFields(fieldInformation);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseFields " + testNum++ + ") Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }

        // Test that string with split delimiter and whitespaces are trimmed
        {
            String fieldInformation = " //   / ";
            String[] expected = new String[]{"","","",""};
            String[] actual = Adventure.parseFields(fieldInformation);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseFields " + testNum++ + ") Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }

        // 3 - Test that a normal string with split delimiter works
        {
            String fieldInformation = "this/is just a normal/string of field/information";
            String[] expected = new String[]{"this","is just a normal","string of field","information"};
            String[] actual = Adventure.parseFields(fieldInformation);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseFields " + testNum++ + ") Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }

        if ( error) {
            System.out.println("Error in testParseFields.");
        } else {
            System.out.println("All tests in testParseFields passed.");
        }
    }

    /**
     * Tests for the determineLocation method.
     */
    public static void testDetermineLocation() {
        boolean error = false;
        int testNum = 1;

        // Test player will wrap to right when moving left
        {
            String[][][] map = new String[3][3][1];
            int[] expected = new int[]{0, 2};
            int[] actual = Adventure.determineLocation(new String[3][3][1], new int[]{0, 0}, Config.MOVE_LEFT);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation " + testNum++ + ") Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }

        // Test player will wrap to left when moving right
        {
            String[][][] map = new String[3][3][1];
            int[] expected = new int[]{2, 0};
            int[] actual = Adventure.determineLocation(new String[3][3][1], new int[]{2, 2}, Config.MOVE_RIGHT);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation " + testNum++ + ") Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }

        // Test player will wrap to bottom when moving up
        {
            String[][][] map = new String[3][3][1];
            int[] expected = new int[]{2, 0};
            int[] actual = Adventure.determineLocation(new String[3][3][1], new int[]{0, 0}, Config.MOVE_UP);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation " + testNum++ + ") Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }

        // Test player will wrap to top when moving down
        {
            String[][][] map = new String[3][3][1];
            int[] expected = new int[]{0, 2};
            int[] actual = Adventure.determineLocation(new String[3][3][1], new int[]{2, 2}, Config.MOVE_DOWN);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation " + testNum++ + ") Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }

        if ( error) {
            System.out.println("Error in testDetermineLocation.");
        } else {
            System.out.println("All tests in testDetermineLocation passed.");
        }
    }

    /**
     * Tests for the enter method.
     */
    public static void testEnter() {
        boolean error = false;
        int testNum = 1;
        Random rand = new Random();
        String[][][] map = new String[][][] {
            {{Config.NAME_START, "this is the start", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}},
            {null, {"transport", "rand spot", Config.RESULT_RANDOM_MOVE, "you're gonna be moved", ""}, {"", "", "", "", ""}},
            {{"bad end", "lose spot", Config.RESULT_LOSE, "YOU WILL LOSe!!!", ""}, {"", "", "", "", ""}, {"good end", "win spot", Config.RESULT_WIN, "YOU will WIN TEXT", ""}}
        };

        // Test player is told open when entering null spot
        {
            boolean expected = false;
            boolean actual = Adventure.enter(map, new int[]{1, 0}, rand);
            if (expected != actual) {
                System.out.println("testEnter " + testNum++ + ") Expected: " + expected
                        + " Actual: " + actual);
                error = true;
            }
        }

        // Test player is transported to a null spot when entering randomMove spot
        {
            boolean expected = false;
            boolean actual = Adventure.enter(map, new int[]{1, 1}, rand);
            if (expected != actual) {
                System.out.println("testEnter " + testNum++ + ") Expected: " + expected
                        + " Actual: " + actual);
                error = true;
            }
        }

        // Test player is told that they lost and function returns true
        {
            boolean expected = true;
            boolean actual = Adventure.enter(map, new int[]{2, 0}, rand);
            if (expected != actual) {
                System.out.println("testEnter " + testNum++ + ") Expected: " + expected
                        + " Actual: " + actual);
                error = true;
            }
        }

        // Test player is told that they won and function returns true
        {
            boolean expected = true;
            boolean actual = Adventure.enter(map, new int[]{2, 2}, rand);
            if (expected != actual) {
                System.out.println("testEnter " + testNum++ + ") Expected: " + expected
                        + " Actual: " + actual);
                error = true;
            }
        }

        if ( error) {
            System.out.println("Error in testEnter.");
        } else {
            System.out.println("All tests in testEnter passed.");
        }
    }

    /**
     * Tests for the enter method.
     */
    public static void testMapString() {

        // Test map is written correctly (via eyes lol)
        {
            String[][][] map = new String[][][] {
                    {{"start", "", "", "", ""}, null, null},
                    {null, {"bat", "", "", "", ""}, null},
                    {{"pit", "", "", "", ""}, null, {"child", "", "", "", ""}}
            };
            Adventure.writeMap(map, new int[]{1, 0}, "test_map.txt");
        }

        System.out.println("testMapString has successfully run. Check 'test_map.txt'.");
    }
}
