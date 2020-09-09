package brain.models;

public class ClsType {
    
    private int id;
    private String typeItem;

    public ClsType(int id, String typeItem) {
        this.id = id;
        this.typeItem = typeItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeItem() {
        return typeItem;
    }

    public void setTypeItem(String typeItem) {
        this.typeItem = typeItem;
    }
 
}
