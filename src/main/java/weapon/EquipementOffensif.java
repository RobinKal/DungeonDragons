package weapon;

public class EquipementOffensif {
    private String type;
    private String nom;
    public Integer niveauAttaque;

    public EquipementOffensif(String type){
        if (type == "Arme" ){
            niveauAttaque = 10;
            nom = "Arme";
        } else if (type == "Sort") {
            niveauAttaque = 15;
            nom = "Sort";
        }
    }
    public EquipementOffensif(){

    }
    public String getNom(){
        return this.nom;
    }
}
