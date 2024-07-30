import java.sql.SQLException;
import java.util.List;
import java.util.Scanner; 

public class LibraryManager {
    private Database database;

    public LibraryManager(Database database) {
        this.database = database;
    }

    public void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Book book = new Book(0, title, author, year);
        try {
            database.addBook(book);
            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewBooks() {
        try {
            List<Book> books = database.getBooks();
            for (Book book : books) {
                System.out.println(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Other methods for updating, and deleting books
}
