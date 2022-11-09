
/**
 * @author Jason Hatfield
 * This is my original work.
 */
public class Armor extends Product {
	private double armorWeight;
	private String armorType;
	
	/**
	 * @param id
	 * @param name
	 * @param armorType
	 * @param  description
	 * @param count
	 * @param price
	 */
	public Armor(int id, String name, String armorType, String description, int count,
			int price) {
		super(id, name, description, count, price);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the armorWeight
	 */
	public double getArmorWeight() {
		return armorWeight;
	}

	/**
	 * @param armorWeight the armorWeight to set
	 */
	public void setArmorWeight(double armorWeight) {
		this.armorWeight = armorWeight;
	}

	/**
	 * @return the armorType
	 */
	public String getArmorType() {
		return armorType;
	}

	/**
	 * @param armorType the armorType to set
	 */
	public void setArmorType(String armorType) {
		this.armorType = armorType;
	}
	
}