package edu.cpp.cs.cs141.FinalProject;

/**
 * This represents the main board of the game.  The Grid should hold all
 * the rooms, items, and activeagents.  It should be represented as a 9x9 array.
 * 
 * @author Samuel Holt
 *
 */

public class Grid {
	
	/**
	 * This string represents an {@link #emptySpace} on the board.
	 */
	String emptySpace = " ";
	
	/**
	 * This array is the 
	 * visual representation of the board.
	 */
	String[][] board = new String[9][9];
	
	/**
	 * The default constructor for the grid.
	 */
	public Grid(){
		
	}
	
	/**
	 * This method will return the room number of the briefcase for the current room.
	 * 
	 * @return roomNumber
	 */
	public int briefCaseRoomNumber(){
		return 0;
	}
	
	/**
	 * This method returns a string representation of the grid.
	 */
	@Override
	public String toString(){
		return null;
	}
	
	
	
	
	
	

}
