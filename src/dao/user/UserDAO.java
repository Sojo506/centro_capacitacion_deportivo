package dao.user;

import java.util.List;
import model.User;

public interface UserDAO {

    void add(User user);

    User login(String nickName, String plainPassword);

    List<User> getAll();

    User findByNickname(String nickname);

    boolean deactivate(String nickname);
}
