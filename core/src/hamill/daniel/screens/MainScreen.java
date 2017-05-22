package hamill.daniel.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

import hamill.daniel.Main;
import hamill.daniel.entity.Entity;
import hamill.daniel.utils.Vec2;

public class MainScreen implements Screen{
	
	Main main;
	
	Texture field;
	
	Entity entity;
	
	public MainScreen(Main main) {
		this.main = main;
		
		field = new Texture("gfx/game/world.png");
		entity = new Entity(100, 100);
		entity.addVec(new Vec2(50, 50, 50));
		entity.addVec(new Vec2(-50,50, 50));
		entity.addVec(new Vec2(20,-50, 100));
		entity.addVec(new Vec2(20,10, 100));
	}
	
	@Override
	public void render(float delta) {
		tick(delta);
		draw();
	}
	
	public void tick(float delta) {
		entity.tick(delta);
	}
	
	public void draw() {
		main.batch.begin();
		
		main.batch.draw(field, 0, 0);
		entity.draw(main.batch);
		
		main.batch.end();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
