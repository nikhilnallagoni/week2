package library;
import java.util.*;
import library.PatronBooksDetails;
public class Patron {
    private String name;
    private int id;
    private ArrayList<PatronBooksDetails> books = new ArrayList<>();

    Patron(String name, int id) {//constructor for patro
        this.name = name;
        this.id = id;
    }

    public String getPatronName() { //getter for patron name
        return this.name; 
    }
    public int getPatronId() { //getter for patron id
        return this.id; 
    }

    public void addBook(Book book) {//adding books borrowed by patrons
        PatronBooksDetails bookDetails = new PatronBooksDetails(book.getBookTitle(),book.getBookISBN());
        books.add(bookDetails);
    }

    public void removeBook(int ISBN) {//removing books borrowed by patrons
        books.removeIf(book -> book.getPatronBookISBN() == ISBN);
    }

    public void displayBooks() {//displaying books borrowed by patrons
        if (books.isEmpty()) {
            System.out.println("No books borrowed.");
        } else {
            try{
            for (PatronBooksDetails book : books) {
                System.out.println("Book Name: " + book.getPatronBookName());
                System.out.println("ISBN: " + book.getPatronBookISBN());
            }
            }
            catch(NullPointerException e){
                System.out.println("Error in displaying books");
            }
        }
    }
}
