
public class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	int getX() {
		int x = this.x;
		return x;
	}
	int getY() {
		int y = this.y;
		return y;
	}
	String getPoint() {
		String point = "(" + this.x + "," + this.y + ")";
		return point;
	}
	static int randomX(int j) {
		int x = (int)(Math.random() * j);
		return x;
	}
	static int randomY(int j) {
		int y = (int)(Math.random() * j);
		return y;
	}
	static Point randomPoint(int j) {
		int x = randomX(j);
		int y = randomY(j);
		Point random = new Point(x,y);
		return random;
	}
}
