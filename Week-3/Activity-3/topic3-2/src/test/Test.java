package test;

import base.Circle;
import base.Hexagon;
import base.Rectangle;
import base.ShapeBase;
import base.Triangle;

/**
 * @author Jason Hatfield
 * This is my original work.
 */

public class Test {
	/**
	 * method to print the shape information
	 * @param shape
	 */
	public static void displayArea(ShapeBase shape) {
		System.out.printf("This is a shape named %s with an area of %d.%n", shape.getName(), shape.calculateArea());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShapeBase[] shapes = new ShapeBase[4];
		shapes[0] = new Rectangle("Rectangle", 10, 200);
		shapes[1] = new Triangle("Triangle", 10, 50);
		shapes[2] = new Circle("Circle", 4);
		shapes[3] = new Hexagon(10, "Hexagon");
		
		for (int i = 0; i < shapes.length; i++) {
			displayArea(shapes[i]);
		}
	}
}
