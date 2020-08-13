package bombers.model;

public enum Direction {
	UP(0,-1), RIGHT(1,0), LEFT(-1,0), DOWN(0,1), REST(0,0);
	
	private int x;
	private int y;
	
	Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}