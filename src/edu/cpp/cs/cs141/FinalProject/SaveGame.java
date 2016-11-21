package edu.cpp.cs.cs141.FinalProject;

import java.io.Serializable;
import java.io.FileInputStream;
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

	Ninja ninja = null;
	Item item = null;
	Player player = null;
	Room room = null;
	Grid grid = null;  
	GameEngine ge = null;
	
	/**
	 * This method will pass serializable objects Grid, Player, Ninja, Item, Room and GridItem and output the files 
	 * to a file to be loaded at a later point 
	 * 
	 * @param gridParam
	 */
	public void Save(Grid gridParam) throws IOException
	{
		try {
			
			grid= gridParam;
			
			FileOutputStream fileOut = new FileOutputStream("savegame.dat");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(grid);
			objectOut.flush();
			objectOut.close();
			
		} catch (IOException e) {
			System.out.println("Error: File Cannot Be Saved. Try Again.");
		}
	}

}
