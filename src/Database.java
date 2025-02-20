import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String url = "jdbc:mysql://localhost:3306/libirary";
    private static final String user = "root";
    private static final String password = "Mohammad43";


public static Connection getConnection() throws SQLException {
   Connection conn = DriverManager.getConnection(url,user,password);
   return  conn;
    }
}