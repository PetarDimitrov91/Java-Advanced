package Book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book first, Book second) {
        if (first.getTitle().compareTo(second.getTitle()) == 0) {
            if (first.getYear() > second.getYear()) {
                return 1;
            } else if (first.getYear() < second.getYear()) {
                return -1;
            }
            return 0;
        } else {
            return first.getTitle().compareTo(second.getTitle());
        }
    }

}
