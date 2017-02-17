package samuel.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import fx.StartUpTest;
import samuel.Samuel;
import utils.Constants;
import utils.LecturaFichero;

import java.io.IOException;

public class DesktopLauncher {
	public static void main (String[] arg) {

		LecturaFichero lectura = new LecturaFichero();

		new Thread() {
			@Override
			public void run() {
				javafx.application.Application.launch(StartUpTest.class);
			}
		}.start();

		try {
			lectura.read();
		} catch (IOException e) {
			e.printStackTrace();
		}


		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Constants.APP_WIDTH;
		config.height = Constants.APP_HEIGHT;
		new LwjglApplication(new Samuel(), config);
	}
}