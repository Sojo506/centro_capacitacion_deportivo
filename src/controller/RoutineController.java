package controller;

import dao.routine.RoutineDAO;
import dao.routine.RoutineDAOImpl;
import dao.sport.SportDAO;
import dao.sport.SportDAOImpl;
import model.Routine;
import model.Sport;

import java.util.List;

public class RoutineController {

    private RoutineDAO routineDAO = new RoutineDAOImpl();
    private SportDAO sportDAO = new SportDAOImpl();

    public boolean registerRoutine(Routine r) {
        // Validar si el deporte existe
        Sport s = sportDAO.findById(r.getSportId());
        if (s == null) {
            System.out.println("Sport not found.");
            return false;
        }

        // Validar que no exista una rutina con la misma descripción
        if (routineDAO.findByDescription(r.getDescription()) != null) {
            System.out.println("Routine already exists.");
            return false;
        }

        routineDAO.add(r);
        return true;
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

    public List<Routine> listRoutines() {
        return routineDAO.getAll();
    }

    public List<Routine> getRoutinesBySportId(int sportId) {
        return routineDAO.getBySportId(sportId);
    }
}
