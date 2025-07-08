package dao.sport;

import db.ConnectionDB;
import model.Sport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SportDAOImpl implements SportDAO {

    @Override
    public void add(Sport sport) {
        String sql = "INSERT INTO sports (name, characteristics, active) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sport.getName());
            ps.setString(2, sport.getCharacteristics());
            ps.setBoolean(3, sport.isActive());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error while creating a sport", e);
        }
    }

    @Override
    public void update(Sport sport) {
        String sql = "UPDATE sports SET name = ?, characteristics = ?, active = ? WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sport.getName());
            ps.setString(2, sport.getCharacteristics());
            ps.setBoolean(3, sport.isActive());
            ps.setInt(4, sport.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error while updating the sport with ID " + sport.getId(), e);
        }
    }

    @Override
    public boolean deactivate(int id) {
        String sql = "UPDATE sports SET active = false WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting the sport with ID " + id, e);
        }
    }

    @Override
    public Sport findById(int id) {
        String sql = "SELECT * FROM sports WHERE id = ? AND active = true";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return buildSport(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while finding sport by ID " + id, e);
        }
        return null;
    }

    @Override
    public Sport findByName(String name) {
        String sql = "SELECT * FROM sports WHERE name = ? AND active = true";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return buildSport(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while finding sport by name: " + name, e);
        }
        return null;
    }

    @Override
    public List<Sport> getAll() {
        List<Sport> list = new ArrayList<>();
        String sql = "SELECT * FROM sports WHERE active = true";
        try (Connection conn = ConnectionDB.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(buildSport(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while getting all sports", e);
        }
        return list;
    }

    private Sport buildSport(ResultSet rs) throws SQLException {
        return new Sport(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("characteristics"),
                rs.getBoolean("active")
        );
    }
}
