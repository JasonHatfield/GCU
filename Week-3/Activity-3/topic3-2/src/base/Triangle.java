package base;

/**
 * @author Jason Hatfield
 * This is my original work.
 */
public class Triangle extends ShapeBase {

	/**
	 * @param width
	 * @param height
	 * @param name
	 */
	public Triangle(String name, int width, int height) {
		super(name, width, height);
	}
	
	@Override
	public int calculateArea() {
		return (width * height) / 2;
	}
}
