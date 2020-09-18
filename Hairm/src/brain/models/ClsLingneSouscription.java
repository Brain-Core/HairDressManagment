package brain.models;

public class ClsLingneSouscription {
    
    private ClsSouscription souscription;
    private ClsCoiffure coiffure;
    private float qte;

    public ClsLingneSouscription(ClsSouscription souscription, ClsCoiffure coiffure, float qte) {
        this.souscription = souscription;
        this.coiffure = coiffure;
        this.qte = qte;
    }

    public ClsSouscription getSouscription() {
        return souscription;
    }

    public void setSouscription(ClsSouscription souscription) {
        this.souscription = souscription;
    }

    public ClsCoiffure getCoiffure() {
        return coiffure;
    }

    public void setCoiffure(ClsCoiffure coiffure) {
        this.coiffure = coiffure;
    }

    public float getQte() {
        return qte;
    }

    public void setQte(float qte) {
        this.qte = qte;
    }
  
}
