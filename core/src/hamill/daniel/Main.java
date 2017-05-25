package hamill.daniel;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;

import hamill.daniel.screens.MainScreen;

public class Main extends Game {
	public static final int WIDTH = 320;
	public static final int HEIGHT = 240;
	
	public OrthographicCamera camera;
	public Viewport viewport;
	public Batch batch;
	public MainScreen screen;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 320, 240);
		
		screen = new MainScreen(this);
		setScreen(screen);
	}

	@Override
	public void render () {
		batch.setProjectionMatrix(camera.combined);
		super.render();
	}
	
	 public void setForegroundFPS(int value) {}
}
