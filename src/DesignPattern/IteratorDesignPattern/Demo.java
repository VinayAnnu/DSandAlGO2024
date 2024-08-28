package DesignPattern.IteratorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Book> listOfBook = new ArrayList<>();
        Book b1 = new Book(123,"abc");
        Book b2 = new Book(456,"def");
        Book b3 = new Book(789,"ghi");
        Book b4 = new Book(543,"jkl");
        Book b5 = new Book(215,"mno");
        listOfBook.add(b1);listOfBook.add(b2);listOfBook.add(b3);listOfBook.add(b4);listOfBook.add(b5);
        Library library = new BookCollection(listOfBook);

        Iterator itr = library.iterator();
        while (itr.hasNext()){
            Book b = (Book) itr.next();
            System.out.println(b);
        }
    }
}
