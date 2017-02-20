package stages;

/**
 * Created by Aarón on 12/02/2017.
 */


import com.badlogic.gdx.scenes.scene2d.Stage;
import samuel.Samuel;
import utils.Constants;


public class EndStage extends Stage {
    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;
    private Samuel game;

    public EndStage(Samuel game){
        this.game = game;
    }




}
