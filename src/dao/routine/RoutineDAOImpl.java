package dao.routine;

import db.ConnectionDB;
import model.Routine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoutineDAOImpl implements RoutineDAO {

    @Override
    public int add(Routine routine) {
        String sql = "INSERT INTO routines (description, duration_minutes, active) VALUES (?, ?, ?)";
        int generatedId = -1;

        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, routine.getDescription());
            ps.setInt(2, routine.getDurationMinutes());
            ps.setBoolean(3, routine.isActive());

            int affectedRows = ps.executeUpdate(); 

            if (affectedRows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        generatedId = rs.getInt(1);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generatedId;
    }

    @Override
    public void update(Routine routine) {
        String sql = "UPDATE routines SET description=?, duration_minutes=?, active=? WHERE id=?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, routine.getDescription());
            ps.setInt(2, routine.getDurationMinutes());
            ps.setBoolean(3, routine.isActive());
            ps.setInt(4, routine.getId());
            ps.executeUpdate();
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
        String sql = "SELECT * FROM routines WHERE active = true";
        try (Connection conn = ConnectionDB.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Routine(
                        rs.getInt("id"),
                        rs.getString("description"),
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
