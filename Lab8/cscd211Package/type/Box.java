package cscd211Package.type;

public class Box extends Package implements Comparable<Package> {
	
	private int height;
	protected static final int MAX_WEIGHT = 100, MAX_LENGTH = 36, MAX_WIDTH = 36, MAX_HEIGHT = 36;
	
	public Box(final int trackNum,
				final int weight,
				final int length,
				final int width,
				final int height) {
		super(trackNum, weight, length, width);
		if (height < 1) {
			throw new IllegalArgumentException("Height must be >= 1");
		}
		this.height = height;
		if (weight > MAX_WEIGHT || length > MAX_LENGTH || width > MAX_WIDTH || height > MAX_HEIGHT) {
			setTooBig(true);
		}
	}
	
	public int getHeight() {
		return this.height;
	}
	
	@Override
	public String getType() {
		return "box";
	}
	
	@Override
	public String toString() {
		return super.toString() + ", height: " + this.height;
	}

}
