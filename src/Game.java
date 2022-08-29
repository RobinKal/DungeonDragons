import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    Boolean gameHasStarted = false;
    Integer position;


    public static void main(String[] args) {
        Game game = new Game();
        Personnage player = new Personnage();
        Menu menu = new Menu();
        player = menu.createPersonnage();
        player.setNom();
        game.startGame();
        while (menu.rollDice()){
            game.rollDice();
        }
    }

    public int startGame() {
        if (!gameHasStarted) {
            gameHasStarted = true;
        }
        return position = 1;
    }

    public void rollDice() {
        if (position <= 64) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 6 + 1);
            int lastPos = position;
            position += randomNum;
            System.out.println("Your position was: " + lastPos + " . You rolled a: " + randomNum + " and moved to: " + position);
        }else {
            System.out.println("You got to the 64th position");
        }

    }


}
