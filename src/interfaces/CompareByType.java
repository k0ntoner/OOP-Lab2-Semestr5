package interfaces;

import models.Page;

import java.util.Comparator;

public class CompareByType implements Comparator<Page> {

    @Override
    public int compare(Page page1, Page page2) {
        if(page1.getType().compareToIgnoreCase(page2.getType())!=0)
            return page1.getType().compareToIgnoreCase(page2.getType());
        return page1.getId()-page2.getId();
    }
}
