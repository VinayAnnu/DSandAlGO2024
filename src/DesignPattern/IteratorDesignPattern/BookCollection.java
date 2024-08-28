package DesignPattern.IteratorDesignPattern;

import java.util.List;

public class BookCollection implements Library {
    List<Book> listOfBook;

    public BookCollection(List<Book> listOfBook) {
        this.listOfBook = listOfBook;
    }

    @Override
    public Iterator iterator() {
        return new BookIterator(listOfBook);
    }
}
