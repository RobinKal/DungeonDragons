package engine;

import Loot.BigPotion;
import Loot.EmptyCase;
import Loot.SmallPotion;
import lalala.Case;
import personnage.Personnage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private List<Case> plateau = new ArrayList<>();
    GameState state = GameState.CREATION;
    Menu menu = new Menu();
    Scanner sc = new Scanner(System.in);
    Integer position;
    private Personnage player;

    public void setPlateau() {

        int maxSize = 63;
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

    public void start() {
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
                    while (menu.shouldRollDice()) {
                        this.rollDice();
                    }
                    this.state = GameState.FIN;
                    break;
                case FIN:
                    jeuFini = this.fin();
                    break;
            }
        }
    }

    public void startGame() {
        position = 1;
    }

    public void controle(int pos) throws PersonnageHorsPlateauException {
        if (pos > 64)
            throw new PersonnageHorsPlateauException("You are out of board");
    }

    public void rollDice() {
        try {
            this.controle(this.position);
        } catch (PersonnageHorsPlateauException e) {
            System.out.println("You are out of board :" + this.position);
        }
        if (this.position < 64) {
            int randomNum = 1;
//            int randomNum = ThreadLocalRandom.current().nextInt(1, 6 + 1);
            int lastPos = position;
            this.position += randomNum;
            System.out.println("Your position was: " + lastPos + " . You rolled a: " + randomNum + " and moved to: " + position + "/64");
            plateau.get(position).interaction(this.player);
        }
        if (this.position == 64) {
            System.out.println("You WON!");
            this.state = GameState.FIN;
        }
    }

    public boolean fin() {
        boolean result = false;
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