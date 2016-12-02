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
 * The breifcase represents the game winning item.  The Player will
 * win the game once they pick up this item.
 * 
 * @author Matthew McPartland
 *
 */

public class Briefcase extends Item{
	
	/**
	 * This represents the room number in which the briefcase is.
	 */
	private int roomNumber;
	
	/**
	 * The default constructor for the briefcase.
	 */
	public Briefcase(int inputroomnumber){
		//Zero is passed because the player does not need the briefcase for over 1 turn
		super(0);
	}

	public int getRoomNumber(){
		return roomNumber;
	}
}
