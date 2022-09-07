package engine;

import java.sql.*;

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

    public static void readData() throws SQLException {
        System.out.println("Reading data...");
        try (PreparedStatement statement = connection.prepareStatement("""
                SELECT * FROM Hero
                """)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String type = resultSet.getString(2);
                String name = resultSet.getString(3);
                int niveauVie = resultSet.getInt(4);
                int niveauForce = resultSet.getInt(5);
                String weapon = resultSet.getString(6);
                String defWeapon = resultSet.getString(7);
                System.out.println("Personnage -> " + name + " / Type: " + type + " / HP: " + niveauVie + " / Force: " + niveauForce + " / Compétence: " + weapon + " / Defense: " + defWeapon);
            }
            System.out.println("Data reading done.");
        }

    }
}
