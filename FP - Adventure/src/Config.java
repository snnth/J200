///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           A text based adventure program.
// Course:          CS200 Fall 2020
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

/**
 * This file contains constants for the text Adventure project. Also at the bottom of this file
 * are READ ME Notes for the Grader.
 *
 * @author Jim Williams
 * @author Matthew Smith
 */
public class Config {

    /**
     * Indexes into coordinate arrays specifying a location in the map.
     */
    public static final int ROW = 0;
    public static final int COLUMN = 1;

    /**
     * Indexes into the fields/attributes array for each map location (3rd dimension of
     * the map array)
     */
    public static final int NAME = 0;
    public static final int ENTER_TEXT = 1;
    public static final int ENTER_RESULT = 2;
    public static final int NEARBY_TEXT = 3;
    //add additional indexes here for additional field information added to each configuration
    //line.

    /**
     * Values within the location fields/attributes that are used for game logic other than
     * simply printing out.
     */
    //In name field, designates the starting location of the player
    public static final String NAME_START = "start";

    //The result of the player entering the field.
    public static final String RESULT_RANDOM_MOVE = "randomMove";
    public static final String RESULT_WIN = "win";
    public static final String RESULT_LOSE = "lose";
    //add additional game logic fields here (not text fields that are simply printed).

    /**
     * Values used by the player to navigate through the map.
     */
    public static final String MOVE_UP = "w";
    public static final String MOVE_DOWN = "s";
    public static final String MOVE_LEFT = "a";
    public static final String MOVE_RIGHT = "d";
    public static final String NEARBY = "n";
    public static final String QUIT = "q";
    //add additional game control characters here, throwing, shooting, etc.

}

/*
Your READ ME notes to the Grader
Describe your enhancements to the program, map, etc. here.  You may include a link to a
YouTube video of a maximum of 2 minutes demonstrating your program.

0) Overview of your changes or a YouTube video link (max 2 minutes)
 - Youtube link: https://youtu.be/BlCZ2Hft1qo
 - Robust unit testing file
 - Created a new advcfg file

1) Configuration Example: Contents of your own configuration (.advcfg) file
Find in video

2) Configuration Description: Describe unique elements in your configuration file
 - walled off the end from the start so the player only has one way to move
 - lore-wise, you're a blind sailor that needs to make it to shore which fits well with the parameters of this game


3) writeMap Output: Example output of the writeMap method for your configuration file.
Find in video

4) Choose at least 1 of the following ways you extended the game and describe them:
  a) Tools: added your own tools/weapons and use of them in the game
  b) Audio: playing of audio files when sensing the neighbors, rather than simply text
  -> c) Test Cases: adding test cases to TestAdventure that thoroughly test the methods you wrote. <-
  d) Your Own: describe any other changes or additions we should consider for credit.
 */
