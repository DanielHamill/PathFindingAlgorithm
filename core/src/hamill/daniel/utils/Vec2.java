package hamill.daniel.utils;

public class Vec2 {
	
	public float x, y, distance;

	public Vec2(float x, float y, float distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	
	public Vec2(String parse) {
		this.x = Integer.parseUnsignedInt(parse.substring(0,4),2);
		this.y = Integer.parseUnsignedInt(parse.substring(4,8),2);
		this.distance = Integer.parseInt(parse.substring(8,16),2);
	}
	
	public void add(Vec2 vector) {
		this.x += vector.x;
		this.y += vector.y;
	}
	
	public float distanceFrom(Vec2 vector) {
		return (float)Math.sqrt((x-vector.x)*(x-vector.x) + (y-vector.y)*(y-vector.y));
	}
	
	public String toString() {
		return String.format("%04d", Integer.parseInt(Integer.toBinaryString((int) x))) + "" + String.format("%04d", Integer.parseInt(Integer.toBinaryString((int)y))) + "" + String.format("%08d", Integer.parseInt(Integer.toBinaryString((int)distance)));
	}
	
}
