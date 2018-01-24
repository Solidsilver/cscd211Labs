/* 
 * This Lab1Methods class was created by Luke Mattfeld 
 * for CSCD211 at Eastern Washington University.
 */

package cscd211Methods;

import java.io.PrintStream;
import java.util.Scanner;
import cscd211Classes.Motor;
import cscd211Utils.SortUtil;

public class CSCD211Lab1Methods {
	
	// Fill Array
	public static Motor[] fillArray(final Scanner fin, final int total) {
		if (total <= 0) {
			throw new IllegalArgumentException("Total must be greater than 0");
		}
		if (fin == null) {
			throw new NullPointerException("Scanner must not be null");
		}
		
		Motor[] mtrs = new Motor[total];
		for (int ix = 0; ix < total; ix++) {
			mtrs[ix] = new Motor(fin.nextLine(), fin.nextDouble());
			fin.nextLine();	//Remove the carriage return
		}
		//Sort array? If so, output is different from results document.
		// SortUtil.selectionSort(mtrs);
		return mtrs;
	}
	
	
	// Print Array
	public static void printArray(final Motor[] myMotors, final PrintStream fout) {
		for (int ix = 0; ix < myMotors.length; ix++) {
			fout.println(myMotors[ix]);
		}
		
	}
}
