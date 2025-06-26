package controller;

import dao.parent.ParentDAO;
import dao.parent.ParentDAOImpl;
import dao.athlete.AthleteDAO;
import dao.athlete.AthleteDAOImpl;
import model.Parent;
import model.Athlete;

import java.util.List;

public class ParentController {

    private ParentDAO parentDAO = new ParentDAOImpl();
    private AthleteDAO athleteDAO = new AthleteDAOImpl();

    public boolean registerParent(Parent parent) {
        Athlete a = athleteDAO.findById(parent.getAthleteId());
        if (a == null) {
            return false;
        }
        parentDAO.add(parent);
        return true;
    }

    public void updateParent(Parent parent) {
        parentDAO.update(parent);
    }

    public boolean deactivateParent(int id) {
        return parentDAO.deactivate(id);
    }

    public Parent getParentById(int id) {
        return parentDAO.findById(id);
    }

    public Parent getParentByEmail(String email) {
        return parentDAO.findByEmail(email);
    }

    public List<Parent> listParents() {
        return parentDAO.getAll();
    }
}
