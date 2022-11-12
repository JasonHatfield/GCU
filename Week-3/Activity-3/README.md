## Activity 3
- [Cover Sheet](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/Cover%20Sheet.pdf)
### Part 1
---
#### Screenshots
![Screenshot 1](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/01-Screenshot.png)<br>
![Screenshot 2](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/02-Screenshot.png)<br>

---
#### Theory
After the `Person[]` object is created and instantiated with 4 persons, each person is assigned a position in the array.
``` Java
Person[] persons = new Person[4];
persons[0] = new Person("Justine", "Reha");
persons[1] = new Person("Brianna", "Reha");
persons[2] = new Person("Mary", "Reha");
persons[3] = new Person("Mark", "Reha");
```
The sort method in the Arrays class is called from the Java library and evaluates the first value and then the second value of each index.
``` Java
Arrays.sort(persons);
```
After the arrays are sorted by both last and first name, the program continues to the for loop where each name is printed out in alphabetical order.
``` Java
for(int i = 0; i < persons.length; i++) {
  System.out.println(persons[i]);
```
---
#### Code
- [Person.java](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/topic3-1/src/app/Person.java)<br>
- [PersonInterface.java](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/topic3-1/src/app/PersonInterface.java)<br>
- [Test.java](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/topic3-1/src/app/Test.java)<br>

---
### Part 2

---
#### UML Diagram
![UML Diagram](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/UML%20Class%20Diagram.png)

---
#### Theory
The ShapeBase superclass establishes the parameters for each subclass.

Through inheritance, each subclass inherites the `calculateArea()` method from the ShapeBase.java class, which overrides the ShapeInterface.java class.
``` Java
@Override
public int calculateArea() {
  return -1;
}
```
An example of further polymorphism in the Circle.java class is the same method mentioned above. 

This class further overrides the calculateArea() method and replaces the return value of -1 with the formula to find the area of a circle.
``` Java
@Override
public int calculateArea() {
  return (int) ((Math.PI * radius) * radius);
}
```

---
#### Screenshots
![Screenshot 3](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/03-Screenshot.png)<br>
![Screenshot 4](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/04-Screenshot.png)<br>

---
#### Code
Test Package
- [Test.java](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/topic3-2/src/test/Test.java)

Base Package
- [ShapeInterface.java](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/topic3-2/src/base/ShapeInterface.java)
- [ShapeBase.java](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/topic3-2/src/base/ShapeBase.java)
- [Rectangle.java](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/topic3-2/src/base/Rectangle.java)
- [Triangle.java](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/topic3-2/src/base/Triangle.java)
- [Circle.java](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/topic3-2/src/base/Circle.java)
- [Hexagon.java](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/topic3-2/src/base/Hexagon.java)
