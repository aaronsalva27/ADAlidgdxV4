package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Aarón on 16/02/2017.
 */
public class LecturaFichero {
    public  String cadena;
    public  String cadena2;
    public  static String[] arrayCadena;

    public LecturaFichero (){

    }

    public  void read() throws IOException {
        FileReader f = new FileReader("Constants.txt");
        BufferedReader b = new BufferedReader(f);
          while((cadena = b.readLine())!=null) {
            cadena2 = cadena;
        }
        transformararray();
          b.close();



    }

    public  void transformararray (){
        System.out.println(cadena2);
        arrayCadena = cadena2.split(",");
        System.out.println(Float.parseFloat(arrayCadena[0]));
        System.out.println(Float.parseFloat(arrayCadena[1]));
    }

}
