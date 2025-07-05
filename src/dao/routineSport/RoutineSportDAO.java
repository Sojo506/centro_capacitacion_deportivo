package dao.routineSport;

import model.Sport;

import java.util.List;

public interface RoutineSportDAO {

    void linkRoutineToSports(int routineId, List<Sport> sports);

    void unlinkAllByRoutine(int routineId);
    
    boolean isSportInAnyRoutine(int sportId);

    List<Sport> getSportsByRoutineId(int routineId);
}
