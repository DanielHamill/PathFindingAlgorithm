package hamill.daniel.utils;

public class Vec2 {
	
	public float x, y, distance;

	public Vec2(float x, float y, float distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	
	public Vec2(String parse) {
		this.x = Integer.parseUnsignedInt(parse.substring(1,5),2);
		if(parse.charAt(0)=='0') this.x *= -1;
		this.y = Integer.parseUnsignedInt(parse.substring(6,10),2);
		if(parse.charAt(5)=='0') this.y *= -1;
		this.distance = Integer.parseInt(parse.substring(10,parse.length()),2);
	}
	
	public void add(Vec2 vector) {
		this.x += vector.x;
		this.y += vector.y;
	}
	
	public float distanceFrom(Vec2 vector) {
		return (float)Math.sqrt((x-vector.x)*(x-vector.x) + (y-vector.y)*(y-vector.y));
	}
	
	public void setCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		String signX = x<0?"0":"1";
		String signY = y<0?"0":"1";
		String binX = String.format("%04d", Integer.parseInt(Integer.toBinaryString(Math.abs((int)x))));
		String binY = String.format("%04d", Integer.parseInt(Integer.toBinaryString(Math.abs((int)y))));
		String dis = String.format("%08d", Integer.parseInt(Integer.toBinaryString((int)distance)));
		return signX+binX+signY+binY+dis;
	}
	
}
