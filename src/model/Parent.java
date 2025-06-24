package model;

public class Parent extends Person {

    private int id;
    private int athleteId;

    public Parent() {
    }

    public Parent(int id, String name, String lastName, String city, String address,
            String phone, String email, boolean active, int athleteId) {
        super(name, lastName, city, address, phone, email, active);
        this.id = id;
        this.athleteId = athleteId;
    }

    public int getId() {
        return id;
    }

    public int getAthleteId() {
        return athleteId;
    }

}
