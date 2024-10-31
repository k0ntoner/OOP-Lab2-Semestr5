package models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name="Chars")
public class Chars {
    private List<String> chars;

    public Chars(List<String> chars) {
        this.chars = chars;
    }

    public Chars() {
    }
    @XmlElement(name="Char")
    public List<String> getChars() {
        return chars;
    }

    public void setChars(List<String> chars) {
        this.chars = chars;
    }
}
