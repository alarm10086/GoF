package abstractFactory.sample.listfactory;

import abstractFactory.sample.factory.Factory;
import abstractFactory.sample.factory.Link;
import abstractFactory.sample.factory.Page;
import abstractFactory.sample.factory.Tray;

public class ListFactory extends Factory {
    @Override
    public Link createLink(final String caption, final String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(final String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(final String title, final String author) {
        return new ListPage(title, author);
    }
}
