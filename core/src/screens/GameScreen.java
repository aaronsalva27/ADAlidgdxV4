package screens;

        import com.badlogic.gdx.Gdx;
        import com.badlogic.gdx.Screen;
        import com.badlogic.gdx.graphics.GL20;
        import stages.GameStage;
        import utils.Tempo;

public class GameScreen implements Screen {

    public Tempo temp;
    private GameStage stage;

    public GameScreen() {
        stage = new GameStage();
        temp = new Tempo();
    }

    @Override
    public void render(float delta) {
        //Clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Update the stage
        stage.draw();
        temp.temporizador(delta);
        stage.act(delta);
        stage.touchDown();
    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }


}