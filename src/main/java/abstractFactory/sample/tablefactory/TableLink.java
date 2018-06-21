package abstractFactory.sample.tablefactory;

import abstractFactory.sample.factory.Link;

public class TableLink extends Link {
    public TableLink(final String caption, final String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "<td><a href=\"" + url + "\">" + caption + "</a></td>\n";
    }
}
