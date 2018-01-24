/* 
 * This Color enum was created by Luke Mattfeld
 * for CSCD211 at EWU
 */


package cscd211Enums;

public enum Color {
	RED("red"), GREEN("green"), BLUE("blue"), PURPLE("purple"), PINK("pink");
	
	private String value;
	
	private Color(final String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return this.value.substring(0, 1).toUpperCase() + this.value.substring(1);
	}


}