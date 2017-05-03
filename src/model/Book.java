package model;

/**
 * Created by iliesalinadenisa on 25/04/2017.
 */
public class Book {
    private String title;
    private String author;
    private String gendre;
    private int quantity;
    private int price;

    public Book(String title, String author, String gendre, int quantity, int price) {
        this.title = title;
        this.author = author;
        this.gendre = gendre;
        this.quantity = quantity;
        this.price = price;
    }

    public Book (){
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGendre() {
        return gendre;
    }

    public void setGendre(String gendre) {
        this.gendre = gendre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", gendre='" + gendre + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
