package brain.models;

public class ClsCoiffure {
    
    private int id ;
    private String modele;
    private String typeItem;
    private float montant ;

    public ClsCoiffure(int id, String modele, String typeItem, float montant) {
        this.id = id;
        this.modele = modele;
        this.typeItem = typeItem;
        this.montant = montant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getTypeItem() {
        return typeItem;
    }

    public void setTypeItem(String typeItem) {
        this.typeItem = typeItem;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }
    
}
