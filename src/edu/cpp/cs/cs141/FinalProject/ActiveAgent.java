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

/**
 * This class represents all members of the grid which can move.  This class
 * was made as an abstract class instead of an interface because all {@link ActiveAgents}
 * need to be able to extend the {@link GridItem} class because they must be placed on the grid.
 * We also needed a way to distinguish between moving members and non-moving members in the {@link GameEngine}.
 * 
 * @author Samuel Holt
 *
 */
public abstract class ActiveAgent extends GridItem {

}
