
/**
 * @author Jason Hatfield
 * This is my original work.
 */
import java.util.Scanner;

public class Tire {
	Scanner input = new Scanner(System.in);
	private int tirePressure;
	
	/**
	 * constructor
	 */
	public Tire() {
	}

	/**
	 * getter
	 * @return
	 */
	public int getTirePressure() {
		return tirePressure;
	}

	/**
	 * setter
	 * @param tirePressure
	 */
	public void setTirePressure(int tirePressure) {
		this.tirePressure = tirePressure;
	}

	/**
	 * method to check each tire for the proper tire pressure
	 * if ok, skips to the next tire, if not moves to the addAir()
	 * method
	 */
	public void checkTires() {
		char c = '.';

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 3; i++) {
			System.out.print(c + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (tirePressure < 32) {
			System.out.println("Tire pressure is below the minimum of 32 PSI.\n");
			addAir();
		} else {
			System.out.println("OK\n");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * method to add air to the tire to meet the minimum requirement of 32 PSI
	 */
	public void addAir() {
		char c = '.';
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.print("Press 1 to add air to this tire: ");

		if (input.nextInt() == 1) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.print("\nAdding air to the tire ");

			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (int i = 0; i < 3; i++) {
				System.out.print(c + " ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			tirePressure = 32;

			System.out.println("COMPLETE");

			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();

	}
}
