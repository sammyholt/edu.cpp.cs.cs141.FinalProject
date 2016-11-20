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
	 * This represents the status of the Ninja.
	 */
	private boolean alive;
	
	/**
	 * This represents the number of lives the ninja has left which is by default 1.
	 */
	private int lives = 1;
	
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
