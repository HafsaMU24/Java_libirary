*Sammanfattning: 
Programmet är ett bibliotekssystem där användare kan se och låna böcker, och administratörer kan hantera böcker via en MySQL-databas. 

 1. Start av programmet (Main)
Main.java kör ConsoleView.showMenu() för att visa huvudmenyn.
ConsoleView hanterar användarinteraktioner.

3. Användarmenyn (ConsoleView)
Användaren får välja mellan olika alternativ:
Visa alla användare → Hämtar alla användare från databasen via UserDAO.getAllUsers().
Visa alla böcker → Hämtar alla böcker från databasen via BookDAO.getAllBooks().
Låna en bok →
Användaren anger sitt namn och bokens ID.
LoanDAO.addLoan() registrerar lånet i databasen.
Admin-inloggning →
Användaren anger admin-namn och lösenord.
Om inloggningen lyckas, får admin välja:
Lägga till en bok → Admin.addBook()
Ta bort en bok → Admin.removeBook()
Avsluta programmet → Programmet stängs.

3. Hur databasen används (DAO-klasser):
Användarhantering (UserDAO)
Hämtar alla användare (getAllUsers()).
Lägger till en ny användare (addUser()).
Bokhantering (BookDAO)
Hämtar alla böcker (getAllBooks()).
Lägger till en ny bok (addBook()).
Tar bort en bok (removeBook()).
Lån (LoanDAO)
Hämtar alla lån (getAllLoans()).
Lägger till ett nytt lån (addLoan()).

5. Hur databasen är uppbyggd:
Programmet använder en MySQL-databas (library) med följande tabeller:
users (id, name, password, role)
books (id, title, author, available)
loans (id, user_name, book_id, loan_date, return_date)
När en användare lånar en bok:
En ny rad läggs till i loans.
Bokens tillgänglighet (available) kan uppdateras om du vill.

5. Viktiga funktioner i koden:
Database.getConnection() → Skapar en anslutning till databasen.
try-with-resources → Säkerställer att anslutningar stängs efter användning.
SQLException hantering → Visar felmeddelanden om databasen har problem.
