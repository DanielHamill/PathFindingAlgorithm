
package hamill.daniel.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import hamill.daniel.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		final LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Main() {
			 public void setForegroundFPS(int value) {
				 config.foregroundFPS = value;
				 config.backgroundFPS = value;
				 config.vSyncEnabled = false;
				 config.useGL30 = false;
				 config.forceExit = false;
			 }
		}, config);
	}
}
