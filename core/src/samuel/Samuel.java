package samuel;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import screens.EndScreen;
import screens.GameScreen;

public class Samuel extends Game {
    private AssetManager manager;
    public  2AssetManager getManager() { return  manager;}

    public GameScreen gameScreen;
    public EndScreen endScreen;

    @Override
    public void create() {
        manager = new AssetManager();
        manager.load("gameover.png",Texture.class);
        manager.finishLoading();

        gameScreen = new GameScreen(this);
        endScreen = new EndScreen(this);

        setScreen(gameScreen);

    }

    // Get rid of render function, let the parent class handle it

}