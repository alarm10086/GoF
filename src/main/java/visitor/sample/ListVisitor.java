package visitor.sample;


import java.util.Iterator;

public class ListVisitor extends Visitor {
    private String currentdir = "";                         // 当前访问的文件夹的名字

    @Override
    public void visit(final File file) {                  // 在访问文件时被调用
        System.out.println(currentdir + "/" + file);
    }

    @Override
    public void visit(final Directory directory) {   // 在访问文件夹时被调用
        System.out.println(currentdir + "/" + directory);
        final String savedir = currentdir;
        currentdir = currentdir + "/" + directory.getName();
        final Iterator it = directory.iterator();
        while (it.hasNext()) {
            final Entry entry = (Entry) it.next();
            entry.accept(this);
        }
        currentdir = savedir;
    }
}
