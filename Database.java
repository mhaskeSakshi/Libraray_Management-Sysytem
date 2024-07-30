import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private Connection connection;

    public Database(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public void addBook(Book book) throws SQLException {
        String query = "INSERT INTO books (title, author, year) VALUES (?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, book.getTitle());
        stmt.setString(2, book.getAuthor());
        stmt.setInt(3, book.getYear());
        stmt.executeUpdate();
    }

    public List<Book> getBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Book book = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getInt("year"));
            books.add(book);
        }
        return books;
    }

    // Other methods for updating, and deleting books
}
