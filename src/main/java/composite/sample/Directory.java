package composite.sample;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {
    private final String name;
    private final ArrayList<Entry> directory = new ArrayList();

    public Directory(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        final Iterator it = directory.iterator();
        while (it.hasNext()) {
            final Entry entry = (Entry) it.next();
            size += entry.getSize();
        }
        return size;
    }

    @Override
    public Entry add(final Entry entry) {
        directory.add(entry);
        entry.parent = this;
        return this;
    }

    @Override
    protected void printList(final String prefix) {
        System.out.println(prefix + "/" + this);
        final Iterator it = directory.iterator();
        while (it.hasNext()) {
            final Entry entry = (Entry) it.next();
            entry.printList(prefix + "/" + name);
        }
    }
}
