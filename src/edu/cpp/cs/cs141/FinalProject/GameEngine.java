package edu.cpp.cs.cs141.FinalProject;

/**
 * This class represents the main logic and stat tracking for the game.
 * This class should have access to all the classes which will be used in the logic
 * of the game and should get information from the UI.
 * 
 * @author Matthew McPartland
 *
 */
public class GameEngine {

	private Grid grid = new Grid();
	
	private boolean gameFinished = false;
	
	private boolean gameWon =false;
	
	private boolean gameOver = false;
	
	private boolean turnIndicator = false;
	
	
	public String displayGrid(){
		return grid.toString();
	}
	
	public boolean gameOver() {
		
		return gameFinished;
	}
	
	public boolean checkWinCondition()
	{
		if(grid.briefcaseFound())
			gameWon = true;
		else
			;
		return gameWon;
	}
}
