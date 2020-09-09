package brain.models;

import java.sql.Date;

public class ClsDepense {
    
    private int	id ;
    private String intitule ;
    private String executant ;
    private float montant;// doit se soustraire a la caisse
    private Date date_depense ;
    private ClsUser user ;

    public ClsDepense(int id, String intitule, String executant, float montant, Date date_depense, ClsUser user) {
        this.id = id;
        this.intitule = intitule;
        this.executant = executant;
        this.montant = montant;
        this.date_depense = date_depense;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getExecutant() {
        return executant;
    }

    public void setExecutant(String executant) {
        this.executant = executant;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Date getDate_depense() {
        return date_depense;
    }

    public void setDate_depense(Date date_depense) {
        this.date_depense = date_depense;
    }

    public ClsUser getUser() {
        return user;
    }

    public void setUser(ClsUser user) {
        this.user = user;
    } 
    
}
