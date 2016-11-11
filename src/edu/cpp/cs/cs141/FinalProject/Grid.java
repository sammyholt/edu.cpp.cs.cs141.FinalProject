package edu.cpp.cs.cs141.FinalProject;

import java.util.Random;

/**
 * This represents the main board of the game.  The Grid should hold all
 * the rooms, items, and activeagents.  It should be represented as a 9x9 array.
 * 
 * @author Samuel Holt
 *
 */

public class Grid {
	
	/**
	 * This string represents an {@link #emptySpace} on the board.
	 */
	String emptySpace = " ";
	
	/**
	 * This array is the 
	 * representation of the main game board.
	 */
	GridItem[][] board = new GridItem[9][9];
	
	/**
	 * The default constructor for the grid.
	 */
	public Grid(){
		
	}
	
	/**
	 * This method will return the room number of the briefcase for the current room.
	 * 
	 * @return roomNumber
	 */
	public int briefCaseRoomNumber(){
		return 0;
	}
	
	/**
	 * This method will initialize the grid with no arguments.
	 * It will place all the rooms, ninjas, items, and the player.
	 * It will generate the positions of these {@link GridItem}s randomly
	 * since there are no passed arguments.
	 */
	public void initializeGrid(){
		Room[] rooms = generateRooms(9);
		Ninja[] ninjas = generateNinjas(6);
		Item[] items = generateItems();
		Player player = new Player();
		
		// initialize player in bottom left
		board[0][0] = player;
		// place the rooms equally apart
		board = placeRooms(board, rooms, 2, 1);
	}
	
	/**
	 * This method will place the rooms on the board.  It will space
	 * the rooms based on the provided values of columnSpacing and
	 * rowSpacing.
	 * 
	 * @param board
	 * @param rooms
	 * @param rowSpacing
	 * @param columnSpacing
	 * @return board
	 */
	public GridItem[][] placeRooms(GridItem[][] board, Room[] rooms, int rowSpacing, int columnSpacing){
		int counter = 0;
		for(int row = 1; row < board.length - 1; row += (rowSpacing + 1)){
			for(int column = 2; column < board[0].length - 1; column += (columnSpacing + 1)){
				board[row][column] = rooms[counter];
				counter++;
			}
		}
		return board;
	}
	
	/**
	 * Generates an array of rooms and 
	 * randomly assigns the briefcase to one of the 
	 * rooms.
	 * 
	 * @param amount
	 * @return rooms
	 */
	public Room[] generateRooms(int amount){
		// Create and initialize an array of rooms
		Room[] rooms = new Room[amount];
		for(int i = 0; i < amount; i++){
			rooms[i] = new Room();
		}
		
		// Generate a random int based on the amount of rooms
		// and assign a briefcase to that room
		int randomInt = getRandomInt(0, amount - 1);
		rooms[randomInt].giveBriefcase();
		
		return rooms;
	}
	
	/**
	 * Generates an array of ninjas.
	 * 
	 * @param amount
	 * @return ninjas
	 */
	public Ninja[] generateNinjas(int amount){
		// Create and initialize an array of ninjas
		Ninja[] ninjas = new Ninja[amount];
		for(int i = 0; i < amount; i++){
			ninjas[i] = new Ninja();
		}
		
		return ninjas;
	}
	
	/**
	 * Generates an array of items.
	 * 
	 * @return items
	 */
	public Item[] generateItems(){
		// Create and initialize an array of Items
		Item[] items = new Item[3];
		items[0] = new Bullet();
		items[1] = new Invincibility();
		items[2] = new Radar();
		
		return items;
	}
	
	/**
	 * This method will return a random integer between
	 * and including the two passed values.
	 * 
	 * @param minimum
	 * @param maximum
	 * @return randomInt
	 */
	public int getRandomInt(int minimum, int maximum) {
	    Random generatedRandom = new Random();
	    int randomInt = generatedRandom.nextInt((maximum - minimum) + 1) + minimum;

	    return randomInt;
	}
	
	/**
	 * This method returns a string representation of the grid.
	 */
	@Override
	public String toString(){
		return null;
	}
	
	
	
	
	
	

}
