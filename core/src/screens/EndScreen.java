package screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import samuel.Samuel;
import stages.EndStage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import static utils.Partida.*;


/**
 * Created by Aarón on 12/02/2017.
 */
public class EndScreen implements Screen {
    private EndStage stage;
    private Image gameover;


    public EndScreen(Samuel game){
        stage = new EndStage(game);
        gameover = new Image(game.getManager().get("gameover.png", Texture.class));
        gameover.setPosition(200,200);
        stage.addActor(gameover);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();

        SpriteBatch spriteBatch = new SpriteBatch();
        BitmapFont font = new BitmapFont();
        spriteBatch.begin();
            font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
            font.getData().setScale(2,2);
            font.draw(spriteBatch,"Puntos: "+pointS+" Dificultad: "+levelS,200,200);
        spriteBatch.end();
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();

    }


}
