package stages;

import cliente.Cliente;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import actors.Background;
import actors.Enemy;
import actors.Ground;
import actors.Runner;
import samuel.Samuel;
import screens.EndScreen;
import screens.GameScreen;
import servidor.MapPartidas;
import utils.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class GameStage extends Stage implements ContactListener,ActionListener {

    // This will be our viewport measurements while working with the debug renderer
    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    private final float TIME_STEP = 1 / 300f;
    private float accumulator = 0f;

    private OrthographicCamera camera;

    private World world;
    private Ground ground;
    private Runner runner;

    private Samuel game;


    public Partida partidaEnCurso = new Partida();

    public GameStage(Samuel game) throws IOException {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        setUpWorld();
        setupCamera();
        this.game = game;
    }

    private void setUpWorld() throws IOException {
        world = WorldUtils.createWorld();
        world.setContactListener(this);
        setUpBackground();
        setUpGround();
        setUpRunner();
        createEnemy();
    }

    private void setUpBackground() {
        addActor(new Background());
    }


    private void setUpGround() {
        ground = new Ground(WorldUtils.createGround(world));
        addActor(ground);
    }

    private void setUpRunner() {
        runner = new Runner(WorldUtils.createRunner(world));
        addActor(runner);
    }


    public Runner getRunner(){
         return runner;
    }

    private void setupCamera() {
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);

        for (Body body : bodies) {
            try {
                update(body);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        accumulator += delta;

        while (accumulator >= delta) {
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }

    }

    private void update(Body body) throws IOException {
        if (!BodyUtils.bodyInBounds(body)) {
            if (BodyUtils.bodyIsEnemy(body) && !runner.isHit()) {
                createEnemy();
            }
            world.destroyBody(body);
        }
    }

    private void createEnemy() throws IOException {
        Enemy enemy = new Enemy(WorldUtils.createEnemy(world));
        addActor(enemy);
    }


    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                runner.jump();
                //System.out.println("Entra saltar");
                return true;
            case Input.Keys.S:
                runner.dodge();
                //System.out.println("Entra esquivar");
                return true;
            case Input.Keys.B:
                try {
                    game.setScreen(new GameScreen(game));
                    Tempo.Temp =0;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //System.out.println("Entra salir");
                return true;
            default:
                //System.out.println("Entra default");
                runner.stopDodge();
                return false;
        }

    }


    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.S:
                //System.out.println("Entra stop dodge");
                runner.stopDodge();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void beginContact(Contact contact) {

        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();

        if ((BodyUtils.bodyIsRunner(a) && BodyUtils.bodyIsEnemy(b)) ||
                (BodyUtils.bodyIsEnemy(a) && BodyUtils.bodyIsRunner(b))) {
            runner.hit();


            try {
                partidaEnCurso.setPoints(Tempo.Temp);
                partidaEnCurso.setLevel(LecturaFichero.recuperarValor1());

                MapPartidas.setArraylistPartidas(partidaEnCurso);

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Cliente.main(partidaEnCurso);
            } catch (Exception e) {
                e.printStackTrace();
            }

            game.setScreen(new EndScreen(game));

        } else if ((BodyUtils.bodyIsRunner(a) && BodyUtils.bodyIsGround(b)) ||
                (BodyUtils.bodyIsGround(a) && BodyUtils.bodyIsRunner(b))) {
            runner.landed();
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {


    }
}