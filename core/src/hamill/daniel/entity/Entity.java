package hamill.daniel.entity;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import hamill.daniel.utils.Vec2;

public class Entity {
	
	Texture img;
	
//	public float xPos, yPos;
	public ArrayList<Vec2> path;
	public int index;
	public Vec2 current;
	public Vec2 start;

	public Entity(float x, float y) {
		img = new Texture("gfx/game/entity.png");
		
		path = new ArrayList<Vec2>();
		index = 0;
		
		current = new Vec2(x, y, 0);
		start = new Vec2(x, y, 0);
	}
	
	public void tick(float delta) {
		if(current.distanceFrom(start) >= path.get(index).distance) {
			if(index<path.size()-1) {
				System.out.println("Changing");
				changeTarget();
			}
		}
		else {
			add(path.get(index));
		}
	}
	
	public void draw(Batch batch) {
		batch.draw(img, current.x, current.y);
	}
	
	public void changeTarget() {
		index++;
		start.x = current.x;
		start.y = current.y;
	}
	
	public void add(Vec2 vector) {
		current.x += vector.x * Gdx.graphics.getDeltaTime();
		current.y += vector.y * Gdx.graphics.getDeltaTime();
	}
	
	public void addVec(Vec2 vector) {
		path.add(vector);
	}
	
}
