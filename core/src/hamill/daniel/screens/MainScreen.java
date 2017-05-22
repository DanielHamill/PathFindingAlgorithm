package hamill.daniel.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

import hamill.daniel.Main;
import hamill.daniel.entity.Entity;
import hamill.daniel.utils.GeneticAlgorithm;
import hamill.daniel.utils.Vec2;

public class MainScreen implements Screen{
	
	public Main main;
	public Texture field;
	public Entity entity;
	
	public GeneticAlgorithm ga;
	
	public MainScreen(Main main) {
		this.main = main;
		
		field = new Texture("gfx/game/world.png");
		ga = new GeneticAlgorithm();
		ga.runProgram();
	}
	
	@Override
	public void render(float delta) {
		tick(delta);
		draw();
	}
	
	public void tick(float delta) {
		ga.tick(delta);
	}
	
	public void draw() {
		main.batch.begin();
		
		main.batch.draw(field, 0, 0);
		ga.draw(main.batch);
		
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
