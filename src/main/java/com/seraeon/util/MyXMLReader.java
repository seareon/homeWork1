package com.seraeon.util;

import com.seraeon.Beeline;
import com.seraeon.Point;
import org.apache.log4j.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Misha Ro on 12.12.2016.
 */
public class MyXMLReader {
    private static final Logger log = Logger.getLogger(MyXMLReader.class);

    static public Object readXML(String type, String name) {
        Object obj = null;

        try {
            XMLStreamReader xmlsr = XMLInputFactory.newInstance().createXMLStreamReader("",
                    new FileInputStream("param.xml"));

            while(xmlsr.hasNext()) {
                xmlsr.next();
                if(xmlsr.isStartElement()) {
                    if(xmlsr.getLocalName().equals(type)) {
                        if(xmlsr.getAttributeValue(null, "name").equals(name)) {
                            switch(type) {
                                case "line":
                                    obj = readBeeline(xmlsr);
                                    break;
                                case "expected":
                                    obj = parseDouble(xmlsr, "value");
                            }
                        }
                    }
                }
            }
        } catch(IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        } catch (XMLStreamException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return obj;
    }

    static private Beeline readBeeline(XMLStreamReader xmlsr) {
        Beeline line = new Beeline();
        Double x;
        Double y;

        for(int indexPoint = 1; indexPoint < 3; indexPoint++) {
            String strX = "x";
            String strY = "y";

            x = parseDouble(xmlsr, strX + indexPoint);
            y = parseDouble(xmlsr, strY + indexPoint);

            if (x != null && y != null) {
                if(indexPoint == 1) {
                    line.setPoint1(new Point(x.intValue(), y.intValue()));
                } else {
                    line.setPoint2(new Point(x.intValue(), y.intValue()));
                }
            } else {
                line = null;
                break;
            }
        }
        return line;
    }

    static private Double parseDouble(XMLStreamReader xmlsr, String attr) {
        String str = xmlsr.getAttributeValue(null, attr);

        if(str.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) {
            return new Double(str);
        } else {
            return null;
        }
    }
}
