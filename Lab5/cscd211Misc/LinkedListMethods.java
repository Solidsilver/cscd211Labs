/*
 * This LinkedListMethods class was created by Luke Mattfeld
 * for CSCD211 at EWU
 */

package cscd211Misc;

import java.util.Scanner;

public class LinkedListMethods {
	
	public static BoxCar createBoxCar(final Scanner kb) {
		if (kb == null) {
			throw new NullPointerException("Scanner cannot be null");
		}
		System.out.print("Enter a Boxcar: ");
		return new BoxCar(kb.nextLine());
	}
	
	public static BoxCar[] fillArray(Scanner kb, int total) {
		if (kb == null) {
			throw new NullPointerException("Scanner cannot be null");
		}
		if (total < 1) {
			throw new IllegalArgumentException("Total must be greater than 0");
		}
		BoxCar[] bxs = new BoxCar[total];
		for (int indx = 0; indx < bxs.length; indx++) {
			bxs[indx] = createBoxCar(kb);
		}
		return bxs;
	}
	
	public static int menu(final Scanner kb) {
		if (kb == null) {
			throw new NullPointerException("Scanner cannot be null");
		}
		int itm = 0;
		do {
			System.out.print("1) Print the List \n" + 
					"2) Create a BoxCar and append the specified element to the end of this list. \n" + 
					"3) addAll(index, array) \n" + 
					"4) Read an index and get the data at that index \n" + 
					"5) getLast \n" + 
					"6) remove \n" + 
					"7) removeIndex \n" + 
					"8) removeLast \n" + 
					"9) toArray \n" + 
					"10) clear the list \n" + 
					"11) Print the size of the list \n> ");
			try {
				itm = Integer.parseInt(kb.nextLine());
			} catch (Exception e) {
				System.out.println("Not an integer");
			}
			if (itm < 1 || itm > 11) {
				System.out.println("You must enter a valid menu option");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.print("couldn't wait...");
				}
			}
		} while (itm < 0 && itm > 11);
		return itm;
	}
	
	public static int readIndex(final Scanner kb) {
		if (kb == null) {
			throw new NullPointerException("Scanner cannot be null");
		}
		int in = -1;
		do {
			System.out.print("Index: ");
			in = Integer.parseInt(kb.nextLine());
			if (in < 0) {
				System.out.println("Index must be greater than -1");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.print("couldn't wait...");
				}
			}
		} while (in < 0);
		
		return in;
	}

}
