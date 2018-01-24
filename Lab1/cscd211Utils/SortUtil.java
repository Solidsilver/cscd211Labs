/* 
 * This SortUtil utility class was created by Luke Mattfeld 
 * for CSCD211 at Eastern Washington University.
 */

package cscd211Utils;

import cscd211Classes.Motor;

public class SortUtil {
	public static void selectionSort(final Comparable[] array) {
		for (int j = 0; j < array.length; j++) {				// j holds the place of the first scannable element
			int indSmall = j;								// indSmall holds the index of the smallest element
			for (int i = j+1; i < array.length; i++) {		// i holds the currently scanned element
				if (array[i].compareTo(array[indSmall]) < 0) {
					indSmall = i;
				}
			}
			if (indSmall != j) {
				Comparable cache = array[indSmall];		//Swap the element at j with the smallest element
		    	    array[indSmall] = array[j];
		    	    array[j] = cache;
			} 
		}
	}
}
