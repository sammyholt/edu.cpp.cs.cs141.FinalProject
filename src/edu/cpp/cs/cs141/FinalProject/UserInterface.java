package edu.cpp.cs.cs141.FinalProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
/**
 * This class represents the user interface of the game.  It is what allows
 * the player to send information to the game engine and receive information
 * from the game engine.
 * 
 * @author Chory Gruta
 *
 */

public class UserInterface {
	
	private GameEngine game = null;
	private Scanner keyboard = null;
	private boolean debugMode = false;
	SaveGame sg = null;
	
	public UserInterface (GameEngine game){
		this.game = game;
		keyboard = new Scanner(System.in);
	}
	
	public void startGame() throws IOException, ClassNotFoundException {
		printWelcomeMessage();
		boolean quit = false;
		
		while (!quit) {
			int option = mainMenu();
			
			switch(option) {
			case 1: // Starts a new game
				gameLoop(false);
				break;
			
			case 2: // Loads a saved game
				System.out.print("Enter a save name: ");
				sg = game.loadGame(keyboard.next() + ".dat");
				game.resetGame(sg);
				gameLoop(true);
				break;
			
			case 3: // Quits game
				System.out.println("\n"
						+ "Thank you for playing Spy Game.\n" + "Press ENTER to continue...");
				keyboard.nextLine();
				System.out.println("\n\n\n");
				quit = true;
				break;
			default:
				System.out.println("Invalid option. Try again...");
				break;
			}	
		}	
		keyboard.close();
	}

	private void printWelcomeMessage() {
		System.out.println("Welcome to Spy Game! \n\n");
	}
	
	private int mainMenu(){
		int option = 3;
		
		System.out.println("\tMenu\n\n"
				+ "\t1. Start New Game.\n"
				+ "\t2. Load Game. \n"
				+ "\t3. Quit.\n\n"
				+ "Choose an option: ");
		
		option = keyboard.nextInt();
		keyboard.nextLine();
		
		return option;
	}
	
	private void gameLoop(boolean loadedGame) throws IOException, ClassNotFoundException{
		
		// if game was not loaded, initialize game
		if(!loadedGame){
			gameModeMessage();
			newGameMessage(keyboard.nextInt()); // This initializes the GameEngine either in debug mode or normal mode
		}
	
		while(!game.checkWinCondition() && !game.gameOver()){
			
			char movementchoice;
			
			System.out.println("\n" + game.grid);
			System.out.println("\nLives left: " + game.grid.player.getLives() );
			System.out.println("Ammos left: " + game.grid.player.getAmmo());
			System.out.println("Invincibility left: "+game.invincibilityturns);
			
			game.endOfTurnCleanUp();
			
			actionMessage();
			movementchoice = keyboard.next().charAt(0);
			actionMethod(movementchoice);
			
			if(!game.grid.player.hasBriefcase()){
				for(int ninjanumber = 0; ninjanumber < game.ninjasalive; ninjanumber++){
					game.ninjaAI(ninjanumber);
				}
			}
			/*
			if(debugMode)
				for(int i = 0 ; i < game.ninjasalive ; i++){
				System.out.println("\nNinja Coordinates\n"+game.grid.ninjas[i].getXCoordinate()+","+game.grid.ninjas[i].getYCoordinate());
				}
				*/
		}
		
		
		
	}
	
	private void actionMessage()
	{
		System.out.println("What would you like to do? W = move up, A = move left, D = move right, "
				+ "S = move down, F = shoot, Z = save\n\n");
	}
	
	private void newGameMessage(int option)
	{
		if(option == 1){
			System.out.println("New game in debug mode started!\n");
			game = new GameEngine(true);
			game.ninjaInit();
			debugMode=true;
		}
		else{
			System.out.println("New game started! \n");
			game = new GameEngine();
			game.ninjaInit();
			debugMode=false;
		}

	}
	
	private void gameModeMessage()
	{
		System.out.println("Would you like to play the game in debug mode? (Enter 1 for yes and 0 for no): ");
	}
	
	private void actionMethod(char movementchoice) throws IOException, ClassNotFoundException
	{
		
		
		if(movementchoice == 'W' || movementchoice == 'w' || movementchoice == 'A' || movementchoice == 'a' || movementchoice == 'D'|| 
				movementchoice == 'd'|| movementchoice == 'S' || movementchoice == 's')
		{
			System.out.println(game.playerMovement(movementchoice));
			
		}

		else if(movementchoice == 'f' || movementchoice == 'F')
		{
			System.out.println("Choose a direction (W = up, A = left, D = right, "
					+ "S  = down,): ");
					movementchoice = keyboard.next().charAt(0);
					if(game.playerShoots(movementchoice))
					{
						System.out.println("You hit an enemy!\n");
						
						
					}
					else
						System.out.println("You didn't hit an enemy :(\n1");
						
					
						
		}
		else if(movementchoice == 'z' || movementchoice == 'Z')
		{
			String fileName = "";
			System.out.print("Enter a save name: ");
			fileName = keyboard.next();
			game.Save(fileName);
			System.out.println("Game Saved as " + fileName);
		}
		else
			;
	}
}