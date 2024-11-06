package tests;

import configs.DomHandler;
import configs.SaxHandler;
import configs.StaxHandler;
import configs.XMLConfigLoader;
import interfaces.Handler;
import models.Page;
import models.Site;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestXml {
    private void TestSiteCorrectness(Site site){
        assertEquals(site!=null, true);
        assertEquals(site.getPages().size(), 4);
        Page page1 = site.getPages().get(0);
        assertEquals(page1.getId(), 1);
        assertEquals(page1.getTitle(), "Hot News");
        assertEquals(page1.getType(), "News");
        assertEquals(page1.getChars().size(), 3);
        assertEquals(page1.getChars().get(0).getProperty(), "Email Available");
        assertEquals(page1.getChars().get(1).getProperty(), "News Available");
        assertEquals(page1.getChars().get(2).getProperty(), "Free");
        assertEquals(page1.getIsAuthorize(), false);

        Page page2 = site.getPages().get(1);
        assertEquals(page2.getId(), 2);
        assertEquals(page2.getTitle(), "New Car");
        assertEquals(page2.getType(), "Advertising");
        assertEquals(page2.getChars().size(), 1);
        assertEquals(page2.getChars().get(0).getProperty(), "Email Not Available");
        assertEquals(page2.getIsAuthorize(), false);

        Page page3 = site.getPages().get(2);
        assertEquals(page3.getId(), 3);
        assertEquals(page3.getTitle(), "Info");
        assertEquals(page3.getType(), "Portal");
        assertEquals(page3.getChars().size(), 2);
        assertEquals(page3.getChars().get(0).getProperty(), "Email Available");
        assertEquals(page3.getChars().get(1).getProperty(), "Paid");
        assertEquals(page3.getIsAuthorize(), true);

        Page page4 = site.getPages().get(3);
        assertEquals(page4.getId(), 4);
        assertEquals(page4.getTitle(), "Boom");
        assertEquals(page4.getType(), "Mirror");
        assertEquals(page4.getChars().size(), 3);
        assertEquals(page4.getChars().get(0).getProperty(), "Email Available");
        assertEquals(page4.getChars().get(1).getProperty(), "Paid");
        assertEquals(page4.getChars().get(2).getProperty(), "Archived Available");
        assertEquals(page4.getIsAuthorize(), true);
    }
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
        Handler handler = new SaxHandler();
        Site site = handler.parse("/Users/andriikot/IdeaProjects/OOPLab2/src/site.xml");
        TestSiteCorrectness(site);
    }

    @Test
    public void TestDomParsing() throws Exception{
        Handler handler = new DomHandler();
        Site site = handler.parse("/Users/andriikot/IdeaProjects/OOPLab2/src/site.xml");
        TestSiteCorrectness(site);
    }
    @Test
    public void TestXmlParsing() throws Exception{
        Handler handler = new StaxHandler();
        Site site= handler.parse("/Users/andriikot/IdeaProjects/OOPLab2/src/site.xml");
        TestSiteCorrectness(site);
    }
}

