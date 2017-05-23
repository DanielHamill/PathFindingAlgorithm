package hamill.daniel.entity;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import hamill.daniel.utils.Chromosome;
import hamill.daniel.utils.GeneticAlgorithm;
import hamill.daniel.utils.Vec2;

public class Entity implements Runnable{
	
	Chromosome ch;
	Thread thread;
	Texture img;
	public ArrayList<Vec2> path;
	public int index;
	public Vec2 current;
	public Vec2 start;

	public Entity(float x, float y, Chromosome ch, String bitString) {
		path = new ArrayList<Vec2>();
		interpret(bitString);
		this.ch = ch;
		thread = new Thread(this);
		img = new Texture("gfx/game/entity.png");
		
		index = 0;
		
		current = new Vec2(x, y, 0);
		start = new Vec2(x, y, 0);
	}
	
	public void tick() {
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
	
	public void draw(Batch batch) {
		batch.draw(img, current.x, current.y);
	}
	
	public void changeTarget() {
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

	@Override
	public void run() {
		tick();
	}
	
}
