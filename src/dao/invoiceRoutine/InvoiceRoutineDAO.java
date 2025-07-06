package dao.invoiceRoutine;

import java.util.List;
import model.InvoiceRoutine;
import model.Routine;

public interface InvoiceRoutineDAO {

    void add(InvoiceRoutine ir);

    void deleteByInvoiceId(int invoiceId);

    boolean isRoutineInAnyInvoice(int sportId);

    List<Routine> getByInvoiceId(int invoiceId);

}
