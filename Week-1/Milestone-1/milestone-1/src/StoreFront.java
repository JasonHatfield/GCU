/**
 * @author Jason Hatfield
 * GCU - CST-239
 * This is my original work.
 */

public class StoreFront {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Welcome to Jason's Magical Market!\n");
		
		Product healingPotion = new Product(
				1, 
				"Potion of Healing",
				"A character who drinks the magical red fluid in this vial "
						+ "regains \n2d4 + 2 hit points. Drinking or administering a potion "
						+ "takes an action.",
				50, 
				100);
		
		healingPotion.itemList();
	}
}
