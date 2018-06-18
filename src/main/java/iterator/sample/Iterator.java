package iterator.sample;

public interface Iterator<T> {
    public abstract boolean hasNext();

    public abstract T next();
}
