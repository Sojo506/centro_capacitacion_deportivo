package dao.routine;

import model.Routine;
import java.util.List;

public interface RoutineDAO {

    int add(Routine routine);

    void update(Routine routine);

    boolean deactivate(int id);

    Routine findById(int id);

    Routine findByDescription(String description);

    List<Routine> getAll();
}
