
/**
 * This program demonstrates using inheritance, overloading, and overriding
 * methods.
 * 
 * @author Jason Hatfield This is my original work.
 */
public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Bomb bomb = new Bomb();
		Gun gun = new Gun();

		bomb.activate(true);
		gun.activate(true);
		gun.fireWeapon(10);
		bomb.fireWeapon(5);
		gun.fireWeapon();
		bomb.fireWeapon();
	}

}
