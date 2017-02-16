package utils;

import org.w3c.dom.*;
import stages.GameStage;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by Aarón on 12/02/2017.
 */
public class XMLDOM {
    private Tempo puntuacion;
    private float puntos;
    public String arxivo = ".\\puntos.xml";
    private Document doc;
    private Document docRead;

    public XMLDOM(){
        puntos = Tempo.getTemp();
    }

    public float getPuntos(){
        return puntos;
    }

    public void crearXML() {
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
            puntos.appendChild(doc.createTextNode(String.valueOf(puntuacion.getTemp())));
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

    public void lecturaXML(){
        try {
            File stocks = new File("puntos.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stocks);
            doc.getDocumentElement().normalize();

            System.out.println("arrel " + doc.getDocumentElement().getNodeName());
            NodeList nodes = (NodeList) doc.getElementsByTagName("partida").item(0);

            for (int i=0; i< nodes.getLength(); i++){
                Node node = nodes.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("Puntos: " + obtenirContingut("puntos", element));
                }

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static String obtenirContingut(String etiqueta, Element element) {
        NodeList nodes = element.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node node = (Node) nodes.item(0);
        return node.getNodeValue();
    }


}
