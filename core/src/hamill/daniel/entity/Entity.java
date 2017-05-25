package hamill.daniel.entity;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

import hamill.daniel.screens.MainScreen;
import hamill.daniel.utils.Chromosome;
import hamill.daniel.utils.Vec2;

public class Entity implements Runnable{
	
	Chromosome ch;
	Thread thread;
	Texture img;
	MainScreen screen;
	public Double distance;
	public ArrayList<Vec2> path;
	public int index;
	public Vec2 current;
	public Vec2 start;
	public Rectangle hitBox;
	public boolean moves;

	public Entity(float x, float y, Chromosome ch, String bitString, MainScreen screen) {
		this.screen = screen;
		path = new ArrayList<Vec2>();
		interpret(bitString);
		this.ch = ch;
		thread = new Thread(this);
		img = new Texture("gfx/game/entity.png");
		
		index = 0;
		
		current = new Vec2(x, y, 0);
		start = new Vec2(x, y, 0);
		distance = 0d;
		hitBox = new Rectangle(current.x+2, current.y+2, 12, 12);
		moves = true;
	}
	
	public Entity(float x, float y, String filePath, MainScreen screen) {
		this.screen = screen;
		path = new ArrayList<Vec2>();
		thread = new Thread(this);
		img = new Texture(filePath);
		
		index = 0;
		
		current = new Vec2(x, y, 0);
		start = new Vec2(x, y, 0);
		distance = 0d;
		hitBox = new Rectangle(current.x+2, current.y+2, 12, 12);
		moves = false;
	}
	
	public void tick() {
		hitBox.setPosition(current.x, current.y);
		boolean collide = false;
		for(Entity e: screen.obstacles) {
			if(this.doesCollide(e)) {
				collide = true;
			}
		}
 		
		if(current.distanceFrom(new Vec2(50,50,0)) < 20 || collide) {
			ch.ran = true;
			ch.reachedGoal = true;
		}
		else {
			if(path.isEmpty() || current.distanceFrom(start) >= path.get(index).distance) {
				if(index<path.size()-1) {
					changeTarget();
				}
				else {
					ch.ran = true;
				}
			}
			else {
				add(path.get(index));
			}	
		}
	}
	
	public void draw(Batch batch) {
		batch.draw(img, current.x, current.y);
	}
	
	public void changeTarget() {
		distance += path.get(index).distance;
		index++;
		start.x = current.x;
		start.y = current.y;
	}
	
	public void add(Vec2 vector) {
		current.x += vector.x;
		current.y += vector.y;
//		current.add(vector);
	}
	
	public void addVec(Vec2 vector) {
		path.add(vector);
	}
	
	public void interpret(String bitString) {
		path.clear();
		for(int i = 0; i < bitString.length(); i+=18) {
			path.add(new Vec2(bitString.substring(i, i+18)));
		}
	}
	
	public boolean doesCollide(Entity e) {
		return e.hitBox.overlaps(hitBox);
	}

	@Override
	public void run() {
		tick();
	}
	
}
