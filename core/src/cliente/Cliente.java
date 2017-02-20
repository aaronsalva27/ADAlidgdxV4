package cliente;

import api.Api;
import api.Data;
import utils.Partida;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Aarón on 17/02/2017.
 */
public class Cliente extends UnicastRemoteObject{
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 1099;
    private static Registry registre;

    protected Cliente() throws RemoteException {
    }


    public static void main(Partida partidaEnCurso)throws Exception  {
        registre = LocateRegistry.getRegistry(HOST, PORT);
        Api remoteApi = (Api) registre.lookup(Api.class.getSimpleName());
        remoteApi.generarXML(new Data(partidaEnCurso.getPoints()).getValor(),partidaEnCurso.getLevel());
        remoteApi.returnPuntos(partidaEnCurso);
        //System.out.println(info[0]);

    }



}
