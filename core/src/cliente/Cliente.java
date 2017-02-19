package cliente;

import api.Api;
import api.Data;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Aarón on 17/02/2017.
 */
public class Cliente {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 1099;
    private static Registry registre;

    public static void main(float puntos) throws Exception {
        registre = LocateRegistry.getRegistry(HOST, PORT);
        Api remoteApi = (Api) registre.lookup(Api.class.getSimpleName());
        remoteApi.generarXML(new Data(puntos)).getValor();

    }

}
