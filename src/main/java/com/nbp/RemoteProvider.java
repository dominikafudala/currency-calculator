package com.nbp;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;
import java.net.URL;

public class RemoteProvider {
    private static final String url = "https://www.nbp.pl/kursy/xml/lasta.xml";
    public RemoteProvider() {
    }

    public Document getData(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new URL(url).openStream());
            doc.getDocumentElement().normalize();
            return doc;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Nie znaleziono pliku xml");
        }
        return null;
    }
}
