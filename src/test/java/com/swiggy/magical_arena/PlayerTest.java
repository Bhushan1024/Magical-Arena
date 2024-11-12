package com.swiggy.magical_arena;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

	// Instance variable for the player being tested
		private Player player;

		// Setup method to initialize the player before each test
		@BeforeEach
		void setUp() {
			// Create a new player with 50 health, 5 strength, and 10 attack
			player = new Player("Player A", 50, 5, 10);
		}

		// Test that the player is alive when health is above zero
		@Test
		void testIsAlive_whenHealthIsAboveZero() {
			assertTrue(player.isAlive(), "Player should be alive when health is above zero");
		}

		// Test that the player is not alive when health is zero
		@Test
		void testIsAlive_whenHealthIsZero() {
			player.reduceHealth(50); // Reduce health to zero
			assertFalse(player.isAlive(), "Player should not be alive when health is zero");
		}

		// Test that health reduces correctly when damage is less than current health
		@Test
		void testReduceHealth_whenDamageIsLessThanHealth() {
			player.reduceHealth(10);// Reduce health by 10
			assertEquals(40, player.getHealth(), "Player's health should reduce by the damage amount");
		}

		// Test that health doesn't go below zero when damage is more than current
		// health
		@Test
		void testReduceHealth_whenDamageIsMoreThanHealth() {
			player.reduceHealth(60); // More damage than current health
			assertEquals(0, player.getHealth(), "Player's health should not go below zero");
		}

		// Test that the dice roll returns a value between 1 and 6 (inclusive)
		@Test
		void testRollDice() {
			// Roll the dice 100 times to ensure it's within range
			for (int i = 0; i < 100; i++) {
				int roll = player.rollDice();
				assertTrue(roll >= 1 && roll <= 6, "Dice roll should be between 1 and 6");
			}
		}

		// Test that the attack decreases the opponent's health
		@Test
		void testAttackOpponent() {
			Player opponent = new Player("Player B", 50, 5, 5);
			int initialHealth = opponent.getHealth();
			player.attackOpponent(opponent);// Player A attacks Player B

			// Assert that the opponent's health has decreased
			assertTrue(opponent.getHealth() < initialHealth, "Opponent's health should decrease after attack");
		}

		// Test that negative damage doesn't affect the player's health
		@Test
		void testReduceHealth_whenDamageIsNegative() {
			// Simulate a scenario where a negative damage might be passed
			player.reduceHealth(-10); // Negative damage should have no effect
			assertEquals(50, player.getHealth(), "Health should not increase due to negative damage");
		}

		// Test that dice rolls are random by comparing two consecutive rolls
		@Test
		void testDiceRollIsRandom() {
			int roll1 = player.rollDice();
			int roll2 = player.rollDice();
			assertNotEquals(roll1, roll2, "Dice rolls should be random and not the same each time");
		}

		// Test that attacking with minimum and maximum dice rolls results in different
		// damage
		@Test
		void testAttackWithMinMaxDiceRolls() {
			Player opponent = new Player("Player B", 50, 5, 5);

			// Simulate minimum attack damage (dice roll of 1)
			player.attackOpponent(opponent); // Minimum roll (1)
			int healthAfterMinAttack = opponent.getHealth();

			// Reset opponent health and simulate maximum attack damage (dice roll of 6)
			opponent = new Player("Player B", 50, 5, 5);
			// Simulate maximum attack damage
			player.attackOpponent(opponent); // Maximum roll (6)
			int healthAfterMaxAttack = opponent.getHealth();

			// Ensure health decreases differently with different attack rolls
			assertTrue(healthAfterMinAttack < 50, "Opponent's health should decrease after the attack");
			assertTrue(healthAfterMaxAttack < healthAfterMinAttack,
					"Opponent's health should decrease more with higher attack");
		}

		// Test that the opponent with higher defense than the player's attack doesn't
		// take damage
		@Test
		void testAttackWhenDefenseIsGreaterThanAttack() {
			// Create an opponent with higher defense than the attack strength of the player
			Player opponent = new Player("Player B", 50, 15, 5); // Higher strength than attack
			player.attackOpponent(opponent);

			// Assert that the opponent's health remains the same since defense is greater
			// than attack
			assertEquals(50, opponent.getHealth(),
					"Opponent should not take damage if defense is greater than attack damage");
		}


}
