package cscd211Package.type;

public class Letter extends Package implements Comparable<Package> {
	
	protected static final int MAX_LENGTH = 18, MAX_WEIGHT = 24, MAX_WIDTH = 18;
	
	public Letter(final int trackNum, final int weight, final int length, final int width) {
		super(trackNum, weight, length, width);
		if (weight > MAX_WEIGHT || length > MAX_LENGTH || width > MAX_WIDTH) {
			setTooBig(true);
		}
	}

	@Override
	public String getType() {
		return "letter";
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
