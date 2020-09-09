package brain.models;

import java.sql.Date;

public class ClsPaiement {
    
    private int id;
    private ClsSouscription souscription;
    private Date date_paiement;
    private float montant;
    private ClsUser user;

    public ClsPaiement(int id, ClsSouscription souscription, Date date_paiement, float montant, ClsUser user) {
        this.id = id;
        this.souscription = souscription;
        this.date_paiement = date_paiement;
        this.montant = montant;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClsSouscription getSouscription() {
        return souscription;
    }

    public void setSouscription(ClsSouscription souscription) {
        this.souscription = souscription;
    }

    public Date getDate_paiement() {
        return date_paiement;
    }

    public void setDate_paiement(Date date_paiement) {
        this.date_paiement = date_paiement;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public ClsUser getUser() {
        return user;
    }

    public void setUser(ClsUser user) {
        this.user = user;
    }
  
}
