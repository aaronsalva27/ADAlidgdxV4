package screens;

/**
 * Created by Aarón on 15/02/2017.
 */
public class ScreenGenerica<T> {
    private T pantalla;

    public ScreenGenerica(T o) {
        pantalla = o;
    }

    public void classType() {
        System.out.println("El tipo de T es " + pantalla.getClass().getName());
    }

    public T getT(){
        return pantalla;
    }

}
