package dao.invoice;

import db.ConnectionDB;
import model.Invoice;
import model.Routine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAOImpl implements InvoiceDAO {

    @Override
    public void create(Invoice invoice) {
        String sqlInvoice = "INSERT INTO invoices (athlete_id, total_amount, active) VALUES (?, ?, ?)";
        String sqlJoin = "INSERT INTO invoice_routine (invoice_id, routine_id) VALUES (?, ?)";

        try (Connection conn = ConnectionDB.getConnection()) {
            conn.setAutoCommit(false); // transacción

            // Agregar en la tabla invoices
            PreparedStatement ps = conn.prepareStatement(sqlInvoice, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, invoice.getAthleteId());
            ps.setDouble(2, invoice.getTotalAmount());
            ps.setBoolean(3, invoice.isActive());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int invoiceId = 0;
            if (rs.next()) {
                invoiceId = rs.getInt(1);
            }

            // Agregar en la tabla intermedia
            PreparedStatement psJoin = conn.prepareStatement(sqlJoin);
            for (Routine r : invoice.getRoutines()) {
                psJoin.setInt(1, invoiceId);
                psJoin.setInt(2, r.getId());
                psJoin.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Invoice findById(int id) {
        String sql = "SELECT * FROM invoices WHERE id = ? AND active = true";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Invoice invoice = new Invoice(
                        rs.getInt("id"),
                        rs.getTimestamp("date").toLocalDateTime(),
                        rs.getInt("athlete_id"),
                        rs.getDouble("total_amount"),
                        rs.getBoolean("active"),
                        getRoutinesByInvoiceId(rs.getInt("id"))
                );
                return invoice;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Routine> getRoutinesByInvoiceId(int invoiceId) {
        List<Routine> routines = new ArrayList<>();
        String sql = """
            SELECT r.id, r.description, r.sport_id, r.duration_minutes, r.active
            FROM invoice_routine ir
            JOIN routines r ON ir.routine_id = r.id
            WHERE ir.invoice_id = ?
        """;
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, invoiceId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                routines.add(new Routine(
                        rs.getInt("id"),
                        rs.getString("description"),
                        rs.getInt("duration_minutes"),
                        rs.getBoolean("active")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routines;
    }

    @Override
    public List<Invoice> getAll() {
        List<Invoice> list = new ArrayList<>();
        String sql = "SELECT * FROM invoices WHERE active = true";
        try (Connection conn = ConnectionDB.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Invoice invoice = new Invoice(
                        rs.getInt("id"),
                        rs.getTimestamp("date").toLocalDateTime(),
                        rs.getInt("athlete_id"),
                        rs.getDouble("total_amount"),
                        rs.getBoolean("active"),
                        getRoutinesByInvoiceId(rs.getInt("id"))
                );
                list.add(invoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deactivate(int id) {
        String sql = "UPDATE invoices SET active = false WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
