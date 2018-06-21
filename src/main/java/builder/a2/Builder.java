package builder.a2;

public abstract class Builder {
    private boolean initialized = false;

    public void makeTitle(final String title) {
        if (!initialized) {
            buildTitle(title);
            initialized = true;
        }
    }

    public void makeString(final String str) {
        if (initialized) {
            buildString(str);
        }
    }

    public void makeItems(final String[] items) {
        if (initialized) {
            buildItems(items);
        }
    }

    public void close() {
        if (initialized) {
            buildDone();
        }
    }

    protected abstract void buildTitle(String title);

    protected abstract void buildString(String str);

    protected abstract void buildItems(String[] items);

    protected abstract void buildDone();
}
