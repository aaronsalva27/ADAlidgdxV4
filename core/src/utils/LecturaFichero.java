package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Aarón on 16/02/2017.
 */
public class LecturaFichero {
    public static String cadena;
    public static String cadena2;
    public static String[] arrayCadena;
    public static String fichero ="medium.txt";


    public LecturaFichero (){

    }

    public static float recuperarValor1() throws IOException {
        read();
        return Float.parseFloat(arrayCadena[0]);
    }

    public static float recuperarValor2() throws IOException {
        read();
        return Float.parseFloat(arrayCadena[1]);
    }

    public static void read() throws IOException {
        FileReader f = new FileReader(fichero);
        BufferedReader b = new BufferedReader(f);
          while((cadena = b.readLine())!=null) {
            cadena2 = cadena;
        }
        transformararray();
          b.close();
    }


    public static void setFichero(String fichero) {
        LecturaFichero.fichero = fichero;
    }

    public static void transformararray (){
        System.out.println(cadena2);
        arrayCadena = cadena2.split(",");
        System.out.println(Float.parseFloat(arrayCadena[0]));
        System.out.println(Float.parseFloat(arrayCadena[1]));
    }

}
