package iterator.sample;

public class BookShelfIterator implements Iterator<Book> {
    private final BookShelf bookShelf;
    private int index;

    public BookShelfIterator(final BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book next() {
        final Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
