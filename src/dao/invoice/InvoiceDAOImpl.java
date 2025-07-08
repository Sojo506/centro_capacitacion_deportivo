package dao.invoice;

import db.ConnectionDB;
import model.Invoice;
import util.InvoiceEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAOImpl implements InvoiceDAO {

    @Override
    public int add(Invoice invoice) {
        String sql = "INSERT INTO invoices (parent_id, total, status, active, created_at) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, invoice.getParentId());
            ps.setDouble(2, invoice.getTotal());
            ps.setString(3, invoice.getStatus().name());
            ps.setBoolean(4, invoice.isActive());
            ps.setTimestamp(5, Timestamp.valueOf(invoice.getCreatedAt()));

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("Creating invoice failed, no rows affected.");
            }

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                } else {
                    throw new RuntimeException("Creating invoice failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error adding invoice", e);
        }
    }

    @Override
    public void update(Invoice invoice) {
        String sql = "UPDATE invoices SET parent_id = ?, total = ?, status = ?, active = ?, created_at = ? WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, invoice.getParentId());
            ps.setDouble(2, invoice.getTotal());
            ps.setString(3, invoice.getStatus().name());
            ps.setBoolean(4, invoice.isActive());
            ps.setTimestamp(5, Timestamp.valueOf(invoice.getCreatedAt()));
            ps.setInt(6, invoice.getId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("Updating invoice failed, no rows affected.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error updating invoice with id " + invoice.getId(), e);
        }
    }

    @Override
    public boolean deactivate(int id) {
        String sql = "UPDATE invoices SET active = false WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting invoice with id " + id, e);
        }
    }

    @Override
    public Invoice findById(int id) {
        String sql = "SELECT * FROM invoices WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return buildInvoice(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding invoice by id: " + id, e);
        }
        return null;
    }

    @Override
    public List<Invoice> getDesc() {
        return getInvoicesOrdered("DESC");
    }

    @Override
    public List<Invoice> getAsc() {
        return getInvoicesOrdered("ASC");
    }

    private List<Invoice> getInvoicesOrdered(String order) {
        List<Invoice> list = new ArrayList<>();
        String sql = "SELECT * FROM invoices WHERE active = true ORDER BY created_at " + order;

        try (Connection conn = ConnectionDB.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(buildInvoice(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting invoices ordered " + order, e);
        }
        return list;
    }

    private Invoice buildInvoice(ResultSet rs) throws SQLException {
        return new Invoice(
                rs.getInt("id"),
                rs.getInt("parent_id"),
                rs.getDouble("total"),
                InvoiceEnum.valueOf(rs.getString("status")),
                rs.getBoolean("active"),
                rs.getTimestamp("created_at").toLocalDateTime()
        );
    }
}
