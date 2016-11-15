/**
 * 
 */
package edu.cpp.cs.cs141.FinalProject;

/**
 * This class represents the Player in the game.  The Player should
 * have attributes and methods that allow it to interact with the other
 * agents and items in the game.
 * 
 * @author Justin Do
 *
 */
public class Player extends ActiveAgent {
	
	/**
	 * This represents the status of the Player.
	 */
	private boolean alive;
	
	/**
	 * This represents the number of lives the player has left.
	 */
	private int lives;
	
	/**
	 * This represents the amount of ammo the Player.
	 */
	private int ammo;
	
	private Item item;

}
