package cscd211Package.type;

public class WoodCrate extends Crate implements Comparable<Package> {
	
	protected static final int MAX_WEIGHT = 200, MAX_LENGTH = 48, MAX_WIDTH = 48, MAX_HEIGHT = 48;
	
	public WoodCrate(final int trackNum, final int weight, final int length, final int width, final int height, final String contents) {
		super(trackNum, weight, length, width, height, contents);
		if (weight > MAX_WEIGHT || length > MAX_LENGTH || width > MAX_WIDTH || height > MAX_HEIGHT) {
			setTooBig(true);
		}
	}
	
	@Override
	public String getType() {
		return "wooden crate";
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
