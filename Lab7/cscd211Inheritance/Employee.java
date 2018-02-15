package cscd211Inheritance;

public abstract class Employee implements Comparable<Employee> {
	
	private double BASE;
	private String name;
	protected double salary;
	
	public Employee(String name, double basePayrate, double additionalPayrate) {
		if(name == null) {
			throw new NullPointerException("name cannot be null");
		}
		if (name.isEmpty() || basePayrate < 0.0 || additionalPayrate < 0.0) {
			throw new IllegalArgumentException("Invalid data");
		}
		this.name = name;
		this.BASE = basePayrate;
		this.setSalary(additionalPayrate);
	}
	
	public double getSalary() {
		return this.salary;
	}
	
	public double getBaseSalary() {
		return this.BASE;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.getClass().getSimpleName();
	}
	
	public void setSalary(double additionalPayrate) {
		if (additionalPayrate < 0) {
			throw new IllegalArgumentException("additional rate must be >= 0");
		}
		this.salary = this.BASE + additionalPayrate;
	}
	
	public void setName(String name) {
		if(name == null) {
			throw new NullPointerException("Name cannot be null");
		}
		this.name = name;
	}
	
	public abstract void report();
	

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public int compareTo(Employee pi) {
		if (pi == null) {
			throw new IllegalArgumentException("employee cannot be null");
		}
		int comp = this.getType().compareTo(pi.getType());
		if (comp == 0) {
			Double thisD = this.getSalary();
			Double thatD = pi.getSalary();
			comp = thisD.compareTo(thatD);
		}
		return comp;
	}

}
