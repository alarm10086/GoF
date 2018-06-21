package visitor.a2;

import java.util.Iterator;

public class SizeVisitor extends Visitor {
    private int size = 0;

    public int getSize() {
        return size;
    }

    @Override
    public void visit(final File file) {
        size += file.getSize();
    }

    @Override
    public void visit(final Directory directory) {
        final Iterator it = directory.iterator();
        while (it.hasNext()) {
            final Entry entry = (Entry) it.next();
            entry.accept(this);
        }
    }
}
