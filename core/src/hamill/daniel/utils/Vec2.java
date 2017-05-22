package hamill.daniel.utils;

public class Vec2 {
	
	public float x, y, distance;

	public Vec2(float x, float y, float distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	
	public void add(Vec2 vector) {
		this.x += vector.x;
		this.y += vector.y;
	}
	
	public float distanceFrom(Vec2 vector) {
		return (float)Math.sqrt((x-vector.x)*(x-vector.x) + (y-vector.y)*(y-vector.y));
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
}
