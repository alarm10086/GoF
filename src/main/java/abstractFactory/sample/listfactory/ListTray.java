package abstractFactory.sample.listfactory;

import abstractFactory.sample.factory.Item;
import abstractFactory.sample.factory.Tray;

import java.util.Iterator;

public class ListTray extends Tray {
    public ListTray(final String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        final StringBuffer buffer = new StringBuffer();
        buffer.append("<li>\n");
        buffer.append(caption + "\n");
        buffer.append("<ul>\n");
        final Iterator it = tray.iterator();
        while (it.hasNext()) {
            final Item item = (Item) it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append("</li>\n");
        return buffer.toString();
    }
}
