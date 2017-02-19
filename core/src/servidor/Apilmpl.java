package servidor;

import api.Api;
import api.Data;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utils.Tempo;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Aarón on 17/02/2017.
 */
public class Apilmpl extends UnicastRemoteObject implements Api {
    private static final long serialVersionUID = 1L;
    private Tempo puntuacion;
    private float puntos;
    public String arxivo = ".\\puntos2.xml";
    private Document doc;
    private Document docRead;

    public Apilmpl() throws RemoteException{
        super();
    }

    @Override
    public Data generarXML(Data object) throws RemoteException {
        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder =
                    dbFactory.newDocumentBuilder();
            doc = dBuilder.newDocument();
            // root element
            Element rootElement = doc.createElement("partida");
            doc.appendChild(rootElement);

            //  puntos element
            Element puntos = doc.createElement("puntos");
            puntos.appendChild(doc.createTextNode(String.valueOf(object.getValor())));
            rootElement.appendChild(puntos);

            // write the content into xml file
            TransformerFactory transformerFactory =
                    TransformerFactory.newInstance();
            Transformer transformer =
                    transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result =
                    new StreamResult(new File(arxivo));
            transformer.transform(source, result);
            // Output to console for testing
            StreamResult consoleResult =
                    new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return object;
    }
}
