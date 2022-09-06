package engine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase {
    private static Connection connection;

    public static void openDatabaseConnection() throws SQLException {
        System.out.println("Connecting to the DB...");
        connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/DunDra",
                "root", "987"
        );
        System.out.println("Connection valid: status: " + connection.isValid(5));
    }

    public static void closeDatabaseConnection() throws SQLException {
        System.out.println("Closing database connection...");
        connection.close();
        System.out.println("Connection status: " + connection.isValid(5));
    }

    public static void createDatabasePersonnage(String type, String name, int niveauVie, int niveauForce, String weapon, String defWeapon) throws SQLException {
        System.out.println("Creating data...");
        int rowsInserted;
        try (PreparedStatement statement = connection.prepareStatement("""
                INSERT INTO Hero(type, name, niveauVie, niveauForce, weapon, defWeapon)
                VALUES (?, ?, ?, ?, ?, ?)
                """)) {
            statement.setString(1, type);
            statement.setString(2, name);
            statement.setInt(3, niveauVie);
            statement.setInt(4, niveauForce);
            statement.setString(5, weapon);
            statement.setString(6, defWeapon);
            rowsInserted = statement.executeUpdate();
        }
        System.out.println("Number of rows added : " + rowsInserted);
    }

    public static void deleteDatabasePersonnage() throws SQLException {
        System.out.println("Deleting data...");
        try (PreparedStatement statement = connection.prepareStatement("""
                DELETE FROM Hero
                """)) {
            int rowsDeleted = statement.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
        }
    }
}
