package iterator.sample;

import java.util.ArrayList;

public class BookShelf implements Aggregate<Book> {
    private final ArrayList<Book> books;

    public BookShelf(final int initialSize) {
        this.books = new ArrayList(initialSize);
    }

    public Book getBookAt(final int index) {
        return books.get(index);
    }

    public void appendBook(final Book book) {
        books.add(book);
    }

    public int getLength() {
        return books.size();
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
