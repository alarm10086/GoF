package abstractFactory.sample.listfactory;

import abstractFactory.sample.factory.Link;

public class ListLink extends Link {
    public ListLink(final String caption, final String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "  <li><a href=\"" + url + "\">" + caption + "</a></li>\n";
    }
}
