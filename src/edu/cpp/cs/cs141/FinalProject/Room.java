package edu.cpp.cs.cs141.FinalProject;

import java.io.Serializable;

/**
 * This class will allow for the rooms to be represented as their own entity.
 * The rooms should know if they have the briefcase or not
 * 
 * @author Samuel Holt
 *
 */
public class Room extends GridItem implements Serializable{
	
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
	 * This method will set the {@link #hasBriefcase} value
	 * of the {@link Room} to true.
	 */
	public void giveBriefcase(){
		hasBriefcase = true;
	}
	
	/**
	 * This method will allow other parts of the game to know if the room has
	 * the briefcase.
	 * 
	 * @return hasBriefcase
	 */
	public boolean HasBriefcase(){
		return hasBriefcase;
	}

}
