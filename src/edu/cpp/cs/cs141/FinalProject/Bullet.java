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
