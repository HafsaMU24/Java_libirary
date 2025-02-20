import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books";

        try (Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet re = stmt.executeQuery(query)){

            while (re.next()) {
                books.add(new Book(
                        re.getInt("id"),
                        re.getString("title"),
                        re.getString("author"),
                        (re.getBoolean("available") ? "Ja" : "Nej")));
            }
        }
        return books;

    }

    public void addBook(String title, String author) throws SQLException {
        String query = " INSERT INTO books (title, author, available) VALUES (?,?,TRUE)";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.executeUpdate();
        }
    }

    public void removeBook(int bookId) throws SQLException {
        String query = "DELETE FROM books WHERE id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, bookId);
            stmt.executeUpdate();
        }
    }
}


