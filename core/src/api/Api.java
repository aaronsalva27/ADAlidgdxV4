package api;

import java.rmi.RemoteException;
import java.rmi.*;

/**
 * Created by Aarón on 17/02/2017.
 */
public interface Api {

    public Data generarXML(Data object) throws RemoteException;
}
