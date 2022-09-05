package personnage;

import weapon.Philtre;
import weapon.Sort;

public class Magicien extends Personnage {
    public Magicien(String name){
        super(name);
        niveauDeVie = 6;
        forceDattaque = 15;
        weapon = new Sort("Sort");
        defWeapon = new Philtre("Philtre");
    }
}
