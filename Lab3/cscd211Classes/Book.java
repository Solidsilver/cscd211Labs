/* 
 * This Book class was created by Luke Mattfeld
 * for CSCD211 at EWU
 */

package cscd211Classes;

import cscd211Enums.Genre;
import cscd211Methods.CSCD211Lab3Methods;

public class Book implements Comparable<Book> {
	
	private Author[] authors;
	private String title, isbn;
	private int pages;
	private Publisher pub;
	private Genre type;
	
	public Book(final String title, 
				final String isbn, 
				final int pages, 
				final Genre type, 
				final Publisher pubs, 
				final String[] author) {
		
		if (title == null || isbn == null || type == null || pubs == null || author == null) {
			throw new IllegalArgumentException("References cannot be null");
		}
		if (title.equals("") || isbn.equals("")) {
			throw new IllegalArgumentException("Strings cannot be empty");
		}
		if (pages < 1) {
			throw new IllegalArgumentException("pages must be greater than 0");
		}
		
		this.title = title;
		this.isbn = isbn;
		this.type = type;
		this.pub = pubs;
		this.authors = new Author[author.length];
		String[] auName;
		for (int aix = 0; aix < authors.length; aix++) {
			auName = author[aix].split(" ", 2);
			this.authors[aix] = new Author(auName[0], auName[1]);
		}
	}
	
	
	public Book(final String title, 
				final String isbn, 
				final int pages, 
				final String type, 
				final String pubName, 
				final String pubCity, 
				final Author[] array) {
		
		if (title == null || isbn == null || type == null || pubName == null || pubCity == null || array == null) {
			throw new IllegalArgumentException("References cannot be null");
		}
		if (title.equals("") || isbn.equals("") || type.equals("") || pubName.equals("") || pubCity.equals("")) {
			throw new IllegalArgumentException("Strings cannot be empty");
		}
		if (pages == 0) {
			throw new IllegalArgumentException("pages cannot be 0");
		}
		
		this.title = title;
		this.isbn = isbn;
		this.pages = pages;
		this.type =  CSCD211Lab3Methods.getGenre(type);
		this.pub = new Publisher(pubName, pubCity);
		this.authors = new Author[array.length];
		for (int auth = 0; auth < array.length; auth++) {
			this.authors[auth] = new Author(array[auth].getFirstName(), array[auth].getLastName());
		}
	}
	
	
	public boolean equals(final Object obj) {
		Book bk = (Book) obj;
		if (this.title.equals(bk.getTitle()) && this.isbn.equals(bk.getISBN()) && this.pages == bk.getPages()) {
			return true;
		} else {
			return false;
		}
	}
	
	//Getters
	public Author getFirstAuthor() {
		return this.authors[0];
	}
	
	public String getISBN() {
		return this.getISBN();
	}
	
	public int getPages() {
		return this.pages;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public Genre getType() {
		return this.type;
	}
	
	public int hashCode() {
		return this.title.hashCode() + this.isbn.hashCode();
	}
	
	//Setters
	public void setISBN(final String isbn) {
		if (isbn.equals("") || isbn == null) {
			throw new IllegalArgumentException("isbn cannot be null or empty");
		}
		this.isbn = isbn;
	}
	
	public void setPages(final int pages) {
		if (pages == 0) {
			throw new IllegalArgumentException("pages must be greater than 0");
		}
		this.pages = pages;
	}
	
	public void setTitle(final String title) {
		if (title.equals("") || title == null) {
			throw new IllegalArgumentException("title cannot be null or empty");
		}
		this.title = title;
	}
	
	
	@Override
	public String toString() {
		return this.title + ", ISBN: " + this.isbn;
		// Format: Title, ISBN: isbnNumber
	}

	@Override
	public int compareTo(final Book passedIn) {
		if (passedIn == null) {
			throw new IllegalArgumentException("Book object cannot be null");
		}
		int cmp = this.pub.compareTo(passedIn.pub);
		if (cmp == 0) {
			cmp = this.title.compareTo(passedIn.getTitle());
		}
		if (cmp == 0) {
			cmp = this.isbn.compareTo(passedIn.getISBN());
		}
		return cmp;
	}
}
