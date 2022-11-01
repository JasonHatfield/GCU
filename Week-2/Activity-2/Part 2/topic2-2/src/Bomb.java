
/**
 * @author Jason Hatfield This is my original work.
 */
public class Bomb extends Weapon {

	/**
	 * Overrides the Weapon println statement.
	 * 
	 * @Override
	 */
	public void fireWeapon(int power) {
		System.out.println("in Bomb.fireWeapon() with a power of " + power);
	}

	/**
	 * Overloaded method fires the weapon if no parameters are passed.
	 */
	public void fireWeapon() {
		System.out.println("In overloaded Bomb.fireWeapon()");
		super.fireWeapon(10);
	}

	/**
	 * Prints to the console if passed variable from Weapon class is true.
	 */
	public void activate(boolean enable) {
		System.out
				.println("In the Bomb.activate() with an enable of " + enable);
	}
}
