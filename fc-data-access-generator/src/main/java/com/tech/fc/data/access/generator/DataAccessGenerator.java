/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.fc.data.access.generator;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author admin
 */
class DataAccessGenerator {
    
    File fXmlFile;

    public void setfXmlFile(File fXmlFile) {
        this.fXmlFile = fXmlFile;
    }
    
    boolean isValidFormat() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();
            
            return doc.getDocumentElement().getNodeName().equals("dataset");
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace(System.err);
        }
        return false;
    }

}
