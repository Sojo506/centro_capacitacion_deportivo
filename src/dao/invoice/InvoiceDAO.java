package dao.invoice;

import java.util.List;
import model.Invoice;

public interface InvoiceDAO {

    int add(Invoice invoice);

    void update(Invoice invoice);

    boolean deactivate(int id);

    Invoice findById(int id);

    List<Invoice> getAll();

    List<Invoice> getPending();

    List<Invoice> getPaid();

    List<Invoice> getDesc();

    List<Invoice> getAsc();
}
