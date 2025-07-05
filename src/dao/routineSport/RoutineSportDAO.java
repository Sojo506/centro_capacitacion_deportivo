package dao.routineSport;

import model.Sport;

import java.util.List;

public interface RoutineSportDAO {

    void add(int routineId, List<Sport> sports);

    void deleteByRoutineId(int routineId);
    
    boolean isSportInAnyRoutine(int sportId);

    List<Sport> getByRoutineId(int routineId);
}
