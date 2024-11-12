package com.swiggy.magical_arena;

public class Main {
// Main method to start the game
	public static void main(String[] args) {
		// Create two players with different initial health, strength, and attack values
		Player playerA = new Player("Player A", 50, 5, 10); // Player A with 50 health, 5 strength, and 10 attack
		Player playerB = new Player("Player B", 100, 10, 5); // Player B with 100 health, 10 strength, and 5 attack

		// Create an arena and initialize it with playerA and playerB
		Arena arena = new Arena(playerA, playerB);

		// Start the battle in the arena
		arena.startBattle();
	}
}
