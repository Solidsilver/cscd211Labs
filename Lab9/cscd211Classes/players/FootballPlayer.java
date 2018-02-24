package cscd211Classes.players;

public class FootballPlayer extends Player implements Cloneable {
	
	protected int jerseyNumber, td;

	public FootballPlayer(final String name, final String ssn, final int salary, final String position, final int td, final int jerseyNumber) {
		super(name, ssn, salary, position);
		if (jerseyNumber < 0) {
			throw new IllegalArgumentException("Jersey Num and td cannot be negative");
		}
		this.td = td;
		this.jerseyNumber = jerseyNumber;
	}
	
	@Override
	public Player clone() throws CloneNotSupportedException {
		return (FootballPlayer)super.clone();
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t" + this.td + "\t" + this.jerseyNumber;
	}

}
