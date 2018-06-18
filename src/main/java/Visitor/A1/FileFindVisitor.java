package Visitor.A1;

import Composite.A2.Entry;
import Visitor.A2.Directory;
import Visitor.A2.File;

import java.util.Iterator;
import java.util.ArrayList;

public class FileFindVisitor extends Visitor.A2.Visitor {
    private String filetype;
    private ArrayList found = new ArrayList();
    public FileFindVisitor(String filetype) {           // 指定.后面的文件后缀名，如".txt"
        this.filetype = filetype;
    }
    public Iterator getFoundFiles() {                   // 获取已经找到的文件
        return found.iterator();
    }
    public void visit(File file) {                  // 在访问文件时被调用
        if (file.getName().endsWith(filetype)) {
            found.add(file);
        }
    }
    public void visit(Directory directory) {   // 在访问文件夹时被调用
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Composite.A2.Entry entry = (Entry)it.next();
            entry.accept(this);
        }
    }
}