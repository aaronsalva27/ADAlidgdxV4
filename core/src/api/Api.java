package api;

import java.rmi.RemoteException;
import java.rmi.*;
import java.util.Map;

/**
 * Created by Aarón on 17/02/2017.
 */
public interface Api extends Remote {

    public void generarXML(float object1, String object2) throws RemoteException;

    public Map<Float, String> returnPuntos() throws RemoteException;

}
