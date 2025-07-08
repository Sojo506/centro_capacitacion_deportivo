package dao.user;

import db.ConnectionDB;
import model.User;
import util.HashUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public void add(User user) {
        if (findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("A user with this email already exists.");
        }

        String sql = "INSERT INTO users (full_name, email, password_hash, active) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getFullName());
            ps.setString(2, user.getEmail());
            ps.setString(3, HashUtil.sha256(user.getPassword())); // hash password
            ps.setBoolean(4, user.isActive());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error while creating user", e);
        }
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET full_name = ?, email = ?, password_hash = ?, active = ? WHERE id = ?";

        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            User currentUser = findById(user.getId());

            String passwordToSave = currentUser.getPassword().equals(user.getPassword())
                    ? currentUser.getPassword()
                    : HashUtil.sha256(user.getPassword());

            ps.setString(1, user.getFullName());
            ps.setString(2, user.getEmail());
            ps.setString(3, passwordToSave);
            ps.setBoolean(4, user.isActive());
            ps.setInt(5, user.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error while updating user", e);
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
                String inputHash = HashUtil.sha256(plainPassword);

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
            throw new RuntimeException("Error while logging in", e);
        }

        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE active = true";

        try (Connection conn = ConnectionDB.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("password_hash"),
                        rs.getBoolean("active")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while retrieving users", e);
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
            throw new RuntimeException("Error while searching user by email", e);
        }

        return null;
    }

    @Override
    public User findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";

        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                        id,
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("password_hash"),
                        rs.getBoolean("active")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while searching user by ID", e);
        }

        return null;
    }

    @Override
    public int countUsers() {
        String sql = "SELECT COUNT(*) FROM users WHERE active = true";

        try (Connection conn = ConnectionDB.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while counting users", e);
        }

        return 0;
    }

    @Override
    public boolean deactivate(String email) {
        String sql = "UPDATE users SET active = false WHERE email = ?";

        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error while deactivating user", e);
        }
    }
}
