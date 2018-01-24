/* 
 * This Publisher class was created by Luke Mattfeld
 * for CSCD211 at EWU
 */

package cscd211Classes;

public class Publisher implements Comparable<Publisher> {
	
	private String city, name;
	
	public Publisher(final String name, final String city) {
		if (name == null || city == null) {
			throw new IllegalArgumentException("Strings cannot be null");
		}
		if (name.equals("") || city.equals("")) {
			throw new IllegalArgumentException("Strings cannot be empty");
		}
		this.name = name;
		this.city = city;
	}
	
	//Getters
	public String getPubCity() {
		return this.city;
	}
	
	public String getPubName() {
		return this.name;
	}
	
	
	@Override
	public String toString() {
		return this.name + ", " + this.city;
	}

	@Override
	public int compareTo(final Publisher pi) {
		if (pi == null) {
			throw new IllegalArgumentException("Publisher object cannot be null");
		}
		return this.name.compareTo(pi.getPubName());
	}
}
