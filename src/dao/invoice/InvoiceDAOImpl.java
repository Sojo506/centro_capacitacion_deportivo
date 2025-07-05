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
        int generatedId = -1;

        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, invoice.getParentId());
            ps.setDouble(2, invoice.getTotal());
            ps.setString(3, invoice.getStatus().name());
            ps.setBoolean(4, invoice.isActive());
            ps.setTimestamp(5, Timestamp.valueOf(invoice.getCreatedAt()));

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generatedId;
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
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    @Override
    public Invoice findById(int id) {
        String sql = "SELECT * FROM invoices WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Invoice(
                        rs.getInt("id"),
                        rs.getInt("parent_id"),
                        rs.getDouble("total"),
                        InvoiceEnum.valueOf(rs.getString("status")),
                        rs.getBoolean("active"),
                        rs.getTimestamp("created_at").toLocalDateTime()
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Invoice> getDesc() {
        List<Invoice> list = new ArrayList<>();
        String sql = "SELECT * FROM invoices WHERE active = true ORDER BY created_at DESC";

        try (Connection conn = ConnectionDB.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Invoice(
                        rs.getInt("id"),
                        rs.getInt("parent_id"),
                        rs.getDouble("total"),
                        InvoiceEnum.valueOf(rs.getString("status")),
                        rs.getBoolean("active"),
                        rs.getTimestamp("created_at").toLocalDateTime()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
     @Override
    public List<Invoice> getAsc() {
        List<Invoice> list = new ArrayList<>();
        String sql = "SELECT * FROM invoices WHERE active = true ORDER BY created_at ASC";

        try (Connection conn = ConnectionDB.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Invoice(
                        rs.getInt("id"),
                        rs.getInt("parent_id"),
                        rs.getDouble("total"),
                        InvoiceEnum.valueOf(rs.getString("status")),
                        rs.getBoolean("active"),
                        rs.getTimestamp("created_at").toLocalDateTime()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
