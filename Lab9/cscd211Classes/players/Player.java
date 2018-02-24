package cscd211Classes.players;

public abstract class Player implements Cloneable {
	
	protected String name, position, ssn;
	protected int salary;
	
	protected Player(final String name, final String ssn, final int salary, final String position) {
		if (name.isEmpty() || name == null || ssn.isEmpty() || ssn == null || position.isEmpty() || position == null) {
			throw new IllegalArgumentException("Bad String(s)");
		}
		this.name = name;
		this.ssn = ssn;
		this.position = position;
		this.salary = salary;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPosition() {
		return this.position;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public String getSSN() {
		return this.ssn;
	}
	
	@Override
	public Player clone() throws CloneNotSupportedException {
		return (Player)super.clone();
	}
	
	@Override
	public String toString() {
		return this.name + "\t" + this.ssn + "\t" + this.salary + "\t\t" + this.position;
	}
	
	
	
}
