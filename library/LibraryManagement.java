package library;
import java.util.*;
public class LibraryManagement implements Borrowable {
     Map<Integer, Book> booksTracking = new HashMap<>();//hashmap to store books
     Map<Integer, Patron> patronTracking = new HashMap<>();//hashmap to store patrons

    public void addBook(String title, String author, int ISBN, int quantity) {//adding books
        if (booksTracking.containsKey(ISBN) && booksTracking.get(ISBN).getBookTitle().equals(title)) {//checking if book already exists and checking if current book name matches with existing book
            Book book = booksTracking.get(ISBN);
            book.setBookQuantity(book.getBookQuantity() + quantity);//if book already exists then updating the count
            System.out.println("Quantity updated.");
        }
        else if(booksTracking.containsKey(ISBN) && !booksTracking.get(ISBN).getBookTitle().equals(title)){
            System.out.println("Book with same ISBN already exists.");
        }
         else {//adding new books
            booksTracking.put(ISBN, new Book(title, author, ISBN, quantity));
            System.out.println("Book added successfully.");
        }
    }

    public void removeBook(int ISBN) {//removing books
        if (booksTracking.containsKey(ISBN)) {
            booksTracking.remove(ISBN);
            System.out.println("Book removed.");
        } else {//if book does not exist
            System.out.println("Book does not exist.");
        }
    }

    public void displayBooks() {//displaying books
        if (booksTracking.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : booksTracking.values()) {
                System.out.println("Book Details:");
                System.out.println("Title: " + book.getBookTitle());
                System.out.println("Author: " + book.getBookAuthor());
                System.out.println("ISBN: " + book.getBookISBN());
                System.out.println("Quantity: " + book.getBookQuantity());
                System.out.println();
                System.out.println();
            }
        }
    }

    public void addPatron(String name, int id) {//logic for adding patrons
        if (patronTracking.containsKey(id)) {//if patron already exists
            System.out.println("Patron already exists.");
        } else {//adding new patrons
            patronTracking.put(id, new Patron(name, id));
            System.out.println("Patron added successfully.");
        }
    }

    public void removePatron(int id) {//removing patrons
        if (patronTracking.containsKey(id)) {
            patronTracking.remove(id);
            System.out.println("Patron removed.");
        } else {
            System.out.println("Patron does not exist.");
        }
    }

    public void displayPatrons() {//displaying patrons
        if (patronTracking.isEmpty()) {
            System.out.println("No patrons found.");
        } else {
            for (Patron patron : patronTracking.values()) {
                System.out.println("Patron Name: " + patron.getPatronName());
                System.out.println("Patron ID: " + patron.getPatronId());
                patron.displayBooks();
            }
        }
    }

    public void borrowBook(int patronId, String patronName, int ISBN) {//borrowing books
        if (!booksTracking.containsKey(ISBN)) {
            System.out.println("Book not found.");
            return;
        }

        Book book = booksTracking.get(ISBN);
        if (book.getBookQuantity() == 0) {//condition to check if book is out of stock
            System.out.println(book.getBookTitle() + " is out of stock.");
            return;
        }

        book.setBookQuantity(book.getBookQuantity() - 1); 

        Patron patron = patronTracking.get(patronId);//if patron doesnot exists
        if (patron == null) {
            patron = new Patron(patronName, patronId);
            patronTracking.put(patronId, patron);
        }

        patron.addBook(book);//adding books to the patron books list
        System.out.println("Book borrowed successfully.");
    }

    public void returnBook(int patronId, int ISBN) {//returning books
        if (patronTracking.containsKey(patronId)) {//if patron exists
            Patron patron = patronTracking.get(patronId);
            patron.removeBook(ISBN);

            Book book = booksTracking.get(ISBN);
            if (book != null) {
                book.setBookQuantity(book.getBookQuantity() + 1);
            }

            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Patron not found.");
        }
    }
}