package brain.models;

import java.sql.Date;

public class ClsCaisse {
    
    private int id ;
    private float montant ;
    private Date date_update;

    public ClsCaisse(int id, float montant, Date date_update) {
        this.id = id;
        this.montant = montant;
        this.date_update = date_update;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Date getDate_update() {
        return date_update;
    }

    public void setDate_update(Date date_update) {
        this.date_update = date_update;
    }

}
