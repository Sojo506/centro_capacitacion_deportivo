package dao.user;

import java.util.List;
import model.User;

public interface UserDAO {

    void add(User user);

    void update(User user);

    User login(String nickName, String plainPassword);

    List<User> getAll();

    User findByEmail(String nickname);

    User findById(int id);

    int countUsers();

    boolean deactivate(String nickname);
}
