import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


public class Voting {
    private boolean isAnonymous;

    public Voting(boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public Voting() {
    }
    @XmlElement(name="Anonymous")
    public boolean getIsAnonymous() {
        return this.isAnonymous;
    }

    public void setIsAnonymous(boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }
}
