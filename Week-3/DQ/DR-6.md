### Discussion Response
Polymorphism has always been a concept that I have struggled to comprehend. This week, I concentrated my efforts of learning how to implement Polymorphism into my code and I feel as though I have a much better grasp now.

>"Polymorphism is the task that performs a single action in different ways" and "occurs hen there is inheritance, i.e., there are many classes that related to each other" (Great Learning Team, 2022).

By implementing polymporphism through inheritance, programmers are able to make multiple objects through inheritance of their parent class. The parent class establishes the blueprint for each subclass, but polymorphism allows for greater flexibility of what the subclass objects can do.

### Polymorphism Example
``` Java
public abstract class ShapeBase {
  protected String name;
  protected int radius
  
  public ShapeBase(String name, int radius) {
    this.name = name;
    this.radius = radius;
  }
  
  public String getName() {
    return this.name;
  }
  
  public int calculateArea() {
    return -1;
  }
}

public class Circle extends ShapeBase {

  public Circle(String name, int radius) {
    super(name, radius);
  }
  
  @Override
  public int calculateArea() {
    return (int) ((Math.PI * radius) * radius);
  }
}

public class Main {
  public static void displayArea(ShapeBase shape) {
    System.out.printf("This is a shape named %s with an area of %d.%n", shape.getName(), shape.calculateArea());
	}
  
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

```
### Output
``` Java
This is a shape named Circle with an area of 50.
```

### Reference
Great Learning Team. (2022, September 13). Polymorphism in Java with Examples – 2022. Great Learning Blog: Free Resources What Matters to Shape Your Career! https://www.mygreatlearning.com/blog/polymorphism-in-java/
