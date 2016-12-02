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
 * This class represents a bullet in the game.  It allows the player to have another bullet if
 * their ammo is empty.
 * 
 * @author Matthew McPartland
 *
 */

public class Bullet extends Item {

	//Default constructor for the bullet
	Bullet(){
		//0 is passed because the bullet does not need to be active for more than 1 turn
		super(0);
	}
}
