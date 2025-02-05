import library.*;
import java.util.*;
class Library {
    

    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();
        Scanner sc = new Scanner(System.in);
        int choice=0;
        
        do {
            //for user purpose
            System.out.println("Enter: ");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Add Patron");
            System.out.println("5. Remove Patron");
            System.out.println("6. Display Patrons");
            System.out.println("7. Borrow Book");
            System.out.println("8. Return Book");
            System.out.println("9. Exit");
            System.out.println("---------------------------");
            System.out.println();//spacing for clear format in terminal
            System.out.println();
            System.out.println();
            try {
                choice = sc.nextInt();//taking input from user
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please select valid choice.");
                break;
                
            }
            System.out.println("---------------------------");
            switch (choice) {
                
                case 1: {//adding books
                    System.out.println("Enter title, author, ISBN, and quantity:");
                    String title="",author="";
                    int ISBN=0,quantity=0;
                    try{
                        title = sc.next();
                        author = sc.next();
                        ISBN = sc.nextInt();
                        quantity = sc.nextInt();
                    }
                    catch(InputMismatchException e){
                        System.out.println("please enter the input in correct format");
                        break;
                    }
                    
                        library.addBook(title, author, ISBN, quantity);
                        break;
                
                }
                case 2: {//removing books
                    System.out.println("Enter ISBN of book to be removed:");
                    int ISBN=0;
                    try{
                     ISBN = sc.nextInt();
                    }
                    catch(InputMismatchException e){
                        System.out.println("please enter the input in correct format");
                    }
                    library.removeBook(ISBN);
                    break;
                }
                case 3: {//displaying books
                    library.displayBooks();
                    break;
                }
                case 4: {//adding patrons
                    System.out.println("Enter patron name and ID:");
                    String name="";
                    int id=0;
                    try{
                     name = sc.next();
                     id = sc.nextInt();
                    }catch(InputMismatchException e){
                        System.out.println("please enter the input in correct format");
                    }
                    library.addPatron(name, id);
                    break;
                }
                case 5: {//removing patrons
                    System.out.println("Enter patron ID to be removed:");
                    int id=0;
                    try{
                     id = sc.nextInt();
                    }
                    catch(InputMismatchException e){
                        System.out.println("please enter the input in correct format");
                    }
                    library.removePatron(id);
                    break;
                }
                case 6: {//displaying patrons
                    library.displayPatrons();
                    break;
                }
                case 7: {//borrowing books
                    System.out.println("Enter patron ID, patron name, and ISBN of book to borrow:");
                    int patronId=0,ISBN=0;
                    String patronName="";
                    try{
                     patronId = sc.nextInt();
                     patronName = sc.next();
                     ISBN = sc.nextInt();
                    }
                    catch(InputMismatchException e){
                        System.out.println("please enter the input in correct format");
                    }
                    library.borrowBook(patronId, patronName, ISBN);
                    break;
                }
                case 8: {//returning books
                    System.out.println("Enter patron ID and ISBN of book to return:");
                    int patronId=0,ISBN=0;
                    try{
                     patronId = sc.nextInt();
                     ISBN = sc.nextInt();
                    }
                    catch(InputMismatchException e){
                        System.out.println("please enter the input in correct format");
                    }
                    library.returnBook(patronId, ISBN);
                    break;
                }
                case 9: {//exiting
                   
                    break;
                }
                case 10:{//Handling invalid input
                    System.out.println("Please a valid number between 1-9");
                    continue;
                }
            }
            System.out.println("---------------------------");
        } while (choice != 9);
    }
}
