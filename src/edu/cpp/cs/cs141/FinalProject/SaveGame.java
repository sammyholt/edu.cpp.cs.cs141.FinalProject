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

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.IOException;

/**
 * This class represents the save of the game.  All the fields in this class should be serializable
 * in order to load them back from a file.
 * 
 * @author Robert Gil
 *
 */

public class SaveGame implements Serializable
{
	
	/**
	 * This field represents the {@link Grid} to be saved.
	 * The {@link Grid} also contains the {@link Player}.
	 */
	private Grid board;
	
	/**
	 * This field represents if the game was finished
	 * when the save was created.
	 */
	private boolean gameFinished;
	
	/**
	 * This field represents if the game was won
	 * when the save was created.
	 */
	private boolean gameWon;
	
	/**
	 * This field represents the amount
	 * of {@link Ninja}s alive when the save was created.
	 */
	private int ninjasAlive;
	
	/**
	 * The default constructor of a {@link SaveGame}.  Should only be used 
	 * for testing purposes.
	 */
	public SaveGame(){
		board = new Grid();
		gameFinished = false;
		gameWon = false;
		ninjasAlive = 6;
	}
	
	/**
	 * This constructor will create the save based on the necessary passed fields.
	 * 
	 * @param passedBoard
	 * @param passedGameFinished
	 * @param passedGameWon
	 * @param passedNinjasAlive
	 */
	public SaveGame(Grid passedBoard, boolean passedGameFinished, boolean passedGameWon, int passedNinjasAlive){
		board = passedBoard;
		gameFinished = passedGameFinished;
		gameWon = passedGameWon;
		ninjasAlive = passedNinjasAlive;
	}
	
	/**
	 * This method returns the {@link #board}.
	 * 
	 * @return {@link #board}
	 */
	public Grid getSavedGrid(){
		return board;
	}
	
	/**
	 * This method returns the {@link #ninjasAlive} value.
	 * 
	 * @return {@link #ninjasAlive}
	 */
	public int getSavedNinjasAlive(){
		return ninjasAlive;
	}
	
	/**
	 * This method returns the {@link #gameFinished} value.
	 * 
	 * @return {@link #gameFinished}
	 */
	public boolean getSavedGameFinished(){
		return gameFinished;
	}
	
	/**
	 * This method returns the {@link #gameWon} value.
	 * 
	 * @return {@link #savedGrid}
	 */
	public boolean getSavedGameWon(){
		return gameFinished;
	}
}
