
/**
 * @author Jason Hatfield This is my original work.
 */
public class Gun extends Weapon {

	/**
	 * Overrides the Weapon println statement.
	 * 
	 * @Override
	 */
	public void fireWeapon(int power) {
		System.out.println("In Gun.fireWeapon() with a power of " + power);
	}

	/**
	 * Overloaded method fires the weapon if no parameters are passed.
	 */
	public void fireWeapon() {
		System.out.println("In overloaded Gun.fireWeapon()");
		super.fireWeapon(5);
	}

	/**
	 * Prints to the console if passed variable from Weapon class is true.
	 */
	public void activate(boolean enable) {
		System.out.println("In the Gun.activate() with an enable of " + enable);
	}
}
