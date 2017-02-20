package servidor;

import api.Api;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

/**
 * Created by Aarón on 17/02/2017.
 */
public class Servidor {
    private static final int PORT = 1099;
    private static Registry registre;

    public static void iniciarRegistre() throws RemoteException {
        registre = java.rmi.registry.LocateRegistry.createRegistry(PORT);
    }

    public static void registrarObjecte(String nom, Remote objecteRemot)
            throws RemoteException, AlreadyBoundException {
        registre.bind(nom, objecteRemot);
        System.out.println("S'ha registrat: " + nom + " -> " +
                objecteRemot.getClass().getName() + "[" + objecteRemot + "]");
    }

    public static void main() throws Exception {
        iniciarRegistre();
        registrarObjecte(Api.class.getSimpleName(), new Apilmpl());
        Thread.sleep(5 * 60 * 1000);
    }
}