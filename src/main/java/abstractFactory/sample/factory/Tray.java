package abstractFactory.sample.factory;

import java.util.ArrayList;

public abstract class Tray extends Item {
    protected ArrayList<Item> tray = new ArrayList();

    public Tray(final String caption) {
        super(caption);
    }

    public void add(final Item item) {
        tray.add(item);
    }
}
