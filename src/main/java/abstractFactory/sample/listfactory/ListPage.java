package abstractFactory.sample.listfactory;

import abstractFactory.sample.factory.Item;
import abstractFactory.sample.factory.Page;

import java.util.Iterator;

public class ListPage extends Page {
    public ListPage(final String title, final String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        final StringBuffer buffer = new StringBuffer();
        buffer.append("<html><head><title>" + title + "</title></head>\n");
        buffer.append("<body>\n");
        buffer.append("<h1>" + title + "</h1>\n");
        buffer.append("<ul>\n");
        final Iterator it = content.iterator();
        while (it.hasNext()) {
            final Item item = (Item) it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append("<hr><address>" + author + "</address>");
        buffer.append("</body></html>\n");
        return buffer.toString();
    }
}
