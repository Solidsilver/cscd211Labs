/*
This Student class was created by Luke Mattfeld
for CSCD211 at Eastern Washington University
*/

package cscd211Inheritance;

public class Student implements Comparable<Student> {
	
	public Student(final String name, final int id) {
		if (name == null) {
			throw new NullPointerException("String cannot be null");
		}
		if (name.isEmpty() || id < 0) {
			throw new IllegalArgumentException("Invalid Data: Strings cannot be empty and id > 0");
		}
		this.name = name;
		this.id = id;
	}
	
	protected int id;
	private String name;
	
	public int getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.getClass().getSimpleName();
	}
	
	@Override
	public String toString() {
		return "Name: " + this.name + " ID: " + this.id;
	}

	@Override
	public int compareTo(Student pi) {
		return this.name.compareTo(pi.getName());
	}

}
