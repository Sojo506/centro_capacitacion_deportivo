package controller;

import dao.routine.RoutineDAO;
import dao.routine.RoutineDAOImpl;
import dao.sport.SportDAO;
import dao.sport.SportDAOImpl;
import model.Sport;

import java.util.List;
import model.Routine;

public class SportController {

    private SportDAO sportDAO = new SportDAOImpl();
    private RoutineDAO routineDAO = new RoutineDAOImpl();

    public boolean registerSport(Sport s) {
        if (sportDAO.findByName(s.getName()) != null) {
            return false;
        }
        sportDAO.add(s);
        return true;
    }

    public void updateSport(Sport s) {
        sportDAO.update(s);
    }

    public boolean deactivateSport(int id) {
        List<Routine> routines = routineDAO.getBySportId(id);

        if (routines.size() > 0) {
            return false;
        }
        return sportDAO.deactivate(id);
    }

    public Sport getSportById(int id) {
        return sportDAO.findById(id);
    }

    public List<Sport> listSports() {
        return sportDAO.getAll();
    }
}
