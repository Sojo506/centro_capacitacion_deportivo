package model;

public class Parent extends Person {

    private int id;

    public Parent() {
    }

    public Parent(String name, String lastName, String city, String address, String phone, String email, boolean active) {
        super(name, lastName, city, address, phone, email, active);
    }

    public Parent(int id, String name, String lastName, String city, String address,
            String phone, String email, boolean active) {
        super(name, lastName, city, address, phone, email, active);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
