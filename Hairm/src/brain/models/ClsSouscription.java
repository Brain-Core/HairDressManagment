package brain.models;

import java.sql.Date;

public class ClsSouscription {
    
    private int id;
    private Date date_souscription;
    private String client;
    private ClsUser user;

    public ClsSouscription(int id, Date date_souscription, String client, ClsUser user) {
        this.id = id;
        this.date_souscription = date_souscription;
        this.client = client;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_souscription() {
        return date_souscription;
    }

    public void setDate_souscription(Date date_souscription) {
        this.date_souscription = date_souscription;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public ClsUser getUser() {
        return user;
    }

    public void setUser(ClsUser user) {
        this.user = user;
    }
  
}
