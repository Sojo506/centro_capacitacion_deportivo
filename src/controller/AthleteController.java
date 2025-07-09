package controller;

import dao.athlete.AthleteDAO;
import dao.athlete.AthleteDAOImpl;
import model.Athlete;
import java.util.List;

public class AthleteController {

    private AthleteDAO dao = new AthleteDAOImpl();

    public void createAthlete(Athlete a) {
        dao.add(a);
    }

    public void updateAthlete(Athlete a) {
        dao.update(a);
    }

    public boolean deactivateAthlete(int id) {
        Athlete a = getAthleteById(id);
        if (a.getParentId() != null) {
            return false;
        }
        return dao.deactivate(id);
    }

    public Athlete getAthleteById(int id) {
        return dao.findById(id);
    }

    public Athlete getAthleteByEmail(String email) {
        return dao.findByEmail(email);
    }

    public List<Athlete> getByParentId(int parentId) {
        return dao.getByParentId(parentId);
    }

    public List<Athlete> getAvailableAthletes() {
        return dao.getAvailableAthletes();
    }

    public List<Athlete> listAthletes() {
        return dao.getAll();
    }

    public boolean canCreateAthlete(String email) {
        return getAthleteByEmail(email) == null;
    }

    public boolean canUpdateAthlete(Athlete athlete, String newEmail) {
        if (athlete.getEmail().equalsIgnoreCase(newEmail)) {
            return true;
        }
        return getAthleteByEmail(newEmail) == null;
    }

}
