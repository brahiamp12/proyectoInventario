package modelo;

public class Shop {
    private int id;
    private String name;
    private String id_status;

    public Shop(String name, String id_status) {
        this.name = name;
        this.id_status = id_status;
    }

    public Shop(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_status() {
        return id_status;
    }

    public void setId_status(String id_status) {
        this.id_status = id_status;
    }
}
