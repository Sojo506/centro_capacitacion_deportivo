package dao.invoiceRoutine;

import java.util.List;
import model.InvoiceRoutine;

public interface InvoiceRoutineDAO {

    void add(InvoiceRoutine ir);

    void deleteByInvoiceId(int invoiceId);

    boolean isRoutineInAnyInvoice(int sportId);

    List<InvoiceRoutine> getByInvoiceId(int invoiceId);

}
