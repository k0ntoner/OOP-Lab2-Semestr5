package tests;

import configs.*;
import interfaces.Handler;
import models.Page;
import models.Site;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestXml {
    private void TestSiteCorrectness(Site site) {
        assertEquals(site != null, true);
        assertEquals(site.getPages().size(), 8);

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

        Page page5 = site.getPages().get(4);
        assertEquals(page5.getId(), 5);
        assertEquals(page5.getTitle(), "Latest Updates");
        assertEquals(page5.getType(), "News");
        assertEquals(page5.getChars().size(), 3);
        assertEquals(page5.getChars().get(0).getProperty(), "Email Available");
        assertEquals(page5.getChars().get(1).getProperty(), "Breaking News");
        assertEquals(page5.getChars().get(2).getProperty(), "Free");
        assertEquals(page5.getIsAuthorize(), false);

        Page page6 = site.getPages().get(5);
        assertEquals(page6.getId(), 6);
        assertEquals(page6.getTitle(), "Special Offers");
        assertEquals(page6.getType(), "Advertising");
        assertEquals(page6.getChars().size(), 1);
        assertEquals(page6.getChars().get(0).getProperty(), "Email Not Available");
        assertEquals(page6.getIsAuthorize(), false);

        Page page7 = site.getPages().get(6);
        assertEquals(page7.getId(), 7);
        assertEquals(page7.getTitle(), "Resource Hub");
        assertEquals(page7.getType(), "Portal");
        assertEquals(page7.getChars().size(), 2);
        assertEquals(page7.getChars().get(0).getProperty(), "Email Available");
        assertEquals(page7.getChars().get(1).getProperty(), "Paid");
        assertEquals(page7.getIsAuthorize(), true);

        Page page8 = site.getPages().get(7);
        assertEquals(page8.getId(), 8);
        assertEquals(page8.getTitle(), "Mirror Site");
        assertEquals(page8.getType(), "Mirror");
        assertEquals(page8.getChars().size(), 3);
        assertEquals(page8.getChars().get(0).getProperty(), "Email Available");
        assertEquals(page8.getChars().get(1).getProperty(), "Paid");
        assertEquals(page8.getChars().get(2).getProperty(), "Archived Available");
        assertEquals(page8.getIsAuthorize(), true);
    }
    private void TestSiteCorrectnessAfterSortingByType(Site site) {

        List<Page> sortedPages = site.getPages();
        assertEquals(sortedPages.size(), 8);


        assertEquals(sortedPages.get(0).getTitle(), "New Car");
        assertEquals(sortedPages.get(1).getTitle(), "Special Offers");
        assertEquals(sortedPages.get(2).getTitle(), "Boom");
        assertEquals(sortedPages.get(3).getTitle(), "Mirror Site");
        assertEquals(sortedPages.get(4).getTitle(), "Hot News");
        assertEquals(sortedPages.get(5).getTitle(), "Latest Updates");
        assertEquals(sortedPages.get(6).getTitle(), "Info");
        assertEquals(sortedPages.get(7).getTitle(), "Resource Hub");
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
    @Test void TestSortingByType() throws Exception{
        Handler handler = new StaxHandler();
        Site site= handler.parse("/Users/andriikot/IdeaProjects/OOPLab2/src/site.xml");
        TestSiteCorrectness(site);
        handler.sort(site);
        TestSiteCorrectnessAfterSortingByType(site);
    }
    @Test void TestXMLByXSD() throws Exception{

        assertEquals(XsdValidator.Validating("/Users/andriikot/IdeaProjects/OOPLab2/src/validate.xsd","/Users/andriikot/IdeaProjects/OOPLab2/src/site.xml"),true);
    }
    @Test void TestXSLT() throws Exception{
        XslTransformer.transform("/Users/andriikot/IdeaProjects/OOPLab2/src/sortingByType.xsl","/Users/andriikot/IdeaProjects/OOPLab2/src/site.xml","/Users/andriikot/IdeaProjects/OOPLab2/src/siteAfterSortingXSL.xml");
        assertEquals(XsdValidator.Validating("/Users/andriikot/IdeaProjects/OOPLab2/src/validateAfterXSLT.xsd","/Users/andriikot/IdeaProjects/OOPLab2/src/siteAfterSortingXSL.xml"),true);
    }
}

