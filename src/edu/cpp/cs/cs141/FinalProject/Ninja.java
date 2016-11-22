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
	
	public void kill(){
		lives = 0;
		alive = false;
	}
	
	public boolean getAlive(){
		return alive;
	}
}
