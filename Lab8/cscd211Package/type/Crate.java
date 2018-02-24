package cscd211Package.type;

public abstract class Crate extends Package implements Comparable<Package> {
	
	protected String contents;
	protected int height;

	protected Crate(final int trackNum, final int weight, final int length, final int width, final int height, final String contents) {
		super(trackNum, weight, length, width);
		if (contents == null) {
			throw new NullPointerException("contents cannot be null");
		}
		if (contents.isEmpty() || height < 1) {
			throw new IllegalArgumentException("Contents/height arguments invalid");
		}
		this.contents = contents;
		this.height = height;
		
	}
	
	public String getContents() {
		return this.contents;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Height: " + this.height + ", Contents: " + this.contents;
	}
	
	
}
