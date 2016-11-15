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
	
	/**
	 * This represents whether or not the Player has the briefcase.
	 */
	private boolean briefcase;
	
	
	
		
	/**
	 * The constructor for the Player class which initializes the field variables.
	 */
	public Player()
	{
		alive = true;
		lives = 3;
		briefcase = false;
		ammo = 1;
				
	}
	
	/**
	 * @return the number of lives the Player has remaining.
	 */
	public int getLives()
	{
		return lives;
	}
	
	/**
	 * If the player is killed, the life total is deducted.
	 */
	public void changeLife()
	{
		if (lives >= 0)
			lives--;
		if(lives == 0)
			alive = false;
	}
	
	/**
	 * @return alive is true if the Player still has lives remaining, otherwise returns false
	 */
	public boolean isAlive()
	{
		return alive;
	}
	
	/**
	 * (@code briefcase) is set to true after the Player has gotten the briefcase.
	 */
	public void setBriefcase()
	{
		briefcase = true;
	}
	
	/**
	 * @return true if the Player has gotten the briefcase, otherwise returns false
	 */
	public boolean hasBriefcase()
	{
		return briefcase;
	}
	
	

}