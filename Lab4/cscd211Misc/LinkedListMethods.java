/*
 * This LinkedListMethods class was created by Luke Mattfeld
 * for CSCD211 at EWU
 */

package cscd211Misc;

import java.util.Scanner;

public class LinkedListMethods {
	
	public static int menu(final Scanner kb) {
		if (kb == null) {
			throw new NullPointerException("Scanner cannot be null");
		}
		int itm = 0;
		do {
			System.out.print("1) Print the List \n" + 
					"2) Create a BoxCar and addFirst \n" + 
					"3) Create a BoxCar and addLast \n" + 
					"4) Create a BoxCar, read and index and add -- at the index \n" + 
					"5) Create a BoxCar, check the list to see if the list contains the BoxCar \n" + 
					"6) Create a BoxCar, find the indexOf that BoxCar \n" + 
					"7) removeFirst \n" + 
					"8) removeLast \n" + 
					"9) Read index remove Node at that index \n" + 
					"10) Create a BoxCar and removeFirstOccurrence of that BoxCar \n" + 
					"11) Create a BoxCar and removeLastOccurrence of that BoxCar \n" + 
					"12) clear the list \n" + 
					"13) Print the size of the list\n> ");
			itm = Integer.parseInt(kb.nextLine());
			if (itm < 1 || itm > 13) {
				System.out.println("You must enter a valid menu number");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.print("couldn't wait...");
				}
			}
		} while (itm < 0 && itm > 14);
		return itm;
		
	}
	
	public static BoxCar createBoxCar(final Scanner kb) {
		if (kb == null) {
			throw new NullPointerException("Scanner cannot be null");
		}
		System.out.print("Enter a Boxcar: ");
		return new BoxCar(kb.nextLine());
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
