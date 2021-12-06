/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.litopia.trajectoires;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author volatlo
 */
public class Trajectoire {

    private List<Coordonnée> pos;

    public Trajectoire() {
        this.pos = new ArrayList<>();
    }

    public Boolean ajoute(Coordonnée pos) {
        return this.pos.add(pos);
    }

    public Boolean ajoute(Etape étape) {
        Boolean returnVal = false;
        if (this.pos.size() > 0) {
            Coordonnée pos = this.pos.get(this.pos.size());
            if (pos.equals(étape.getDépart())) {
                returnVal = this.ajoute(étape.getArrivée());
            }
        } else {
            returnVal = this.ajoute(étape.getDépart()) && this.ajoute(étape.getArrivée());
        }
        return returnVal;
    }

    public double distance() {
        double distance = 0;
        if (this.pos.size() >= 2) {
            for (int i = 0; i < pos.size() - 1; i++) {
                Etape e = new Etape(this.pos.get(i), this.pos.get(i + 1));
                distance += e.distance();
            }
        }
        return distance;
    }

    public void vide() {
        pos.clear();
    }

    public void readDOM(String path, String filename) throws SAXException, IOException {
        // crée un parser de type DOM
        DOMParser parser = new DOMParser();
        // parse le document XML correspondant au fichier filename dans le chemin path
        parser.parse(path + filename);
        // récupère l'instance de document
        Document doc = parser.getDocument();
        // récupère la liste des éléments nommés tr:pos
        NodeList posList = doc.getChildNodes();
        NodeList elements = posList.item(1).getChildNodes();
        // vide la liste de coordonnées
        this.vide();
        // déclare une coordonnée
        Coordonnée c;
        // parcoure la liste posList
        for (int i = 0; i < elements.getLength();i++) {
            Node node = elements.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                try{
                c = new Coordonnée(Double.valueOf(((Element) node).getAttribute("x")),
                        Double.valueOf(((Element) node).getAttribute("y")),
                        Double.valueOf(((Element) node).getAttribute("z")));
                ajoute(c);
                }catch(NumberFormatException e){
                    
                } 
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        if (pos.size() == 0) {
            s += "Aucun point enregistré";
        } else if (pos.size() == 1) {
            s += "Il n'y a qu'un point enregistré : " + pos.get(0).toString();
        } else {
            Etape etape = new Etape(pos.get(0), pos.get(1));
            s += " [étape " + 1 + "] " + etape.toString();
            for (int i = 1; i < pos.size() - 1; i++) {
                s += " [étape " + (i + 1) + "] ";
                etape.set(pos.get(i), pos.get(i + 1));
                s += etape.toString();
            }
        }
        return s;
    }

    public void writeDOM(String path, String filename) throws SAXException, IOException, TransformerConfigurationException, TransformerException, ParserConfigurationException, TransformerException, ParserConfigurationException {
        // creates a document DOM
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        docFactory.setNamespaceAware(true);
        DocumentBuilder docBuilder;
        docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        // creates the root element with namespaces
        Element rootElement = doc.createElementNS("http://www.univ-grenoble-alpes.fr/trajectoires", "tr:Trajectoire");
        rootElement.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:tr", "http://www.univ-grenoble-alpes.fr/trajectoires");
        rootElement.setAttribute("xmlns:tr", "http://www.univ-grenoble-alpes.fr/trajectoires");
        rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        rootElement.setAttribute("xsi:schemaLocation", "http://www.univ-grenoble-alpes.fr/trajectoires Trajectoire.xsd");

        // append root element as a child
        doc.appendChild(rootElement);

        // ICI : enregistrer toutes les positions (pos ...) et leurs attributs x, y, z en créant tous les éléments DOM nécessaires
        for (Coordonnée po : pos) {
            Element posElement = doc.createElement("tr:pos");
            posElement.setAttribute("x", String.valueOf(po.getX()));
            posElement.setAttribute("y", String.valueOf(po.getY()));
            posElement.setAttribute("z", String.valueOf(po.getZ()));
            rootElement.appendChild(posElement);
        }

        // prepare DOM for output
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);

        // output DOM XML to console
        StreamResult console = new StreamResult(System.out);
        transformer.transform(source, console);

        // output DOM XML to a file
        StreamResult file = new StreamResult(new File(path + filename));
        transformer.transform(source, file);

        System.out.println("\nXML DOM Created Successfully..");

    }
}
