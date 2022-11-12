package app;

import java.util.Arrays;

/**
 * @author Jason Hatfield
 * This is my original work.
 */
public class Test {
	public static void main(String[] args) {
		
		Person[] persons = new Person[4];
		persons[0] = new Person("Justine", "Reha");
		persons[1] = new Person("Brianna", "Reha");
		persons[2] = new Person("Mary", "Reha");
		persons[3] = new Person("Mark", "Reha");
		
		Arrays.sort(persons);
		
		for(int i = 0; i < persons.length; i++) {
			System.out.println(persons[i]);
		}
//		
//		Person person1 = new Person("Jason", "Hatfield");
//		Person person2 = new Person("Jason", "Hatfield");
//		Person person3 = new Person(person1);
//		
//		person1.walk();
//		person1.run();
//		System.out.println("Person 1 is running: " + person1.isRunning());
//		person1.walk();
//		System.out.println("Person 1 is running: " + person1.isRunning());
//
//		if (person1 == person2) {
//			System.out.println("These persons are identical using ==");
//		} else {
//			System.out.println("These persons are not identical using ==");
//		}
//
//		if (person1.equals(person2)) {
//			System.out.println("These persons are identical using equals()");
//		} else {
//			System.out.println("These persons are not identical using equals()");
//		}
//
//		if (person1.equals(person3)) {
//			System.out.println("These copied person is identical to using equals()");
//		} else {
//			System.out.println("These copied person is not identical using equals()");
//		}
//
//		System.out.println(person1);
//		System.out.println(person2.toString());
//		System.out.println(person3);
	}
}
