package dao.invoice;

import model.Invoice;
import java.util.List;

public interface InvoiceDAO {

    void create(Invoice invoice);

    Invoice findById(int id);

    List<Invoice> getAll();

    boolean deactivate(int id);
}
