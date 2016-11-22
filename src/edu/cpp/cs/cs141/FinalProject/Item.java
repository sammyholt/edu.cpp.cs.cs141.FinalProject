package edu.cpp.cs.cs141.FinalProject;

import java.io.Serializable;

/**
 * This interface represents all the items in the game.  The
 * items can be picked up on the board by the player.
 * 
 * @author Matthew McPartland
 *
 */

public abstract class Item extends GridItem implements Serializable{

	/*
	 * This is the max amount of turns that the item is active
	 * Must be overridden by each class specifically
	 */
	private final int maxturns;
	private int turnsleft;
	private boolean active;
	
	/*
	 * Initializes the item
	 * The item will get set to active
	 * Must pass the maximum amount of turns that the item will be allowed to be active
	 */
	public Item(int inputmaxturns){
		maxturns = inputmaxturns;
		active = false;
		turnsleft = maxturns;
	}
	
	/*
	 * If the item is active, this will return true
	 */
	public boolean itemActive(){
		return active;
	}
	
	public void setActive()
	{
		active = true;
	}
	
	/*
	 * This will return the number of turns left that the item is active
	 */
	public int getTurnsLeft(){
		return turnsleft;
	}
	
	
	/*
	 * This will remove one turn each time called
	 * Will not lower the turns below 0
	 */
	public void setTurns(){
		turnsleft -= 1;
		if (turnsleft < 0)
			turnsleft = 0;
		if (turnsleft == 0)
			active = false;
	}
}



/*
 * if item is active, remove from board
 * if item is activated, then push changes to game engine
 * 	on each turn, engine shall check each item
 * 		if item is active, then 
 * 
 */