




FINAL PROJECT
TEAM CHORYBOYS
Version <1.0>
11/28/2016


 

 
INTRODUCTION
ChoryBoys Team Members:
Robert Gil
Samuel Holt
Matthew McPartland
Justin Do
Chory Gruta
Victor Yuen

Organization and Collaboration
	Assigned different responsibilites to each team member. We mainly communicated through slack, and our code was hosted on a GitHub repository.

	
   

	
 

PURPOSE OF THE TEST CASE DOCUMENT
The Test Case document documents the functional requirements and current bugs within the code of our final project. The objective was to create a turn based game where the player ventures into a dungeon in search of a briefcase while trying to avoid the ninjas in the darkness. 


ISSUES AS OF VERSION 1.0
Test case 3
Test case 4
Test case 7
Test case 8
Test case 49 (Fixed)


Test case id: 1
Unit to test: mainMenu presents the menu of the game
Assumptions: NA
Test data: NA
Expected result: Display options Start new game, Load Game, Quit and wait for input
Actual result: Display options Start new game, Load Game, Quit and wait for input
Pass/Fail: Pass
Comments: NA

Test case id: 2
Unit to test: incorrect numerical input on main menu defaults to "Invalid Option. Try again"
Assumptions: Can take options other than 1,2,3 but defaults to "Invalid Option"
Test data: startGame()'s option variable
Expected result: "Invalid option. Try again..."
Actual result: "Invalid option. Try again..."
Pass/Fail: Pass
Comments: Will not pass with double values

Test case id: 3
Unit to test: alphabetic input on main menu defaults to "Invalid Option. Try again"
Assumptions: Can take options other than 1,2,3 but defaults to "Invalid Option" 
Test data: startGame()'s option variable
Expected result: "Invalid option. Try again..."
Actual result: Exception in thread "main" java.util.InputMismatchException
Pass/Fail: Fail
Comments: Will not pass with any Alphabetic input

Test case id: 4
Unit to test: special character input on main menu defaults to "Invalid Option. Try again"
Assumptions: Can take options other than 1,2,3 but defaults to "Invalid Option" 
Test data: startGame()'s option variable
Expected result: "Invalid option. Try again..."
Actual result: Exception in thread "main" java.util.InputMismatchException
Pass/Fail: Fail
Comments: Will not pass with any special character input

Test case id: 5
Unit to test: Input '3' will close keyboard input and exit the game
Assumptions: The game stops when quit variable becomes true
Test data: startGame()'s quit variable
Expected result: "Thank you for playing Spy Game."
Actual result: "Thank you for playing Spy Game."
Pass/Fail: Pass
Comments: NA

Test case id: 6
Unit to test: incorrect numerical input on debug menu defaults to "Invalid Option. Try again"
Assumptions: The game will request different input
Test data: newGameMessage()'s option variable
Expected result: "Invalid Option. Try again"
Actual result: New game starts with debug mode off
Pass/Fail: Fail
Comments: NA

Test case id: 7
Unit to test: alphabetic input on debug menu defaults to "Invalid Option. Try again"
Assumptions: The game will request different input
Test data: newGameMessage()'s option variable
Expected result: Invalid Option. Try again"
Actual result: Exception in thread "main" java.util.InputMismatchException
Pass/Fail: Fail
Comments: NA

Test case id: 8
Unit to test: special character input on debug menu defaults to "Invalid Option. Try again"
Assumptions: The game will request different input
Test data: newGameMessage()'s option variable
Expected result: Invalid Option. Try again"
Actual result: Exception in thread "main" java.util.InputMismatchException
Pass/Fail: Fail
Comments: NA

Test case id: 9
Unit to test: input 0 will start new game from debug menu without debugging mode enabled
Assumptions: All grid objects are hidden unless a power up spawned in immediate area
Test data: boardString()'s className variable
Expected result: ' ' unless power up, in which case would be U, I and or D for Bullet, Invincibility and Radar respectively
Actual result: ' ' unless power up, in which case would be U, I and or D for Bullet, Invincibility and Radar respectively
Pass/Fail: Pass
Comments: NA

Test case id: 10
Unit to test: input 1 will start new game from debug menu with debugging mode enabled
Assumptions: All grid objects are shown across the board
Test data: boardString()'s className variable
Expected result: ' ' unless power up, Ninja, Room or Briefcase 
Actual result: ' ' unless power up, Ninja, Room or Briefcase 
Pass/Fail: Pass
Comments: NA

Test case id: 11
Unit to test: walk to the left at the player's initial position
Assumptions: Player should not be able to go out of the grid
Test data: Player out of grid bounds
Expected result: Player stays at initial position, output try again
Actual result: Player stays at initial position, output try again
Pass/Fail: Pass
Comments: NA

Test case id: 12
Unit to test: walk down a unit from the player's initial position
Assumptions: Player should not be able to go out of the grid
Test data: Player out of grid bounds
Expected result: Player stays at initial position, output try again
Actual result: Player stays at initial position, output try again
Pass/Fail: Pass
Comments: NA

Test case id: 13
Unit to test: enter the bottom left most room from the south
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 14
Unit to test: enter the bottom left most room from the west
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 15
Unit to test: enter the bottom left most room from the east
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 16
Unit to test: enter the bottom left most room from the north
Assumptions: Player should be able to check inside the room but remain outside of it
Test data: Player's momvement
Expected result: Player stays at initial position, output You entered the room and found nothing OR You found the briefcase!You won the game! Good Job! 
Actual result: Player stays at initial position, output You entered the room and found nothing OR You found the briefcase!You won the game! Good Job!
Pass/Fail: Pass
Comments: NA

Test case id: 17
Unit to test: enter the middle left most room from the east
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 18
Unit to test: enter the middle left most room from the south
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 19
Unit to test: enter the middle left most room from the west
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 20
Unit to test: enter the middle left most room from the north
Assumptions: Player should be able to check inside the room but remain outside of it
Test data: Player's momvement
Expected result: Player stays at initial position, output You entered the room and found nothing OR You found the briefcase!You won the game! Good Job! 
Actual result: Player stays at initial position, output You entered the room and found nothing OR You found the briefcase!You won the game! Good Job!
Pass/Fail: Pass
Comments: NA

Test case id: 21
Unit to test: enter the upper left most room from the west
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 22
Unit to test: enter the upper left most room from the south
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 23
Unit to test: enter the upper left most room from the east
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 24
Unit to test: enter the upper left most room from the north
Assumptions: Player should be able to check inside the room but remain outside of it
Test data: Player's momvement
Expected result: Player stays at initial position, output You entered the room and found nothing OR You found the briefcase!You won the game! Good Job! 
Actual result: Player stays at initial position, output You entered the room and found nothing OR You found the briefcase!You won the game! Good Job!
Pass/Fail: Pass
Comments: NA

Test case id: 25
Unit to test: enter the upper middle most room from the west
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 26
Unit to test: enter the upper middle left most room from the south
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 27
Unit to test: enter the upper middle left most room from the east
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 28
Unit to test: enter the upper middle left most room from the north
Assumptions: Player should be able to check inside the room but remain outside of it
Test data: Player's momvement
Expected result: Player stays at initial position, output You entered the room and found nothing OR You found the briefcase!You won the game! Good Job! 
Actual result: Player stays at initial position, output You entered the room and found nothing OR You found the briefcase!You won the game! Good Job!
Pass/Fail: Pass
Comments: NA

Test case id: 29
Unit to test: enter the center room from the west
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 30
Unit to test: enter the center room from the south
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 31
Unit to test: enter the center room from the east
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 32
Unit to test: enter the center room from the north
Assumptions: Player should be able to check inside the room but remain outside of it
Test data: Player's momvement
Expected result: Player stays at initial position, output You entered the room and found nothing OR You found the briefcase!You won the game! Good Job! 
Actual result: Player stays at initial position, output You entered the room and found nothing OR You found the briefcase!You won the game! Good Job!
Pass/Fail: Pass
Comments: NA

Test case id: 33
Unit to test: enter the bottom middle room from the west
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 34
Unit to test: enter the bottom middle room from the south
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 35
Unit to test: enter the bottom middle room from the east
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 36
Unit to test: enter the bottom middle room from the north
Assumptions: Player should be able to check inside the room but remain outside of it
Test data: Player's momvement
Expected result: Player stays at initial position, output You entered the room and found nothing OR You found the briefcase!You won the game! Good Job! 
Actual result: Player stays at initial position, output You entered the room and found nothing OR You found the briefcase!You won the game! Good Job!
Pass/Fail: Pass
Comments: NA

Test case id: 37
Unit to test: enter the upper right room from the west
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 38
Unit to test: enter the upper right room from the south
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 39
Unit to test: enter the upper right room from the east
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 40
Unit to test: enter the upper right room from the north
Assumptions: Player should be able to check inside the room but remain outside of it
Test data: Player's momvement
Expected result: Player stays at initial position, output You entered the room and found nothing OR You found the briefcase!You won the game! Good Job! 
Actual result: Player stays at initial position, output You entered the room and found nothing OR You found the briefcase!You won the game! Good Job!
Pass/Fail: Pass
Comments: NA

Test case id: 41
Unit to test: enter the middle right room from the west
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 42
Unit to test: enter the middle right room from the south
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 43
Unit to test: enter the middle right room from the east
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 44
Unit to test: enter the middle right room from the north
Assumptions: Player should be able to check inside the room but remain outside of it
Test data: Player's momvement
Expected result: Player stays at initial position, output You entered the room and found nothing OR You found the briefcase!You won the game! Good Job! 
Actual result: Player stays at initial position, output You entered the room and found nothing OR You found the briefcase!You won the game! Good Job!
Pass/Fail: Pass
Comments: NA

Test case id: 45
Unit to test: enter the bottom right room from the west
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 46
Unit to test: enter the bottom right room from the south
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 47
Unit to test: enter the bottom right room from the east
Assumptions: Player should not be able to go in the room
Test data: Player's momvement
Expected result: Player stays at initial position, output You can only enter the room from the top
Actual result: Player stays at initial position, output You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 48 
Unit to test: enter the bottom right room from the north
Assumptions: Player should be able to check inside the room but remain outside of it
Test data: Player's momvement
Expected result: Player stays at initial position, output You entered the room and found nothing OR You found the briefcase!You won the game! Good Job! 
Actual result: Player stays at initial position, output You entered the room and found nothing OR You found the briefcase!You won the game! Good Job!
Pass/Fail: Pass
Comments: NA

Test case id: 49
Unit to test: Player's invincibility
Assumptions: Player should not lose lives by ninjas within 5 turns; Ninjas should have no effect on player's location
Test data: Player's lives & location
Expected result: Player can get shanked but does not lose a life or it's position, output: You picked up invincibility! You cannot die for the next 5 turns!
Actual result: Player loses a life, player location resets to starting point and output: You picked up invincibility! You cannot die for the next 5 turns!
Pass/Fail: Fail
Comments: NA

Test case id: 50
Unit to test: Player's ability to pick up additional bullet with while carrying 1 bullet
Assumptions: Player's ammo amount changes to 2
Test data: Player's ammo 
Expected result: Player can pick up an additional bullet to carry a total of 2 bullets.  output: You picked up an ammo, you gained one bullet.
Actual result: Player can pick up an additional bullet to carry a total of 2 bullets.  output: You picked up an ammo, you gained one bullet.
Pass/Fail: Pass
Comments: NA

Test case id: 51
Unit to test: Player's ability to pick up additional bullet with while carrying 0 bullet
Assumptions: Player's ammo amount changes to 1
Test data: Player's ammo 
Expected result: Player can pick up a bullet to carry a total of 1 bullet.  output: You picked up an ammo, you gained one bullet.
Actual result: Player can pick up a bullet to carry a total of 1 bullet.  output: You picked up an ammo, you gained one bullet.
Pass/Fail: Pass
Comments: NA

Test case id: 52
Unit to test: Player's ability to pick up additional bullet with while carrying 0 bullet and invincibility enabled
Assumptions: Player's ammo amount changes to 1
Test data: Player's ammo 
Expected result: Player can pick up a bullet to carry a total of 1 bullet.  output: You picked up an ammo, you gained one bullet.
Actual result: Player can pick up a bullet to carry a total of 1 bullet.  output: You picked up an ammo, you gained one bullet.
Pass/Fail: Pass
Comments: NA

Test case id: 53
Unit to test: Player's ability to pick up additional bullet with while carrying 1 bullet and invincibility enabled
Assumptions: Player's ammo amount changes to 1
Test data: Player's ammo 
Expected result: Player can pick up a bullet to carry a total of 1 bullet.  output: You picked up an ammo, you gained one bullet.
Actual result: Player can pick up a bullet to carry a total of 1 bullet.  output: You picked up an ammo, you gained one bullet.
Pass/Fail: Pass
Comments: NA

Test case id: 54
Unit to test: Shooting with invincibility enabled decrements ammo amount
Assumptions: Player's ammo amount reduces by 1
Test data: Player's ammo 
Expected result: Player can shoot while being invincible and decrement Ammo. Output: You didn't hit an enemy :( or you hit an enemy!
Actual result: Player can shoot while being invincible and decrement Ammo. Output: You didn't hit an enemy :( or you hit an enemy!
Pass/Fail: Pass
Comments: NA

Test case id: 55
Unit to test: Shooting with radar enabled decrements ammo amount
Assumptions: Player's ammo amount reduces by 1
Test data: Player's ammo 
Expected result: Player can shoot with radar enabled and decrement Ammo. Output: You didn't hit an enemy :( or you hit an enemy!
Actual result: Player can shoot with radar enabled and decrement Ammo. Output: You didn't hit an enemy :( or you hit an enemy!
Pass/Fail: Pass
Comments: NA

Test case id: 56
Unit to test: Shooting decrements ammo amount
Assumptions: Player's ammo amount reduces by 1 if ammo amount starts above 0.
Test data: Player's ammo 
Expected result: Player can shoot and ammo decrements. Output: You didn't hit an enemy :( or you hit an enemy!
Actual result: Player can shoot and ammo decrements. Output: You didn't hit an enemy :( or you hit an enemy!
Pass/Fail: Pass
Comments: NA

Test case id: 57
Unit to test: attempting to shoot without ANY ammo does not reduce ammo below 0
Assumptions: Player's ammo will stay at 0. Shooting has no effect. 
Test data: Player's ammo 
Expected result: Player can attempt to shoot but nothing will happen. Ammo does not change from 0. Output: You didn't hit an enemy :(
Actual result: Player can attempt to shoot but nothing will happen. Ammo does not change from 0. Output: You didn't hit an enemy :(
Pass/Fail: Pass
Comments: NA

Test case id: 58
Unit to test: shooting the Bullet (U) character has no effect
Assumptions: Player's ammo will decrement. Shooting has no effect. 
Test data: Player's ammo 
Expected result: Player can attempt to shoot but nothing will happen. Ammo reduces by 1. Output: You didn't hit an enemy :(
Actual result: Player can attempt to shoot but nothing will happen. Ammo reduces by 1. Output: You didn't hit an enemy :(
Pass/Fail: Pass
Comments: NA

Test case id: 59
Unit to test: shooting the Bullet (U) character has no effect
Assumptions: Player's ammo will decrement. Shooting has no effect. 
Test data: Player's ammo 
Expected result: Player can attempt to shoot but nothing will happen. Ammo reduces by 1. Output: You didn't hit an enemy :(
Actual result: Player can attempt to shoot but nothing will happen. Ammo reduces by 1. Output: You didn't hit an enemy :(
Pass/Fail: Pass
Comments: NA

Test case id: 60
Unit to test: shooting the Bullet (U) character has no effect with Radar enabled
Assumptions: Player's ammo will decrement. Shooting has no effect. 
Test data: Player's ammo 
Expected result: Player can attempt to shoot but nothing will happen. Ammo reduces by 1. Output: You didn't hit an enemy :(
Actual result: Player can attempt to shoot but nothing will happen. Ammo reduces by 1. Output: You didn't hit an enemy :(
Pass/Fail: Pass
Comments: NA

Test case id: 61
Unit to test: shooting a ninja that is behind a invincibility(I) character from south to north
Assumptions: No effect on invincibility. Player's ammo will decrement. Shooting will kill the ninja, reducing the amount of ninjas by 1
Test data: Player's ammo and Ninja amount
Expected result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Actual result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Pass/Fail: Pass
Comments: NA

Test case id: 62
Unit to test: shooting a ninja that is behind a radar(D) character from south to north
Assumptions: No effect on radar. Player's ammo will decrement. Shooting will kill the ninja, reducing the amount of ninjas by 1
Test data: Player's ammo and Ninja amount
Expected result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Actual result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Pass/Fail: Pass
Comments: NA

Test case id: 63
Unit to test: shooting a ninja that is behind a radar(D) character from west to east
Assumptions: No effect on radar. Player's ammo will decrement. Shooting will kill the ninja, reducing the amount of ninjas by 1
Test data: Player's ammo and Ninja amount
Expected result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Actual result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Pass/Fail: Pass
Comments: NA

Test case id: 64
Unit to test: shooting a ninja that is behind a Bullet(U) character from south to north
Assumptions: No effect on Bullet. Player's ammo will decrement. Shooting will kill the ninja, reducing the amount of ninjas by 1
Test data: Player's ammo and Ninja amount
Expected result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Actual result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Pass/Fail: Pass
Comments: NA

Test case id: 65
Unit to test: shooting a ninja that is behind a Bullet(U) character from west to east
Assumptions: No effect on Bullet. Player's ammo will decrement. Shooting will kill the ninja, reducing the amount of ninjas by 1
Test data: Player's ammo and Ninja amount
Expected result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Actual result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Pass/Fail: Pass
Comments: NA

Test case id: 66
Unit to test: shooting a ninja that is behind a Bullet(U) character from east to west
Assumptions: No effect on Bullet. Player's ammo will decrement. Shooting will kill the ninja, reducing the amount of ninjas by 1
Test data: Player's ammo and Ninja amount
Expected result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Actual result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Pass/Fail: Pass
Comments: NA

Test case id: 67
Unit to test: shooting a ninja that is behind a Radar(D) and two room's from west to east
Assumptions: No effect on Radar or Rooms. Player's ammo will decrement. Shooting will kill the ninja, reducing the amount of ninjas by 1
Test data: Player's ammo and Ninja amount
Expected result: Player can shoot through a power up and multiple rooms killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Actual result: Player can shoot through a power up and multiple rooms killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Pass/Fail: Pass
Comments: NA

Test case id: 68
Unit to test: shooting a ninja that is behind a Bullet(U) from north to south
Assumptions: No effect on Bullet. Player's ammo will decrement. Shooting will kill the ninja, reducing the amount of ninjas by 1
Test data: Player's ammo and Ninja amount
Expected result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Actual result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Pass/Fail: Pass
Comments: NA

Test case id: 69
Unit to test: shooting a ninja that is behind a Radar(D) from east to west
Assumptions: No effect on Radar. Player's ammo will decrement. Shooting will kill the ninja, reducing the amount of ninjas by 1
Test data: Player's ammo and Ninja amount
Expected result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Actual result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Pass/Fail: Pass
Comments: NA

Test case id: 70
Unit to test: shooting a ninja that is behind a invincibility(I) character from north to south
Assumptions: No effect on invincibility. Player's ammo will decrement. Shooting will kill the ninja, reducing the amount of ninjas by 1
Test data: Player's ammo and Ninja amount
Expected result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Actual result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Pass/Fail: Pass
Comments: NA

Test case id: 71
Unit to test: shooting a ninja that is behind a invincibility(I) character from west to east
Assumptions: No effect on invincibility. Player's ammo will decrement. Shooting will kill the ninja, reducing the amount of ninjas by 1
Test data: Player's ammo and Ninja amount
Expected result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Actual result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Pass/Fail: Pass
Comments: NA

Test case id: 72
Unit to test: shooting a ninja that is behind a invincibility(I) character from east to west
Assumptions: No effect on invincibility. Player's ammo will decrement. Shooting will kill the ninja, reducing the amount of ninjas by 1
Test data: Player's ammo and Ninja amount
Expected result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Actual result: Player can shoot through a power up killing a ninja and Ammo reduces by 1. Output: You hit an enemy!
Pass/Fail: Pass
Comments: NA

Test case id: 73
Unit to test: Save and Load game with debug disabled
Assumptions: Briefcase, Bullet ammount, Ninja Locations stay the same as when when first saved. Debug loads disabled
Test data: Briefcase and Ninja and Player Location, Bullet and Lives amount
Expected result: Player location the same (Up 3 from initial point), Briefcase and ninja location the same, bullet and life amount he same. All objects hiudden
Actual result: Player location the same (Up 3 from initial point), Briefcase and ninja location the same, bullet and life amount he 
Pass/Fail: Pass
Comments: NA

Test case id: 74
Unit to test: Save and Load game with debug enabled
Assumptions: Briefcase, Bullet ammount, Ninja Locations stay the same as when when first saved. Debug loads enabled
Test data: Briefcase and Ninja and Player Location, Bullet and Lives amount
Expected result: Player location the same (Up 3 from initial point), Briefcase and ninja location the same, bullet and life amount he same. All objects visible
Actual result: Player location the same (Up 3 from initial point), Briefcase and ninja location the same, bullet and life amount he 
Pass/Fail: Pass
Comments: NA

Test case id: 75
Unit to test: Save and Load game with 2 ammo with debug enabled 
Assumptions: Briefcase, Bullet ammount stays 2, Ninja Locations stay the same as when when first saved
Test data: Briefcase and Ninja and Player Location, Bullet and Lives amount
Expected result: Player location the same (Up 3 from initial point), Briefcase and ninja location the same, bullet and life amount the same
Actual result: Player location the same (Up 3 from initial point), Briefcase and ninja location the same, bullet and life amount the same
Pass/Fail: Pass
Comments: NA

Test case id: 76
Unit to test: Save and Load game with 2 ammo with debug disabled
Assumptions: Briefcase, Bullet ammount stays 2, Ninja Locations stay the same as when when first saved
Test data: Briefcase and Ninja and Player Location, Bullet and Lives amount
Expected result: Player location the same (Up 3 from initial point), Briefcase and ninja location the same, bullet and life amount the same
Actual result: Player location the same (Up 3 from initial point), Briefcase and ninja location the same, bullet and life amount the same
Pass/Fail: Pass
Comments: NA

Test case id: 77
Unit to test: Load game with filename that does not exist
Assumptions: game to request different load file
Test data: SaveGame Load 
Expected result: Output please try again
Actual result: at java.util.Scanner.throwFor(Unknown Source)
Pass/Fail: Fail
Comments: Try and Catch should fix this?

Test case id: 78
Unit to test: Shooting the Room with the Briefcase has no effect on room and briefcase and decrements ammo from south to north
Assumptions: only effect is ammo decrements
Test data: Player's Ammo
Expected result: Player's life and location stay the same. Ammo decrements by one. No effect on room
Actual result: Player's life and location stay the same. Ammo decrements by one. No effect on room
Pass/Fail: Pass
Comments: NA

Test case id: 79
Unit to test: Shooting the Room with the Briefcase has no effect on room and briefcase and decrements ammo from north to south
Assumptions: only effect is ammo decrements
Test data: Player's Ammo
Expected result: Player's life and location stay the same. Ammo decrements by one. No effect on room
Actual result: Player's life and location stay the same. Ammo decrements by one. No effect on room
Pass/Fail: Pass
Comments: NA

Test case id: 80
Unit to test: Shooting the Room with the Briefcase has no effect on room and briefcase and decrements ammo from west to east
Assumptions: only effect is ammo decrements
Test data: Player's Ammo
Expected result: Player's life and location stay the same. Ammo decrements by one. No effect on room
Actual result: Player's life and location stay the same. Ammo decrements by one. No effect on room
Pass/Fail: Pass
Comments: NA

Test case id: 81
Unit to test: Shooting the Room with the Briefcase has no effect on room and briefcase and decrements ammo from east to west
Assumptions: only effect is ammo decrements
Test data: Player's Ammo
Expected result: Player's life and location stay the same. Ammo decrements by one. No effect on room
Actual result: Player's life and location stay the same. Ammo decrements by one. No effect on room
Pass/Fail: Pass
Comments: NA

Test case id: 82 
Unit to test: Shooting a ninja behind the Room with the Briefcase has no effect on room and briefcase and decrements ammo & ninja from north to south
Assumptions: ammo and ninja decrements and ninja along with it's icon are removed from the board
Test data: Player's Ammo and Ninja Amount
Expected result: Player's life and location stay the same. Ammo and Ninja decrements by one. Ninja(N) removed. No effect on room
Actual result: Player's life and location stay the same. Ammo and Ninja decrements by one. Ninja(N) removed. No effect on room
Pass/Fail: Pass
Comments: NA

Test case id: 83 
Unit to test: Shooting a ninja behind the Room with the Briefcase has no effect on room and briefcase and decrements ammo & ninja from east to west
Assumptions: ammo and ninja decrements and ninja along with it's icon are removed from the board
Test data: Player's Ammo and Ninja Amount
Expected result: Player's life and location stay the same. Ammo and Ninja decrements by one. Ninja(N) removed. No effect on room
Actual result: Player's life and location stay the same. Ammo and Ninja decrements by one. Ninja(N) removed. No effect on room
Pass/Fail: Pass
Comments: NA

Test case id: 84
Unit to test: Shooting a ninja behind the Room with the Briefcase has no effect on room and briefcase and decrements ammo & ninja from west to east
Assumptions: ammo and ninja decrements and ninja along with it's icon are removed from the board
Test data: Player's Ammo and Ninja Amount
Expected result: Player's life and location stay the same. Ammo and Ninja decrements by one. Ninja(N) removed. No effect on room
Actual result: Player's life and location stay the same. Ammo and Ninja decrements by one. Ninja(N) removed. No effect on room
Pass/Fail: Pass
Comments: NA

Test case id: 85
Unit to test: Shooting a ninja behind the Room with the Briefcase has no effect on room and briefcase and decrements ammo & ninja from south to north
Assumptions: ammo and ninja decrements and ninja along with it's icon are removed from the board
Test data: Player's Ammo and Ninja Amount
Expected result: Player's life and location stay the same. Ammo and Ninja decrements by one. Ninja(N) removed. No effect on room
Actual result: Player's life and location stay the same. Ammo and Ninja decrements by one. Ninja(N) removed. No effect on room
Pass/Fail: Pass
Comments: NA

Test case id: 86
Unit to test: Player's inability to walk through Room through east side with invincibility
Assumptions: The player should not be able to walk through/check a room for the briefcase with invincibility.
Test data: Player's movement
Expected result: Player's location stay the same. Output: You can only enter the room from the top
Actual result: Player's location stay the same. Output: You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 87
Unit to test: Player's inability to walk through Room through south side with invincibility
Assumptions: The player should not be able to walk through/check a room for the briefcase with invincibility.
Test data: Player's movement
Expected result: Player's location stay the same. Output: You can only enter the room from the top
Actual result: Player's location stay the same. Output: You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 88
Unit to test: Player's inability to walk through Room through west side with invincibility
Assumptions: The player should not be able to walk through/check a room for the briefcase with invincibility.
Test data: Player's movement
Expected result: Player's location stay the same. Output: You can only enter the room from the top
Actual result: Player's location stay the same. Output: You can only enter the room from the top
Pass/Fail: Pass
Comments: NA

Test case id: 89
Unit to test: Player's ability to check a room from the north with invincibility
Assumptions: The player should able to check a room for the briefcase with invincibility.
Test data: Player's movement
Expected result: Player's location stay the same. Output: You found the briefcase! OR You entered the room and found nothing
Actual result: Player's location stay the same. Output: You found the briefcase! OR You entered the room and found nothing
Pass/Fail: Pass
Comments: NA




 
