package model;

public class Athlete extends Person {

    private int id;
    private Integer parentId;

    public Athlete() {
    }

    public Athlete(String name, String lastName, String city, String address, String phone, String email, boolean active) {
        super(name, lastName, city, address, phone, email, active);
    }

    public Athlete(int id, String name, String lastName, String city, String address,
            String phone, String email, boolean active) {
        super(name, lastName, city, address, phone, email, active);
        this.id = id;
        parentId = null;
    }

    public Athlete(int id, Integer parentId, String name, String lastName, String city, String address, String phone, String email, boolean active) {
        super(name, lastName, city, address, phone, email, active);
        this.id = id;
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

}
