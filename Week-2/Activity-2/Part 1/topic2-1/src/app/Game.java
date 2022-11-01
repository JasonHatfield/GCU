package app;

import java.util.Random;

/**
 * Driver class to create super heroes with a randomly generated
 * health pool between 1 and 1000. Each superhero attacks on their
 * turn and if the health pool drops to 0, the attacking superhero
 * wins the game.
 * @author Jason Hatfield 
 * This is my original work.
 */
public class Game {
	public static void main(String[] args) {
		Random random = new Random();

		System.out.println("Creating our Super Heroes...\n");
		
		Superman superman = new Superman(random.nextInt(1000) + 1);
		Batman batman = new Batman(random.nextInt(1000) + 1);
		
		System.out.println("Super Heroes created.\n");

		while (!superman.isDead() && !batman.isDead()) {
			superman.attack(batman);
			batman.attack(superman);

			if (superman.isDead()) {
				System.out.println("\nBatman defeated Superman.");
			}

			if (batman.isDead()) {
				System.out.println("\nSuperman defeated Batman.");
			}
		}
	}
}
