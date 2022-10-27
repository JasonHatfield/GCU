/**
 * @author Jason Hatfield
 * This is my original work.
 */

public class Person {
	private int age;
	private String name;
	private double weight;
	
	/**
	 * @param age
	 * @param name
	 * @param weight
	 */
	public Person(int age, String name, double weight) {
		super();
		this.age = age;
		this.name = name;
		this.weight = weight;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * Prints "I am in walk();
	 */
	public void walk() {
		System.out.println("I am in walk()");
	}

	/**
	 * Receives the run parameter passed by main person.run and prints
	 * "I am in run(0)" by default or replaces 0 with the passed parameter.
	 * @param distance
	 * @return
	 */
	public double run(double distance) {
		System.out.println("I am in run(" + distance + ")");
		return 0;
	}

	public static void main(String[] args) {
		Person person = new Person(25, "Bob", (double) 165.02);
		System.out.println("My name is " + person.getName());
		person.walk();
		person.run(10);
	}
	
	/**
	 * The main method creates "Bob" as a person and passes the age, name, and
	 * weight variables to the public getters. "My name is " followed by the
	 * declared person is received and then subsequently printed. Finally, the
	 * person.walk() and person.run() methods are called and each method prints
	 * to the console.
	 */
}