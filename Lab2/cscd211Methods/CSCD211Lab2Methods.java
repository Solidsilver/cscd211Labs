/* 
 * This Methods class was created by Luke Mattfeld
 * for CSCD211 at EWU
 */


package cscd211Methods;

import java.util.Scanner;

import cscd211Classes.Person;
import cscd211Enums.Color;

public class CSCD211Lab2Methods {

	// Convert a string to a valid color enum type.		// TODO ask Stu: Stu says it should be private
	private static Color convertColor(String color) {		//API shows convertColor as public, but
		if (color == null || color.equals("")) {			//reference from readColor implies it should be private.
			throw new IllegalArgumentException("Color input null or empty");
		}
		Color temp;
		try {
			temp = Color.valueOf(color.toUpperCase());	// If the color is not defined in the enum,
		} catch (IllegalArgumentException e) {			//it will throw an exception.
			temp = Color.PURPLE;							// The color is then set to the default: purple
		}	
		return temp;
	}
	
	// Display all people with the specified color
	public static void displayAll(Color toFind, Person[] myPeeps) {
		if (myPeeps == null) {
			throw new IllegalArgumentException("Array input for myPeeps cannot be null");
		}
		for (int ix = 0; ix < myPeeps.length; ix++) {
			if (myPeeps[ix].getColor().equals(toFind)) {
				System.out.println(myPeeps[ix]);
			}
		}
		
	}
	
	// Fill an array of Person(s) from a given file scanner
	public static Person[] fillArray(final Scanner fin, final int total) {
		if (fin == null) {
			throw new IllegalArgumentException("Scanner cannot be null");
		}
		if (total <= 0) {
			throw new IllegalArgumentException("Total must be greater than 0");
		}
		Scanner lin;
		Person[] fillPeeps = new Person[total];
		
		for (int ix = 0; ix < total; ix++) {
			lin = new Scanner(fin.nextLine());
			lin.useDelimiter(",");
			fillPeeps[ix] = new Person(lin.next().trim(), lin.next().trim(), convertColor(lin.next().trim()));
		}
		return fillPeeps;
	}
	
	// Print out a menu, and wait for valid input
	public static int menu(Scanner kb) {
		if (kb == null) {
			throw new IllegalArgumentException("Scanner cannot be null");
		}
		int choice = 0;
		do {
			System.out.print("\n1. Print the Array to the screen\n" + 
					"2. Display all people that contain a certain color\n" + 
					"3. Sort the array by Color\n" + 
					"4. Sort the array by the 'natural order'\n" + 
					"5. Quit\n~~> ");
			choice = kb.nextInt();
			kb.nextLine();
			if (choice < 1 || choice > 5) {
				System.out.println("You must enter a valid menu number");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.print("couldn't wait...");
				}
			}
		} while (choice < 1 || choice > 5);
		
		
		return choice;
	}
	
	// Print all my peeps
	public static void printArray(Person[] myPeeps) {
		if (myPeeps == null) {
			throw new IllegalArgumentException("Array cannot be null");
		}
		for (int ix = 0; ix < myPeeps.length; ix++) {
			System.out.println(myPeeps[ix]);
		}
		
	}
	
	// Read a color from user input, and return a valid color enum type
	public static Color readColor(Scanner kb) {
		if (kb == null) {
			throw new IllegalArgumentException("Scanner cannot be null");
		}
		System.out.print("Color: ");
		return convertColor(kb.nextLine());
	}
}

