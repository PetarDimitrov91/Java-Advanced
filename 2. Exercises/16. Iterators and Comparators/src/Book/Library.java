package Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Library<Book> implements Iterable<Book> {
    List<Book> books;


    @SafeVarargs
    public Library(Book... book) {
        books = new ArrayList<>();
        books = Arrays.asList(book);
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }

    private final class LibraryIterator implements Iterator<Book> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return books.size() > this.counter;
        }

        @Override
        public Book next(){
            return books.get(this.counter++);
        }
    }
}
