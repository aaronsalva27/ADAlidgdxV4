package screens;


        import actors.Runner;
        import com.badlogic.gdx.Gdx;
        import com.badlogic.gdx.Screen;
        import com.badlogic.gdx.graphics.GL20;
        import samuel.Samuel;
        import stages.GameStage;
        import utils.Tempo;
        import java.io.IOException;
        import static com.badlogic.gdx.Gdx.input;


public class GameScreen implements Screen {
    public Tempo temp;
    private GameStage stage;
    private Runner runner;

    public GameScreen(Samuel samuel) throws IOException {
        stage = new GameStage(samuel);
        runner = stage.getRunner();
        temp = new Tempo();
        input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        temp.temporizador(delta);
        stage.act(delta);
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

