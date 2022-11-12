## Activity 3
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
#### *Code*
- [Person.java](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/topic3-1/src/app/Person.java)<br>
- [PersonInterface.java](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/topic3-1/src/app/PersonInterface.java)<br>
- [Test.java](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/topic3-1/src/app/Test.java)<br>

---
### Part 2
---
#### Screenshots
![Screenshot 3](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/03-Screenshot.png)<br>
![Screenshot 4](https://github.com/JasonHatfield/GCU/blob/CST-239/Week-3/Activity-3/04-Screenshot.png)<br>
---
#### Theory

---
#### Code
