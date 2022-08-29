import java.util.Scanner;

public class Personnage {
    Scanner myObj = new Scanner(System.in);
    Integer type;
    String nom;
    Integer niveauDeVie;
    Integer forceDattaque;
    EquipementOffensif weapon;
    EquipementDefensif defWeapon;

    Personnage(Integer type, String nom) {
        this.nom = nom;
        this.type = type;
        if (type == 1) {
            niveauDeVie = 10;
            forceDattaque = 10;
            weapon = new EquipementOffensif("Arme");
            defWeapon = new EquipementDefensif("Bouclier");
        } else if (type == 2) {
            niveauDeVie = 6;
            forceDattaque = 15;
            weapon = new EquipementOffensif("Sort");
            defWeapon = new EquipementDefensif("Philtre");

        }
    }

    Personnage(String nom) {
        this.nom = nom;
    }

    Personnage() {
    }

    public String toString(){
        return "Personnage: " + nom + ", Niveau de Vie: " + niveauDeVie + ", Force d'attaque: " + forceDattaque + ", Arme: " + weapon.nom + ", Defensif: " + defWeapon.nom;
    }

    public void setNom() {
       if (this.nom.equals("Player1")){
           System.out.println("Enter character name : ");
           this.nom = myObj.nextLine();
           System.out.println(this.toString());
       }
    }
}
