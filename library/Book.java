package library;
import java.util.*;
public class Book {// Book class to store book details
    private String title;
    private String author;
    private int ISBN;
    private int quantity;

    public Book(String title, String author, int ISBN, int quantity) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.quantity = quantity;
    }

    public String getBookTitle() { // getting title of book
        return this.title; 
    }
    public String getBookAuthor() { // getting author of book
        return this.author; 
    }
    public int getBookISBN() { // getting ISBN of book
        return this.ISBN; 
    }
    public int getBookQuantity() { // getting quantity of book
        return this.quantity; 
    }
    public Book getBookById(int ISBN){// getting book by ISBN
        if(this.ISBN == ISBN){
            return this;
        }
        return null;
    }
    public void setBookQuantity(int quantity) { // set quantity of book
        this.quantity = quantity; 
    }
}