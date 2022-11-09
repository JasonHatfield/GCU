import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jason Hatfield
 * This is my original work.
 */
public class Main {
	public static void main(String[] args) {
		welcomeMessage();
		inventory();
	}
	
	/**
	 * welcomeMessage() method
	 */
	public static void welcomeMessage() {
		System.out.println("~={ Welcome to Jason's Magical Market }=~\n");
	}
	
	/**
	 * void inventory() method to create product ArrayList.
	 */
	public static void inventory() {
		ArrayList<Product> products = new ArrayList<Product>();
		
		//creates a healer's kit in the Health Subclass of the Product Superclass
		Product healersKit = new Health(1, "Healer's Kit", "This kit is a"
			+ " leather pouch containing bandages, salves, \nand splints."
			+ " The kit has ten uses. As an action, you can expend one use "
			+ "of \nthe kit to stabilize a creature that has 0 hit points, "
			+ "without needing to \nmake a Wisdom (Medicine) check.",
			10, 5);
		
		//creates a Dagger in the Weapon Subclass of the Product Superclass
		Product dagger = new Weapon(2, "Dagger", "A knife with a very sharp"
			+ " point and usually two sharp \nedges. Proficiency with a "
			+ "dagger allows you to add your proficiency bonus \nto the "
			+ "attack roll for any attack you make with it.", 
			5, 2);
		
		//creates a Great Sword in the Weapon Subclass of the Product Superclass
		Product greatSword = new Weapon(3, "Great Sword", "A large sword that "
			+ "has a double-edged blade and \nrequires two hands to wield,"
			+ " with an elongated hilt to accommodate the \nextra grip. "
			+ "Proficiency with a greatsword allows you to add your "
			+ "\nproficiency bonus to the attack roll for any attack you "
			+ "make with it.", 
			2, 50);
		
		//creates Studded Leather Armor in the Armor Subclass of the Product 
		//Superclass
		Product studdedLeather= new Armor(4, "Studded Leather", "Light Armor",
			"Made from tough but flexible leather, \nstudded leather is "
			+ "reinforced with close-set rivets or spikes.", 
			3, 45);
		
		//creates a Breastplate in the Armor Subclass of the Product Superclass
		Product breastPlate = new Armor(5, "Breastplate", "Medium Armor", "This"
			+ " armor consists of a fitted metal chest piece \nworn with "
			+ "supple leather. Although it leaves the legs and arms "
			+ "relatively \nunprotected, this armor provides good "
			+ "protection for the wearer's vital \norgans while leaving the"
			+ " wearer relatively unencumbered.", 4, 450);
		
		//adds each product item to the ArrayList
		products.add(healersKit);
		products.add(dagger);
		products.add(greatSword);
		products.add(studdedLeather);
		products.add(breastPlate);
		
		// calls the displayList and passes the products ArrayList
		displayList(products);
	}
	
	/**
	 * presents a list of items available in the shop
	 * @param products
	 */
	public static void displayList(ArrayList<Product> products) {
		System.out.println("~={ Shop Inventory }=~\n");
		
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getCount() == 0) {
				System.out.printf("%d: %s ***SOLD OUT***%n", 
						products.get(i).getID(), products.get(i).getName());
			} else {
			System.out.printf("%d: %s%n", products.get(i).getID(), 
				products.get(i).getName());
			}
		}
		//calls the userChoice method and passes the products ArrayList
		userChoice(products);
	}
	
	/**
	 * allows the user to select a product fromt he item list
	 * @param products
	 */
	public static void userChoice(ArrayList<Product> products) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nEnter the item number to select an item: ");
		
		try {
			int userInput = input.nextInt();
			switch(userInput) {
				case (1):
					productSelection(products, 0);
					break;
				case 2:
					productSelection(products, 1);
					break;
				case 3:
					productSelection(products, 2);
					break;
				case 4:
					productSelection(products, 3);
					break;
				case 5:
					productSelection(products, 4);
					break;
				default:
					userChoice(products);
			}
		} catch (Exception e) {
			userChoice(products);
		}
		
		input.close();
	}
	
	/**
	 * presents the user with a detailed description of the selected item
	 * to include the item's name, description, amount in stock, and price
	 * @param products
	 * @param i
	 */
	public static void productSelection(ArrayList<Product> products, int i) {
		//calls the linBreak method
		lineBreak();
		
		System.out.printf("%n~={ %s }=~%n"
			+ "%nItem Description: %s%n"
			+ "%nIn Stock: %d%n"
			+ "%nPrice: %d GP%n",
			products.get(i).getName(), products.get(i).getDescription(),
			products.get(i).getCount(), products.get(i).getPrice());
		
		lineBreak();
		
		productPurchase(products, i);
	}
	
	/**
	 * provides the user with the choice to purchase the selected item or to 
	 * cancel the transaction
	 * @param products
	 * @param i
	 */
	public static void productPurchase(ArrayList<Product> products, int i) {
		Scanner input = new Scanner(System.in);
		
		System.out.printf("%nWould you like to purchase %s?%n", 
			products.get(i).getName());
		
		System.out.print("\n1: Purchase"
			+ "\n2: Cancel\n"
			+ "\nEnter your selection: ");
		
		try {
			int userInput = input.nextInt();
			
			if (userInput == 1) {
				System.out.println();
				purchaseSelection(products, i);
			} else if (userInput == 2) {
				System.out.println("\nCanceling transaction.");
				returnToList();
				displayList(products);
			} else {
				productPurchase(products, i);
			}
		} catch (Exception e) {
			productPurchase(products, i);
		}

		input.close();
	}
	
	/**
	 * the user will select the quantity and finalize the transaction
	 * the user is also presented with one final decision to cancel or proceed
	 * @param products
	 * @param i
	 */
	public static void purchaseSelection(ArrayList<Product> products, int i) {
		Scanner input = new Scanner(System.in);
		
		System.out.printf("Enter quantity to purchase(MAX %d): ", 
			products.get(i).getCount());
		
		try {
			int purchaseCount = input.nextInt();
			
			if (purchaseCount > 0 && purchaseCount <= 
					products.get(i).getCount()) {
				int cost = products.get(i).getPrice() * purchaseCount;
				
				System.out.printf("%nYou are about to purchase %d ", 
					purchaseCount);
				if (purchaseCount == 1) {
					System.out.printf("%s", products.get(i).getName());
				} else {
					System.out.printf("%ss", products.get(i).getName());
				}
				System.out.printf(" for %,d GP.%n"
					+ "%nPress 1 to confirm your purchase, or 2 to cancel: ",
					cost);
				
				int userInput = input.nextInt();
				
				if (userInput == 1) {
					products.get(i).setCount(products.get(i).getCount() - 
						purchaseCount);
					System.out.println("\nYour transaction is complete.\n");
					displayList(products);
				} else if (userInput == 2) {
					System.out.println("Canceling purchase.\n");
					
					returnToList();
					
					displayList(products);
				}
			} else if (purchaseCount == 0) {
				System.out.println("Canceling purchase.\n");
				
				returnToList();
				
				displayList(products);
			} else
				System.out.printf("%n***Enter a quantity between 1 and "
					+ "%d***%n%n", products.get(i).getCount());
				purchaseSelection(products, i);
		} catch (Exception e) {
			System.out.printf("%n***Enter a quantity between 1 and "
				+ "%d***%n%n", products.get(i).getCount());
			
			purchaseSelection(products, i);
		}
		
		input.close();
	}
	
	/**
	 * method presents the user with a delay of three seconds to simulate 
	 * returning to the shop's inventory
	 */
	public static void returnToList() {
		System.out.print("\nReturning to the Shop Inventory ");
		
		for (int i = 0; i < 3; i++) {
			delay(1);
			System.out.print(". ");
		}
		
		delay(1);
		
		System.out.println();
		
		lineBreak();
		
		System.out.println();
	}
	
	/**
	 * encapsulation which passes a while number integer 1, 2, 3, etc...
	 * and multiplies it by 1,000 (milliseconds) then delays by the number
	 * passed
	 * @param seconds
	 */
	public static void delay(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	/**
	 * method to present the user with a line break to break up each section 
	 * of the shop
	 */
	public static void lineBreak() {
		System.out.println("\n******************************************");
	}
}