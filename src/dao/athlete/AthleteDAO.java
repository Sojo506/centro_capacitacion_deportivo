package dao.athlete;

import model.Athlete;
import java.util.List;

public interface AthleteDAO {

    void add(Athlete athlete);

    void update(Athlete athlete);

    boolean deactivate(int id);

    Athlete findById(int id);

    List<Athlete> getAll();
}
