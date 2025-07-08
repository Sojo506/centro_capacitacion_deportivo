package dao.athlete;

import db.ConnectionDB;
import model.Athlete;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AthleteDAOImpl implements AthleteDAO {

    @Override
    public void add(Athlete athlete) {
        String sql = "INSERT INTO athletes (name, last_name, city, address, phone, email, parent_id, active) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, athlete.getName());
            ps.setString(2, athlete.getLastName());
            ps.setString(3, athlete.getCity());
            ps.setString(4, athlete.getAddress());
            ps.setString(5, athlete.getPhone());
            ps.setString(6, athlete.getEmail());
            ps.setObject(7, athlete.getParentId());
            ps.setBoolean(8, athlete.isActive());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding athlete", e);
        }
    }

    @Override
    public void update(Athlete athlete) {
        String sql = "UPDATE athletes SET name=?, last_name=?, city=?, address=?, phone=?, email=?, active=?, parent_id=? WHERE id=?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, athlete.getName());
            ps.setString(2, athlete.getLastName());
            ps.setString(3, athlete.getCity());
            ps.setString(4, athlete.getAddress());
            ps.setString(5, athlete.getPhone());
            ps.setString(6, athlete.getEmail());
            ps.setBoolean(7, athlete.isActive());
            ps.setObject(8, athlete.getParentId());
            ps.setInt(9, athlete.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating athlete", e);
        }
    }

    @Override
    public boolean deactivate(int id) {
        String sql = "UPDATE athletes SET active = false WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error deactivating athlete with id " + id, e);
        }
    }

    @Override
    public Athlete findById(int id) {
        String sql = "SELECT * FROM athletes WHERE id = ? AND active = true";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return buildAthlete(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding athlete by id: " + id, e);
        }
        return null;
    }

    @Override
    public Athlete findByEmail(String email) {
        String sql = "SELECT * FROM athletes WHERE email = ? AND active = true";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return buildAthlete(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding athlete by email: " + email, e);
        }
        return null;
    }

    @Override
    public List<Athlete> getAll() {
        List<Athlete> list = new ArrayList<>();
        String sql = "SELECT * FROM athletes WHERE active = true";
        try (Connection conn = ConnectionDB.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(buildAthlete(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting all athletes", e);
        }
        return list;
    }

    @Override
    public List<Athlete> getByParentId(int parentId) {
        List<Athlete> list = new ArrayList<>();
        String sql = "SELECT * FROM athletes WHERE parent_id = ? AND active = true";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, parentId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(buildAthlete(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting athletes by parentId: " + parentId, e);
        }
        return list;
    }

    @Override
    public List<Athlete> getAvailableAthletes() {
        List<Athlete> list = new ArrayList<>();
        String sql = "SELECT * FROM athletes WHERE parent_id IS NULL AND active = true";
        try (Connection conn = ConnectionDB.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(buildAthlete(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting available athletes", e);
        }
        return list;
    }

    private Athlete buildAthlete(ResultSet rs) throws SQLException {
        Integer parentId = rs.getInt("parent_id");
        if (rs.wasNull()) {
            parentId = null;
        }
        return new Athlete(
                rs.getInt("id"),
                parentId,
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
