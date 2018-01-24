/* 
 * This WattsSort comparator class was created by Luke Mattfeld 
 * for CSCD211 at Eastern Washington University.
 */

package cscd211Comparators;

import java.util.Comparator;
import cscd211Classes.Motor;

public class WattsSort implements Comparator<Motor> {
	
	public WattsSort() {
		
	}
	
	public int compare(final Motor m1, final Motor m2) {
		if (m1 == null || m2 == null) {
			throw new NullPointerException("Motors cannot be null");
		}
		Double oneW = m1.getWatts();
		Double twoW = m2.getWatts();
		return oneW.compareTo(twoW);
	}

}
