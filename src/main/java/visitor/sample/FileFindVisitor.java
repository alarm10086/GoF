package visitor.sample;

import java.util.ArrayList;
import java.util.Iterator;

public class FileFindVisitor extends Visitor {
    private final String filetype;
    private final ArrayList found = new ArrayList();

    public FileFindVisitor(final String filetype) {           // 指定.后面的文件后缀名，如".txt"
        this.filetype = filetype;
    }

    public Iterator getFoundFiles() {                   // 获取已经找到的文件
        return found.iterator();
    }

    @Override
    public void visit(final File file) {                  // 在访问文件时被调用
        if (file.getName().endsWith(filetype)) {
            found.add(file);
        }
    }

    @Override
    public void visit(final Directory directory) {   // 在访问文件夹时被调用
        final Iterator it = directory.iterator();
        while (it.hasNext()) {
            final Entry entry = (Entry) it.next();
            entry.accept(this);
        }
    }
}
