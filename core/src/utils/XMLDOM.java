package utils;

import org.w3c.dom.*;

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
    public String arxivo = ".\\cars.xml";
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
            File stocks = new File(arxivo);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            docRead = dBuilder.parse(stocks);
            docRead.getDocumentElement().normalize();

            System.out.println("arrel " + docRead.getDocumentElement().getNodeName());
            NodeList nodes = (NodeList) docRead.getElementsByTagName("partida").item(0);

            for (int i=0; i< nodes.getLength(); i++){
                Node node = nodes.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("puntos "+element.getElementsByTagName("puntos").item(0).getNodeValue());
                }

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
