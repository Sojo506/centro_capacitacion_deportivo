package model;

public class Sport {

    private int id;
    private String name;
    private String characteristics;
    private Integer routineId;
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
        routineId = null;
        this.active = active;
    }

    public Sport(int id, String name, String characteristics, Integer routineId, boolean active) {
        this.id = id;
        this.name = name;
        this.characteristics = characteristics;
        this.routineId = routineId;
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

    public Integer getRoutineId() {
        return routineId;
    }

    public void setRoutineId(Integer routineId) {
        this.routineId = routineId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
