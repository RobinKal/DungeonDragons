package weapon;

public class EquipementDefensif {
    String type;
    String nom;
    Integer niveauDefense;

    public EquipementDefensif(String type){
        if (type == "Bouclier" ){
            niveauDefense = 10;
            nom = "Bouclier";
        } else if (type == "Philtre") {
            niveauDefense = 15;
            nom = "Philtre";
        }
    }

    public EquipementDefensif(){}
    public String getNom(){
        return this.nom;
    }
}
