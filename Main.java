import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Database database = new Database("jdbc:mysql://localhost:3306/Libraray_Mangement_System", "root", "root");

            LibraryManager manager = new LibraryManager(database);
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("Choose an option:");
                System.out.println("1. Add Book");
                System.out.println("2. View Books");
                System.out.println("3. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        manager.addBook();
                        break;
                    case 2:
                        manager.viewBooks();
                        break;
                    case 3:
                        running = false; // Exit the loop
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

            scanner.close(); // Close the scanner
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
