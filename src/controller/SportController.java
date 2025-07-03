package controller;

import dao.sport.SportDAO;
import dao.sport.SportDAOImpl;
import model.Sport;

import java.util.List;

public class SportController {

    private SportDAO dao = new SportDAOImpl();

    public boolean registerSport(Sport s) {
        if (dao.findByName(s.getName()) != null) {
            return false;
        }
        dao.add(s);
        return true;
    }

    public void updateSport(Sport s) {
        dao.update(s);
    }

    public boolean deactivateSport(int id) {
        return dao.deactivate(id);
    }

    public Sport getSportById(int id) {
        return dao.findById(id);
    }

    public List<Sport> getByRoutineId(int parentId) {
        return dao.getByRoutineId(parentId);
    }

    public List<Sport> getAvailableSports() {
        return dao.getAvailableSports();
    }

    public List<Sport> listSports() {
        return dao.getAll();
    }
}
