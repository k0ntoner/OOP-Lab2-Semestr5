package models;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.List;


public class Page {

    private int id;
    private String title;
    private String type;
    private Chars chars;
    private List<Voting> votings;
    private boolean isAuthorize;

    public Page(String title, String type, Chars chars, List<Voting> votings, boolean isAuthorize) {
        this.title = title;
        this.type = type;
        this.chars = chars;
        this.votings = votings;
        this.isAuthorize = isAuthorize;
    }

    public Page() {
        this.votings = new ArrayList<>();
        this.chars = new Chars();
    }

    public Page(int id) {
        this.id = id;
        this.votings = new ArrayList<>();
        this.chars = new Chars();
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
    public List<Voting> getVotings() {
        return votings;
    }

    public void addVoting(Voting voting) {
        this.votings.add(voting);
    }
    @XmlElement(name="Authorize")
    public boolean getIsAuthorize() {
        return isAuthorize;
    }

    public void setIsAuthorize(boolean isAuthorize) {
        this.isAuthorize = isAuthorize;
    }
    public void addChar(Char property){
        this.chars.addChar(property);
    }
}
