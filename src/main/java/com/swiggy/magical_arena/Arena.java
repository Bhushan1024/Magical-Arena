package com.swiggy.magical_arena;

public class Arena {

	// Instance variables for the two players in the arena
		private Player player1;
		private Player player2;

		// Constructor to initialize the two players in the arena
		public Arena(Player player1, Player player2) {
			this.player1 = player1; // Set player1 for the battle
			this.player2 = player2; // Set player2 for the battle
		}

		// Method to start the battle between the two players
		public void startBattle() {
			Player attacker, defender; // Declare variables to store the attacker and defender for each turn

			// Battle loop: continues until one of the players' health is 0 or less
			while (player1.isAlive() && player2.isAlive()) {
				// Determine the attacker and defender based on the current health of the
				// players
				if (player1.getHealth() <= player2.getHealth()) {
					attacker = player1;// If player1 has less or equal health, player1 becomes the attacker
					defender = player2;// player2 becomes the defender
				} else {
					attacker = player2;// If player2 has less health, player2 becomes the attacker
					defender = player1;// player1 becomes the defender
				}

				// Print out who is attacking whom
				System.out.printf("%s attacks %s:\n", attacker.getName(), defender.getName());
				// Perform the attack
				attacker.attackOpponent(defender);
			}

			// After the loop ends, the winner is the player who is still alive
			Player winner = player1.isAlive() ? player1 : player2;
			// Print out the winner’s name and remaining health
			System.out.printf("Game over! %s wins with %d health left.\n", winner.getName(), winner.getHealth());
		}
}
