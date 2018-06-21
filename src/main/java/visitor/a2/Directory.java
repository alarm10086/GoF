package visitor.a2;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {
    private final String name;                    // 文件夹名字
    private final ArrayList dir = new ArrayList();      // 目录条目的集合

    public Directory(final String name) {         // 构造函数
        this.name = name;
    }

    @Override
    public String getName() {               // 获取名字
        return name;
    }

    @Override
    public int getSize() {                  // 获取大小
        final SizeVisitor v = new SizeVisitor();
        accept(v);
        return v.getSize();
    }

    @Override
    public Entry add(final Entry entry) {         // 添加目录条目
        dir.add(entry);
        return this;
    }

    @Override
    public Iterator iterator() {
        return dir.iterator();
    }

    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }
}
