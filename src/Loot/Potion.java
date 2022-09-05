package Loot;

import lalala.Case;
import personnage.Personnage;

public class Potion implements Case {
    Integer healingPower = 0;

    public Potion(Integer healing) {
        this.healingPower = healing;
    }

    Potion() {
    }

    @Override
    public void interaction(Personnage player) {
        player.addHealth(healingPower);
        System.out.println("You found a Potion ! Your HP goes up by : " + this.healingPower + ". You now have : " + player.getNiveauDeVie());
    }
}
