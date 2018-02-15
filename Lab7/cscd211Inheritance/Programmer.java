package cscd211Inheritance;

public class Programmer extends Employee implements Comparable<Employee> {
	
	private boolean busPass;
	
	public Programmer(java.lang.String name,
            double basePayrate,
            double additionalPayrate,
            boolean busPass) {
		super(name, basePayrate, additionalPayrate);
		this.busPass = busPass;
	}
	
	public boolean getBusPass() {
		return this.busPass;
	}
	
	public void setBusPass(boolean busPass) {
		this.busPass = busPass;
	}

	@Override
	public void report() {
		String getPass = "";
		if (!this.busPass) {
			getPass = "do not ";
		}
		System.out.println("I am a programmer. I get " + this.salary + " and I " + getPass + "get a bus pass");
	}
	
	@Override
	public String toString() {
		return "Programmer: " + super.toString();
	}

}
