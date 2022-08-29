public class EquipementDefensif {
    String type;
    String nom;
    Integer niveauDefense;

    EquipementDefensif(String type){
        if (type == "Bouclier" ){
            niveauDefense = 10;
            nom = "Bouclier";
        } else if (type == "Philtre") {
            niveauDefense = 15;
            nom = "Philtre";
        }
    }
}
