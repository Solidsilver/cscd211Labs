/* 
 * These methods were created by Luke Mattfeld
 * for CSCD211 at EWU
 */

package cscd211Methods;

import java.io.PrintStream;
import java.util.Scanner;

import cscd211Classes.Author;
import cscd211Classes.Book;
import cscd211Classes.Publisher;
import cscd211Enums.Genre;
import cscd211Utils.SortUtil;

public class CSCD211Lab3Methods {
	
	//Adds a new book to an array of books
	public static Book[] addBook(final Book[] array, final Book book) {
		if (book == null || array == null) {
			throw new IllegalArgumentException("Book array or book cannot be null");
		}
		
		Book[] temp = new Book[array.length + 1];
		for (int bix = 0; bix < array.length; bix++) {
			temp[bix] = array[bix];
		}
		temp[temp.length - 1] = book;
		SortUtil.selectionSort(temp);
		return temp;
	}
	
	//Create a new Book object from user input
	public static Book createBook(final Scanner kb) {
		if (kb == null) {
			throw new IllegalArgumentException("Scanner cannot be null");
		}
		
		int pages;
		String title, isbn, type, pubName, pubCity, auths;
		String[] name, authArr;
		Author[] authors;
		System.out.print("Title: ");
		title = kb.nextLine();
		System.out.print("ISBN: ");
		isbn = kb.nextLine();
		System.out.print("# of Pages: ");
		pages = Integer.parseInt(kb.nextLine());
		System.out.print("Genre: ");
		type = kb.nextLine();
		System.out.print("Publisher Name: ");
		pubName = kb.nextLine();
		System.out.print("Publisher City: ");
		pubCity = kb.nextLine();
		System.out.print("Author(s) (for more than one: author1, author2, etc.): ");
		auths = kb.nextLine();
		authArr = auths.split(", ");
		authors = new Author[authArr.length];
		for (int aix = 0; aix < authArr.length; aix++) {
			name = authArr[aix].split(" ", 2);
			authors[aix] = new Author(name[0], name[1]);
		}
		return new Book(title, isbn, pages, type, pubName, pubCity, authors);
	}
	
	//Create an array of books from a file
	public static Book[] fillArray(final Scanner fin) {
		if (fin == null) {
			throw new IllegalArgumentException("Scanner cannot be null");
		}
		
		int pages;
		String title, isbn;
		Genre type;
		Publisher pub;
		String[] authors;
		Book[] bkfill = new Book[fin.nextInt()];
		fin.nextLine();
		for (int bix = 0; bix < bkfill.length; bix++) {
			title = fin.nextLine();
			isbn = fin.nextLine();
			pages = Integer.parseInt(fin.nextLine());
			type = getGenre(fin.nextLine());
			pub = new Publisher(fin.nextLine(), fin.nextLine());
			authors = new String[Integer.parseInt(fin.nextLine())];
			for (int aix = 0; aix < authors.length; aix++) {
				authors[aix] = fin.nextLine();
			}
			bkfill[bix] = new Book(title, isbn, pages, type, pub, authors);
		}
		
		return bkfill;
	}
	
	//Gets a valid Genre enum from a string.
	public static Genre getGenre(final String g) {
		if (g == null || g.equals("")) {
			throw new IllegalArgumentException("String cannot be null or empty");
		}
		
		Genre temp;
		try {
			temp = Genre.valueOf(g.toUpperCase());	
		} catch (IllegalArgumentException e) {		
			temp = Genre.FICTION;
		}	
		return temp;
	}
	
	//Prints a menu, will only return with a valid menu option
	public static int menu(final Scanner kb) {
		if (kb == null) {
			throw new IllegalArgumentException("Scanner cannot be null");
		}
		
		int choice = 0;
		do {
			System.out.print("\n1. Print the books to the screen\n" + 
					"2. Print the books to a file\n" + 
					"3. Sort the book using compareTo\n" + 
					"4. Sort the books by first author as a Comparator\n" + 
					"5. Add a book\n" + 
					"6. Quit\n~~> ");
			choice = kb.nextInt();
			kb.nextLine();
			if (choice < 1 || choice > 6) {
				System.out.println("You must enter a valid menu number");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.print("couldn't wait...");
				}
			}
		} while (choice < 1 || choice > 6);
		return choice;
	}
	
	//Print an array of books
	public static void printBooks(final Book[] array, final PrintStream fout) {
		if (array == null || fout == null) {
			throw new IllegalArgumentException("Array and PrintStream cannot be null");
		}
		
		for (int bix = 0; bix < array.length; bix++) {
			fout.println(array[bix]);
		}
	}
	
	//Gets a filename string from the user
	public static String readFileName(final Scanner kb) {
		if (kb == null) {
			throw new IllegalArgumentException("Scanner cannot be null");
		}
		System.out.print("Output File Name: ");
		return kb.nextLine();
	}
}
