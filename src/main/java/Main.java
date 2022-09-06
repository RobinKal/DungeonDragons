import engine.DataBase;
import engine.Game;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataBase.openDatabaseConnection();
        Game engine = new Game();
        engine.start();
       DataBase.closeDatabaseConnection();
    }
}