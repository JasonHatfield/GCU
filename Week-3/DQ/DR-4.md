### Week 3: Summarizing The Reading

The reading for this week encompassed three significant points: Interfaces, Polymorphism, and Abstract classes. 

An abstract class is like a regular class, but the programmer cannot create an object within the abstract class. Instead, objects must be implemented using the subclasses of the abstract superclass. 

> "The constructor in the abstract class is defined as protected because it is used only by subclasses" (Liang, 2019, p. 502).

Additionally, when implementing an abstract method within a class, the class itself must also be abstract.

An interface is a separate file created to specify "common behavior for objects of related classes or unrelated classes" (Liang, 2019, p. 533). 

### Interface Example
``` Java
public interface ShapeInterface {
	/**
	 * ShapeInterface
	 * @return Provides the interface for the ShapeBase superclass.
	 */
	int calculateArea();
}
```
### Abstract Class Example
``` Java
public abstract class ShapeBase implements ShapeInterface {
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
```

### Reference
Liang, Y. D. (2020). Introduction to Java Programming and Data Structures. Hoboken, New Jersey, United States of America: Pearson Education, Inc.
