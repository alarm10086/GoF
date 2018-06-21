package abstractFactory.sample.factory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public abstract class Page {
    protected String title;
    protected String author;
    protected ArrayList<Item> content = new ArrayList();

    public Page(final String title, final String author) {
        this.title = title;
        this.author = author;
    }

    public void add(final Item item) {
        content.add(item);
    }

    public void output() {
        try {
            final String filename = title + ".html";
            final Writer writer = new FileWriter(filename);
            writer.write(this.makeHTML());
            writer.close();
            System.out.println(filename + " 编写完成。");
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public abstract String makeHTML();
}
