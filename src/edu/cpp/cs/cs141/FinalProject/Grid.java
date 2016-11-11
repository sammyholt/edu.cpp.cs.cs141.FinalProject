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
	 * The board size for which the square dimensions of the board should be.
	 */
	public static final int boardSize = 9;
	
	/**
	 * This array is the 
	 * representation of the main game board.
	 */
	private GridItem[][] board = new GridItem[boardSize][boardSize];
	
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
		// place the ninjas randomly at least the minimum distance away from player
		board = placeNinjas(board, ninjas, 3);
		// place the items where there are free spaces
		board = placeItems(board, items);
		// place the empty spaces to finish initialization
		board = placeEmptySpace(board);
		
		
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
	 * This method will place the ninjas on the board.  It will start
	 * looking for spaces to place ninjas past the specified minimum distance.
	 * A ninja cannot be placed if there is something already on the space.
	 * 
	 * @param board
	 * @param ninjas
	 * @param minDistance
	 * @return board
	 */
	public GridItem[][] placeNinjas(GridItem[][] board, Ninja[] ninjas, int minDistance){
		int randomX = 0;
		int randomY = 0;
		boolean spaceTaken = false;
		
		// loop through the ninja array to place them
		for(Ninja n : ninjas){
			do{
				// get a random x and y coordinate to try to place the ninja
				randomX = getRandomInt(minDistance, boardSize - 1);
				randomY = getRandomInt(minDistance, boardSize - 1);
				
				// if something is already on the space, keep generating random coordinates
				// else, place the ninja at that coordinate
				if(board[randomX][randomY] !=  null){
					spaceTaken = true;
				}else{
					board[randomX][randomY] = n;
					spaceTaken = false;
				}
			}while(spaceTaken);
		}
		
		return board;
	}
	
	/**
	 * This method will place the items on the board. An item will not be placed
	 * if an item is already on the space.
	 * 
	 * @param board
	 * @param items
	 * @return board
	 */
	public GridItem[][] placeItems(GridItem[][] board, Item[] items){
		int randomX = 0;
		int randomY = 0;
		boolean spaceTaken = false;
		
		// loop through the items array to place them
		for(Item i : items){
			do{
				// get a random x and y coordinate to try to place the item
				randomX = getRandomInt(0, boardSize - 1);
				randomY = getRandomInt(0, boardSize - 1);
				
				// if something is already on the space, keep generating random coordinates
				// else, place the item at that coordinate
				if(board[randomX][randomY] !=  null){
					spaceTaken = true;
				}else{
					board[randomX][randomY] = i;
					spaceTaken = false;
				}
			}while(spaceTaken);
		}
		
		return board;
	}
	
	/**
	 * This method will place the items on the board. An item will not be placed
	 * if an item is already on the space.
	 * 
	 * @param board
	 * @param items
	 * @return board
	 */
	public GridItem[][] placeEmptySpace(GridItem[][] board){
		for(int row = 0; row < board.length; row++){
			for(int column = 0; column < board[0].length; column++){
				if(board[row][column] ==  null){
					board[row][column] = new EmptySpace();
				}
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
	 * This method will return the string representation
	 * of the item in order to print it on the board.
	 * 
	 * @param item
	 * @return s - 
	 * String representation of item.
	 */
	public String getClassStringRepresentation(GridItem item){
		String s = null;
		String className = item.getClass().getSimpleName();
		
		switch(className){
		case "Player":
			s = "P";
			break;
		case "EmptySpace":
			s = " ";
			break;
		case "Room":
			Room room = (Room)item;
			if(room.HasBriefcase()){
				s = "B";
			}else{
				s = "R";
			}
			break;
		case "Ninja":
			s = "N";
			break;
		case "Bullet":
			s = "U";
			break;
		case "Invincibility":
			s = "I";
			break;
		case "Radar":
			s = "D";
			break;
		default:
			s = " ERROR ";
			break;
		}
		return s;
	}
	
	/**
	 * This method returns a two-dimensional string
	 * representation of the board.
	 * 
	 * @return boardString - 
	 * A two dimensional array of strings which represent the board.
	 */
	public String[][] boardString(){
		String[][] returnString = new String[boardSize][boardSize];
		String className = null;
		for(int row = 0; row < board.length; row++){
			for(int column = 0; column < board[0].length; column++){
				// if space is null, represent as empty
				// else give it the class name
				if(board[row][column].getClass() == null){
					className = " ";
				}else{
					className = getClassStringRepresentation(board[row][column]);
				}
				returnString[row][column] = " [ " + className + " ] ";
			}
		}
		return returnString;
	}
	
	/**
	 * This allows the board to be printed by simply printing out the board object.
	 * 
	 * @return String representation of board.
	 */
	@Override
	public String toString(){
		String s = "";
		
		String[][] boardString = boardString();
		for(int row = boardString.length - 1; row >= 0; row--){
			for(int column = 0; column < boardString[0].length; column++){
				s += boardString[row][column];
			}
			s += "\n";
		}
		
		return s;
	}
	
	
	
	
	
	

}
