package configs;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XslTransformer {
    public static void transform(String xslFile,String xmlPath ,String outputPath) {
        try{
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Source xslSource = new StreamSource(xslFile);
            Transformer transformer = transformerFactory.newTransformer(xslSource);
            Source xmlSource = new StreamSource(xmlPath);
            Result xmlResult = new StreamResult(outputPath);
            transformer.transform(xmlSource, xmlResult);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
