/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Final Project: Spy Game
 *
 * The game takes place inside a building which will be represented as a grid of 81 squares, 
 * every square representing a possible position for different entities in the game (player's avatar, enemies, power-ups), 
 * with the exception of 9 special squares which represent rooms, and are equally distributed on the grid.
 * The player's character is a spy that is tasked with retrieving a briefcase containing classified enemy documents, 
 * which is located in one of the rooms. 
 * 
 * Team Choryboys 
 *   Robert Gil
 *   Sammy Holt
 *   Chory Gruta
 *   Victor Yuen
 *   Justin Do
 *   Matthew McPartland
 */

package edu.cpp.cs.cs141.FinalProject;

import java.io.Serializable;

/**
 * This class represents the Player in the game.  The Player should
 * have attributes and methods that allow it to interact with the other
 * agents and items in the game.
 * 
 * @author Justin Do
 *
 */
public class Player extends ActiveAgent implements Serializable{
	
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
	 * This field represents the {@link Player}'s {@link Radar}.
	 */
	private Radar playerradar;
	
	/**
	 * This field represents the {@link Player}'s {@link Invincibility}.
	 */
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
		if (lives > 0)
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
	
	/**
	 * (@code ammo) is increased by the inputed amount up to a maximum of (@code maxammo)
	 */
	public void setAmmo(int inputammo)
	{
		ammo += inputammo;
		if (ammo < 0)
			ammo = 0;
	}
	
	/**
	 * This method returns the current {@link #ammo} value of the {@link Player}.
	 * 
	 * @return {@link #ammo}
	 */
	public int getAmmo()
	{
		return ammo;
	}
	
	/**
	 * This method resets the {@link Player} to default values.
	 */
	public void resetPlayer()
	{
		alive = true;
		lives = 3;
		briefcase = false;
		ammo = 1;
		playerradar = new Radar();
		playerinvincibility = new Invincibility();
	}
	
	/**
	 * This method determines if the player has {@link #ammo} or not.
	 * 
	 * @return hasAmmo - A boolean value representing if the {@link Player} has {@link #ammo}.
	 */
	public boolean hasAmmo(){
		return (ammo > 0) ? true : false;
	}
	
	/**
	 * This method returns true if the {@link Player}'s {@link Radar} is active.
	 * 
	 * @return True if the {@link Radar} is active.
	 */
	public boolean radarIsActive(){
		return playerradar.itemActive();
	}
	
	/**
	 * This method returns true if the {@link Player}'s {@link Invincibility} is active.
	 * 
	 * @return True if the {@link Invincibility} is active.
	 */
	public boolean invincibilityIsActive(){
		return playerinvincibility.itemActive();
	}
	
	/**
	 * This method sets the {@link Player}'s {@link Radar} as active.
	 */
	public void pickUpRadar(){
		playerradar.setActive();
	}
	
	/**
	 * This method sets the {@link Player}'s {@link Invincibility} as active.
	 */
	public void pickUpInvincibility(){
		playerinvincibility.setActive();
	}
	
	/**
	 * This method will use one turn of the {@link Player}'s {@link Radar}.
	 */
	public void radarUseOneTurn(){
		playerradar.setTurns();
	}
	
	/**
	 * This method will use one turn of the {@link Player}'s {@link Invincibility}.
	 */
	public void invinciblityUseOneTurn(){
		playerinvincibility.setTurns();
	}
}
