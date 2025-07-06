package dao.routineSport;

import db.ConnectionDB;
import model.Sport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoutineSportDAOImpl implements RoutineSportDAO {

    @Override
    public void add(int routineId, List<Sport> sports) {
        String sql = "INSERT INTO routine_sports (routine_id, sport_id) VALUES (?, ?)";

        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            for (Sport sport : sports) {
                ps.setInt(1, routineId);
                ps.setInt(2, sport.getId());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByRoutineId(int routineId) {
        String sql = "DELETE FROM routine_sports WHERE routine_id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, routineId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isSportInAnyRoutine(int sportId) {
        String sql = "SELECT 1 FROM routine_sports WHERE sport_id = ? LIMIT 1";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, sportId);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Sport> getByRoutineId(int routineId) {
        List<Sport> list = new ArrayList<>();
        String sql = """
                SELECT s.* FROM sports s
                JOIN routine_sports rs ON s.id = rs.sport_id
                WHERE rs.routine_id = ? AND s.active = true
                """;

        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, routineId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Sport(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("characteristics"),
                        rs.getBoolean("active")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
