
/**
 * @author Jason Hatfield
 * This is my original work.
 */
import java.util.Scanner;

public class Engine {
	Scanner input = new Scanner(System.in);

	private Boolean hasEngine = false;
	
	/**
	 * constuctor that receives the Boolean value hasEngine
	 * @param hasEngine
	 */
	public Engine(Boolean hasEngine) {
		this.hasEngine = hasEngine;
	}

	/**
	 * constructor
	 */
	public Engine() {
	}

	/**
	 * 
	 * @return
	 */
	public Boolean getHasEngine() {
		return hasEngine;
	}

	/**
	 * 
	 * @param hasEngine
	 */
	public void setHasEngine(Boolean hasEngine) {
		this.hasEngine = hasEngine;
	}

	/**
	 * If the hasEngine status is false, this will add the engine, otherwise this
	 * will skip and go to the Car class.
	 */
	public void checkEngine() {
		if (hasEngine == false) {
			System.out.println("STATUS: Your car does not have an engine.\n");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			addEngine();
		}
	}

	/**
	 * Adds an engine to the car and then goes to the car class.
	 */
	public void addEngine() {
		System.out.print("Press 1 to add an engine: ");
		char s = '.';

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (input.nextInt() == 1) {

			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.print("\nPlease wait while your engine is installed ");

			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(s + " ");
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("COMPLETE\n");
			hasEngine = true;

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			addEngine();
		}
	}
}
