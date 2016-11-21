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

	
	/*
	 * Constructor for radar that will give 1 maximum turn for usage
	 */
	public Radar()
	{
		//1 is passed to give 1 maximum turn
		super(1);
	}
	
}
