package weapon;

public class EquipementDefensif {
    private String type;
    private String nom;
    public Integer niveauDefense;

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
