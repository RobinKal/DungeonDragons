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

    public Integer getNiveauDeVie() {
        return niveauDeVie;
    }

    public void addHealth(int health){
        this.niveauDeVie += health;
    }
}
