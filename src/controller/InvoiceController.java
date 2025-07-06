package controller;

import dao.invoice.InvoiceDAO;
import dao.invoice.InvoiceDAOImpl;
import dao.invoiceRoutine.InvoiceRoutineDAO;
import dao.invoiceRoutine.InvoiceRoutineDAOImpl;
import model.Invoice;
import model.InvoiceRoutine;

import java.util.List;
import model.Routine;

public class InvoiceController {

    private InvoiceDAO invoiceDAO;
    private InvoiceRoutineDAO invoiceRoutineDAO;

    public InvoiceController() {
        invoiceDAO = new InvoiceDAOImpl();
        invoiceRoutineDAO = new InvoiceRoutineDAOImpl();
    }

    public int registerInvoice(Invoice invoice, List<Integer> routineIds) {
        int invoiceId = invoiceDAO.add(invoice);

        if (invoiceId != -1 && routineIds != null && !routineIds.isEmpty()) {
            for (int routineId : routineIds) {
                invoiceRoutineDAO.add(new InvoiceRoutine(invoiceId, routineId));
            }
        }

        return invoiceId;
    }

    public List<Invoice> listInvoicesAsc() {
        return invoiceDAO.getAsc();
    }

    public List<Invoice> listInvoicesDesc() {
        return invoiceDAO.getDesc();
    }

    public Invoice getInvoiceById(int id) {
        return invoiceDAO.findById(id);
    }

    public boolean deactivateInvoice(int id) {
        return invoiceDAO.deactivate(id);
    }

    public void updateInvoice(Invoice invoice) {
        invoiceDAO.update(invoice);
    }

    public List<Routine> getRoutinesByInvoiceId(int invoiceId) {
        return invoiceRoutineDAO.getByInvoiceId(invoiceId);
    }
}
