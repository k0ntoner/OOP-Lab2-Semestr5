package configs;

import interfaces.Handler;
import models.Char;
import models.Page;
import models.Site;
import models.Voting;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxHandler implements Handler {
    private Site site;
    private Page currentPage;
    private String currentValue;
    public Site parse(String filePath){
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser= factory.newSAXParser();
            this.site=new Site();
            DefaultHandler defaultHandler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if(qName.equalsIgnoreCase("Page")){
                        currentPage = new Page(Integer.parseInt(attributes.getValue("id")));
                        currentPage.setType(attributes.getValue("type"));
                    }


                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    switch(qName.toLowerCase()) {
                        case "page":
                            site.addPage(currentPage);
                            break;
                        case "title":
                            currentPage.setTitle(currentValue);
                            break;
                        case "char":
                            Char property=new Char(currentValue);
                            currentPage.addChar(property);
                            break;
                        case "voting":
                            Voting voting = new Voting(Boolean.parseBoolean(currentValue));
                            currentPage.addVoting(voting);
                            break;
                        case "authorize":
                            currentPage.setIsAuthorize(Boolean.parseBoolean(currentValue));
                            break;
                    }

                }

                @Override
                public void characters(char[] ch, int start, int length) {
                    currentValue= new String(ch, start, length).trim();

                }
            };
            saxParser.parse(new File(filePath),defaultHandler);
            return site;
        }
        catch (SAXException e){
            System.out.println(e);
        }
        catch (ParserConfigurationException e){
            System.out.println(e);
        }
        catch (IOException e){
            System.out.println(e);
        }
        return null;

    }



}
