import java.util.Objects;
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
        Personnage player1;
        if (name.equals("")) {
            player1 = new Personnage(type, "Player1");
        } else {
            player1 = new Personnage(type, name);
        }

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

    public Boolean rollDice() {
        Boolean shouldRoll;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Press Y to roll :");
        String ans = myObj.nextLine();
        if (Objects.equals(ans, "Y")) {
            shouldRoll = true;
        } else {
            shouldRoll = false;
        }
        return shouldRoll;
    }

    public int inputStartGame() {
        Scanner newGame = new Scanner(System.in);
        int startGame = newGame.nextInt();
        return startGame;
    }
}
