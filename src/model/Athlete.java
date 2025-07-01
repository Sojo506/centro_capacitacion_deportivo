package model;

public class Athlete extends Person {

    private int id;

    public Athlete() {
    }

    public Athlete(String name, String lastName, String city, String address, String phone, String email, boolean active) {
        super(name, lastName, city, address, phone, email, active);
    }

    public Athlete(int id, String name, String lastName, String city, String address,
            String phone, String email, boolean active) {
        super(name, lastName, city, address, phone, email, active);
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
