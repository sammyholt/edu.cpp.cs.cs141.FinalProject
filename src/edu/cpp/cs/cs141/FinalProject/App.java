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

import java.io.IOException;
import java.util.Scanner;

/**
 * The only purpose of this class is to hold the main method.
 * 
 * @author Samuel Holt
 *
 */
public class App {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		UserInterface ui = new UserInterface(new GameEngine(true));
		ui.startGame();
	}
}
