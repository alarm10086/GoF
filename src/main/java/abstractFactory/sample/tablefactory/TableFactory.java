package abstractFactory.sample.tablefactory;

import abstractFactory.sample.factory.Factory;
import abstractFactory.sample.factory.Link;
import abstractFactory.sample.factory.Page;
import abstractFactory.sample.factory.Tray;

public class TableFactory extends Factory {
    @Override
    public Link createLink(final String caption, final String url) {
        return new TableLink(caption, url);
    }

    @Override
    public Tray createTray(final String caption) {
        return new TableTray(caption);
    }

    @Override
    public Page createPage(final String title, final String author) {
        return new TablePage(title, author);
    }
}
