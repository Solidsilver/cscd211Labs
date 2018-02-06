/*
This Undergrad class was created by Luke Mattfeld
for CSCD211 at Eastern Washington University
*/

package cscd211Inheritance;

public class Undergrad extends Student {
	
	private int gradYear;
	
	public Undergrad(String name, int id, int year) {
		super(name, id);
		if (year < 2000) {
			throw new IllegalArgumentException("Year must be greater than 2000");
		}
		
		this.gradYear = year;
	}
	
	public int getGrad() {
		return this.gradYear;
	}
	
	@Override
	public String toString() {
		return "Undergrad Student -- " + super.toString() + " Grad: " + this.gradYear;
	}
	

}
