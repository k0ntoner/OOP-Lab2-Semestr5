package configs;

import interfaces.Handler;
import models.Char;
import models.Page;
import models.Site;
import models.Voting;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;



public class DomHandler implements Handler {
    private Site site;
    public Site parse(String filePath) {
        try{
            DocumentBuilderFactory DomFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder DomBuilder = DomFactory.newDocumentBuilder();
            Document doc = DomBuilder.parse(new File(filePath));
            doc.getDocumentElement().normalize();

            Site site = new Site();
            NodeList pages = doc.getElementsByTagName("Page");
            for (int i = 0; i < pages.getLength(); i++) {
                Element pageElement = (Element) pages.item(i);
                Page page=new Page();
                page.setId(Integer.parseInt(pageElement.getAttribute("id")));
                page.setType(pageElement.getAttribute("type"));
                page.setTitle(pageElement.getElementsByTagName("Title").item(0).getTextContent());

                NodeList chars= pageElement.getElementsByTagName("Char");
                for(int j=0;j<chars.getLength();j++){
                    page.addChar(new Char(chars.item(j).getTextContent()));
                }
                NodeList votings= pageElement.getElementsByTagName("Voting");
                for(int j=0;j<votings.getLength();j++){
                    page.addVoting(new Voting(Boolean.parseBoolean( votings.item(j).getTextContent())));
                }
                page.setIsAuthorize(Boolean.parseBoolean(pageElement.getElementsByTagName("Authorize").item(0).getTextContent()));
                site.addPage(page);
            }

            return site;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
