package dao.parent;

import db.ConnectionDB;
import model.Parent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParentDAOImpl implements ParentDAO {

    @Override
    public int add(Parent parent) {
        String sql = "INSERT INTO parents (name, last_name, city, address, phone, email, active) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        int generatedId = -1;

        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, parent.getName());
            ps.setString(2, parent.getLastName());
            ps.setString(3, parent.getCity());
            ps.setString(4, parent.getAddress());
            ps.setString(5, parent.getPhone());
            ps.setString(6, parent.getEmail());
            ps.setBoolean(7, parent.isActive());

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        generatedId = rs.getInt(1);
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while creating parent: " + e.getMessage(), e);
        }

        return generatedId;
    }

    @Override
    public void update(Parent parent) {
        String sql = "UPDATE parents SET name=?, last_name=?, city=?, address=?, phone=?, email=?, active=? WHERE id=?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, parent.getName());
            ps.setString(2, parent.getLastName());
            ps.setString(3, parent.getCity());
            ps.setString(4, parent.getAddress());
            ps.setString(5, parent.getPhone());
            ps.setString(6, parent.getEmail());
            ps.setBoolean(7, parent.isActive());
            ps.setInt(8, parent.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error while updating parent: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean deactivate(int id) {
        String sql = "UPDATE parents SET active = false WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting parent: " + e.getMessage(), e);
        }
    }

    @Override
    public Parent findById(int id) {
        String sql = "SELECT * FROM parents WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return buildParent(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while searching parent by ID: " + e.getMessage(), e);
        }

        return null;
    }

    @Override
    public Parent findByEmail(String email) {
        String sql = "SELECT * FROM parents WHERE email = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return buildParent(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while searching parent by email: " + e.getMessage(), e);
        }

        return null;
    }

    @Override
    public List<Parent> getAll() {
        List<Parent> list = new ArrayList<>();
        String sql = "SELECT * FROM parents WHERE active = true";
        try (Connection conn = ConnectionDB.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(buildParent(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while getting all parents: " + e.getMessage(), e);
        }

        return list;
    }

    private Parent buildParent(ResultSet rs) throws SQLException {
        return new Parent(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("last_name"),
                rs.getString("city"),
                rs.getString("address"),
                rs.getString("phone"),
                rs.getString("email"),
                rs.getBoolean("active")
        );
    }
}
