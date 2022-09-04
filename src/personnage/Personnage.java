package personnage;

import weapon.*;

import java.util.Scanner;

public abstract class Personnage {
    Scanner myObj = new Scanner(System.in);
    Integer type;
    String nom;
    Integer niveauDeVie;
    Integer forceDattaque;
    EquipementOffensif weapon;
    EquipementDefensif defWeapon;

    public Personnage(Integer type, String nom) {
        this.nom = nom;
        this.type = type;
        if (type == 1) {
            niveauDeVie = 10;
            forceDattaque = 10;
            weapon = new Arme("Arme");
            defWeapon = new Bouclier("Bouclier");
        } else if (type == 2) {
            niveauDeVie = 6;
            forceDattaque = 15;
            weapon = new Sort("Sort");
            defWeapon = new Philtre("Philtre");

        }
    }

    Personnage(String nom) {
        this.nom = nom;
    }

    public Personnage() {
    }

    public String toString(){
        return "Personnage: " + nom + ", Niveau de Vie: " + niveauDeVie + ", Force d'attaque: " + forceDattaque + ", Arme: " + weapon.getNom() + ", Defensif: " + defWeapon.getNom();
    }

    public void setNom() {
       if (this.nom.equals("Player1")){
           System.out.println("Enter character name : ");
           this.nom = myObj.nextLine();
           System.out.println(this.toString());
       }
    }
}
