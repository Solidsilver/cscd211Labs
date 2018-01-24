/* 
 * This Motor object class was created by Luke Mattfeld 
 * for CSCD211 at Eastern Washington University.
 */

package cscd211Classes;

public class Motor implements Comparable<Motor> {

	private String manufacturer;
	private double watts;
	
	public Motor(String manufacturer, double watts) {
		if (manufacturer == null) {
			throw new NullPointerException("Manufacturer cannot be null");
		}
		if (manufacturer.length() < 1) {
			throw new IllegalArgumentException("Manufacturer is empty");
		}
		if (watts <= 0) {
			throw new IllegalArgumentException("The value of watts must be greater than or equal to 0");
		}
		this.manufacturer = manufacturer;
		this.watts = watts;
	}
	
	public Motor(double watts, String manufacturer) {
		this(manufacturer, watts);
	}
	
	
	//Getters
	public String getManufacturer() {
		return this.manufacturer;
	}
	
	public double getWatts() {
		return this.watts;
	}
	
	
	@Override
	public String toString() {
		return this.manufacturer + " - " + Math.round(this.watts * 100)/100.0;
	}
	
	@Override
	public int compareTo(Motor pi) {
		if (pi == null) {
			throw new NullPointerException("Motor cannot be null");
		}
		int compManFact = this.manufacturer.compareTo(pi.manufacturer);
		if (compManFact == 0) {	//In case the manufacturer is the same, it will then compare by wattage
			Double thisW = this.watts;
			Double thatW = pi.watts;
			return thisW.compareTo(thatW);
		} else {
			return compManFact;
		}
	}

}
