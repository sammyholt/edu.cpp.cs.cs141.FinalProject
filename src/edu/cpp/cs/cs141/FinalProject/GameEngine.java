package edu.cpp.cs.cs141.FinalProject;

import java.io.IOException;
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


	
	private boolean gameFinished = false;
	
	private boolean gameWon = false;
	
	
	private boolean turnIndicator = false;
	
	
	public String displayGrid(){
		return grid.toString();
	}
	
	public boolean gameOver() {
		if(grid.player.isAlive() != false)
			gameFinished = true;
		return gameFinished;
	}
	
	public boolean checkWinCondition() {
		
		if(grid.player.hasBriefcase()){
			gameWon = true;
			gameFinished = true;
		}
		return gameWon;
	}

	//private Player p1 = null;
	protected Grid grid = null;
	public int ninjasalive;
	
	
	public GameEngine(){
		grid = new Grid();
		ninjasalive = 6;
	}
	
	public GameEngine(boolean debugIsOn){
		grid = new Grid(debugIsOn);
		ninjasalive = 6;
	}
	
	
	public void loadGame(){
		
	}
	
	/*
	 * This will reset all values that need to be changed to start a new game
	 */
	public void resetGame(){
		
		grid = new Grid();
		gameFinished = false;
		gameWon = false;
	}
	
	/*
	 * This will call a function in the @SaveGame object to initialize the save state
	 */
	public void saveGame() throws IOException
	{
		SaveGame sg = new SaveGame();
		sg.Save(grid);
	}
	
	/*
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
	
	public void ninjaAI(int ninjanumber){
		//TODO first check if player is nearby (to stab them) otherwise proceed with moving
		int playerrow = grid.getPlayerRow();
		int playercolumn = grid.getPlayerColumn();
		//if()
		char wasdmovement;
		//for(int ninjanumber = 0; ninjanumber < 5; ninjanumber++){
			do{
				Random rand = new Random();
				int randdirection = rand.nextInt(4);
				if(randdirection == 0){
					wasdmovement = 'w';
				}else if(randdirection == 1){
					wasdmovement = 'a';
				}else if(randdirection == 2){
					wasdmovement = 's';
				}else{
					wasdmovement = 'd';
				}
			}while(!validNinjaMove(wasdmovement, ninjanumber));
			//System.out.println("Ninja number "+ninjanumber+" moved with "+wasdmovement);
		//}
	}
	
	public boolean validNinjaMove(char movementchoice, int ninjanumber){
		
		//TODO find a way to get unique ninja coordinates
		System.out.println("Ninja number "+ninjanumber+" moved with "+movementchoice);
		int initialninjarow = grid.ninjas[ninjanumber].getYCoordinate(), initialninjacolumn = grid.ninjas[ninjanumber].getXCoordinate();
		int ninjarow = grid.ninjas[ninjanumber].getYCoordinate(), ninjacolumn = grid.ninjas[ninjanumber].getXCoordinate();
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
		if(ninjarow == -1 || ninjarow == 10 || ninjacolumn == -1 || ninjacolumn == 10)
			return false;
		System.out.println("Ninja move not out of array");
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
	
	public String givePlayerPowerUp(String abilityletter){
		//I is for invincibility
		if(abilityletter == "I"){
			//TODO fix damage taking while invincible
			grid.player.pickUpInvincibility();
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
	
	public void endOfTurnCleanUp(){
		grid.player.radarUseOneTurn();
		grid.player.invinciblityUseOneTurn();
	}
	
	
	public boolean playerShoots(char directionofshot){
		if(!grid.player.hasAmmo())
			return false;
		grid.player.setAmmo(-1);
		int playerrow = grid.getPlayerRow(), playercolumn = grid.getPlayerColumn();
		boolean ninjahit = false;
		//TODO once hit, replace the gridspace with an empty space
		//X is for rows		Y is for columns
		
		if(directionofshot == 'w' || directionofshot == 'W'){
			//in the same column as player, check rows less than player's row
			for(int i = 0 ; i < ninjasalive ; i++){
				if(grid.ninjas[i].getYCoordinate() == playercolumn && grid.ninjas[i].getXCoordinate() > playerrow){
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
					ninjasalive --;
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
