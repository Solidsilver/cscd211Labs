package cscd211Inheritance;

public class Lawyer extends Employee implements Comparable<Employee> {
	
	private int stockOptions;
	
	public Lawyer(java.lang.String name, double basePayrate, double additionalPayrate, int stockOptions) {
		super(name, basePayrate, additionalPayrate);
		if (stockOptions < 0) {
			throw new IllegalArgumentException("stock optioins must be greater than 0");
		}
		this.stockOptions = stockOptions;
	}
	
	public int getStockOptions() {
		return this.stockOptions;
	}
	
	public void setStockOptions(int stockOptions) {
		this.stockOptions = stockOptions;
	}
	
	@Override
	public void report() {
		System.out.println("I am an lawyer. I get " + this.salary + " and I have " + this.stockOptions + " shares of stock");
	}
	
	@Override
	public String toString() {
		return "Lawyer: " + super.toString();
	}

}
