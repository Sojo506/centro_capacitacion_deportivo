package model;

public class Routine {

    private int id;
    private String description;
    private int durationMinutes;
    private boolean active;

    public Routine() {
    }

    public Routine(String description, int durationMinutes, boolean active) {
        this.description = description;
        this.durationMinutes = durationMinutes;
        this.active = active;
    }

    public Routine(int id, String description, int durationMinutes, boolean active) {
        this.id = id;
        this.description = description;
        this.durationMinutes = durationMinutes;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
