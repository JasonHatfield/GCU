/**
 * @author Jason Hatfield
 * This is my original work.
 */
public class Product {
	private int id;
	private String name;
	private String description;
	private int count;
	private int price;
	
	/**
	 * @param name
	 * @param description
	 * @param count
	 * @param price
	 */
	public Product(int id, String name, String description, int count, int price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.count = count;
		this.price = price;
	}
	
	/**
	 * 
	 * @return id
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
}
