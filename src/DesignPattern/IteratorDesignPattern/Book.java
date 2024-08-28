package DesignPattern.IteratorDesignPattern;

public class Book {
    int price;
    String name;

    public Book(int price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
