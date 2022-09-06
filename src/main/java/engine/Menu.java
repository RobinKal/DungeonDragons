package engine;

import com.sun.tools.javac.Main;
import personnage.Guerrier;
import personnage.Magicien;
import personnage.Personnage;

import java.sql.SQLException;
import java.util.Scanner;


public class Menu {
    Scanner myObj = new Scanner(System.in);
    public Personnage createPersonnage() throws SQLException {

        System.out.println("Enter character type ( 1 = Guerrier / 2 = Magicien) and name:");
        // Numerical input
        int type = myObj.nextInt();

        // String input
        String name = myObj.nextLine();

        // Create Character for user
        Personnage player1 = switch (type){
            case 1 -> new Guerrier(name);
            case 2 -> new Magicien(name);
            default -> null;
        };
        switch (type){
            case 1 -> DataBase.createDatabasePersonnage("Guerrier", name, 10, 10, "Arme", "Bouclier");
            case 2 -> DataBase.createDatabasePersonnage("Magicien", name, 6, 14, "Sort", "Philtre");
        }

        System.out.println(player1);
        return player1;
    }

    public boolean shouldRollDice() {
        System.out.println("Press Y to roll :");
        String ans = myObj.nextLine();
        return ans.equals("Y");
    }

    public int inputStartGame() {
        Scanner newGame = new Scanner(System.in);
        int startGame = newGame.nextInt();
        return startGame;
    }
}
