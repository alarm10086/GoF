package Visitor.A2;

import Composite.A2.Entry;
import Visitor.A3.Directory;
import Visitor.A3.File;

import java.util.Iterator;

public class SizeVisitor extends Visitor.A3.Visitor {
    private int size = 0;
    public int getSize() {
        return size;
    }
    public void visit(File file) {
        size += file.getSize();
    }
    public void visit(Directory directory) {
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Composite.A2.Entry entry = (Entry)it.next();
            entry.accept(this);
        }
    }
}
