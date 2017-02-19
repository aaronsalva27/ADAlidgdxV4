package utils;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tempo {
    public static float Temp = 0;


    public Tempo() {
    }

    public void setTemp(float temp) {
        Temp = temp;
    }

    public static float getTemp() {
        return Temp;
    }

    public String updateX( float delta){
        float x = getTemp();
        x = x + delta;
        setTemp(x);
        return String.valueOf(x);
    }

    public void temporizador(float delta){
        SpriteBatch spriteBatch = new SpriteBatch();
        BitmapFont font = new BitmapFont();
        spriteBatch.begin();
        font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        font.draw(spriteBatch, String.valueOf(updateX(delta)) , 680, 450);
        spriteBatch.end();

    }


}
