package dao.user;

import db.ConnectionDB;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import model.User;

public class UserDAOImpl implements UserDAO {

    @Override
    public void add(User user) {
        if (findByEmail(user.getEmail()) != null) {
            System.out.println("User already exists.");
            return;
        }

        String sql = "INSERT INTO users (full_name, email, password_hash, active) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setBoolean(4, user.isActive());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User login(String email, String plainPassword) {
        String sql = "SELECT * FROM users WHERE email = ? AND active = true";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String storedHash = rs.getString("password_hash");
                String inputHash = util.HashUtil.sha256(plainPassword); 

                if (storedHash.equals(inputHash)) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("full_name"),
                            rs.getString("email"),
                            storedHash,
                            true
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = ConnectionDB.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("password_hash"),
                        rs.getBoolean("active")
                );
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        email,
                        rs.getString("password_hash"),
                        rs.getBoolean("active")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deactivate(String nickName) {
        String sql = "UPDATE users SET active = false WHERE email = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nickName);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
