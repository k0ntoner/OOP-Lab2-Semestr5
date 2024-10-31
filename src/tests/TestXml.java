package tests;

import configs.XMLConfigLoader;
import models.Site;
import org.junit.jupiter.api.Test;

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
}
