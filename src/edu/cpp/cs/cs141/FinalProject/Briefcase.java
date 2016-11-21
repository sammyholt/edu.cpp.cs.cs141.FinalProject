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
