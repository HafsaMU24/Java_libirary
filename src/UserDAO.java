import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";

       try (Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet re = stmt.executeQuery(query)){

            while(re.next()) {
                users.add(new User(
                        re.getInt("id"),
                        re.getString("name"),
                        re.getString("password"),
                    re.getString("role")));
            }
         }
        return users;
    }

    public void addUser(String name, String password, String role) throws SQLException {
        String query = "INSERT INTO users (name, password, role) VALUES (?,?,?)";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.setString(3,role);
            stmt.executeUpdate();
        }
    }
}
