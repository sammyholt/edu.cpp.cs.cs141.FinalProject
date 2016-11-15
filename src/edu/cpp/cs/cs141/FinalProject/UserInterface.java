package edu.cpp.cs.cs141.FinalProject;

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
	
	public UserInterface (GameEngine game) {
		this.game = game;
		keyboard = new Scanner(System.in);
	}
	
	public void startGame() {
		printWelcomeMessage();
		boolean quit = false;
		
		while (!quit) {
			int option = mainMenu();
			
			switch(option) {
			case 1: // Starts a new game
				break;
			
			case 2: // Loads a saved game
				break;
			
			case 3: // Quits game
				quit = true;
				break;
			default:
				System.out.println("Invalid option. Try again...");
				break;
			}
			
		}
		
	}



	private void printWelcomeMessage() {
		System.out.println("Welcome to Spy Game! \n\n");
	}
	
	private int mainMenu(){
		int option = 3;
		
		System.out.println("Select an option:\n"
				+ "\t1. Start New Game.\n"
				+ "\t2. Load Game. \n"
				+ "\t3. Quit.");
		option = keyboard.nextInt();
		keyboard.nextLine();
		
		return option;
	}
	
	private void gameLoop(){
		 // create reset() in GameEngine class
		
	}
}