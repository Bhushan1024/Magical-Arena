# Magical Arena

A simple turn-based magical arena game, implemented in Java, where two players engage in a battle using dice rolls to determine attack and defense outcomes. The game ends when one player's health reaches zero.

# Technologies Used
Highlight the technologies and tools you used in the project:
- Programming Language: Java 17
- Testing Framework: JUnit 5
- Development Environment: Eclipse/IntelliJ IDEA

# Project Structure
- Player: Represents each player with health, strength, and attack attributes.
- Arena: Manages the game loop, handling attacks and defenses in a turn-based fashion.
- Main: The entry point to start the game.
- ArenaTest: Unit tests to verify the functionality of Player and Arena classes.

# Features
List the key features of your game to summarize its functionality:
- Turn-based gameplay.
- Real-time dice roll simulation.
- Detailed combat logs.
- Customizable player attributes.
- Unit-tested with JUnit 5.

# Game Rules
- Each player has three main attributes: health, strength, and attack.
- Players take turns attacking each other.
- On each turn, the attacking player rolls a 6-sided die for attack, and the defending player rolls a 6-sided die for defense.
- Damage is calculated as follows:
- Attack Damage = Attacker’s attack * Attack Dice Roll
- Defense Value = Defender’s strength * Defense Dice Roll
- Net Damage = Attack Damage - Defense Value (if positive)
- The defender’s health is reduced by the net damage, if any.
- The game continues until one player’s health reaches zero.

# Prerequisites
- Eclipse IDE: Ensure you have Eclipse IDE installed on your system.
- Java Development Kit (JDK) 8 or later
- JUnit 5 Jupiter API for running tests

# Code Design
The project uses the following classes and design:

- Player: Contains methods for dice rolls, taking damage, and checking if the player is still alive.
- Arena: Manages the game by alternating turns between the players until one of them loses.
- Main: Sets up players with default values and initiates the game in the arena.
- PlayerTest: Verifies key methods in the Player class for expected behavior.
- ArenaTest: Verifies key methods in the Arena class for expected behavior.

# Customization
Explain how users can modify the game to customize player attributes:
- Open the Main class.
- Adjust the default values for health, strength, and attack for each player:

Player playerA = new Player("Player A", 100, 5, 10);
Player playerB = new Player("Player B", 80, 6, 12);

# Running the Game
- Clone or download this repository to your local machine.
- Open Eclipse IDE.
- Import the project:
  File -> Import -> General -> Existing Projects into Workspace.
 Select the root directory of the project and click Finish.
- Locate the Main class in the src folder.
- Right-click on the Main class -> Run As -> Java Application.
- Follow the game instructions in the console output.

# Testing the Game
- Ensure that the JUnit 5 library is added to the project’s build path:
 Right-click the project -> Build Path -> Add Libraries -> JUnit -> Select JUnit 5 -> Finish.
- Locate the ArenaTest class in the test folder.
- Right-click on the ArenaTest class -> Run As -> JUnit Test.
- Review the test results in the JUnit tab.

# Example Game Output

Player A attacks Player B:
Player A rolls 2 (Attack Damage: 20)
Player B rolls 2 (Defense Value: 20)
Player B takes 0 damage, health now 100.

Player A attacks Player B:
Player A rolls 4 (Attack Damage: 40)
Player B rolls 4 (Defense Value: 40)
Player B takes 0 damage, health now 100.

Player A attacks Player B:
Player A rolls 5 (Attack Damage: 50)
Player B rolls 5 (Defense Value: 50)
Player B takes 0 damage, health now 100.

Player A attacks Player B:
Player A rolls 1 (Attack Damage: 10)
Player B rolls 3 (Defense Value: 30)
Player B takes 0 damage, health now 100.

Player A attacks Player B:
Player A rolls 3 (Attack Damage: 30)
Player B rolls 1 (Defense Value: 10)
Player B takes 20 damage, health now 80.

Player A attacks Player B:
Player A rolls 1 (Attack Damage: 10)
Player B rolls 1 (Defense Value: 10)
Player B takes 0 damage, health now 80.

Player A attacks Player B:
Player A rolls 1 (Attack Damage: 10)
Player B rolls 5 (Defense Value: 50)
Player B takes 0 damage, health now 80.

Player A attacks Player B:
Player A rolls 3 (Attack Damage: 30)
Player B rolls 4 (Defense Value: 40)
Player B takes 0 damage, health now 80.

Player A attacks Player B:
Player A rolls 5 (Attack Damage: 50)
Player B rolls 3 (Defense Value: 30)
Player B takes 20 damage, health now 60.

Player A attacks Player B:
Player A rolls 1 (Attack Damage: 10)
Player B rolls 5 (Defense Value: 50)
Player B takes 0 damage, health now 60.

Player A attacks Player B:
Player A rolls 5 (Attack Damage: 50)
Player B rolls 6 (Defense Value: 60)
Player B takes 0 damage, health now 60.

Player A attacks Player B:
Player A rolls 4 (Attack Damage: 40)
Player B rolls 3 (Defense Value: 30)
Player B takes 10 damage, health now 50.

Player A attacks Player B:
Player A rolls 6 (Attack Damage: 60)
Player B rolls 2 (Defense Value: 20)
Player B takes 40 damage, health now 10.

Player B attacks Player A:
Player B rolls 6 (Attack Damage: 30)
Player A rolls 6 (Defense Value: 30)
Player A takes 0 damage, health now 50.

Player B attacks Player A:
Player B rolls 1 (Attack Damage: 5)
Player A rolls 3 (Defense Value: 15)
Player A takes 0 damage, health now 50.

Player B attacks Player A:
Player B rolls 6 (Attack Damage: 30)
Player A rolls 1 (Defense Value: 5)
Player A takes 25 damage, health now 25.

Player B attacks Player A:
Player B rolls 3 (Attack Damage: 15)
Player A rolls 5 (Defense Value: 25)
Player A takes 0 damage, health now 25.

Player B attacks Player A:
Player B rolls 2 (Attack Damage: 10)
Player A rolls 4 (Defense Value: 20)
Player A takes 0 damage, health now 25.

Player B attacks Player A:
Player B rolls 5 (Attack Damage: 25)
Player A rolls 6 (Defense Value: 30)
Player A takes 0 damage, health now 25.

Player B attacks Player A:
Player B rolls 4 (Attack Damage: 20)
Player A rolls 2 (Defense Value: 10)
Player A takes 10 damage, health now 15.

Player B attacks Player A:
Player B rolls 2 (Attack Damage: 10)
Player A rolls 3 (Defense Value: 15)
Player A takes 0 damage, health now 15.

Player B attacks Player A:
Player B rolls 1 (Attack Damage: 5)
Player A rolls 6 (Defense Value: 30)
Player A takes 0 damage, health now 15.

Player B attacks Player A:
Player B rolls 4 (Attack Damage: 20)
Player A rolls 6 (Defense Value: 30)
Player A takes 0 damage, health now 15.

Player B attacks Player A:
Player B rolls 4 (Attack Damage: 20)
Player A rolls 4 (Defense Value: 20)
Player A takes 0 damage, health now 15.

Player B attacks Player A:
Player B rolls 6 (Attack Damage: 30)
Player A rolls 6 (Defense Value: 30)
Player A takes 0 damage, health now 15.

Player B attacks Player A:
Player B rolls 3 (Attack Damage: 15)
Player A rolls 6 (Defense Value: 30)
Player A takes 0 damage, health now 15.

Player B attacks Player A:
Player B rolls 6 (Attack Damage: 30)
Player A rolls 1 (Defense Value: 5)
Player A takes 25 damage, health now 0.

Game over! Player B wins with 10 health left.


# Author
- Name: Bhushan Chavan
- Email: bhushanchavan2710@gmail.com or bhushanchavan1024@gmail.com
- Phone: +91 7721873720

