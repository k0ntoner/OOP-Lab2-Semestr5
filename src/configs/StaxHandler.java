package configs;

import interfaces.Handler;
import models.Char;
import models.Page;
import models.Site;
import models.Voting;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;
import java.io.FileReader;

public class StaxHandler implements Handler {
    public Site parse(String filePath){
        Site site = new Site();
        try{
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader reader = factory.createXMLEventReader(new FileReader(filePath));
            Page currentPage=  null;
            String currentElement=null;
            while(reader.hasNext()){
                XMLEvent event = reader.nextEvent();
                if(event.isStartElement()){
                    switch(event.asStartElement().getName().getLocalPart().toLowerCase()){
                        case "page":
                            currentPage = new Page();
                            currentPage.setId(Integer.parseInt(event.asStartElement().getAttributeByName(new QName("id")).getValue()));
                            break;
                        case "title":
                            currentElement="Title";
                            break;
                        case "type":
                            currentElement="Type";
                            break;
                        case "char":
                            currentElement="Char";
                            break;
                        case "voting":
                            currentElement="Voting";
                            break;
                        case "authorize":
                            currentElement="Authorize";
                            break;
                    }
                }
                else if(event.isCharacters()){
                    String dataOfElement=event.asCharacters().getData().trim();

                    if(currentPage!=null){
                        if("Title".equals(currentElement)){
                            currentPage.setTitle(dataOfElement);
                        }
                        else if("Type".equals(currentElement)){
                            currentPage.setType(dataOfElement);
                        }
                        else if("Char".equals(currentElement)){
                            currentPage.addChar(new Char(dataOfElement));
                        }
                        else if("Voting".equals(currentElement) && !"".equals(dataOfElement)){
                            currentPage.addVoting(new Voting(Boolean.parseBoolean(dataOfElement)));
                        }
                        else if("Authorize".equals(currentElement)){
                            currentPage.setIsAuthorize(Boolean.parseBoolean(dataOfElement));
                        }
                    }
                }
                else if(event.isEndElement()){
                    if("Page".equals(event.asEndElement().getName().getLocalPart()) && currentPage!=null){
                        site.addPage(currentPage);
                    }
                    currentElement = null;

                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return site;
    }
}
