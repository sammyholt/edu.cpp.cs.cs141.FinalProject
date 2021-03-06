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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

/**
 * This class represents the main logic and stat tracking for the game.
 * This class should have access to all the classes which will be used in the logic
 * of the game and should get information from the UI.
 * 
 * @author Matthew McPartland
 *
 */
public class GameEngine {


	/**
	 * This field represents if the current game has been completed or not.
	 */
	private boolean gameFinished;
	
	/**
	 * This field represents if the game has been won.
	 */
	private boolean gameWon;
	
	/**
	 * This field is the main {@link Grid} to be used in the game.
	 */
	protected Grid grid = null;
	
	/**
	 * This field represents the amount of {@link Ninja}s alive in the 
	 * current game.
	 */
	public int ninjasalive;
	
	/**
	 * This field represents the amount of turns of {@link Invincibility} the {@link Player}
	 * has remaining.
	 */
	public int invincibilityturns;
	
	/**
	 * This method can be used to display a string representation of the grid.
	 * 
	 * @return grid.toString() - A string representation of the {@link Grid}.
	 */
	public String displayGrid(){
		return grid.toString();
	}
	
	/**
	 * This method will determine if the current game is over.
	 * 
	 * @return gameFinished - A boolean value that states whether or not the game is finished.
	 */
	public boolean gameOver() {
		if(!grid.player.isAlive())
		{
			gameFinished = true;
			System.out.println("\nGame Over. You suck!");
		}
		return gameFinished;
	}
	
	/**
	 * This method will determine if the current game has been won or not.
	 * 
	 * @return gameWon - A boolean value representing if the game has been won.
	 */
	public boolean checkWinCondition() {
		
		if(grid.player.hasBriefcase()){
			gameWon = true;
			gameFinished = true;
			System.out.println("\nYou won the game! Good Job!\n");
		}
		return gameWon;
	}
	
	/**
	 * This is the default constructor for the {@link GameEngine}.  It will
	 * initialize all the necessary variables based on the game rules.
	 */
	public GameEngine(){
		grid = new Grid();
		ninjasalive = 6;
		gameFinished = false;
		gameWon = false;
	}
	
	/**
	 * This constructor allows the game to be initialized with a custom debug mode.
	 * 
	 * @param debugIsOn - A boolean value representing the debug mode being on or off.
	 */
	public GameEngine(boolean debugIsOn){
		grid = new Grid(debugIsOn);
		ninjasalive = 6;
		gameFinished = false;
		gameWon = false;
	}
	
	/**
	 * This constructor takes a {@link SaveGame} object as a
	 * parameter and builds the game correctly based on the
	 * values in that object.
	 * 
	 * @param loadedGame
	 */
	public GameEngine(SaveGame loadedGame){
		grid = loadedGame.getSavedGrid();
		ninjasalive = loadedGame.getSavedNinjasAlive();
		gameWon = loadedGame.getSavedGameWon();
		gameFinished = loadedGame.getSavedGameFinished();
		invincibilityturns = 0;
	}
	
	/**
	 * This method will create a save file saving all the necessary 
	 * parts of the {@link GameEngine} to a data file for later use 
	 * by the {@link #loadGame(String)} method.
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public void Save(String fileName) throws IOException
	{
		try {
			
			// create the save object
			SaveGame save = new SaveGame(grid, gameFinished, gameWon, ninjasalive);
			
			// write it to a file
			FileOutputStream fileOut = new FileOutputStream(fileName + ".dat");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(save);
			objectOut.close();
			
		} catch (IOException e) {
			System.out.println("Error: File Cannot Be Saved. Try Again.");
		}
	}
	
	/**
	 * This method will load a {@link SaveGame} from the passed data file name;
	 * 
	 * @param fileName
	 * @return loadedGame
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public SaveGame loadGame(String fileName) throws ClassNotFoundException, IOException{
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		SaveGame loadedGame = (SaveGame) ois.readObject();
		ois.close();
		
		return loadedGame;
	}
	
	/**
	 * This will reset all values that need to be changed to start a new game
	 */
	public void resetGame(){
		
		grid = new Grid();
		gameFinished = false;
		gameWon = false;
	}
	
	/**
	 * This method initializes the necessary fields
	 * to load a previously saved game.
	 * 
	 * @param loadedGame
	 */
	public void resetGame(SaveGame loadedGame){
		grid = loadedGame.getSavedGrid();
		ninjasalive = loadedGame.getSavedNinjasAlive();
		gameWon = loadedGame.getSavedGameWon();
		gameFinished = loadedGame.getSavedGameFinished();
	}
	
	/**
	 * 				w(up)
	 * 	a(left)		s(down)		d(right)
	 * Returns the string for the UI to output to player
	 */
	public String playerMovement(char movementchoice){
		int initialplayerrow = grid.getPlayerRow(), initialplayercolumn = grid.getPlayerColumn();
		int playerrow = grid.getPlayerRow(), playercolumn = grid.getPlayerColumn();
		if(movementchoice == 'w' || movementchoice == 'W'){
			playerrow++;
		}
		else if(movementchoice == 'a' || movementchoice == 'A'){
			playercolumn--;
		}
		else if(movementchoice == 'd' || movementchoice == 'D'){
			playercolumn++;
		}
		else if(movementchoice == 's' || movementchoice == 'S'){
			playerrow--;
		}
		else{
			return "Invalid move";
		}
		//Test for moving out of the array
		if(!grid.inBounds(playerrow, playercolumn))
			return "You can not walk out of the room";
		GridItem targetgridspace = grid.board[playerrow][playercolumn];
		String targetgridspaceletter = grid.letterFromClassName(targetgridspace, targetgridspace.getClass().getSimpleName());
		//Check if walking into room
		if(targetgridspaceletter == "B" || targetgridspaceletter == "R"){
			return playerChecksRoom(movementchoice, targetgridspace);
		}
		//Walking into item "picks it up"
		if(targetgridspaceletter == "D" || targetgridspaceletter == "I" || targetgridspaceletter == "U"){
			grid.board[playerrow][playercolumn] = grid.player;
			grid.board[initialplayerrow][initialplayercolumn] = new EmptySpace();
			return givePlayerPowerUp(targetgridspaceletter);
		}
		//Try to walk into ninja
		if(targetgridspaceletter == "N")
			return "You cannot walk through a ninja!";
		
		//By this case, it should be only an empty space
		grid.board[playerrow][playercolumn] = grid.player;
		grid.board[initialplayerrow][initialplayercolumn] = targetgridspace;
		return "";
	}
	
	/**
	 * This method will determine what happens when a {@link Player} attempts to enter a room.
	 * If the {@link Player} enters from the top, the invalid move string will be returned.
	 * Otherwise, the {@link Player} will be told what is happening inside the room.
	 * 
	 * @param movementchoice
	 * @param targetgridspace
	 * @return
	 */
	public String playerChecksRoom(char movementchoice, GridItem targetgridspace){
		if(movementchoice == 's' || movementchoice == 'S'){
			//TODO 
			boolean originaldebugchoice = grid.getDebugMode();
			grid.setDebugMode(true);
			if(grid.letterFromClassName(targetgridspace, targetgridspace.getClass().getSimpleName()) == "B"){
				grid.player.setBriefcase();
				grid.setDebugMode(originaldebugchoice);
				return "You found the briefcase!";
			}
			else{
				grid.setDebugMode(originaldebugchoice);
				return "You entered the room and found nothing";
			}
		}
		else
			return "You can only enter the room from the top";
	}
	
	/**
	 * This method will control all the logic of the {@link Ninja}s on the {@link Grid}.
	 * If the {@link Ninja} can stab the {@link Player}, it will.  Otherwise, it will
	 * try to move in a random direction.  All tried directions will be logged, and if a 
	 * move cannot be completed, the {@link Ninja} will stay in its place.
	 * 
	 * @param ninjanumber
	 */
	public void ninjaAI(int ninjanumber){
		//checks adjacent space to stab player
		if(invincibilityturns > 0){
			System.out.println("You are invincible.");
		}
		else{
			//Prevents ninjas from getting stabbed and the moving, aka effectively having two turns
			boolean gotStabbed = false;
			// check same row to the left of ninja
			if(grid.ninjas[ninjanumber].getYCoordinate() == grid.getPlayerColumn() && grid.ninjas[ninjanumber].getXCoordinate() ==
			  grid.getPlayerRow() + 1){
				System.out.println("Playa' got shanked bruh!");
				// nanja stab and takes 1pt of players life.
				grid.player.changeLife();
				gotStabbed = true;
				
			}
			// check same row to the right of ninja
			else if(grid.ninjas[ninjanumber].getYCoordinate() == grid.getPlayerColumn() && grid.ninjas[ninjanumber].getXCoordinate() ==
			  grid.getPlayerRow() - 1){
				System.out.println("Playa' got shanked bruh!");
				// nanja stab and takes 1pt of players life.
				grid.player.changeLife();
				gotStabbed = true;
				
			}
			// check same row to the above ninja
			else if(grid.ninjas[ninjanumber].getXCoordinate() == grid.getPlayerRow() && grid.ninjas[ninjanumber].getYCoordinate() ==
			  grid.getPlayerColumn() - 1){
				System.out.println("Playa' got shanked bruh!");
				// nanja stab and takes 1pt of players life.
				grid.player.changeLife();
				gotStabbed = true;
				
			}
			// check same row to the below ninja
			else if(grid.ninjas[ninjanumber].getXCoordinate() == grid.getPlayerRow() && grid.ninjas[ninjanumber].getYCoordinate() ==
			  grid.getPlayerColumn() + 1){
				System.out.println("Playa' got shanked bruh!");
				// nanja stab and takes 1pt of players life.
				grid.player.changeLife();
				gotStabbed = true;
				
			}
			if(gotStabbed){
				int initialplayerrow = grid.getPlayerRow(), initialplayercolumn = grid.getPlayerColumn();
				int playerrow = 0, playercolumn = 0;
				GridItem targetgridspace = grid.board[playerrow][playercolumn];
				grid.board[playerrow][playercolumn] = grid.player;
				grid.board[initialplayerrow][initialplayercolumn] = targetgridspace;
				return;
			}
		}	
		
		int ninjamovementattemptcount = 0;
		boolean[] ninjaMovementArray = new boolean[4];
		boolean valid = false;
		while (!valid && !ninjaTriedAllMoves(ninjaMovementArray))
		{
			Random rand = new Random();
			int randomDirection = rand.nextInt(4);
			
			if(randomDirection == 0 && !ninjaMovementArray[0]){
				ninjaMovementArray[0] = true;
				if(validNinjaMove('w',ninjanumber)){
					//grid.ninjas[ninjanumber].giveCoordinates(grid.ninjas[ninjanumber].getXCoordinate(), grid.ninjas[ninjanumber].getYCoordinate()+1);
					valid = true;
				}
			}
			else if(randomDirection == 1 && !ninjaMovementArray[1]){
				ninjaMovementArray[1] = true;
				if(validNinjaMove('a',ninjanumber)){
					//grid.ninjas[ninjanumber].giveCoordinates(grid.ninjas[ninjanumber].getXCoordinate()-1, grid.ninjas[ninjanumber].getYCoordinate());
					
					valid = true;
				}
			}
			else if(randomDirection == 2 && !ninjaMovementArray[2]){
				ninjaMovementArray[2] = true;
				if(validNinjaMove('s',ninjanumber)){
					//grid.ninjas[ninjanumber].giveCoordinates(grid.ninjas[ninjanumber].getXCoordinate(), grid.ninjas[ninjanumber].getYCoordinate()-1);
					
					valid = true;
				}
			}
			else {
				ninjaMovementArray[3] = true;
				if(validNinjaMove('d',ninjanumber)){
					//grid.ninjas[ninjanumber].giveCoordinates(grid.ninjas[ninjanumber].getXCoordinate()+1, grid.ninjas[ninjanumber].getYCoordinate());
					
					valid = true;
				}
			}
			ninjamovementattemptcount++;		
		}
		
	}
	
	/**
	 * This method will return true if all the indexes of the array are true.
	 * 
	 * @param ninjaMovementArray
	 * @return triedAllMoves
	 */
	public boolean ninjaTriedAllMoves(boolean[] ninjaMovementArray){
		boolean triedAllMoves = true;
		for(boolean b : ninjaMovementArray){
			if(!b){
				triedAllMoves = false;
			}
		}
		return triedAllMoves;
	}
	
	/**
	 * This method will determine if the {@link Ninja} movement is
	 * valid and proceed to move the {@link Ninja} if it is.
	 * 
	 * @param movementchoice
	 * @param ninjanumber
	 * @return
	 */
	public boolean validNinjaMove(char movementchoice, int ninjanumber){
		
		//TODO find a way to get unique ninja coordinates
		//System.out.println("Ninja number "+ninjanumber+" moved with "+movementchoice);
		int initialninjarow = grid.ninjas[ninjanumber].getXCoordinate(), initialninjacolumn = grid.ninjas[ninjanumber].getYCoordinate();
		int ninjarow = grid.ninjas[ninjanumber].getXCoordinate(), ninjacolumn = grid.ninjas[ninjanumber].getYCoordinate();
		if(movementchoice == 'w' || movementchoice == 'W'){
			ninjarow++;
		}
		else if(movementchoice == 'a' || movementchoice == 'A'){
			ninjacolumn--;
		}
		else if(movementchoice == 'd' || movementchoice == 'D'){
			ninjacolumn++;
		}
		else if(movementchoice == 's' || movementchoice == 'S'){
			ninjarow--;
		}
		else{
			return false;
		}
		if(ninjarow == -1 || ninjarow == 9 || ninjacolumn == -1 || ninjacolumn == 9)
			return false;
		GridItem targetgridspace = grid.board[ninjarow][ninjacolumn];
		String targetgridspaceletter = grid.letterFromClassName(targetgridspace, targetgridspace.getClass().getSimpleName());
		if(targetgridspaceletter == "B" || targetgridspaceletter == "R"){
			return false;
		}
		if(targetgridspaceletter == "D" || targetgridspaceletter == "I" || targetgridspaceletter == "U"){
			return false;
		}
		if(targetgridspaceletter == "N")
			return false;
		if(targetgridspaceletter == "P")
			return false;
		
		
		grid.board[ninjarow][ninjacolumn] = grid.ninjas[ninjanumber];
		grid.board[initialninjarow][initialninjacolumn] = targetgridspace;
		grid.ninjas[ninjanumber].giveCoordinates(ninjarow, ninjacolumn);
		return true;
		
	}
	
	/**
	 * This method allows the {@link Player} to pick up
	 * {@link Item}s and be told about them.
	 * 
	 * @param abilityletter
	 * @return
	 */
	public String givePlayerPowerUp(String abilityletter){
		//I is for invincibility
		if(abilityletter == "I"){
			//TODO fix damage taking while invincible
			grid.player.pickUpInvincibility();
			invincibilityturns = 5;
			return "You picked up invincibility! You cannot die for the next 5 turns!";
		}
		//D is for radar
		else if(abilityletter == "D"){
			grid.player.pickUpRadar();
			return "You picked up a radar, you can see the map for this turn.";
		}
		//U is for ammo
		else{
			grid.player.setAmmo(1);
			return "You picked up an ammo, you gained one bullet.";
		}
		
	}
	
	/**
	 * This method will allow all of the turn based {@link Item}s to
	 * be used correctly by using their use one turn methods.
	 */
	public void endOfTurnCleanUp(){
		grid.player.radarUseOneTurn();
		grid.player.invinciblityUseOneTurn();
		if(invincibilityturns > 0)
			invincibilityturns--;
		
	}
	
	/**
	 * This method will determine if an integer array contains a certain integer.
	 * 
	 * @param array - An array of integers.
	 * @param item - An integer item to look for.
	 * @return contains - A boolean value representing if the array contains the item or not.
	 */
	public boolean contains(int[] array, int item){
		boolean contains = false;
		for(int a : array){
			if(a == item){
				contains = true;
			}
		}
		return contains;
	}
	
	/**
	 * This method will determine if the {@link Player} shoots
	 *  and will also perform the logic associated with shooting.
	 * 
	 * @param directionofshot
	 * @return
	 */
	public boolean playerShoots(char directionofshot){
		if(!grid.player.hasAmmo()){
			System.out.println("You have no ammo\n");
			return false;
		}
		grid.player.setAmmo(-1);
		int playerrow = grid.getPlayerRow(), playercolumn = grid.getPlayerColumn();
		boolean ninjahit = false;
		//TODO once hit, replace the gridspace with an empty space
		//X is for rows		Y is for columns
		
		if(directionofshot == 'w' || directionofshot == 'W'){
			//in the same column as player, check rows less than player's row
			for(int i = 0 ; i < ninjasalive ; i++){
				if(grid.ninjas[i].getYCoordinate() == playercolumn && grid.ninjas[i].getXCoordinate() > playerrow){
					//System.out.println("Found enemy in same column");
					grid.board[grid.ninjas[i].getXCoordinate()][grid.ninjas[i].getYCoordinate()] = new EmptySpace();
					grid.ninjas[i].kill();
					grid.ninjas[i].giveCoordinates(10, 10);
					for(int j = 0 ; j < grid.ninjas.length-1 ; j++){
						if(!grid.ninjas[j].getAlive()){
							Ninja tempninja = grid.ninjas[j];
							grid.ninjas[j] = grid.ninjas[j+1];
							grid.ninjas[j+1] = tempninja;
						}
					}
					ninjasalive --;
					ninjahit = true;
					break;
				}
			}
		}else if(directionofshot == 'a' || directionofshot == 'A'){
			//in the same row as player, check columns less than the player's column
			for(int i = 0 ; i < ninjasalive ; i++){
				if(grid.ninjas[i].getXCoordinate() == playerrow && grid.ninjas[i].getYCoordinate() < playercolumn){
					System.out.println("Found enemy in same column");
					grid.board[grid.ninjas[i].getXCoordinate()][grid.ninjas[i].getYCoordinate()] = new EmptySpace();
					grid.ninjas[i].kill();
					grid.ninjas[i].giveCoordinates(10, 10);
					//Sort dead ninjas out of the array
					for(int j = 0 ; j < grid.ninjas.length-1 ; j++){
						if(!grid.ninjas[j].getAlive()){
							Ninja tempninja = grid.ninjas[j];
							grid.ninjas[j] = grid.ninjas[j+1];
							grid.ninjas[j+1] = tempninja;
						}
					}
					ninjasalive --;
					ninjahit = true;
					break;
				}
			}
		}else if(directionofshot == 's' || directionofshot == 'S'){
			//in the same column as player, check rows greater than player's row
			for(int i = 0 ; i < ninjasalive ; i++){
				if(grid.ninjas[i].getYCoordinate() == playercolumn && grid.ninjas[i].getXCoordinate() < playerrow){
					System.out.println("Found enemy in same column");
					grid.board[grid.ninjas[i].getXCoordinate()][grid.ninjas[i].getYCoordinate()] = new EmptySpace();
					grid.ninjas[i].kill();
					grid.ninjas[i].giveCoordinates(10, 10);
					for(int j = 0 ; j < grid.ninjas.length-1 ; j++){
						if(!grid.ninjas[j].getAlive()){
							Ninja tempninja = grid.ninjas[j];
							grid.ninjas[j] = grid.ninjas[j+1];
							grid.ninjas[j+1] = tempninja;
						}
					}
					ninjasalive--;
					ninjahit = true;
					break;
				}
			}
			
		}else{
			//D
			//in the same row as player, check columns greater than the player column
			for(int i = 0 ; i < ninjasalive ; i++){
				if(grid.ninjas[i].getXCoordinate() == playerrow && grid.ninjas[i].getYCoordinate() > playercolumn){
					System.out.println("Found enemy in same column");
					grid.board[grid.ninjas[i].getXCoordinate()][grid.ninjas[i].getYCoordinate()] = new EmptySpace();
					grid.ninjas[i].kill();
					grid.ninjas[i].giveCoordinates(10, 10);
					//Sort dead ninjas out of the array
					for(int j = 0 ; j < grid.ninjas.length-1 ; j++){
						if(!grid.ninjas[j].getAlive()){
							Ninja tempninja = grid.ninjas[j];
							grid.ninjas[j] = grid.ninjas[j+1];
							grid.ninjas[j+1] = tempninja;
						}
					}
					ninjasalive --;
					ninjahit = true;
					break;
				}
			}
		}
		
			
		return ninjahit;


	}
	
	/**
	 * This method initializes variables necessary for {@link Ninja} movement.
	 */
	public void ninjaInit(){
		GridItem testspace;
		String testspaceletter;
		int ninjacounter = 0;
		for(int i=0; i < 9; i++){
			for(int j=0; j < 9; j++){
				testspace = grid.board[i][j];
				testspaceletter = grid.letterFromClassName(testspace, testspace.getClass().getSimpleName());
				if(testspaceletter == "N")
				{
					grid.ninjas[ninjacounter].giveCoordinates(i, j);
					ninjacounter++;
				}
			}
		}

	}
}
