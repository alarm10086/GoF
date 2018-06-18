package factoryMethod.sample.framework;

public abstract class Factory {
    public final Product create(final String owner) {
        final Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    protected abstract Product createProduct(String owner);

    protected abstract void registerProduct(Product product);
}
