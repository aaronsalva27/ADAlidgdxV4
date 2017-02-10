package samuel;

import com.badlogic.gdx.Game;
import screens.GameScreen;

public class Samuel extends Game {

    @Override
    public void create() {
        setScreen(new GameScreen());

    }

    // Get rid of render function, let the parent class handle it

}