package interfaces;

import models.Site;

public interface Handler {
    public Site parse(String filePath);
}
