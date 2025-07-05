package model;

public class RoutineSport {

    private int id;
    private int routineId;
    private int sportId;

    public RoutineSport(int id, int routineId, int sportId) {
        this.id = id;
        this.routineId = routineId;
        this.sportId = sportId;
    }

    public RoutineSport(int routineId, int sportId) {
        this.routineId = routineId;
        this.sportId = sportId;
    }

    public int getId() {
        return id;
    }

    public int getRoutineId() {
        return routineId;
    }

    public int getSportId() {
        return sportId;
    }
}
