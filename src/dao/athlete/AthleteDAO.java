package dao.athlete;

import model.Athlete;
import java.util.List;

public interface AthleteDAO {

    boolean add(Athlete athlete);

    boolean update(Athlete athlete);

    boolean deactivate(int id);

    Athlete findById(int id);

    Athlete findByEmail(String email);

    List<Athlete> getByParentId(int parentId);

    List<Athlete> getAvailableAthletes();

    List<Athlete> getAll();
}
