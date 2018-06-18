package Visitor.A1;

import Composite.A2.Entry;
import Visitor.A2.Directory;
import Visitor.A2.File;

import java.util.Iterator;

public class ListVisitor extends Visitor.A2.Visitor {
    private String currentdir = "";                         // 当前访问的文件夹的名字
    public void visit(File file) {                  // 在访问文件时被调用
        System.out.println(currentdir + "/" + file);
    }
    public void visit(Directory directory) {   // 在访问文件夹时被调用
        System.out.println(currentdir + "/" + directory);
        String savedir = currentdir;
        currentdir = currentdir + "/" + directory.getName();
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Composite.A2.Entry entry = (Entry)it.next();
            entry.accept(this);
        }
        currentdir = savedir;
    }
}
