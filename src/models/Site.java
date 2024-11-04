package models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="Site")
public class Site {
    private List<Page> pages;

    public Site(List<Page> pages) {
        this.pages = pages;
    }

    public Site() {
        pages = new ArrayList<>();
    }
    @XmlElement(name="Page")
    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }
    public void addPage(Page page) {
        this.pages.add(page);
    }
}
