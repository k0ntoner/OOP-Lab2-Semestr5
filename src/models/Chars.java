package models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="Chars")
public class Chars {
    private List<Char> chars;

    public Chars(List<Char>chars) {
        this.chars = chars;
    }

    public Chars() {
        chars = new ArrayList<Char>();
    }
    @XmlElement(name="Char")
    public  List<Char> getChars() {
        return chars;
    }

    public void setChars(List<Char> chars) {
        this.chars = chars;
    }
    public void addChar(Char chars) {
        this.chars.add(chars);
    }
}
