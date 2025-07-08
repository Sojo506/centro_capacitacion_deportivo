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
            throw new RuntimeException("Error while creating routine: " + e.getMessage(), e);
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
            throw new RuntimeException("Error while updating routine: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean deactivate(int id) {
        String sql = "UPDATE routines SET active = false WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error while deactivating routine: " + e.getMessage(), e);
        }
    }

    @Override
    public Routine findById(int id) {
        String sql = "SELECT * FROM routines WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return buildRoutine(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while searching routine by ID: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Routine findByDescription(String description) {
        String sql = "SELECT * FROM routines WHERE description = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, description);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return buildRoutine(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while searching routine by description: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Routine> getAll() {
        List<Routine> list = new ArrayList<>();
        String sql = "SELECT * FROM routines WHERE active = true";
        try (Connection conn = ConnectionDB.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(buildRoutine(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while getting all routines: " + e.getMessage(), e);
        }
        return list;
    }

    private Routine buildRoutine(ResultSet rs) throws SQLException {
        return new Routine(
                rs.getInt("id"),
                rs.getString("description"),
                rs.getInt("duration_minutes"),
                rs.getBoolean("active")
        );
    }
}
