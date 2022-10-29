
/**
 * @author Jason Hatfield
 * This is my original work.
 */
import java.util.*;

class Product {
	Scanner input = new Scanner(System.in);

	private int id;
	private String itemName;
	private String itemDescription;
	private int itemCost;
	private int itemCount;

	/**
	 * The product class provides the user with the ability to select an item, see the details,
	 * and purchase any quantity at or below the amount in the shop's inventory. When the item
	 * is purchased, the itemCount is reduced by the amount purchased.
	 * @param id
	 * @param itemName
	 * @param itemDescription
	 * @param itemCost
	 * @param itemCount
	 */
	public Product(int id, String itemName, String itemDescription, int itemCost, int itemCount) {

		this.id = id;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemCost = itemCost;
		this.itemCount = itemCount;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemDescription
	 */
	public String getItemDescription() {
		return itemDescription;
	}

	/**
	 * @param itemDescription the itemDescription to set
	 */
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	/**
	 * @return the itemCost
	 */
	public double getItemCost() {
		return itemCost;
	}

	/**
	 * @param itemCost the itemCost to set
	 */
	public void setItemCost(int itemCost) {
		this.itemCost = itemCost;
	}

	/**
	 * @return the itemCount
	 */
	public int getItemCount() {
		return itemCount;
	}

	/**
	 * @param itemCount the itemCount to set
	 */
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	/**
	 * Provides the user with a list of items available for purchase.
	 * The user will be able to select an item by inputting the associated ID number
	 * to see details about the item.
	 */
	public void itemList() {
		System.out.println("-={ Shop Inventory }=-\n\n" + id + ": " + itemName);

		System.out.print("\nEnter the item number to view details: ");

		int userInput = input.nextInt();

		if (userInput == 1) {
			System.out.println();
			itemDetails();
		} else {
			itemList();
		}
	}

	/**
	 * Presents the user with the description of the selected item as well as the price and quantity
	 * available to purchase.
	 */
	public void itemDetails() {
		System.out.println("Item Name: " + itemName + "\n" + "Item Description: " + itemDescription + "\n"
				+ "Item Cost: " + itemCost + " GP\n" + "Available Quantity: " + itemCount + "\n");

		System.out.print("Would you like to purchase " + itemName + "?\n\n" 
		+ "1: Purchase " + itemName + "\n"
		+ "2: Return to Shop Inventory\n\n" + "Enter your selection: ");
		
		// accepts user input to either purchase, or return to the shop inventory.
		int userInput = input.nextInt();

		if (userInput == 1) {
			purchase();
		} else if (userInput == 2) {
			System.out.println();
			itemList();
		} else {
			itemDetails();
		}
	}

	/**
	 * Gives the user the option to select a quantity of items to purchase.
	 * The user will have the option to confirm their purchase, change the desired quantity,
	 * or cancel the purchase and return to the items list page.
	 */
	public void purchase() {
		System.out.print("\n" + itemName + "\n" + "Quantity Available: " + itemCount + "\n"
				+ "How many would you like to purchase? ");
		
		// user input equals the quantity of items they wish to purchase.
		int itemQuantity = input.nextInt();

		if (itemQuantity > itemCount) {
			System.out.println("\nAmount requested exceeds quantity available: " + itemCount);
			purchase();
		} else if (itemQuantity <= itemCount && itemQuantity > 0) {
			System.out.print("\nPlease confirm your purchase\n" + itemName + " x " + itemQuantity + " = "
					+ (itemQuantity * itemCost) + " GP\n\n" + "1: Confirm\n" + "2: Change Quantity\n"
					+ "3: Cancel Order\n\n" + "Enter your selection: ");

			int userInput = input.nextInt();

			if (userInput == 1) {
				itemCount = itemCount - itemQuantity;

				System.out.println("Congratulations, you have purchased " + itemName + " X " + itemQuantity + "\n");

				// delays moving to the itemList method by 2 seconds. 
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				itemList();
			} else if (userInput == 2) {
				System.out.println();
				purchase();

			} else if (userInput == 3) {
				System.out.println();
				itemList();
			} else {
				System.out.println();
				itemList();
			}
		} else {
			purchase();
		}
	}
}