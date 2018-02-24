package cscd211Classes.players;

public class HockeyPlayer extends Player implements Cloneable {
	
	protected int jerseyNumber;

	public HockeyPlayer(final String name, final String ssn, final int salary, final String position, final int jerseyNumber) {
		super(name, ssn, salary, position);
		if (jerseyNumber < 0) {
			throw new IllegalArgumentException("Jersey Num cannot be negative");
		}
		this.jerseyNumber = jerseyNumber;
	}
	
	@Override
	public HockeyPlayer clone() throws CloneNotSupportedException {
		return (HockeyPlayer)super.clone();
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t" + this.jerseyNumber;
	}
}
