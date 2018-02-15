package cscd211Package.type;

public class MetalCrate extends Crate implements Comparable<Package> {
	
	protected static final int MAX_WEIGHT = 500, MAX_LENGTH = 60, MAX_WIDTH = 60, MAX_HEIGHT = 60;
	
	public MetalCrate(final int trackNum, final int weight, final int length, final int width, final int height, final String contents) {
		super(trackNum, weight, length, width, height, contents);
		if (weight > MAX_WEIGHT || length > MAX_LENGTH || width > MAX_WIDTH || height > MAX_HEIGHT) {
			setTooBig(true);
		}
	}
	
	@Override
	public String getType() {
		return "metal crate";
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
