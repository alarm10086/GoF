package abstractFactory.sample.factory;

public abstract class Link extends Item {
    protected String url;

    public Link(final String caption, final String url) {
        super(caption);
        this.url = url;
    }
}
