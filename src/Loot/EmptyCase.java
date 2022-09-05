package Loot;

import lalala.Case;
import personnage.Personnage;

public class EmptyCase implements Case {

    public EmptyCase() {
    }

    @Override
    public void interaction(Personnage player) {
        System.out.println("This is an empty case");
    }
}
