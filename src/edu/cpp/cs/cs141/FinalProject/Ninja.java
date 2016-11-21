/**
 * 
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
	 * This represents the status of the {@link Ninja}.
	 */
	private boolean alive;
	
	/**
	 * This represents the number of lives the {@link Ninja} has left which is by default 1.
	 */
	private int lives = 1;
	
	/**
	 * The default constructor for the {@link Ninja}.
	 */
	public Ninja(){
		uniqueId = totalNinjas++;
	}
	
	/**
	 * This method will return the integer form of the 
	 * {@link #uniqueId} of the {@link Ninja}.
	 * @return {@link #uniqueId}
	 */
	public int getUniqueId(){
		return uniqueId;
	}
	
  
	Ninja(){
		alive = true;
	}
	public void kill(){
		alive = false;
	}
	
	public boolean getAlive(){
		return alive;
	}
}
