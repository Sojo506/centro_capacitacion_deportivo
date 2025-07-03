package dao.sport;

import model.Sport;
import java.util.List;

public interface SportDAO {

    void add(Sport sport);

    void update(Sport sport);

    boolean deactivate(int id);

    Sport findById(int id);

    Sport findByName(String name);

    List<Sport> getByRoutineId(int routineId);

    List<Sport> getAvailableSports();

    List<Sport> getAll();
}
