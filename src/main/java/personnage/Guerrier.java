package personnage;

import weapon.Arme;
import weapon.Bouclier;

public class Guerrier extends Personnage {
    public Guerrier(String name){
        super(name);
        niveauDeVie = 10;
        forceDattaque = 10;
        weapon = new Arme("Arme");
        defWeapon = new Bouclier("Bouclier");
    }
}
