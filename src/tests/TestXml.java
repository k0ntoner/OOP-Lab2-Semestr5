package tests;

import configs.SaxHandler;
import configs.XMLConfigLoader;
import models.Site;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestXml {
    @Test
    public void xmlReadingTest(){
        try {
            Site site = XMLConfigLoader.loadSiteFromXml("/Users/andriikot/IdeaProjects/OOPLab2/src/site.xml");
            assertEquals(site!=null, true);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    @Test
    public void TestSaxParsing() throws SAXException, IOException {
        SaxHandler handler = new SaxHandler();
        Site site = handler.parse("/Users/andriikot/IdeaProjects/OOPLab2/src/site.xml");
        assertEquals(site!=null, true);
    }
}

