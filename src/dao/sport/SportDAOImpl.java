package dao.sport;

import db.ConnectionDB;
import model.Sport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SportDAOImpl implements SportDAO {

    @Override
    public void add(Sport sport) {
        String sql = "INSERT INTO sports (name, characteristics, routine_id, active) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sport.getName());
            ps.setString(2, sport.getCharacteristics());
            ps.setObject(3, sport.getRoutineId());
            ps.setBoolean(4, sport.isActive());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Sport sport) {
        String sql = "UPDATE sports SET name=?, characteristics=?, routine_id=?, active=? WHERE id=?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sport.getName());
            ps.setString(2, sport.getCharacteristics());
            ps.setObject(3, sport.getRoutineId());
            ps.setBoolean(4, sport.isActive());
            ps.setInt(5, sport.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deactivate(int id) {
        String sql = "UPDATE sports SET active = false WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Sport findById(int id) {
        String sql = "SELECT * FROM sports WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Sport(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("characteristics"),
                        rs.getInt("routine_id"),
                        rs.getBoolean("active")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Sport findByName(String name) {
        String sql = "SELECT * FROM sports WHERE name = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Sport(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("characteristics"),
                        rs.getInt("routine_id"),
                        rs.getBoolean("active")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Sport> getAll() {
        List<Sport> list = new ArrayList<>();
        String sql = "SELECT * FROM sports WHERE active = true";
        try (Connection conn = ConnectionDB.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Sport s = new Sport(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("characteristics"),
                        rs.getInt("routine_id"),
                        rs.getBoolean("active")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Sport> getByRoutineId(int routineId) {
        List<Sport> list = new ArrayList<>();
        String sql = "SELECT * FROM sports WHERE routine_id = ? AND active = true";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, routineId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sport athlete = new Sport(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("characteristics"),
                        rs.getInt("routine_id"),
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
    public List<Sport> getAvailableSports() {
        List<Sport> list = new ArrayList<>();
        String sql = "SELECT * FROM sports WHERE routine_id IS NULL AND active = true";
        try (Connection conn = ConnectionDB.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Sport sport = new Sport(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("characteristics"),
                        rs.getInt("routine_id"),
                        rs.getBoolean("active")
                );
                list.add(sport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
