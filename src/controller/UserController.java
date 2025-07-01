package controller;

import dao.user.UserDAO;
import dao.user.UserDAOImpl;
import model.User;
import util.HashUtil;

import java.util.List;

public class UserController {

    private UserDAO dao = new UserDAOImpl();

    public User loginUser(String email, String password) {
        return dao.login(email, password);
    }

    public void registerUser(String fullName, String email, String password) {
        String hash = HashUtil.sha256(password);
        User user = new User(fullName, email, hash, true);
        dao.add(user);
    }

    public void updateUser(User user) {
        dao.update(user);
    }

    public List<User> listUsers() {
        return dao.getAll();
    }

    public User findUser(String email) {
        return dao.findByEmail(email);
    }

    public int countUsers() {
        return dao.countUsers();
    }

    public boolean deactivateUser(String email) {
        return dao.deactivate(email);
    }

}
