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
 * This interface represents an item which can be placed on the grid.
 * All {@link Items} and {@link ActiveAgents} which will be active
 * on the {@link Grid} should implement the {@link GridItem} interface.
 * 
 * @author Samuel Holt
 *
 */
public abstract class GridItem implements Serializable{
	
	/**
	 * This field represents the current
	 * x-coordinate of the {@link GridItem}.
	 */
	private int xCoordinate;
	
	/**
	 * This field represents the current
	 * y-coordinate of the {@link GridItem}.
	 */
	private int yCoordinate;
	
	/**
	 * This method will allow for the modification
	 * of the {@link #xCoordinate} and {@link #yCoordinate}.
	 * @param x
	 * @param y
	 */
	public void giveCoordinates(int x, int y){
		xCoordinate = x;
		yCoordinate = y;
	}
	
	/**
	 * This method returns the current x-coordinate of the {@link GridItem}.
	 * @return xCoordinate
	 */
	public int getXCoordinate(){
		return xCoordinate;
	}
	
	/**
	 * This method returns the current y-coordinate of the {@link GridItem}.
	 * @return yCoordinate
	 */
	public int getYCoordinate(){
		return yCoordinate;
	}

}
