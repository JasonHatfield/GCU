package app;

import java.util.Random;

/**
 * This class randomized attack damaged from 1-10 for each superhero.
 * Additionally, the class determines if the super hero is dead and outputs the 
 * results to the console.
 * @author Jason Hatfield 
 * This is my original work.
 */
public class SuperHero {
	Random random = new Random();
	private String name;
	private int health;
	private boolean isDead;
	
	/**
	 * Class constructor
	 * @param name
	 * @param health
	 */
	public SuperHero(String name, int health) {
		this.name = name;
		this.health = health;
	}
	
	/**
	 * Generates random attack damage from 1 to 10.
	 * @param opponent
	 */
	public void attack(SuperHero opponent) {
		int damage = random.nextInt(10 + 1);
		
		opponent.determineHealth(damage);
		
		System.out.println(String.format("%s has damage of %d and health of %d", 
				opponent.name, damage, opponent.health));
	}
	
	/**
	 * 
	 * @return isDead
	 */
	public boolean isDead() {
		return this.isDead;
	}
	
	/**
	 * Returns either the damage, or death of the superhero.
	 * @param damage
	 */
	private void determineHealth(int damage) {
		if (this.health - damage <= 0) {
			this.health = 0;
			this.isDead = true;
		}
		else {
			this.health = this.health - damage;
		}
	}
}
