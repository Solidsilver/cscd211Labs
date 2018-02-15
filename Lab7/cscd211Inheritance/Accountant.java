package cscd211Inheritance;

public class Accountant extends Employee implements Comparable<Employee> {
	
	private double parkingStipend;
	
	public Accountant(java.lang.String name,
            double basePayrate,
            double additionalPayrate,
            double parkingStipend) {
		super(name, basePayrate, additionalPayrate);
		if (parkingStipend < 1.00) {
			throw new IllegalArgumentException("parking stipend must be > 1");
		}
		this.parkingStipend = parkingStipend;
	}
	
	public double getParkingStipend() {
		return this.parkingStipend;
	}
	
	public void setParkingStipend(double parkingStipend) {
		if (parkingStipend < 1.00) {
			throw new IllegalArgumentException("parking stipend must be > 1");
		}
		this.parkingStipend = parkingStipend;
	}

	@Override
	public void report() {
		System.out.println("I am an accountant. I make " + this.salary + " plus a parking stipend of " + this.parkingStipend);
	}
	
	@Override
	public String toString() {
		return "Accountant: " + super.toString();
	}

}
