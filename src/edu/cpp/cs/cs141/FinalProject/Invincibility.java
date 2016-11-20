package edu.cpp.cs.cs141.FinalProject;

/**
 * 
 * This class represents the invincibility item in the game.  This
 * item makes the Player invulnerable to stabbing for five turns.
 * 
 * @author Matthew Mcpartland
 *
 */

public class Invincibility extends Item {
	
	/*
	 * Default constructor
	 */
	Invincibility(){
		//Calls the super constructor to give 5 maximum turns
		super(5);
	}

}
