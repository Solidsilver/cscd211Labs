package cscd211Classes.players;

public class BaseballPlayer extends Player implements Cloneable {
	
	protected double batAve;

	public BaseballPlayer(final String name, final String ssn, final int salary, final String position, final double batAve) {
		super(name, ssn, salary, position);
		if (batAve < 0) {
			throw new IllegalArgumentException("batAve cannot be negative");
		}
		this.batAve = batAve;
	}
	
	@Override
	public Player clone() throws CloneNotSupportedException {
		return (BaseballPlayer)super.clone();
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t" + this.batAve;
	}

}
