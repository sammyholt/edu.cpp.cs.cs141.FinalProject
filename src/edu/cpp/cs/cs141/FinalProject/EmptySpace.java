/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Final Project: Spy Game
 *
 * The game takes place inside a building which will be represented as a grid of 81 squares, 
 * every square representing a possible position for different entities in the game (player's avatar, enemies, power-ups), 
 * with the exception of 9 special squares which represent rooms, and are equally distributed on the grid.
 * The player's character is a spy that is tasked with retrieving a briefcase containing classified enemy documents, 
 * which is located in one of the rooms. 
 * 
 * Team Choryboys 
 *   Robert Gil
 *   Sammy Holt
 *   Chory Gruta
 *   Victor Yuen
 *   Justin Do
 *   Matthew McPartland
 */

package edu.cpp.cs.cs141.FinalProject;

/**
 * 
 * This class represents the empty spaces on the board.  It has no properties, because it is
 * simply there to be used as a placeholder on the grid.
 * 
 * @author Samuel Holt
 *
 */
public class EmptySpace extends GridItem {
	
	/**
	 * This field is a string representation of empty space on the {@link Grid}.  It will
	 * only be used if the game is not in debug mode.  It will also represent spaces that the
	 * {@link Player} cannot see even if the space is not an {@link EmptySpace}.
	 */
	public static String stringRepresentation = "*";

}
