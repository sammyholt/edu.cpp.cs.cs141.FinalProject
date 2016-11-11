package edu.cpp.cs.cs141.FinalProject;

/**
 * This class will allow for the rooms to be represented as their own entity.
 * The rooms should know if they have the briefcase or not
 * 
 * @author Samuel Holt
 *
 */
public class Room implements GridItem {
	
	/**
	 * This represents if the room has the briefcase.  It will be true if
	 * it does or false if it does not.
	 */
	private boolean hasBriefcase;
	
	/**
	 * The default constructor for the {@link Room}.  By default,
	 * the {@link Room} does not have the briefcase.
	 */
	public Room(){
		hasBriefcase = false;
	}
	
	/**
	 * This constructor allows for the {@link #hasBriefcase} field to be set
	 * manually when the {@link Room} is instantiated.
	 * 
	 * @param hasBriefcase
	 * This will set the object's {@link #hasBriefcase} value to the value of the passed argument.
	 */
	public Room(boolean hasBriefcase){
		this.hasBriefcase = hasBriefcase;
	}
	
	/**
	 * This method will allow other parts of the game to know if the room has
	 * the briefcase.
	 * 
	 * @return
	 */
	public boolean HasBriefcase(){
		return hasBriefcase;
	}

}
