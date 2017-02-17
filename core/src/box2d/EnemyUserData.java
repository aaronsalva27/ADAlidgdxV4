package box2d;

import com.badlogic.gdx.math.Vector2;
import enums.UserDataType;
import utils.Constants;
import utils.LecturaFichero;

import java.io.IOException;
import java.util.LinkedList;

import static utils.LecturaFichero.arrayCadena;

public class EnemyUserData extends UserData {

    private Vector2 linearVelocity;
    private LinkedList<String> textureRegions;

    public EnemyUserData(float width, float height, LinkedList<String> textureRegions) throws IOException {
        super(width, height);
        userDataType = UserDataType.ENEMY;
        linearVelocity = new Vector2(LecturaFichero.recuperarValor1(),LecturaFichero.recuperarValor2());
        this.textureRegions = textureRegions;
    }

    public void setLinearVelocity(Vector2 linearVelocity) {
        this.linearVelocity = linearVelocity;
    }

    public Vector2 getLinearVelocity() {
        return linearVelocity;
    }

    public LinkedList<String> getTextureRegions() {
        return textureRegions;
    }

}