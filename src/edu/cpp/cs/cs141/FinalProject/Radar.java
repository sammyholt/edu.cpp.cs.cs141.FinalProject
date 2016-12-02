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
 * This class represents a radar in the game.  The radar item allows
 * the Player to see the whole board for one turn.
 * 
 * @author Matthew McPartland
 *
 */

public class Radar extends Item {

	
	/**
	 * Constructor for radar that will give 1 maximum turn for usage.
	 */
	public Radar()
	{
		//1 is passed to give 1 maximum turn
		super(1);
	}
	
}
