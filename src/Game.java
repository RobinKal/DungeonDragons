import personnage.Personnage;

import java.util.concurrent.ThreadLocalRandom;
import personnage.Personnage;

public class Game {
    Boolean gameHasStarted = false;
    static Integer position;


    public static void main(String[] args) {
        Game game = new Game();
        Menu menu = new Menu();
        Personnage player = menu.createPersonnage();
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

    public static void controle(int pos) throws PersonnageHorsPlateauException {
        if (pos > 64)
            throw new PersonnageHorsPlateauException("You are out of board");
    }

    public void rollDice() {
        try {
            controle(position);
        }catch (PersonnageHorsPlateauException e) {
            System.out.println("You are out of board :" + position);
        }
            if (position < 64) {
                int randomNum = ThreadLocalRandom.current().nextInt(1, 6 + 1);
                int lastPos = position;
                position += randomNum;
                System.out.println("Your position was: " + lastPos + " . You rolled a: " + randomNum + " and moved to: " + position);
            }else if (position == 64){
                System.out.println("You WON!");
            }
        }

    }



