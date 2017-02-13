package screens;


        import actors.Runner;
        import com.badlogic.gdx.Gdx;
        import com.badlogic.gdx.Input;
        import com.badlogic.gdx.Screen;
        import com.badlogic.gdx.graphics.GL20;
        import samuel.Samuel;
        import stages.GameStage;
        import utils.Tempo;

        import static com.badlogic.gdx.Gdx.input;
        import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveBy;

public class GameScreen implements Screen {
    public Tempo temp;
    private GameStage stage;
    private Runner runner;

    public GameScreen(Samuel samuel) {
        stage = new GameStage(samuel);
        runner = stage.getRunner();
        temp = new Tempo();
        input.setInputProcessor(stage);

        /*runner.addCaptureListener(new InputListener(){
            public boolean keyDown(int keycode) {
                switch (keycode) {
                    case Input.Keys.W:
                        runner.jump();
                        System.out.println("Entra saltar");
                        return true;
                    case Input.Keys.S:
                        //runner.dodge();
                        System.out.println("Entra esquivar");
                        return true;
                    default:
                        System.out.println("Entra default");
                        return false;

                }

            }

            public boolean KeyUp(int keycode) {
                switch (keycode) {
                    case Input.Keys.S:
                        System.out.println("Entra stop dodge");
                        runner.stopDodge();
                        return true;
                    default:
                        return false;
                }
            }
        });*/
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        temp.temporizador(delta);
        stage.act(delta);

        /*if (Gdx.input.isKeyPressed(Input.Keys.W)){
            SequenceAction seq = new SequenceAction();
            System.out.println(stage.getRunner());
            System.out.println("entra");
            stage.keyDown(Input.Keys.W);
            //stage.getRunner().addAction(Actions.moveBy(0,200,5));
        }else if(Gdx.input.isKeyPressed(Input.Keys.S)){
            System.out.println(stage.getRunner());
            System.out.println("entra");
            stage.keyDown(Input.Keys.S);
        } else {
            runner.stopDodge();
        }*/

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