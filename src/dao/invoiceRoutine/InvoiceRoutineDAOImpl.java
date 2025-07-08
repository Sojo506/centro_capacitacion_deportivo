package dao.invoiceRoutine;

import db.ConnectionDB;
import model.InvoiceRoutine;
import model.Routine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceRoutineDAOImpl implements InvoiceRoutineDAO {

    @Override
    public void add(InvoiceRoutine ir) {
        String sql = "INSERT INTO invoice_routines (invoice_id, routine_id) VALUES (?, ?)";

        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, ir.getInvoiceId());
            ps.setInt(2, ir.getRoutineId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error adding invoice, routine: " + ir, e);
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

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Routine(
                            rs.getInt("id"),
                            rs.getString("description"),
                            rs.getInt("duration_minutes"),
                            rs.getBoolean("active")
                    ));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error getting routines for invoice " + invoiceId, e);
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
            throw new RuntimeException("Error deleting invoice routines for invoice " + invoiceId, e);
        }
    }

    @Override
    public boolean isRoutineInAnyInvoice(int routineId) {
        String sql = "SELECT 1 FROM invoice_routines WHERE routine_id = ? LIMIT 1";

        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, routineId);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error checking routine usage for routine " + routineId, e);
        }
    }
}
