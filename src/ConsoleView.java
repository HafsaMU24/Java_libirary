import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private static UserDAO userDAO = new UserDAO();
    private static BookDAO bookDAO = new BookDAO();
    private static LoanDAO loanDAO = new LoanDAO();
    private Scanner sc = new Scanner(System.in);

    public  void showMenu() {

        while(true){
            System.out.println("\nBibliotekshantering");
            System.out.println("1. Visa alla användare");
            System.out.println("2. Visa alla böcker");
            System.out.println("3. Låna en bok");
            System.out.println("4.Admin_inloggning");
            System.out.println("5. Avsluta");
            System.out.print("Välj ett alternativ: ");

         int choice = sc.nextInt();
          sc.nextLine(); // Konsumera newline

            try {
                switch (choice) {
                    case 1:
                        List<User> users = userDAO.getAllUsers();
                        users.forEach(u -> System.out.println(u.getId() + ". " + u.getName() + " - " + u.getRole()));
                        break;
                    case 2:
                        List<Book> books = bookDAO.getAllBooks();
                        books.forEach(b -> System.out.println(b.getId() + ". " + b.getTitle() + " av " + b.getAuthor()));
                        break;
                    case 3:
                        System.out.print("Ange ditt namn: ");
                        String userName = sc.nextLine();
                        System.out.print("Ange bok-ID: ");
                        int bookId = sc.nextInt();
                        sc.nextLine();
                        loanDAO.addLoan(userName, bookId);
                        System.out.println("Bok lånad framgångsrikt!");
                        break;
                    case 4:
                        System.out.print("Ange admin-användarnamn: ");
                        String adminName = sc.nextLine();
                        System.out.print("Ange lösenord: ");
                        String password = sc.nextLine();

                        // Hämta admin från databasen
                        List<User> allUsers = userDAO.getAllUsers();
                        boolean isAdmin = false;
                        Admin admin = null;

                        for (User u : allUsers) {
                            if (u.getName().equals(adminName) && u.getPassword().equals(password) && u.getRole().equals("Admin")) {
                                admin = new Admin(u.getId(), u.getName(), u.getPassword());
                                isAdmin = true;
                                break;
                            }
                         }
                        if(isAdmin && admin != null ) {
                            System.out.println("Inloggad som admin");
                            System.out.println("1. Lägg till en bok");
                            System.out.println("2. Ta bort en bok");
                            int adminChoice = sc.nextInt();
                            sc.nextLine();

                            if (adminChoice == 1) {
                                System.out.print("Ange boktitel: ");
                                String title = sc.nextLine();
                                System.out.print("Ange författare: ");
                                String author = sc.nextLine();
                                admin.addBook(title, author);
                                System.out.println("Bok tillagd!");
                            } else if (adminChoice == 2) {
                                System.out.print("Ange bok-ID att ta bort: ");
                                int removeBookId = sc.nextInt();
                                sc.nextLine();
                                admin.removeBook(removeBookId);
                                System.out.println("Bok borttage!");
                            } else {
                                System.out.println("Ogiltigt val, försök igen.");
                            }
                           }else{
                            System.out.println("Felaktiga inloggningsuppgifter");
                            }
                        break;
                    case 5:
                        System.out.println("Avslutar!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Ogiltigt val, försök igen.");
                }
            } catch (SQLException e) {
        System.out.println("Fel vid databasoperation: " + e.getMessage());
            }
        }
      }
   }


