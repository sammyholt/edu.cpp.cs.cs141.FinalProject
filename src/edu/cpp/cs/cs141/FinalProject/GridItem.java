package edu.cpp.cs.cs141.FinalProject;

/**
 * This interface represents an item which can be placed on the grid.
 * All {@link Items} and {@link ActiveAgents} which will be active
 * on the {@link Grid} should implement the {@link GridItem} interface.
 * 
 * @author Samuel Holt
 *
 */
public abstract class GridItem {
	
	/**
	 * This field represents the current
	 * row of the {@link GridItem}.
	 */
	private int row;
	
	/**
	 * This field represents the current
	 * column of the {@link GridItem}.
	 */
	private int column;
	
	/**
	 * This method will allow for the modification
	 * of the {@link #xCoordinate} and {@link #yCoordinate}.
	 * @param x
	 * @param y
	 */
	public void giveCoordinates(int x, int y){
		row = x;
		column = y;
	}
	
	/**
	 * This method returns the current x-coordinate of the {@link GridItem}.
	 * @return xCoordinate
	 */
	public int getXCoordinate(){
		return row;
	}
	
	/**
	 * This method returns the current y-coordinate of the {@link GridItem}.
	 * @return yCoordinate
	 */
	public int getYCoordinate(){
		return column;
	}

}
