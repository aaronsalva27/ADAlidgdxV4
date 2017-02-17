package samuel;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import screens.EndScreen;
import screens.GameScreen;
import screens.ScreenGenerica;
import utils.LecturaFichero;

import java.io.IOException;


public class Samuel extends Game {
    public GameScreen gameScreen;
    public EndScreen endScreen;
    private AssetManager manager;

    public  AssetManager getManager() {
        return  manager;
    }

    @Override
    public void create() {
        manager = new AssetManager();
        manager.load("gameover.png",Texture.class);
        manager.finishLoading();

        try {
            gameScreen = new GameScreen(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        endScreen = new EndScreen(this);


        ScreenGenerica<GameScreen> gameScreenG = new ScreenGenerica<GameScreen>(gameScreen);
        gameScreenG.classType();

        ScreenGenerica<EndScreen> endScreenG = new ScreenGenerica<EndScreen>(endScreen);
        endScreenG.classType();


        setScreen(gameScreenG.getT());


    }

}