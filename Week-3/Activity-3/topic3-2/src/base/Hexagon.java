package base;

/**
 * @author Jason Hatfield
 * This is my original work.
 */
public class Hexagon extends ShapeBase {

	/**
	 * @param name
	 * @param radius
	 */
	public Hexagon(int area, String name) {
		super(area, name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int calculateArea() {
		return (int) ((6 * (area * area)) / (4 * Math.tan(Math.PI / 6)));
	}
}
