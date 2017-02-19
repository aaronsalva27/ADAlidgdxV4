package api;

/**
 * Created by Aarón on 17/02/2017.
 */
import java.io.*;

public class Data implements Serializable {
    private static final long serialVersionUID = 1L;
    private float valor;

    public Data(float valor) {
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}