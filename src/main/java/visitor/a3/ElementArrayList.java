package visitor.a3;

import java.util.ArrayList;
import java.util.Iterator;

class ElementArrayList extends ArrayList implements Element {
    @Override
    public void accept(final Visitor v) {
        final Iterator it = iterator();
        while (it.hasNext()) {
            final Element e = (Element) it.next();
            e.accept(v);
        }
    }
}
