/* 
 * This Author class was created by Luke Mattfeld
 * for CSCD211 at EWU
 */

package cscd211Classes;

public class Author implements Comparable<Author> {
	
	private String first;
	private String last;
	
	public Author(final String first, final String last) {
		if (first == null || last == null) {
			throw new IllegalArgumentException("Input strings cannot be null");
		} 
		if (first.equals("") || last.equals("")) {
			throw new IllegalArgumentException("Input strings cannot be empty");
		}
		this.first = first;
		this.last = last;
	}
	
	//Getters
	public String getFirstName() {
		return this.first;
	}
	
	public String getLastName() {
		return this.last;
	}
	
	public String toString() {
		return this.getLastName() + " " + this.getFirstName();
		//Format: Lastname Firstname
	}

	@Override
	public int compareTo(final Author pi) {
		if (pi == null) {
			throw new IllegalArgumentException("Author cannot be null");
		}
		//Compare by Last name, then First name
		int cmp = this.getLastName().compareTo(pi.getLastName());
		if (cmp == 0) {
			cmp = this.getFirstName().compareTo(pi.getFirstName());
		}
		return cmp;
	}

}
