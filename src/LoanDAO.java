import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanDAO {
    public List<Loan> getAllLoans() throws SQLException {
        List<Loan> loans = new ArrayList<>();
        String query = "SELECT * FROM loans";

        try (Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet re = stmt.executeQuery(query)){


            while(re.next()){
                loans.add(new Loan(
                        re.getInt("id"),
                        re.getString("user_name"),
                        re.getInt("book_id"),
                        re.getDate("loan_date"),
                        re.getDate("return_date")));
             }
         }
            return loans;
        }

        public void addLoan(String userName,int bookId) throws SQLException {
        String query = "INSERT INTO loans (user_name, book_id, loan_date) VALUES (?,?, NOW())";

        try(Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1,userName);
            stmt.setInt(2, bookId);
            stmt.executeUpdate();
            System.out.println("Lån registrerat för användare: " + userName);

          }catch (SQLException e) {
            System.out.println("Fel vid lånrgistrering: " + e.getMessage());
        }
        }
    }



