package model;

import java.util.List;
import java.time.LocalDateTime;

public class Invoice {

    private int id;
    private LocalDateTime date;
    private int athleteId;
    private double totalAmount;
    private boolean active;
    private List<Routine> routines;

    public Invoice() {
    }

    public Invoice(int id, LocalDateTime date, int athleteId, double totalAmount, boolean active, List<Routine> routines) {
        this.id = id;
        this.date = date;
        this.athleteId = athleteId;
        this.totalAmount = totalAmount;
        this.active = active;
        this.routines = routines;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(int athleteId) {
        this.athleteId = athleteId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Routine> getRoutines() {
        return routines;
    }

    public void setRoutines(List<Routine> routines) {
        this.routines = routines;
    }

}
