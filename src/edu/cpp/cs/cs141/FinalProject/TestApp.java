package edu.cpp.cs.cs141.FinalProject;

/**
 * The only purpose of this class is to hold the main method.
 * 
 * @author Samuel Holt
 *
 */
public class TestApp {
	
	public static void main(String[] args){
		Grid grid = new Grid();
		
		// initialize all the GridItems to the Grid
		grid.initializeGrid();
		
		// print out the board
		System.out.print(grid);
	}

}
