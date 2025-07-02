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
            ps.setObject(7, athlete.getParentId()); // puede ser null
            ps.setBoolean(8, athlete.isActive());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Athlete athlete) {
        String sql = "UPDATE athletes SET name=?, last_name=?, city=?, address=?, phone=?, email=?, active=? WHERE id=?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, athlete.getName());
            ps.setString(2, athlete.getLastName());
            ps.setString(3, athlete.getCity());
            ps.setString(4, athlete.getAddress());
            ps.setString(5, athlete.getPhone());
            ps.setString(6, athlete.getEmail());
            ps.setBoolean(7, athlete.isActive());
            ps.setInt(8, athlete.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deactivate(int id) {
        String sql = "UPDATE athletes SET active = false WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Dentro de AthleteDAOImpl...
    @Override
    public Athlete findById(int id) {
        String sql = "SELECT * FROM athletes WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Athlete(
                        rs.getInt("id"),
                        rs.getInt("parent_id"),
                        rs.getString("name"),
                        rs.getString("last_name"),
                        rs.getString("city"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getBoolean("active")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Athlete findByEmail(String email) {
        String sql = "SELECT * FROM athletes WHERE email = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Athlete(
                        rs.getInt("id"),
                        rs.getInt("parent_id"),
                        rs.getString("name"),
                        rs.getString("last_name"),
                        rs.getString("city"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getBoolean("active")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Athlete> getAll() {
        List<Athlete> list = new ArrayList<>();
        String sql = "SELECT * FROM athletes WHERE active = true";
        try (Connection conn = ConnectionDB.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Athlete athlete = new Athlete(
                        rs.getInt("id"),
                        rs.getInt("parent_id"),
                        rs.getString("name"),
                        rs.getString("last_name"),
                        rs.getString("city"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getBoolean("active")
                );
                list.add(athlete);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Athlete> getByParentId(int parentId) {
        List<Athlete> list = new ArrayList<>();
        String sql = "SELECT * FROM athletes WHERE parent_id = ? AND active = true";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, parentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Athlete athlete = new Athlete(
                        rs.getInt("id"),
                        rs.getInt("parent_id"),
                        rs.getString("name"),
                        rs.getString("last_name"),
                        rs.getString("city"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getBoolean("active")
                );
                list.add(athlete);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Athlete> getAvailableAthletes() {
        List<Athlete> list = new ArrayList<>();
        String sql = "SELECT * FROM athletes WHERE parent_id IS NULL AND active = true";
        try (Connection conn = ConnectionDB.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Athlete athlete = new Athlete(
                        rs.getInt("id"),
                        rs.getInt("parent_id"),
                        rs.getString("name"),
                        rs.getString("last_name"),
                        rs.getString("city"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getBoolean("active")
                );
                list.add(athlete);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
