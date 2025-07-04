package controller;

import dao.routine.RoutineDAO;
import dao.routine.RoutineDAOImpl;
import model.Routine;

import java.util.List;

public class RoutineController {

    private RoutineDAO routineDAO = new RoutineDAOImpl();

    public int registerRoutine(Routine r) {
        return routineDAO.add(r);
    }

    public void updateRoutine(Routine r) {
        routineDAO.update(r);
    }

    public boolean deactivateRoutine(int id) {
        return routineDAO.deactivate(id);
    }

    public Routine getRoutineById(int id) {
        return routineDAO.findById(id);
    }
    
     public Routine getRoutineByDescription(String description) {
        return routineDAO.findByDescription(description);
    }


    public List<Routine> listRoutines() {
        return routineDAO.getAll();
    }

}
