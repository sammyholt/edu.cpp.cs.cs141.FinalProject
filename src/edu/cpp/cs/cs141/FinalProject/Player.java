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
	
	/*
	 * This represents the maximum ammo the player can hold
	 */
	private final int maxammo = 1;
	
	private Radar playerradar;
	
	private Invincibility playerinvincibility;
	
	/**
	 * The constructor for the Player class which initializes the field variables.
	 */
	public Player()
	{
		alive = true;
		lives = 3;
		briefcase = false;
		ammo = 1;
		playerradar = new Radar();
		playerinvincibility = new Invincibility();
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
	
	/*
	 * (@code ammo) is increased by the inputed amount up to a maximum of (@code maxammo)
	 */
	public void setAmmo(int inputammo)
	{
		ammo += inputammo;
		if (ammo > maxammo)
			ammo = maxammo;
	}
	
	public boolean radarIsActive(){
		return playerradar.itemActive();
	}
	
	public boolean invincibilityIsActive(){
		return playerinvincibility.itemActive();
	}
	
	public void pickUpRadar(){
		playerradar.setActive();
	}
	
	public void pickUpInvincibility(){
		playerinvincibility.setActive();
	}
}
