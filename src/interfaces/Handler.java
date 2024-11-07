package interfaces;

import models.Page;
import models.Site;

import java.util.List;

public interface Handler {
    public Site parse(String filePath);
    default Site sort(Site site){
        List<Page> pages=site.getPages();
        CompareByType compareByType =new CompareByType();

        for(int i=1; i<pages.size(); i++){
            Page swap=pages.get(i);
            int counter=i-1;
            while(counter>=0 && compareByType.compare(swap, pages.get(counter))<0){
                pages.set(counter+1,pages.get(counter));

                counter--;
            }

            pages.set(counter+1,swap);

        }
        return site;
    }
}
