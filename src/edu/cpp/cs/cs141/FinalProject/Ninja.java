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
 * This class represents the main enemy in the game.  The ninja
 * should be able to move and interact with the player.
 * 
 * @author Victor Yuen
 *
 */
public class Ninja extends ActiveAgent implements Serializable {
	
	/**
	 * This field represents the total amount of created {@link Ninja}s.
	 * It allows for unique identification ({@link #uniqueId}) of new {@link Ninja}s and also
	 * a quick tool to see how many {@link Ninja}s are in the game.
	 */
	public static int totalNinjas = 0;
	
	/**
	 * This field represents a unique identifier for the ninjas.
	 * Each ninja should be given an {@link #uniqueId} when initialized.
	 */
	private int uniqueId;
  
	/**
	 * This represents the status of life of the {@link Ninja}.
	 */
	private boolean alive;
	
	/**
	 * The default constructor for the {@link Ninja}.
	 */
	public Ninja(){
		uniqueId = totalNinjas++;
		alive = true;
	}
	
	/**
	 * This method will return the integer form of the 
	 * {@link #uniqueId} of the {@link Ninja}.
	 * @return {@link #uniqueId}
	 */
	public int getUniqueId(){
		return uniqueId;
	}
	
	/**
	 * This method will set the {@link #alive} value
	 * of the {@link Ninja} to false.
	 */
	public void kill(){
		alive = false;
	}
	
	/**
	 * This method will return the {@link #alive} value of the {@link Ninja}
	 * 
	 * @return {@link #alive}
	 */
	public boolean getAlive(){
		return alive;
	}
}
