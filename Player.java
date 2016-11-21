/**
 * 
 */
package edu.cpp.cs.cs141.FinalProject;

/**
 * This class represents the Player in the game.  The Player should
 * have attributes and methods that allow it to interact with the other
 * agents and items in the game.
 * 
 * @author Justin Do
 *
 */
public class Player extends ActiveAgent {
	
	/**
	 * This represents the status of the Player.
	 */
	private boolean alive;
	
	/**
	 * This represents the number of lives the player has left.
	 */
	private int lives;
	
	/**
	 * This represents the amount of ammo the Player has.
	 */
	private int ammo;
	
	/**
	 * This represents whether or not the Player has the briefcase.
	 */
	private boolean briefcase;
	
	/**
	 * This represents the maximum ammo the player can hold
	 */
	private final int maxAmmo = 1;
	
	/**
	 * This represents whether or not the Player has the radar.
	 */
	private boolean radar;
	
	/**
	 * This represents wheter or not the Player has invincibility.
	 */
	private boolean invincibility;
	
	/**
	 * The constructor for the Player class which initializes the field variables.
	 */
	public Player()
	{
		alive = true;
		lives = 3;
		briefcase = false;
		ammo = 1;
		radar = false;
		invincibility = false;
				
	}
	
	/**
	 * @return the number of lives the Player has remaining.
	 */
	public int getLives()
	{
		return lives;
	}
	
	/**
	 * If the player is killed, the life total is deducted.
	 */
	public void changeLife()
	{
		if (lives >= 0)
			lives--;
		if(lives == 0)
			alive = false;
	}
	
	/**
	 * @return alive is true if the Player still has lives remaining, otherwise returns false
	 */
	public boolean isAlive()
	{
		return alive;
	}
	
	/**
	 * (@code briefcase) is set to true after the Player has gotten the briefcase.
	 */
	public void setBriefcase()
	{
		briefcase = true;
	}
	
	/**
	 * @return true if the Player has gotten the briefcase, otherwise returns false
	 */
	public boolean hasBriefcase()
	{
		return briefcase;
	}
	
	/**
	 * (@code ammo) is increased by 1 bullet up to a maximum of (@code maxAmmo)
	 */
	public void setAmmo()
	{
		ammo ++;
		if (ammo > maxAmmo)
			ammo = maxAmmo;
	}
	
	/**
	 * 
	 * @return true if the player has enough bullets to shoot and decreases the current amount of bullets by one.
	 * Returns false if there's not enough bullets to shoot.
	 */
	public boolean shoot()
	{
		if( ammo > 0 )
		{
			ammo--;
			return true;
		}
		else
			return false;
	}
	/**
	 * Sets (@code radar) to true to signify that the radar has been picked up
	 */
	public void pickedUpRadar()
	{
		radar = true;
	}
	
	/**
	 * Sets (@ode invincibility) to true to signify that the invincibility has been picked up
	 */
	public void pickedUpInvincibility()
	{
		invincibility = true;
	}
	
	/**
	 * @return the value of (@code radar)
	 */
	public boolean getRadar()
	{
		return radar;
	}
	
	/**
	 * @return the vale of (@code radar)
	 */
	public boolean getInvincibility()
	{
		return invincibility;
	}

}
