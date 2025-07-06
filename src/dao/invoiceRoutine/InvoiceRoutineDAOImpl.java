package dao.invoiceRoutine;

import db.ConnectionDB;
import model.InvoiceRoutine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Routine;

public class InvoiceRoutineDAOImpl implements InvoiceRoutineDAO {

    @Override
    public void add(InvoiceRoutine ir) {
        String sql = "INSERT INTO invoice_routines (invoice_id, routine_id) VALUES (?, ?)";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ir.getInvoiceId());
            ps.setInt(2, ir.getRoutineId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Routine> getByInvoiceId(int invoiceId) {
        List<Routine> list = new ArrayList<>();
        String sql = """
            SELECT r.* FROM routines r
            JOIN invoice_routines ir ON r.id = ir.routine_id
            WHERE ir.invoice_id = ? AND r.active = true
            """;

        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, invoiceId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Routine routine = new Routine(
                        rs.getInt("id"),
                        rs.getString("description"),
                        rs.getInt("duration_minutes"),
                        rs.getBoolean("active")
                );
                list.add(routine);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void deleteByInvoiceId(int invoiceId) {
        String sql = "DELETE FROM invoice_routines WHERE invoice_id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, invoiceId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isRoutineInAnyInvoice(int routineId) {
        String sql = "SELECT 1 FROM invoice_routines WHERE routine_id = ? LIMIT 1";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, routineId);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
