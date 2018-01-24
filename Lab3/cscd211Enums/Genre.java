/* 
 * This Genre enum was created by Luke Mattfeld
 * for CSCD211 at EWU
 */

package cscd211Enums;

public enum Genre implements Comparable<Genre> {
	
	FICTION(10, "fiction"), NONFICTION(20, "non-fiction"), ROMANCE(5, "romance"), SCIFI(30, "sci-fi"), EDUCATION(15, "education");
	
	private String name;
	private int value;
	
	private Genre(final int value, final String name) {
		this.value = value;
		this.name = name;
	}
	
	//Getters
	public String getName() {
		return null;
	}
	
	public int getValue() {
		return 0;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
