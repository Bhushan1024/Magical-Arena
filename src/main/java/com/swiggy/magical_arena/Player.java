package com.swiggy.magical_arena;
import java.util.Random;
public class Player {
// Instance variables for player's name, health, strength, attack, and a Random
	// object for dice rolls
	private String name;
	private int health;
	private int strength;
	private int attack;
	private Random dice;

	// Constructor to initialize a player with name, health, strength, and attack
	// values
	public Player(String name, int health, int strength, int attack) {
		this.name = name; // Set the player's name
		this.health = health; // Set the player's health
		this.strength = strength; // Set the player's strength
		this.attack = attack; // Set the player's attack power
		this.dice = new Random(); // Initialize the dice for random number generation
	}

	// Method to check if the player is still alive (health > 0)
	public boolean isAlive() {
		return this.health > 0; // Returns true if the player has more than 0 health, else false
	}

	// Method to simulate rolling a dice (returns a random number between 1 and 6)
	public int rollDice() {
		return dice.nextInt(6) + 1; // Rolls a dice (returns a value between 1 and 6)
	}

	// Method to simulate attacking another player
	public void attackOpponent(Player opponent) {
		// Roll the dice to determine the attack strength
		int attackRoll = rollDice();
		// Calculate the attack damage by multiplying the player's attack value with the
		// attack roll
		int attackDamage = this.attack * attackRoll;

		// Roll the dice for the opponent's defense
		int defenseRoll = opponent.rollDice();
		// Calculate the defense value by multiplying the opponent's strength with the
		// defense roll
		int defenseValue = opponent.strength * defenseRoll;

		// Calculate the net damage, ensuring it’s not less than 0 (no negative damage)
		int netDamage = Math.max(0, attackDamage - defenseValue);
		// Reduce the opponent’s health by the net damage
		opponent.reduceHealth(netDamage);

		// Print the attack and defense details
		System.out.println(this.name + " rolls " + attackRoll + " (Attack Damage: " + attackDamage + ")");
		System.out.println(opponent.name + " rolls " + defenseRoll + " (Defense Value: " + defenseValue + ")");
		System.out.println(opponent.name + " takes " + netDamage + " damage, health now " + opponent.health + ".\n");
	}

	// Method to reduce the player's health by a certain amount of damage
	public void reduceHealth(int damage) {
		// Ensure health doesn’t go below 0
		this.health = Math.max(0, this.health - damage);
	}

	// Getter for the player's health
	public int getHealth() {
		return health;
	}

	// Getter for the player's name
	public String getName() {
		return name;
	}

}
