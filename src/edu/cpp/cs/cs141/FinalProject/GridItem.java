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
