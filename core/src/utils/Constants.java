package utils;

import com.badlogic.gdx.math.Vector2;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static utils.LecturaFichero.arrayCadena;


public class Constants {

    public static final String BACKGROUND_IMAGE_PATH = "background.png";
    public static final String GROUND_IMAGE_PATH = "ground.png";

    public static final int APP_WIDTH = 800;
    public static final int APP_HEIGHT = 480;
    public static final float WORLD_TO_SCREEN = 32;

    public static final Vector2 WORLD_GRAVITY = new Vector2(0, -11);


    public static final float GROUND_X = 0;
    public static final float GROUND_Y = 0;
    public static final float GROUND_WIDTH = 25f;
    public static final float GROUND_HEIGHT = 2f;
    public static final float GROUND_DENSITY = 0f;

    public static final float RUNNER_X = 2;
    public static final float RUNNER_Y = GROUND_Y + GROUND_HEIGHT;
    public static final float RUNNER_WIDTH = 1f;
    public static final float RUNNER_HEIGHT = 2f;
    public static float RUNNER_DENSITY = 0.5f;

    public static final float RUNNER_GRAVITY_SCALE = 4f;
    public static final float RUNNER_DODGE_X = 2f;
    public static final float RUNNER_DODGE_Y = 1.5f;

    public static final float ENEMY_X = 25f;
    public static final float ENEMY_DENSITY = RUNNER_DENSITY;
    public static final float RUNNING_SHORT_ENEMY_Y = 1.5f;
    public static final float RUNNING_LONG_ENEMY_Y = 2f;

    public static final float FLYING_ENEMY_Y = 3.2f;
    //public static Vector2 ENEMY_LINEAR_VELOCITY = new Vector2(Integer.parseInt(arrayCadena[0]), Integer.parseInt(arrayCadena[1]));

    public static final Vector2 RUNNER_JUMPING_LINEAR_IMPULSE = new Vector2(0, 16f);
    public static final float RUNNER_HIT_ANGULAR_IMPULSE = 13f;


    public static final String CHARACTERS_ATLAS_PATH = "runner.txt";
    public static final List<String> RUNNER_RUNNING_REGION_NAMES =new ArrayList<String>(Arrays.asList("1", "2","3", "4","5", "6","7", "8"));
    public static final String RUNNER_DODGING_REGION_NAME = "Dodge";
    public static final String RUNNER_HIT_REGION_NAME = "Hit";
    public static final String RUNNER_JUMPING_REGION_NAME = "8jump";

    public static final LinkedList<String> RUNNING_SMALL_ENEMY_REGION_NAMES = new LinkedList<String>(Arrays.asList("cono", "cono"));
    public static final LinkedList<String> RUNNING_LONG_ENEMY_REGION_NAMES = new LinkedList<String>(Arrays.asList("minotaur1", "minotaur2","minotaur3", "minotaur4","minotaur5", "minotaur6","minotaur7", "minotaur8", "minotaur9"));
    public static final LinkedList<String> RUNNING_BIG_ENEMY_REGION_NAMES = new LinkedList<String>(Arrays.asList("minotaur1", "minotaur2","minotaur3", "minotaur4","minotaur5", "minotaur6","minotaur7", "minotaur8", "minotaur9"));
    public static final LinkedList<String> RUNNING_WIDE_ENEMY_REGION_NAMES = new LinkedList<String>(Arrays.asList("cono2", "cono2"));
    public static final LinkedList<String> FLYING_SMALL_ENEMY_REGION_NAMES = new LinkedList<String>(Arrays.asList("rap1","rap2","rap3"));
    public static final LinkedList<String> FLYING_WIDE_ENEMY_REGION_NAMES = new LinkedList<String>(Arrays.asList("1FlyEnemy", "2FlyEnemy"));


}
