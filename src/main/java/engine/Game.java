package engine;

import Loot.BigPotion;
import Loot.EmptyCase;
import Loot.SmallPotion;
import lalala.Case;
import personnage.Personnage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The class {@link engine.Game} is managing the game process and it states.
 */
public class Game {
    private final List<Case> plateau = new ArrayList<>();
    private GameState state = GameState.CREATION;
    private Menu menu = new Menu();
    private Scanner sc = new Scanner(System.in);
    private Integer position;
    private Personnage player;

    /**
     * Randomize to spread events through the board. Set maxSize to suit your board size.
     * One of the firsts methods to be called when initializing the game.
     */
    public void setPlateau() {

        int maxSize = 64;
        while (plateau.size() < maxSize) {
            Random rdm = new Random();
            int rdmcase = rdm.nextInt(3);
            switch (rdmcase) {
                case 0 -> plateau.add(new EmptyCase());
                case 1 -> plateau.add(new BigPotion());
                case 2 -> plateau.add(new SmallPotion());
            }
        }
    }

    /**
     * <p>
     * Make a boolean that will last the whole game, to know if the game is over or not and manage game states.
     * The method purpose is to manage game states, it is the core of our game, calling everything the game needs to run smoothly.
     * As long as our boolean is false, the game will keep going, going state to state until the boolean change to true on the last case and method "FIN".
     * </p><p>
     * The first case is mainly to initialize our character, choose which character type the user wants and his name. Then it initialize the board and changes the state of the game to "JEU".
     * The "JEU" case is the main state of the game, it will ask the user if he wants to roll the dice and then interact with the next position's loot/encounter.
     * </p><p>
     * Once the while loop is over, the state will change to "FIN" and ask if the user want's to play again or quit the game.
     * </p>
     */

    public void start() throws SQLException {
        boolean jeuFini = false;
        while (!jeuFini) {
            switch (this.state) {
                case CREATION:
                    player = menu.createPersonnage();
                    player.setNom();
                    setPlateau();
                    this.state = GameState.JEU;
                    break;
                case JEU:
                    this.startGame();
                    while (this.position < 64 && menu.shouldRollDice()) {
                        this.rollDice();
                    }
                    this.state = GameState.FIN;
                    break;
                case FIN:
                    DataBase.deleteDatabasePersonnage();
                    jeuFini = this.fin();
                    break;
            }
        }
    }

    /**
     * Method to initialize the position of the player
     */
    public void startGame() {
        position = 1;
    }

    /**
     * Throws an exception if the position of the player is higher than the board itself.
     * @param pos position of the user.
     * @throws PersonnageHorsPlateauException exception to handle out of bounds.
     */
    public void controle(int pos) throws PersonnageHorsPlateauException {
        if (pos > 64) throw new PersonnageHorsPlateauException("You are out of board");
    }

    /**
     * Method to try and catch an exception if the position is out of bounds, manage dice roll's, player's position and interact with encounters/loot.
     */
    public void rollDice() {
        try {
            this.controle(this.position);
        } catch (PersonnageHorsPlateauException e) {
            System.out.println("You are out of board :" + this.position);
        }
        if (this.position < 64) {
//            int randomNum = 1;
            int randomNum = ThreadLocalRandom.current().nextInt(1, 6 + 1);
            int lastPos = position;
            this.position += randomNum;
            System.out.println("Your position was: " + lastPos + " . You rolled a: " + randomNum + " and moved to: " + position + "/64");
            if (this.position < 64){
                plateau.get(position).interaction(this.player);
            }else if (this.position == 64) {
                System.out.println("You WON!");
                this.state = GameState.FIN;
            }
        }

    }

    /**
     * Method that ends the game and ask if the user wants to play again (it will then change the state of the game to the first one "CREATION") or close the game.
     * @return boolean True if the game needs to close, false if the user wants to play again.
     */
    public boolean fin() {
        boolean result;
        System.out.println("rejouer?");
        String replay = this.sc.nextLine();
        switch (replay) {
            case "yes":
                result = false;
                this.state = GameState.CREATION;
                break;
            default:
                result = true;
        }
        return result;
    }
}