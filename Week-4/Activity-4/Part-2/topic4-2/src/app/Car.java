package app;

/**
 * @author Jason Hatfield
 * This is my original work.
 */
public class Car {
	private int year;
	private String make;
	private String model;
	private int odometer;
	private double engineLiters;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	/**
	 * Generic constructor
	 */
	public Car() {
		year = 0;
		make = "";
		model = "";
		odometer = 0;
		engineLiters = 0;
	}
	/**
	 * @param year
	 * @param make
	 * @param model
	 * @param odometer
	 * @param engineLiters
	 */
	public Car(int year, String make, String model, int odometer, 
			double engineLiters) {
		super();
		this.year = year;
		this.make = make;
		this.model = model;
		this.odometer = odometer;
		this.engineLiters = engineLiters;
	}
	
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the odometer
	 */
	public double getOdometer() {
		return odometer;
	}
	/**
	 * @param odometer the odometer to set
	 */
	public void setOdometer(int odometer) {
		this.odometer = odometer;
	}
	/**
	 * @return the engineLiters
	 */
	public double getEngineLiters() {
		return engineLiters;
	}
	/**
	 * @param engineLiters the engineLiters to set
	 */
	public void setEngineLiters(double engineLiters) {
		this.engineLiters = engineLiters;
	}

}
