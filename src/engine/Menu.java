package engine;

import personnage.Guerrier;
import personnage.Magicien;
import personnage.Personnage;

import java.util.Scanner;


public class Menu {
    Scanner myObj = new Scanner(System.in);
    public Personnage createPersonnage() {

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

        // Output input by user
//        System.out.println("User's choice - Name: " + name);
//        System.out.println("User's choice - Type: " + type);
//        System.out.println("Created - Name: " + player1.nom);
//        System.out.println("Created - niveauDeVie: " + player1.niveauDeVie);
//        System.out.println("Created - Type: " + player1.type);
//        System.out.println("Created - forceDattaque: " + player1.forceDattaque);
//        System.out.println("Created - Weapon: " + player1.weapon.nom);
//        System.out.println("Created - Defensive: " + player1.defWeapon.nom);

        System.out.println(player1.toString());

        return player1;
    }

    public boolean shouldRollDice() {
        boolean shouldRoll;
        System.out.println("Press Y to roll :");
        String ans = myObj.nextLine();
        shouldRoll = ans.equals("Y");
        return shouldRoll;
    }

    public int inputStartGame() {
        Scanner newGame = new Scanner(System.in);
        int startGame = newGame.nextInt();
        return startGame;
    }
}
