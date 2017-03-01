/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import design.DBConn;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Etti
 */
public class CreateXML {
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            public static String alphnumericCode = null;
            public static String time = null;

        public static void main(String str) throws TransformerConfigurationException, TransformerException, ParserConfigurationException {
        
        xmlmake(str);
        
    }

    public static void xmlmake(String artID) throws ParserConfigurationException {
        LocalDate localDate = LocalDate.now();
        System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
        System.err.println("" + localDate);
        time = localDate.toString();
        System.err.println("" + time);
        time ="#"+ DateTimeFormatter.ofPattern("dd/MM/yyy").format(localDate)+"#";
        System.out.println("" + time);
        System.out.println(""+artID);

        ResultSet res = DBConn.query("SELECT recordingSessions.artistId, recordingSessions.startDateAndHour\n" +
"FROM recordingSessions INNER JOIN record ON recordingSessions.sessionNumber = record.sessionNumber\n" +
"WHERE (((recordingSessions.artistId)=\""+artID+"\") AND ((recordingSessions.startDateAndHour)>\""+time+"\"));");
        try {
            while (res.next()) {
                alphnumericCode = res.getString("artistId");
                time = res.getString("startDateAndHour");
            }

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbuilder = dbf.newDocumentBuilder();

            Document document = dbuilder.newDocument();

            Element element = document.createElement("Artist");
            document.appendChild(element);

            Attr attr = document.createAttribute("artistId");
            attr.setValue("" + alphnumericCode);
            element.setAttributeNode(attr);

            Element name = document.createElement("Date");
            name.appendChild(document.createTextNode("" + time));
            element.appendChild(name);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            StreamResult streamResult = new StreamResult(new File("C:\\Users\\Etti\\Documents\\NetBeansProjects\\Login - Copy\\src\\sources\\import.XML"));
            transformer.transform(source, streamResult);
        } catch (TransformerException ex) {
            Logger.getLogger(CreateXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CreateXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
