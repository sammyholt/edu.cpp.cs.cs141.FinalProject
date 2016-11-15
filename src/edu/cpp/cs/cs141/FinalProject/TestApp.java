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
	}
}
