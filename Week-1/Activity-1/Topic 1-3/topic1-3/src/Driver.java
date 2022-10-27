/**
 * @author Jason Hatfield This is my original work.
 */

public class Driver {
	/**
	 * Driver program to check if the car has an engine, 4 tires
	 * at a minimum of 32 PSI. The program will also run the car.
	 * @param args
	 */
	public static void main(String[] args) {

		Engine engine = new Engine();
		engine.checkEngine();

		Tire[] tires = new Tire[4];
		tires[0] = new Tire();
		tires[1] = new Tire();
		tires[2] = new Tire();
		tires[3] = new Tire();

		System.out.print("Checking DRIVER side FRONT tire PSI ");
		tires[0].setTirePressure(0);
		tires[0].checkTires();

		System.out.print("Checking PASSENGER side FRONT tire PSI ");
		tires[1].setTirePressure(0);
		tires[1].checkTires();

		System.out.print("Checking DRIVER side REAR tire PSI ");
		tires[2].setTirePressure(0);
		tires[2].checkTires();

		System.out.print("Checking PASSENGER side FRONT tire PSI ");
		tires[3].setTirePressure(0);
		tires[3].checkTires();

		Car car = new Car(engine, tires);

		car.ready();
	}
}
