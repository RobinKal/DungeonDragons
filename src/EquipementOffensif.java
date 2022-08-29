public class EquipementOffensif {
    String type;
    String nom;
    Integer niveauAttaque;

    EquipementOffensif(String type){
        if (type == "Arme" ){
            niveauAttaque = 10;
            nom = "Arme";
        } else if (type == "Sort") {
            niveauAttaque = 15;
            nom = "Sort";
        }
    }
    public String getNom(){
        return this.nom;
    }
}
