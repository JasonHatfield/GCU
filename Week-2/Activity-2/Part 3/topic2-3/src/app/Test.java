package app;

/**
 * @author Jason Hatfield
 * This is my original work.
 */
public class Test {
	public static void main(String[] args) {
		Person person1 = new Person("Jason", "Hatfield");
		Person person2 = new Person("Jason", "Hatfield");
		Person person3 = new Person(person1);

		if (person1 == person2) {
			System.out.println("These persons are identical using ==");
		} else {
			System.out.println("These persons are not identical using ==");
		}

		if (person1.equals(person2)) {
			System.out.println("These persons are identical using equals()");
		} else {
			System.out.println("These persons are not identical using equals()");
		}

		if (person1.equals(person3)) {
			System.out.println("These copied person is identical to using equals()");
		} else {
			System.out.println("These copied person is not identical using equals()");
		}

		System.out.println(person1);
		System.out.println(person2.toString());
		System.out.println(person3);

	}
}
