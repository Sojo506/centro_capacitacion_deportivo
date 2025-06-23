package dao.user;

import java.util.List;
import model.User;

public interface UserDAO {

    void add(User user);

    List<User> getAll();

    User findByNickname(String nickname);

    boolean deactivate(String nickname);

    boolean activate(String nickname);
}
