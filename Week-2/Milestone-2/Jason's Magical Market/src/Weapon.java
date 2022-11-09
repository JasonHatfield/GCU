
/**
 * @author Jason Hatfield
 * This is my original work.
 */
public class Weapon extends Product {
	private double weaponWeight;
	private String weaponType;
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param string 
	 * @param count
	 * @param price
	 */
	public Weapon(int id, String name, String description, int count,
			int price) {
		super(id, name, description, count, price);
	}

	/**
	 * @return the weaponWeight
	 */
	public double getWeaponWeight() {
		return weaponWeight;
	}

	/**
	 * @param weaponWeight the weaponWeight to set
	 */
	public void setWeaponWeight(double weaponWeight) {
		this.weaponWeight = weaponWeight;
	}

	/**
	 * @return the weaponType
	 */
	public String getWeaponType() {
		return weaponType;
	}

	/**
	 * @param weaponType the weaponType to set
	 */
	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}
	
	
}