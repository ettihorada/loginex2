/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class XML {

  public static void main(String argv[]) {
      Date[] dates = xmlImport("A12");
      int t = 0;
      for(Date d : dates)
          if(d!=null) System.err.println(t++ +" - "+d.toGMTString());
  }
  
  public static Date[] xmlImport(String artID){
      
      List<Date> dates = new ArrayList();
      
    try {
        Document doc;
        try {
	File inputFile = new File("src/sources/hiaxml.xml");
                 DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           doc = dBuilder.parse(inputFile);
        } catch(Exception e){
        File inputFile = new File("sources/hiaxml.xml");
                 DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           doc = dBuilder.parse(inputFile);
    }
	//optional, but recommended
	doc.getDocumentElement().normalize();
	NodeList nList = doc.getElementsByTagName("Artist");
        NodeList nList2 = doc.getElementsByTagName("Show");
        
        
      //  String XString = fXmlFile.toString();
     //   XString = XString.replaceAll("[^\\x20-\\x7e]", "");
	for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Element e = (Element) nNode;
                if(!e.getAttribute("ID").equals(artID))
                    continue;
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;  
		}
	}
        int j=0;
        for(int temp = 0 ; temp < nList2.getLength() ; temp++){
            Node nNode = nList2.item(temp);
            Element e = (Element) nNode;
            
            if(!e.getAttribute("ts").isEmpty()){
               // Timestamp ts = new Timestamp(e.getAttribute("ts"));
                System.err.println("Adding date: "+
                        new Date(
                                Long.parseLong(e.getAttribute("ts"))
                        )+" j: "+j);
                dates.add(new Date(Long.parseLong(e.getAttribute("ts"))));
               
            }
        }
    } catch (Exception e) {
	e.printStackTrace();
    }
    Date[] datesArr = new Date[dates.size()];
    
    return dates.toArray(datesArr);
  }

}