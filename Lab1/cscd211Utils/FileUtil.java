/* 
 * This FilUtil utility class was created by Luke Mattfeld 
 * for CSCD211 at Eastern Washington University.
 */

package cscd211Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileUtil {

	// Count Records
	public static int countRecords(final Scanner fin, final int linesPer) {
		if (fin == null) {
			throw new NullPointerException("Scanner cannot be null");
		}
		if (linesPer <= 0) {
			throw new IllegalArgumentException("linesPer must be greater than 0");
		}
		int cnt = 0;
		while (fin.hasNextLine()) {
			cnt++;
			fin.nextLine();
		}
		fin.close();
		if (cnt == 0) {
			throw new RuntimeException("The count of lines must be greater than 0");
		}
		return cnt / linesPer;
	}
	
	
	// Open Input File
	public static File openInputFile(final Scanner kb) {
		if (kb == null) {
			throw new NullPointerException("Scanner cannot be null");
		}
		File fn;
		do {
			System.out.print("Please enter the name of the input file: ");
			String fname = kb.nextLine();
			fn = new File(fname);
			if (!fn.exists()) {
				System.out.println("File does not exist. Try again.");
			}
		} while (!fn.exists());
		return fn;
		
	}
	
	
	// Open Output File
	public static File openOutputFile(final Scanner kb) throws java.io.FileNotFoundException, java.io.IOException {
		if (kb == null) {
			throw new NullPointerException("Scanner cannot be null");
		}
		File fn;
		System.out.print("Please enter the name of the output file: ");
		String fname = kb.nextLine();
		fn = new File(fname);
		
		if (fn.exists()) {
			fn.delete();
			if (fn.exists()) {
				throw new FileNotFoundException("Could not delete file");
			}
		} 
		fn.createNewFile();
		if (!fn.exists()) {
			throw new IOException("File could not be created");
		}
		return fn;
	}
}
