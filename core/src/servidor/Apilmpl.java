package servidor;

import api.Api;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import utils.Partida;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;



/**
 * Created by Aarón on 17/02/2017.
 */
public class Apilmpl extends UnicastRemoteObject implements Api {
    private static final long serialVersionUID = 1L;
    public String arxivo = ".\\puntos2.xml";
    private Document doc;
    private float puntos;
    private String nivel;
    private Array Last;


    public Apilmpl() throws RemoteException{
        super();
    }

    @Override
    public void generarXML(float object1, String object2) throws RemoteException {
        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder =
                    dbFactory.newDocumentBuilder();
            doc = dBuilder.newDocument();
            // root element
            Element rootElement = doc.createElement("Samuel");
            doc.appendChild(rootElement);

            //  jujador element
            Element nivel = doc.createElement("nivel");
            nivel.appendChild(doc.createTextNode(String.valueOf(object2)));
            rootElement.appendChild(nivel);

            //  puntos element
            Element puntos = doc.createElement("puntos");
            puntos.appendChild(doc.createTextNode(String.valueOf(object1)));
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

    }

    public Map<Float, String> returnPuntos(Partida partidaEnCurso) throws RemoteException {
        try {
            File stocks = new File(".\\puntos2.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stocks);
            doc.getDocumentElement().normalize();

            System.out.println("arrel " + doc.getDocumentElement().getNodeName());
            NodeList nodes = (NodeList) doc.getElementsByTagName("Samuel");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    //System.out.println("Puntos: " + obtenirContingut("puntos", element));
                        puntos = Float.parseFloat(obtenirContingut("puntos", element));

                    //System.out.println("Nivel: " + obtenirContingut("nivel", element));
                        nivel = obtenirContingut("nivel", element);

                }
            }

            MapPartidas.setArrPartidas(puntos,nivel);
            MapPartidas.getArrPartidas();
            MapPartidas.setArraylistPartidas(partidaEnCurso);

            MapPartidas.getSortPoints();

            MapPartidas.sortByValue(MapPartidas.getArrPartidas());

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return MapPartidas.arrPartidas;
    }

    private static String obtenirContingut(String etiqueta, Element element) {
        NodeList nodes = element.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node node = (Node) nodes.item(0);
        return node.getNodeValue();
    }


}
