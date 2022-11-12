package base;

/**
 * This project takes inputs for a Triangle, Rectangle, Circle and Hexagon
 * and outputs the area for each based on the input int the Test.java class.
 * @author Jason Hatfield
 * This is my original work.
 */
public class ShapeBase implements ShapeInterface {
	protected String name;
	protected int width;
	protected int height;
	protected int radius;
	protected int area;
	
	/**
	 * Rectangle or Triangle
	 * @param width rectangle or triangle
	 * @param height rectangle or triangle
	 * @param name rectangle or triangle
	 */
	public ShapeBase(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
	}
	/**
	 * Circle
	 * @param name Circle
	 * @param radius Circle
	 */
	public ShapeBase(String name, int radius) {
		this.name = name;
		this.radius = radius;
	}
	
	/**
	 * Hexagon
	 * The area and name parameters were reversed to enable adding another
	 * constructor.
	 * @param area Hexagon
	 * @param name Hexagon
	 */
	public ShapeBase(int area, String name) {
		this.area = area;
		this.name = name;
	}
	
	/**
	 * Getter
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	@Override
	public int calculateArea() {
		return -1;
	}
}
