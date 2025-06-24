package dao.parent;

import model.Parent;
import java.util.List;

public interface ParentDAO {

    void add(Parent parent);

    void update(Parent parent);

    boolean deactivate(int id);

    Parent findById(int id);

    Parent findByEmail(String email);

    List<Parent> getAll();
}
