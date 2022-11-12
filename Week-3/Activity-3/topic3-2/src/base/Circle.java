package base;

/**
 * @author Jason Hatfield
 * This is my original work.
 */
public class Circle extends ShapeBase {
		
	/**
	 * @param name
	 * @param area
	 */
	public Circle(String name, int radius) {
		super(name, radius);
	}

	@Override
	public int calculateArea() {
		return (int) ((Math.PI * radius) * radius);
	}
}
