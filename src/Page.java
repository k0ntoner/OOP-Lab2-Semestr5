import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;


public class Page {

    private int id;
    private String title;
    private String type;
    private List<String> Chars;
    private Voting voting;
    private boolean isAuthorize;

    public Page(String title, String type, List<String> chars, Voting voting, boolean isAuthorize) {
        this.title = title;
        this.type = type;
        Chars = chars;
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
    public List<String> getChars() {
        return Chars;
    }

    public void setChars(List<String> chars) {
        Chars = chars;
    }
    @XmlElement(name="Voting")
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
