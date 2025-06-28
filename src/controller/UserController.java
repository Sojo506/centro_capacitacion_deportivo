package controller;

import dao.user.UserDAO;
import dao.user.UserDAOImpl;
import model.User;
import util.HashUtil;

import java.util.List;

public class UserController {

    private UserDAO dao = new UserDAOImpl();

    public User loginUser(String nickName, String password) {
        return dao.login(nickName, password);
    }

    public void registerUser(String fullName, String nickname, String password) {
        String hash = HashUtil.sha256(password);
        User u = new User(fullName, nickname, hash, true);
        dao.add(u);
    }

    public List<User> listUsers() {
        return dao.getAll();
    }

    public boolean deactivateUser(String nickname) {
        return dao.deactivate(nickname);
    }

    public User findUser(String email) {
        return dao.findByEmail(email);
    }
}
