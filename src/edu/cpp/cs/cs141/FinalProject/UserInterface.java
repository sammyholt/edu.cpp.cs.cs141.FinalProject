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
	boolean quit = false;
	SaveGame sg = null;
	
	public UserInterface (GameEngine game){
		this.game = game;
		keyboard = new Scanner(System.in);
	}
	
	public void startGame() throws IOException, ClassNotFoundException {
		printWelcomeMessage();
		
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
	
	/**
	 * This method is responsible for printing out menu options
	 * to the console and taking in the user's input.
	 * 
	 * @return option
	 */
	private int mainMenu(){
		int option = 3;

		System.out.println("\tMenu\n\n"
				+ "\t1. Start New Game.\n"
				+ "\t2. Load Game. \n"
				+ "\t3. Quit.\n\n"
				+ "Choose an option: ");
		
		// allows for input type to be checked
		while (true) {
		    try {
		        option = Integer.parseInt(keyboard.next());
		        if(validMainMenuOption(option)){
		        	keyboard.nextLine();
			        break;
		        }else{
		        	System.out.print("Invalid input! Please try again: ");
		        }
		    } catch (NumberFormatException e) {
		        System.out.print("Invalid input! Please try again: ");
		    }
		}
		
		return option;
	}
	
	/**
	 * This method determines if the entered option is a valid menu option.
	 * 
	 * @return validMainMenuOption - This boolean will return true if the option is valid.
	 */
	private boolean validMainMenuOption(int option){
		int[] options = {1,2,3};
		boolean valid = false;
		
		if(game.contains(options, option)){
			valid = true;
		}
		return valid;
	}
	
	/**
	 * This is the main game loop.  Everything happening from the {@link GameEngine}
	 * is called in this loop.
	 * 
	 * @param loadedGame - This boolean parameter allows for the flag to be thrown if
	 * the game was a loaded save or a new game.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void gameLoop(boolean loadedGame) throws IOException, ClassNotFoundException{
		
		// if game was not loaded, initialize game
		if(!loadedGame){
			gameModeMessage();
			int option = 0;
			// allows for input type to be checked to get a valid input data type
			while (true) {
			    try {
			        option = Integer.parseInt(keyboard.next());
		        	keyboard.nextLine();
			        break;
			    } catch (NumberFormatException e) {
			        System.out.print("Invalid input! Please try again: ");
			    }
			}
			newGameMessage(option); // This initializes the GameEngine either in debug mode or normal mode
		}
	
		while(!game.checkWinCondition() && !game.gameOver() && !quit){
			
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
		}
	}
	
	/**
	 * This method prints the available game actions to the console.
	 */
	private void actionMessage()
	{
		System.out.println("What would you like to do? W = move up, A = move left, D = move right, "
				+ "S = move down, F = shoot, Z = save, Q = quit game, 1 = turn off debug mode, 2 = turn on debug mode\n\n");
	}
	
	/**
	 * This message prints the new game started message to the console.
	 * 
	 * @param option - This integer is passed to determine if the
	 * game was started in debug mode or not.  If the passed value
	 * is {@code 1}, the debug message will print.
	 */
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
	
	/**
	 * This message asks the user if they would like to play in debug or normal mode.
	 */
	private void gameModeMessage()
	{
		System.out.println("Would you like to play the game in debug mode? (Enter 1 for yes and 0 for no): ");
	}
	
	/**
	 * This method uses the {@link GameEngine} to accomplish different tasks
	 * based on the input choice given by the user.
	 * 
	 * @param movementchoice - a character choice which determines the action
	 * the user would like to take.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
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
		else if(movementchoice == 'q' || movementchoice == 'Q')
		{
			System.out.println("\n"
					+ "Thank you for playing Spy Game.\n" + "Press ENTER to continue...");
			keyboard.nextLine();
			System.out.println("\n\n\n");
			quit = true;
		}
		else if(movementchoice == '1')
		{
			System.out.println("Debug mode has been turned off!\n");
			game.grid.setDebugMode(false);
		}
		else if(movementchoice == '2')
		{
			System.out.println("Game mode is now in Debug mode!\n");
			game.grid.setDebugMode(true);
		}
		else
			;
	}
}