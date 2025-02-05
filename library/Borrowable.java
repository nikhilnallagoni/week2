package library;
interface Borrowable {//interface for borrowing and returning books
    public void borrowBook(int patronId, String patronName, int ISBN);
    public void returnBook(int patronId, int ISBN);
}