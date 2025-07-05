package model;

public class Sport {

    private int id;
    private String name;
    private String characteristics;
    private boolean active;

    public Sport() {
    }

    public Sport(String name, String characteristics, boolean active) {
        this.name = name;
        this.characteristics = characteristics;
        this.active = active;
    }

    public Sport(int id, String name, String characteristics, boolean active) {
        this.id = id;
        this.name = name;
        this.characteristics = characteristics;
        this.active = active;
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

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
