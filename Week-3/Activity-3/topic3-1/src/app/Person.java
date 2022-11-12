package app;

/**
 * 
 * @author Jason Hatfield This is my original work.
 */
public class Person implements PersonInterface, Comparable<Person> {
	private String firstName;
	private String lastName;
	private boolean running;

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person(Person person) {
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
	}

	/** @return the firstName */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/** @return the lastName */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object other) {
		if(other == this) {
			System.out.println("I am here in other == this");
			return true;
		}
		if(other == null) {
			System.out.println("I am here in other == null");
			return false;
		}
		if(getClass() != other.getClass()) {
			System.out.println("I am here in getClass() != other.getClass()");
			return false;
		}
		Person person = (Person)other;
		return (this.firstName == person.firstName && this.lastName == person.lastName);
	}
	
	@Override
	public String toString() {
		return /*"Test My class is " + getClass() + " " + */this.firstName + " " + this.lastName;
	}

	@Override
	public void walk() {
		System.out.println("I am walking");
		running = false;
	}

	@Override
	public void run() {
		System.out.println("I am running");
		running = true;
	}

	@Override
	public boolean isRunning() {
		return running;
	}

	@Override
	public int compareTo(Person p) {
		int value = this.lastName.compareTo(p.lastName);
		
		if (value == 0) {
			return this.firstName.compareTo(p.firstName);
		}
		return value;
	}
}
