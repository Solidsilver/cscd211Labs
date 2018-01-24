/* 
 * This Person class was created by Luke Mattfeld
 * for CSCD211 at EWU
 */

package cscd211Classes;

import cscd211Enums.Color;

public class Person implements Comparable<Person> {
	
	private Color color;
	private String fn, ln;
	
	//EVC
	public Person(String fn, String ln, Color color) {
		if (fn == null || ln == null || color == null) {
			throw new IllegalArgumentException("Names or color cannot be null");
		} else if (fn.equals("") || ln.equals("")) {
			throw new IllegalArgumentException("Names input cannot be empty!");
		}
		this.color = color;
		this.fn = fn;	// First Name
		this.ln = ln;	// Last Name
	}

	
	public Color getColor() {
		return this.color;
	}
	
	// Compare by last name, then first name, then color (if needed)
	public int compareTo(Person pi) {
		int comp = this.ln.compareTo(pi.ln);
		if (comp == 0) {
			comp = this.fn.compareTo(pi.fn);
			if (comp == 0) {
				comp = this.color.getValue().compareTo(pi.color.getValue());
			}
		}
		return comp;
	}

	
	@Override
	public String toString() {
		return this.fn.substring(0,1).toUpperCase() + this.fn.substring(1)
				+ " " + this.ln.substring(0,1).toUpperCase() + this.ln.substring(1) 
				+  ", " + this.color;
		// Format:	Firstname Lastname, Color
	}
}
