package model;

public class Routine {

    private int id;
    private String description;
    private int sportId;
    private int durationMinutes;
    private boolean active;

    public Routine() {
    }

    public Routine(int id, String description, int sportId, int durationMinutes, boolean active) {
        this.id = id;
        this.description = description;
        this.sportId = sportId;
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

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
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
