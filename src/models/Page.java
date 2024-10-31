package models;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;


public class Page {

    private int id;
    private String title;
    private String type;
    private Chars chars;
    private Voting voting;
    private boolean isAuthorize;

    public Page(String title, String type, Chars chars, Voting voting, boolean isAuthorize) {
        this.title = title;
        this.type = type;
        this.chars = chars;
        this.voting = voting;
        this.isAuthorize = isAuthorize;
    }

    public Page() {
    }
    @XmlAttribute(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlElement(name="Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @XmlElement(name="Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @XmlElement(name="Chars")
    public Chars getChars() {
        return chars;
    }

    public void setChars(Chars chars) {
        this.chars = chars;
    }
    @XmlElement(name="Votings")
    public Voting getVoting() {
        return voting;
    }

    public void setVoting(Voting voting) {
        this.voting = voting;
    }
    @XmlElement(name="Authorize")
    public boolean getIsAuthorize() {
        return isAuthorize;
    }

    public void setIsAuthorize(boolean isAuthorize) {
        this.isAuthorize = isAuthorize;
    }
}
