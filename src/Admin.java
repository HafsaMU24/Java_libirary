
public class Admin extends User {

    public Admin (int id, String name, String password){
        super(id, name, password, "Admin");
    }

   public void addBook(String title,String author) {
        try{
            BookDAO bookDAO = new BookDAO();
            bookDAO.addBook(title, author);
            System.out.println("Boken har lagts till: " + title + "av " + author);
        } catch (Exception e) {
            System.out.println("Fel vid tilläg av book: " + e.getMessage());
        }
   }

    public void removeBook(int bookId) {
        try{
            BookDAO bookDAO = new BookDAO();
            bookDAO.removeBook(bookId);
            System.out.println("Boken med ID " + bookId + " har tagits bort.");
        } catch (Exception e) {
            System.out.println("Fel vid borttagning av bok: " + e.getMessage());
        }
    }
}