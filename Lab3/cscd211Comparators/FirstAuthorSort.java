/* 
 * This Author comparator was created by Luke Mattfeld
 * for CSCD211 at EWU
 */

package cscd211Comparators;

import java.util.Comparator;

import cscd211Classes.Book;

public class FirstAuthorSort implements Comparator<Book> {
	
	@Override
	public int compare(final Book b1, final Book b2) {
		if (b1 == null || b2 == null) {
			throw new IllegalArgumentException("Book objects cannot be null");
		}
		return b1.getFirstAuthor().compareTo(b2.getFirstAuthor());
	}

}
