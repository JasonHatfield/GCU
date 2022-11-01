
/**
 * @author Jason Hatfield This is my original work.
 */
public abstract class Weapon {

	/**
	 * Fires the weapon.
	 * 
	 * @param power
	 */
	public void fireWeapon(int power) {
		System.out.println("In Weapon.fireWeapon() with a power of " + power);
	}

	/**
	 * Enables a boolean value of either true or false.
	 * 
	 * @param enable
	 */
	public abstract void activate(boolean enable);
}
