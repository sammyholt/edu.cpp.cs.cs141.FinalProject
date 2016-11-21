package edu.cpp.cs.cs141.FinalProject;

import java.util.Scanner;

/**
 * The only purpose of this class is to hold the main method.
 * 
 * @author Samuel Holt
 *
 */
public class TestApp {
	public static void main(String[] args){
		GameEngine testengine = new GameEngine(true);
		Scanner keyboard = new Scanner(System.in);
		
		
		GridItem testspace;
		String testspaceletter;
		int ninjacounter = 0;
		for(int i=0; i < 9; i++){
			for(int j=0; j < 9; j++){
				testspace = testengine.grid.board[i][j];
				testspaceletter = testengine.grid.letterFromClassName(testspace, testspace.getClass().getSimpleName());
				if(testspaceletter == "N")
				{
					testengine.grid.ninjas[ninjacounter].giveCoordinates(i, j);
					ninjacounter++;
				}
			}
		}
		
		
		char movementchoice = 10;
		do{
			System.out.println(testengine.grid);
			if(testengine.grid.player.hasBriefcase()){
				System.out.println("Congrats you have the briefcase");
			}
			testengine.endOfTurnCleanUp();
			movementchoice = keyboard.next().charAt(0);
			System.out.println(testengine.playerMovement(movementchoice));
			//for(int ninjanumber = 0; ninjanumber < testengine.ninjasalive; ninjanumber++)
				//testengine.ninjaAI(0);
			if(movementchoice == 'f'){
				movementchoice = keyboard.next().charAt(0);
				if(testengine.playerShoots(movementchoice)){
					System.out.println("You hit an enemy!");
				}
			}
			for(int i = 0 ; i < testengine.ninjasalive ; i++){
				System.out.println(testengine.grid.ninjas[i].getXCoordinate()+","+testengine.grid.ninjas[i].getYCoordinate());
			}
		}while( movementchoice != 'e');
		
		keyboard.close();
		
		
		/*
		Grid grid = null;
		Scanner keyboard = new Scanner(System.in);
		int choice = 0;
			
		// quick loop for Milestone 1 Demo
		System.out.println("P = Player, R = Room, N = Ninja, B = Room w/ Briefcase, D = Radar, U = Bullet, I = Invincibility");
		do{
			// initialize and print out the board
			grid = new Grid();
			System.out.println(grid);
			
			System.out.print("Enter 1 to generate a new grid, enter -1 to quit: ");
			choice = keyboard.nextInt();
		}while(choice != -1);
		keyboard.close();
		*/
	}
}
