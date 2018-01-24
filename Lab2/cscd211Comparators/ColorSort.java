/* 
 * This ColorSort comparator was created by Luke Mattfeld
 * for CSCD211 at EWU
 */


package cscd211Comparators;

import java.util.Comparator;

import cscd211Classes.Person;

public class ColorSort implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		if (p1 == null || p2 == null) {
			throw new IllegalArgumentException("Persons cannot be null");
		}
		return p1.getColor().getValue().compareTo(p2.getColor().getValue());
	}

}
