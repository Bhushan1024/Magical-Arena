package com.swiggy.magical_arena;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArenaTest {

	// Instance variables for the players and the arena
		private Player player1;
		private Player player2;
		private Arena arena;

		// Setup method to initialize the players and the arena before each test
		@BeforeEach
		void setUp() {
			// Create two players with different stats
			player1 = new Player("Player A", 50, 5, 10);// Player A with 50 health, 5 strength, and 10 attack
			player2 = new Player("Player B", 50, 5, 5);// Player B with 50 health, 5 strength, and 5 attack
			// Initialize the arena with the two players
			arena = new Arena(player1, player2);
		}

		// Test case where player1 should win
		@Test
		void testStartBattle_player1Wins() {
			// Simulate a scenario where player 1 should win by reducing player2's health to 0
			player2.reduceHealth(50); // Reduce health of player2 to 0

			// Run the battle
			arena.startBattle();

			// Assert that player2 is dead and player1 is alive after the battle
			assertFalse(player2.isAlive(), "Player 2 should be dead after the battle");
			assertTrue(player1.isAlive(), "Player 1 should be alive after the battle");
		}

		// Test case where player2 should win
		@Test
		void testStartBattle_player2Wins() {
			// Simulate a scenario where player 2 should win by reducing player1's health to 0
			player1.reduceHealth(50); // Reduce health of player1 to 0

			// Run the battle
			arena.startBattle();

			// Assert that player1 is dead and player2 is alive after the battle
			assertFalse(player1.isAlive(), "Player 1 should be dead after the battle");
			assertTrue(player2.isAlive(), "Player 2 should be alive after the battle");
		}

		// Test case for when both players have equal health
		@Test
		void testStartBattle_equalHealth() {
			// Create two players with equal health, strength, and attack
			Player player1 = new Player("Player A", 50, 5, 10);
			Player player2 = new Player("Player B", 50, 5, 10);
			Arena arena = new Arena(player1, player2);

			// Simulate the battle
			arena.startBattle();

			// Assert that one of the players wins and the other loses health
			assertNotEquals(player1.getHealth(), 50, "One player should win and the other should lose health");
			assertNotEquals(player2.getHealth(), 50, "One player should win and the other should lose health");
		}
		
		// Test case for when one player has high strength and low health
		@Test
		void testStartBattle_highStrengthLowHealth() {
			 // Create a player with high strength and low health
			Player player1 = new Player("Player A", 10, 20, 5); // High strength, low health
			Player player2 = new Player("Player B", 50, 5, 5); // Normal stats
			Arena arena = new Arena(player1, player2);

			// Simulate the battle
			arena.startBattle();

			// Assert that the player with more health wins
			assertTrue(player2.isAlive(), "Player 2 should win with higher health");
			assertFalse(player1.isAlive(), "Player 1 should lose due to low health");
		}

		 
	    // Test case for random player stats
		@Test
		void testStartBattle_randomStats() {
			// Create two players with random health, strength, and attack stats
			Random rand = new Random();
			Player player1 = new Player("Player A", rand.nextInt(50) + 1, rand.nextInt(10) + 1, rand.nextInt(10) + 1);
			Player player2 = new Player("Player B", rand.nextInt(50) + 1, rand.nextInt(10) + 1, rand.nextInt(10) + 1);
			Arena arena = new Arena(player1, player2);

			// Simulate the battle
			arena.startBattle();

			// Assert that one player should win, and the other should lose
			assertNotEquals(player1.isAlive(), player2.isAlive(),
					"One player should be alive and the other should be dead");
		}

		// Test case for when both players start with zero health
		@Test
		void testStartBattle_bothPlayersZeroHealth() {
			// Create two players with zero health
			Player player1 = new Player("Player A", 0, 5, 10); // Zero health
			Player player2 = new Player("Player B", 0, 5, 5); // Zero health
			Arena arena = new Arena(player1, player2);

			// Run the battle
			arena.startBattle();

			// Assert that both players should be dead since they both start with zero health
			assertFalse(player1.isAlive(), "Player 1 should be dead");
			assertFalse(player2.isAlive(), "Player 2 should be dead");
		}

		// Test case to check if the players alternate turns during the battle
		@Test
		void testStartBattle_alternatingTurns() {
			// Test that the battle alternates between players
			Player player1 = new Player("Player A", 50, 5, 10);
			Player player2 = new Player("Player B", 50, 5, 5);
			Arena arena = new Arena(player1, player2);

			// Simulate the battle
			arena.startBattle();

			 // Assert that at least one player's health should have decreased during the battle
			assertTrue(player1.getHealth() < 50 || player2.getHealth() < 50,
					"At least one player's health should have decreased during the battle");
		}


}
