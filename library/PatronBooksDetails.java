package library;
class PatronBooksDetails{//class for maintaing details of books borrowed by patrons
    private String BookName;
    private int ISBN;
    PatronBooksDetails(String BookName, int ISBN){
        this.BookName = BookName;
        this.ISBN = ISBN;
    }
    public String getPatronBookName(){
        return this.BookName;
    }
    public int getPatronBookISBN(){
        return this.ISBN;
    }
}