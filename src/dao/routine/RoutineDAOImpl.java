package dao.routine;

import db.ConnectionDB;
import model.Routine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoutineDAOImpl implements RoutineDAO {

    @Override
    public void add(Routine routine) {
        String sql = "INSERT INTO routines (description, sport_id, duration_minutes, active) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, routine.getDescription());
            ps.setInt(2, routine.getSportId());
            ps.setInt(3, routine.getDurationMinutes());
            ps.setBoolean(4, routine.isActive());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Routine routine) {
        String sql = "UPDATE routines SET description=?, sport_id=?, duration_minutes=?, active=? WHERE id=?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, routine.getDescription());
            ps.setInt(2, routine.getSportId());
            ps.setInt(3, routine.getDurationMinutes());
            ps.setBoolean(4, routine.isActive());
            ps.setInt(5, routine.getId());
            ps.executeUpdate();
            System.out.println("Rutina updateada: " + routine.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deactivate(int id) {
        String sql = "UPDATE routines SET active = false WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Routine findById(int id) {
        String sql = "SELECT * FROM routines WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Routine(
                        rs.getInt("id"),
                        rs.getString("description"),
                        rs.getInt("sport_id"),
                        rs.getInt("duration_minutes"),
                        rs.getBoolean("active")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Routine findByDescription(String description) {
        String sql = "SELECT * FROM routines WHERE description = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, description);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Routine(
                        rs.getInt("id"),
                        description,
                        rs.getInt("sport_id"),
                        rs.getInt("duration_minutes"),
                        rs.getBoolean("active")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Routine> getAll() {
        List<Routine> list = new ArrayList<>();
        String sql = "SELECT * FROM routines";
        try (Connection conn = ConnectionDB.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Routine(
                        rs.getInt("id"),
                        rs.getString("description"),
                        rs.getInt("sport_id"),
                        rs.getInt("duration_minutes"),
                        rs.getBoolean("active")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Routine> getBySportId(int sportId) {
        List<Routine> list = new ArrayList<>();
        String sql = "SELECT * FROM routines WHERE sport_id = ? AND active = true";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, sportId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Routine(
                        rs.getInt("id"),
                        rs.getString("description"),
                        sportId,
                        rs.getInt("duration_minutes"),
                        rs.getBoolean("active")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
