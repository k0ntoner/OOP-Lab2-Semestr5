package configs;

import models.Site;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class XMLConfigLoader {
    public static Site loadSiteFromXml(String filePath) throws JAXBException{

        File file = new File(filePath);
        JAXBContext jaxbContext = JAXBContext.newInstance(Site.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Site) jaxbUnmarshaller.unmarshal(file);
    }
}
