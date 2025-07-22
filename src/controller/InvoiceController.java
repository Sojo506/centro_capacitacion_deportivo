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

    public List<Invoice> listAllInvoices() {
        return invoiceDAO.getAll();
    }

    public List<Invoice> listPendingInvoices() {
        return invoiceDAO.getPending();
    }

    public List<Invoice> listPaidInvoices() {
        return invoiceDAO.getPaid();
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
        List<Routine> routines = invoiceRoutineDAO.getByInvoiceId(id);

        if (routines.size() > 0) {
            invoiceRoutineDAO.deleteByInvoiceId(id);
        }

        return invoiceDAO.deactivate(id);
    }

    public void updateInvoice(Invoice invoice, List<Integer> routineIds) {
        if (invoice != null && routineIds != null && !routineIds.isEmpty()) {
            int invoiceId = invoice.getId();

            invoiceDAO.update(invoice);
            invoiceRoutineDAO.deleteByInvoiceId(invoiceId);

            for (int routineId : routineIds) {
                invoiceRoutineDAO.add(new InvoiceRoutine(invoiceId, routineId));
            }
        }
    }

    public List<Routine> getRoutinesByInvoiceId(int invoiceId) {
        return invoiceRoutineDAO.getByInvoiceId(invoiceId);
    }
}
