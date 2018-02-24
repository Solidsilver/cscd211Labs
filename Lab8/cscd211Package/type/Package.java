package cscd211Package.type;

public abstract class Package implements Comparable<Package> {
	
	protected int length, width, weight, trackNum;
	private boolean tooBig;
	
	protected Package(final int trackNum, final int weight, final int length, final int width) {
		if (trackNum < 1 || weight < 1) {
			throw new IllegalArgumentException("Invalid input");
		}
		this.trackNum = trackNum;
		this.weight = weight;
		this.length = length;
		this.width = width;
	}
	
	protected void setTooBig(final boolean tooBig) {
		this.tooBig = tooBig;
	}

	public abstract String getType();
	
	public int getWeight() {
		return this.weight;
	}
	
	public int getTrackNum() {
		return this.trackNum;
	}
	
	protected boolean getTooBig() {
		return this.tooBig;
	}
	
	public boolean checkSize() {
		return this.getTooBig();
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getLength() {
		return this.length;
	}
	
	
	@Override
	public String toString() {
		return "Tracking Number: " + trackNum + ", Weight: " + weight + ", Length:" + length + ", Width:" + width;
	}

	@Override
	public int compareTo(final Package pi) {
		if (pi == null) {
			throw new NullPointerException("Package argument cannot be null");
		}
		int comp = this.getType().compareTo(pi.getType());
		if (comp == 0) {
			Integer thisW = this.weight;
			Integer thatW = pi.getWeight();
			comp = thisW.compareTo(thatW);
		}
		return comp;
	}

}
