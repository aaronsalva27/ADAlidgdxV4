package box2d;

import com.badlogic.gdx.math.Vector2;
import enums.UserDataType;
import utils.LecturaFichero;
import java.io.IOException;
import java.util.LinkedList;


public class EnemyUserData extends UserData {

    private Vector2 linearVelocity;
    private LinkedList<String> textureRegions;

    public EnemyUserData(float width, float height, LinkedList<String> textureRegions) throws IOException {
        super(width, height);
        userDataType = UserDataType.ENEMY;
        linearVelocity = new Vector2(LecturaFichero.recuperarValor1(),LecturaFichero.recuperarValor2());
        this.textureRegions = textureRegions;
    }

    public Vector2 getLinearVelocity() {
        return linearVelocity;
    }

    public LinkedList<String> getTextureRegions() {
        return textureRegions;
    }

}